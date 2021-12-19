package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class PagingIterator<T extends HasId> extends ApiResource implements Iterator<T> {
  private final String url;

  @SuppressWarnings("rawtypes")
  private final Class<? extends JaguarCollectionInterface> collectionType;

  private JaguarCollectionInterface<T> currentCollection;
  private Iterator<T> currentDataIterator;

  private String lastId;

  PagingIterator(final JaguarCollectionInterface<T> stripeCollection) {
    this.url = Jaguar.getApiBase() + stripeCollection.getUrl();

    this.collectionType = stripeCollection.getClass();

    this.currentCollection = stripeCollection;
    this.currentDataIterator = stripeCollection.getData().iterator();
  }

  @Override
  public boolean hasNext() {
    return currentDataIterator.hasNext() || currentCollection.getHasMore();
  }

  @Override
  public T next() {
    // if we've run out of data on the current page, try to fetch another
    // one
    if (!currentDataIterator.hasNext() && currentCollection.getHasMore()) {
      try {
        Map<String, Object> params = new HashMap<>();

        // copy all the parameters from the initial request
        Map<String, Object> initialParams = currentCollection.getRequestParams();
        if (initialParams != null) {
          params.putAll(initialParams);
        }

        // then put our new page start in
        params.put("starting_after", lastId);

        this.currentCollection = list(params, currentCollection.getRequestOptions());

        this.currentDataIterator = currentCollection.getData().iterator();
      } catch (final Exception e) {
        throw new RuntimeException("Unable to lazy-load stripe objects", e);
      }
    }

    if (currentDataIterator.hasNext()) {
      final T next = currentDataIterator.next();
      this.lastId = next.getId();
      return next;
    }

    throw new NoSuchElementException();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

  @SuppressWarnings("unchecked")
  private JaguarCollectionInterface<T> list(
      final Map<String, Object> params, final RequestOptions options) throws Exception {
    return ApiResource.requestCollection(url, params, collectionType, options);
  }
}
