package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/** Please note SearchPagingIterator is in beta and is subject to change or removal at any time. */
public class SearchPagingIterator<T> extends ApiResource implements Iterator<T> {
  private final String url;

  @SuppressWarnings("rawtypes")
  private final Class<? extends JaguarSearchResultInterface> collectionType;

  private JaguarSearchResultInterface<T> currentSearchResult;
  private Iterator<T> currentDataIterator;

  private String nextPage;

  SearchPagingIterator(final JaguarSearchResultInterface<T> stripeSearchResult) {
    this.url = Jaguar.getApiBase() + stripeSearchResult.getUrl();
    this.nextPage = stripeSearchResult.getNextPage();

    this.collectionType = stripeSearchResult.getClass();

    this.currentSearchResult = stripeSearchResult;
    this.currentDataIterator = stripeSearchResult.getData().iterator();
  }

  @Override
  public boolean hasNext() {
    return currentDataIterator.hasNext() || currentSearchResult.getHasMore();
  }

  @Override
  public T next() {
    // if we've run out of data on the current page, try to fetch another
    // one
    if (!currentDataIterator.hasNext() && currentSearchResult.getHasMore()) {
      try {
        Map<String, Object> params = new HashMap<>();

        // copy all the parameters from the initial request
        Map<String, Object> initialParams = currentSearchResult.getRequestParams();
        if (initialParams != null) {
          params.putAll(initialParams);
        }

        // then put our new page start in
        params.put("next_page", this.nextPage);

        this.currentSearchResult = search(params, currentSearchResult.getRequestOptions());
        this.nextPage = this.currentSearchResult.getNextPage();

        this.currentDataIterator = currentSearchResult.getData().iterator();
      } catch (final Exception e) {
        throw new RuntimeException("Unable to lazy-load stripe objects", e);
      }
    }

    if (currentDataIterator.hasNext()) {
      final T next = currentDataIterator.next();
      return next;
    }

    throw new NoSuchElementException();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

  @SuppressWarnings("unchecked")
  private JaguarSearchResultInterface<T> search(
      final Map<String, Object> params, final RequestOptions options) throws Exception {
    return ApiResource.requestSearchResult(url, params, collectionType, options);
  }
}
