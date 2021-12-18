// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.PaymentSourceCollectionCreateParams;
import com.jaguar.param.PaymentSourceCollectionListParams;
import com.jaguar.param.PaymentSourceCollectionRetrieveParams;
import java.util.Map;

public class PaymentSourceCollection extends JaguarCollection<PaymentSource> {
  /** List sources for a specified customer. */
  public PaymentSourceCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** List sources for a specified customer. */
  public PaymentSourceCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, PaymentSourceCollection.class, options);
  }

  /** List sources for a specified customer. */
  public PaymentSourceCollection list(PaymentSourceCollectionListParams params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** List sources for a specified customer. */
  public PaymentSourceCollection list(
      PaymentSourceCollectionListParams params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, PaymentSourceCollection.class, options);
  }

  /** Retrieve a specified source for a given customer. */
  public PaymentSource retrieve(String id) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieve a specified source for a given customer. */
  public PaymentSource retrieve(String id, RequestOptions options) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /** Retrieve a specified source for a given customer. */
  public PaymentSource retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, PaymentSource.class, options);
  }

  /** Retrieve a specified source for a given customer. */
  public PaymentSource retrieve(
      String id, PaymentSourceCollectionRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, PaymentSource.class, options);
  }

  /**
   * When you create a new credit card, you must specify a customer or recipient on which to create
   * it.
   *
   * <p>If the card’s owner has no default card, then the new card will become the default. However,
   * if the owner already has a default, then it will not change. To change the default, you should
   * <a href="https://stripe.com/docs/api#update_customer">update the customer</a> to have a new
   * <code>default_source</code>.
   */
  public PaymentSource create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * When you create a new credit card, you must specify a customer or recipient on which to create
   * it.
   *
   * <p>If the card’s owner has no default card, then the new card will become the default. However,
   * if the owner already has a default, then it will not change. To change the default, you should
   * <a href="https://stripe.com/docs/api#update_customer">update the customer</a> to have a new
   * <code>default_source</code>.
   */
  public PaymentSource create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, PaymentSource.class, options);
  }

  /**
   * When you create a new credit card, you must specify a customer or recipient on which to create
   * it.
   *
   * <p>If the card’s owner has no default card, then the new card will become the default. However,
   * if the owner already has a default, then it will not change. To change the default, you should
   * <a href="https://stripe.com/docs/api#update_customer">update the customer</a> to have a new
   * <code>default_source</code>.
   */
  public PaymentSource create(PaymentSourceCollectionCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * When you create a new credit card, you must specify a customer or recipient on which to create
   * it.
   *
   * <p>If the card’s owner has no default card, then the new card will become the default. However,
   * if the owner already has a default, then it will not change. To change the default, you should
   * <a href="https://stripe.com/docs/api#update_customer">update the customer</a> to have a new
   * <code>default_source</code>.
   */
  public PaymentSource create(PaymentSourceCollectionCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, PaymentSource.class, options);
  }
}
