// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.RefundCollectionListParams;
import com.jaguar.param.RefundCollectionRetrieveParams;
import java.util.Map;

public class RefundCollection extends JaguarCollection<Refund> {
  /**
   * You can see a list of the refunds belonging to a specific charge. Note that the 10 most recent
   * refunds are always available by default on the charge object. If you need more than those 10,
   * you can use this API method and the <code>limit</code> and <code>starting_after</code>
   * parameters to page through additional refunds.
   */
  public RefundCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * You can see a list of the refunds belonging to a specific charge. Note that the 10 most recent
   * refunds are always available by default on the charge object. If you need more than those 10,
   * you can use this API method and the <code>limit</code> and <code>starting_after</code>
   * parameters to page through additional refunds.
   */
  public RefundCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, RefundCollection.class, options);
  }

  /**
   * You can see a list of the refunds belonging to a specific charge. Note that the 10 most recent
   * refunds are always available by default on the charge object. If you need more than those 10,
   * you can use this API method and the <code>limit</code> and <code>starting_after</code>
   * parameters to page through additional refunds.
   */
  public RefundCollection list(RefundCollectionListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * You can see a list of the refunds belonging to a specific charge. Note that the 10 most recent
   * refunds are always available by default on the charge object. If you need more than those 10,
   * you can use this API method and the <code>limit</code> and <code>starting_after</code>
   * parameters to page through additional refunds.
   */
  public RefundCollection list(RefundCollectionListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, RefundCollection.class, options);
  }

  /** Retrieves the details of an existing refund. */
  public Refund retrieve(String id) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the details of an existing refund. */
  public Refund retrieve(String id, RequestOptions options) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /** Retrieves the details of an existing refund. */
  public Refund retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Refund.class, options);
  }

  /** Retrieves the details of an existing refund. */
  public Refund retrieve(String id, RefundCollectionRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Refund.class, options);
  }
}
