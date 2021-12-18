// File generated from our OpenAPI spec
package com.jaguar.model;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.PromotionCodeCreateParams;
import com.jaguar.param.PromotionCodeListParams;
import com.jaguar.param.PromotionCodeRetrieveParams;
import com.jaguar.param.PromotionCodeUpdateParams;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PromotionCode extends ApiResource implements HasId, MetadataStore<PromotionCode> {
  /**
   * Whether the promotion code is currently active. A promotion code is only active if the coupon
   * is also valid.
   */
  @SerializedName("active")
  Boolean active;

  /**
   * The customer-facing code. Regardless of case, this code must be unique across all active
   * promotion codes for each customer.
   */
  @SerializedName("code")
  String code;

  /**
   * A coupon contains information about a percent-off or amount-off discount you might want to
   * apply to a customer. Coupons may be applied to <a
   * href="https://stripe.com/docs/api#invoices">invoices</a> or <a
   * href="https://stripe.com/docs/api#create_order_legacy-coupon">orders</a>. Coupons do not work
   * with conventional one-off <a href="https://stripe.com/docs/api#create_charge">charges</a>.
   */
  @SerializedName("coupon")
  Coupon coupon;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /** The customer that this promotion code can be used by. */
  @SerializedName("customer")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Customer> customer;

  /** Date at which the promotion code can no longer be redeemed. */
  @SerializedName("expires_at")
  Long expiresAt;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /** Maximum number of times this promotion code can be redeemed. */
  @SerializedName("max_redemptions")
  Long maxRedemptions;

  /**
   * Set of <a href="https://stripe.com/docs/api/metadata">key-value pairs</a> that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code promotion_code}.
   */
  @SerializedName("object")
  String object;

  @SerializedName("restrictions")
  Restrictions restrictions;

  /** Number of times this promotion code has been used. */
  @SerializedName("times_redeemed")
  Long timesRedeemed;

  /** Get ID of expandable {@code customer} object. */
  public String getCustomer() {
    return (this.customer != null) ? this.customer.getId() : null;
  }

  public void setCustomer(String id) {
    this.customer = ApiResource.setExpandableFieldId(id, this.customer);
  }

  /** Get expanded {@code customer}. */
  public Customer getCustomerObject() {
    return (this.customer != null) ? this.customer.getExpanded() : null;
  }

  public void setCustomerObject(Customer expandableObject) {
    this.customer = new ExpandableField<Customer>(expandableObject.getId(), expandableObject);
  }

  /**
   * Retrieves the promotion code with the given ID. In order to retrieve a promotion code by the
   * customer-facing <code>code</code> use <a
   * href="https://stripe.com/docs/api/promotion_codes/list">list</a> with the desired <code>code
   * </code>.
   */
  public static PromotionCode retrieve(String promotionCode) throws JaguarException {
    return retrieve(promotionCode, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves the promotion code with the given ID. In order to retrieve a promotion code by the
   * customer-facing <code>code</code> use <a
   * href="https://stripe.com/docs/api/promotion_codes/list">list</a> with the desired <code>code
   * </code>.
   */
  public static PromotionCode retrieve(String promotionCode, RequestOptions options)
      throws JaguarException {
    return retrieve(promotionCode, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves the promotion code with the given ID. In order to retrieve a promotion code by the
   * customer-facing <code>code</code> use <a
   * href="https://stripe.com/docs/api/promotion_codes/list">list</a> with the desired <code>code
   * </code>.
   */
  public static PromotionCode retrieve(
      String promotionCode, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/promotion_codes/%s", ApiResource.urlEncodeId(promotionCode)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, PromotionCode.class, options);
  }

  /**
   * Retrieves the promotion code with the given ID. In order to retrieve a promotion code by the
   * customer-facing <code>code</code> use <a
   * href="https://stripe.com/docs/api/promotion_codes/list">list</a> with the desired <code>code
   * </code>.
   */
  public static PromotionCode retrieve(
      String promotionCode, PromotionCodeRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/promotion_codes/%s", ApiResource.urlEncodeId(promotionCode)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, PromotionCode.class, options);
  }

  /**
   * A promotion code points to a coupon. You can optionally restrict the code to a specific
   * customer, redemption limit, and expiration date.
   */
  public static PromotionCode create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * A promotion code points to a coupon. You can optionally restrict the code to a specific
   * customer, redemption limit, and expiration date.
   */
  public static PromotionCode create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/promotion_codes");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, PromotionCode.class, options);
  }

  /**
   * A promotion code points to a coupon. You can optionally restrict the code to a specific
   * customer, redemption limit, and expiration date.
   */
  public static PromotionCode create(PromotionCodeCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * A promotion code points to a coupon. You can optionally restrict the code to a specific
   * customer, redemption limit, and expiration date.
   */
  public static PromotionCode create(PromotionCodeCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/promotion_codes");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, PromotionCode.class, options);
  }

  /**
   * Updates the specified promotion code by setting the values of the parameters passed. Most
   * fields are, by design, not editable.
   */
  @Override
  public PromotionCode update(Map<String, Object> params) throws JaguarException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specified promotion code by setting the values of the parameters passed. Most
   * fields are, by design, not editable.
   */
  @Override
  public PromotionCode update(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/promotion_codes/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, PromotionCode.class, options);
  }

  /**
   * Updates the specified promotion code by setting the values of the parameters passed. Most
   * fields are, by design, not editable.
   */
  public PromotionCode update(PromotionCodeUpdateParams params) throws JaguarException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specified promotion code by setting the values of the parameters passed. Most
   * fields are, by design, not editable.
   */
  public PromotionCode update(PromotionCodeUpdateParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/promotion_codes/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, PromotionCode.class, options);
  }

  /** Returns a list of your promotion codes. */
  public static PromotionCodeCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of your promotion codes. */
  public static PromotionCodeCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/promotion_codes");
    return ApiResource.requestCollection(url, params, PromotionCodeCollection.class, options);
  }

  /** Returns a list of your promotion codes. */
  public static PromotionCodeCollection list(PromotionCodeListParams params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of your promotion codes. */
  public static PromotionCodeCollection list(PromotionCodeListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/promotion_codes");
    return ApiResource.requestCollection(url, params, PromotionCodeCollection.class, options);
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class Restrictions extends JaguarObject {
    /**
     * A Boolean indicating if the Promotion Code should only be redeemed for Customers without any
     * successful payments or invoices.
     */
    @SerializedName("first_time_transaction")
    Boolean firstTimeTransaction;

    /**
     * Minimum amount required to redeem this Promotion Code into a Coupon (e.g., a purchase must be
     * $100 or more to work).
     */
    @SerializedName("minimum_amount")
    Long minimumAmount;

    /** Three-letter <a href="https://stripe.com/docs/currencies">ISO code</a> for minimum_amount */
    @SerializedName("minimum_amount_currency")
    String minimumAmountCurrency;
  }
}
