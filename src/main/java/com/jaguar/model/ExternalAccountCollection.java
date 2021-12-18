// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.ExternalAccountCollectionCreateParams;
import com.jaguar.param.ExternalAccountCollectionListParams;
import com.jaguar.param.ExternalAccountCollectionRetrieveParams;
import java.util.Map;

public class ExternalAccountCollection extends JaguarCollection<ExternalAccount> {
  /** List external accounts for an account. */
  public ExternalAccountCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** List external accounts for an account. */
  public ExternalAccountCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, ExternalAccountCollection.class, options);
  }

  /** List external accounts for an account. */
  public ExternalAccountCollection list(ExternalAccountCollectionListParams params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** List external accounts for an account. */
  public ExternalAccountCollection list(
      ExternalAccountCollectionListParams params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, ExternalAccountCollection.class, options);
  }

  /** Retrieve a specified external account for a given account. */
  public ExternalAccount retrieve(String id) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieve a specified external account for a given account. */
  public ExternalAccount retrieve(String id, RequestOptions options) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /** Retrieve a specified external account for a given account. */
  public ExternalAccount retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ExternalAccount.class, options);
  }

  /** Retrieve a specified external account for a given account. */
  public ExternalAccount retrieve(
      String id, ExternalAccountCollectionRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ExternalAccount.class, options);
  }

  /** Create an external account for a given account. */
  public ExternalAccount create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Create an external account for a given account. */
  public ExternalAccount create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ExternalAccount.class, options);
  }

  /** Create an external account for a given account. */
  public ExternalAccount create(ExternalAccountCollectionCreateParams params)
      throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Create an external account for a given account. */
  public ExternalAccount create(
      ExternalAccountCollectionCreateParams params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ExternalAccount.class, options);
  }
}
