package com.jaguar.model;

import com.jaguar.exception.JaguarException;
import com.jaguar.net.RequestOptions;
import java.util.Map;

/** Common interface for Stripe objects that can store metadata. */
public interface MetadataStore<T> {
  Map<String, String> getMetadata();

  MetadataStore<T> update(Map<String, Object> params) throws JaguarException;

  MetadataStore<T> update(Map<String, Object> params, RequestOptions options)
      throws JaguarException;
}
