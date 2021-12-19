package com.jaguar.model;

import com.jaguar.net.RequestOptions;
import java.util.List;
import java.util.Map;

public interface JaguarCollectionInterface<T> extends JaguarObjectInterface {
  List<T> getData();

  Boolean getHasMore();

  String getUrl();

  /**
   * Get request options that were used to fetch the collection. This is useful for purposes of
   * pagination.
   */
  RequestOptions getRequestOptions();

  /**
   * Get request parameters that were used to fetch the collection. This is useful for purposes of
   * pagination.
   */
  Map<String, Object> getRequestParams();

  /**
   * Set request options that were used to fetch the collection. This is required for purposes of
   * pagination.
   */
  void setRequestOptions(RequestOptions requestOptions);

  /**
   * Set request parameters that were used to fetch the collection. This is required for purposes of
   * pagination.
   */
  void setRequestParams(Map<String, Object> requestParams);
}
