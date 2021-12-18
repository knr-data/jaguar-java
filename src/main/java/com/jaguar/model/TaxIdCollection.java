// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.TaxIdCollectionCreateParams;
import com.jaguar.param.TaxIdCollectionListParams;
import com.jaguar.param.TaxIdCollectionRetrieveParams;
import java.util.Map;

public class TaxIdCollection extends JaguarCollection<TaxId> {
  /** Creates a new <code>TaxID</code> object for a customer. */
  public TaxId create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new <code>TaxID</code> object for a customer. */
  public TaxId create(Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, TaxId.class, options);
  }

  /** Creates a new <code>TaxID</code> object for a customer. */
  public TaxId create(TaxIdCollectionCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new <code>TaxID</code> object for a customer. */
  public TaxId create(TaxIdCollectionCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, TaxId.class, options);
  }

  /** Retrieves the <code>TaxID</code> object with the given identifier. */
  public TaxId retrieve(String id) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the <code>TaxID</code> object with the given identifier. */
  public TaxId retrieve(String id, RequestOptions options) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /** Retrieves the <code>TaxID</code> object with the given identifier. */
  public TaxId retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, TaxId.class, options);
  }

  /** Retrieves the <code>TaxID</code> object with the given identifier. */
  public TaxId retrieve(String id, TaxIdCollectionRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, TaxId.class, options);
  }

  /** Returns a list of tax IDs for a customer. */
  public TaxIdCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of tax IDs for a customer. */
  public TaxIdCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, TaxIdCollection.class, options);
  }

  /** Returns a list of tax IDs for a customer. */
  public TaxIdCollection list(TaxIdCollectionListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of tax IDs for a customer. */
  public TaxIdCollection list(TaxIdCollectionListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, TaxIdCollection.class, options);
  }
}
