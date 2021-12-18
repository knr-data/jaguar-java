// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.CustomerBalanceTransactionCollectionCreateParams;
import com.jaguar.param.CustomerBalanceTransactionCollectionListParams;
import com.jaguar.param.CustomerBalanceTransactionCollectionRetrieveParams;
import java.util.Map;

public class CustomerBalanceTransactionCollection
    extends JaguarCollection<CustomerBalanceTransaction> {
  /**
   * Retrieves a specific customer balance transaction that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransaction retrieve(String id) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves a specific customer balance transaction that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransaction retrieve(String id, RequestOptions options)
      throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves a specific customer balance transaction that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransaction retrieve(
      String id, Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, CustomerBalanceTransaction.class, options);
  }

  /**
   * Retrieves a specific customer balance transaction that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransaction retrieve(
      String id, CustomerBalanceTransactionCollectionRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, CustomerBalanceTransaction.class, options);
  }

  /**
   * Returns a list of transactions that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransactionCollection list(Map<String, Object> params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of transactions that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransactionCollection list(
      Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(
        url, params, CustomerBalanceTransactionCollection.class, options);
  }

  /**
   * Returns a list of transactions that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransactionCollection list(
      CustomerBalanceTransactionCollectionListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of transactions that updated the customer’s <a
   * href="https://stripe.com/docs/billing/customer/balance">balances</a>.
   */
  public CustomerBalanceTransactionCollection list(
      CustomerBalanceTransactionCollectionListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(
        url, params, CustomerBalanceTransactionCollection.class, options);
  }

  /**
   * Creates an immutable transaction that updates the customer’s credit <a
   * href="https://stripe.com/docs/billing/customer/balance">balance</a>.
   */
  public CustomerBalanceTransaction create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Creates an immutable transaction that updates the customer’s credit <a
   * href="https://stripe.com/docs/billing/customer/balance">balance</a>.
   */
  public CustomerBalanceTransaction create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, CustomerBalanceTransaction.class, options);
  }

  /**
   * Creates an immutable transaction that updates the customer’s credit <a
   * href="https://stripe.com/docs/billing/customer/balance">balance</a>.
   */
  public CustomerBalanceTransaction create(CustomerBalanceTransactionCollectionCreateParams params)
      throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Creates an immutable transaction that updates the customer’s credit <a
   * href="https://stripe.com/docs/billing/customer/balance">balance</a>.
   */
  public CustomerBalanceTransaction create(
      CustomerBalanceTransactionCollectionCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, CustomerBalanceTransaction.class, options);
  }
}
