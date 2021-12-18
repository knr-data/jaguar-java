// File generated from our OpenAPI spec
package com.jaguar.model;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.ExchangeRateListParams;
import com.jaguar.param.ExchangeRateRetrieveParams;
import java.math.BigDecimal;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ExchangeRate extends ApiResource implements HasId {
  /**
   * Unique identifier for the object. Represented as the three-letter <a
   * href="https://www.iso.org/iso-4217-currency-codes.html">ISO currency code</a> in lowercase.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code exchange_rate}.
   */
  @SerializedName("object")
  String object;

  /**
   * Hash where the keys are supported currencies and the values are the exchange rate at which the
   * base id currency converts to the key currency.
   */
  @SerializedName("rates")
  Map<String, BigDecimal> rates;

  /**
   * Returns a list of objects that contain the rates at which foreign currencies are converted to
   * one another. Only shows the currencies for which Stripe supports.
   */
  public static ExchangeRateCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of objects that contain the rates at which foreign currencies are converted to
   * one another. Only shows the currencies for which Stripe supports.
   */
  public static ExchangeRateCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/exchange_rates");
    return ApiResource.requestCollection(url, params, ExchangeRateCollection.class, options);
  }

  /**
   * Returns a list of objects that contain the rates at which foreign currencies are converted to
   * one another. Only shows the currencies for which Stripe supports.
   */
  public static ExchangeRateCollection list(ExchangeRateListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of objects that contain the rates at which foreign currencies are converted to
   * one another. Only shows the currencies for which Stripe supports.
   */
  public static ExchangeRateCollection list(ExchangeRateListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/exchange_rates");
    return ApiResource.requestCollection(url, params, ExchangeRateCollection.class, options);
  }

  /** Retrieves the exchange rates from the given currency to every supported currency. */
  public static ExchangeRate retrieve(String rateId) throws JaguarException {
    return retrieve(rateId, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the exchange rates from the given currency to every supported currency. */
  public static ExchangeRate retrieve(String rateId, RequestOptions options)
      throws JaguarException {
    return retrieve(rateId, (Map<String, Object>) null, options);
  }

  /** Retrieves the exchange rates from the given currency to every supported currency. */
  public static ExchangeRate retrieve(
      String rateId, Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/exchange_rates/%s", ApiResource.urlEncodeId(rateId)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ExchangeRate.class, options);
  }

  /** Retrieves the exchange rates from the given currency to every supported currency. */
  public static ExchangeRate retrieve(
      String rateId, ExchangeRateRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/exchange_rates/%s", ApiResource.urlEncodeId(rateId)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ExchangeRate.class, options);
  }
}
