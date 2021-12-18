// File generated from our OpenAPI spec
package com.jaguar.model.radar;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Charge;
import com.jaguar.model.ExpandableField;
import com.jaguar.model.HasId;
import com.jaguar.model.PaymentIntent;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.radar.EarlyFraudWarningListParams;
import com.jaguar.param.radar.EarlyFraudWarningRetrieveParams;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class EarlyFraudWarning extends ApiResource implements HasId {
  /**
   * An EFW is actionable if it has not received a dispute and has not been fully refunded. You may
   * wish to proactively refund a charge that receives an EFW, in order to avoid receiving a dispute
   * later.
   */
  @SerializedName("actionable")
  Boolean actionable;

  /** ID of the charge this early fraud warning is for, optionally expanded. */
  @SerializedName("charge")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Charge> charge;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /**
   * The type of fraud labelled by the issuer. One of {@code card_never_received}, {@code
   * fraudulent_card_application}, {@code made_with_counterfeit_card}, {@code made_with_lost_card},
   * {@code made_with_stolen_card}, {@code misc}, {@code unauthorized_use_of_card}.
   */
  @SerializedName("fraud_type")
  String fraudType;

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

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code radar.early_fraud_warning}.
   */
  @SerializedName("object")
  String object;

  /** ID of the Payment Intent this early fraud warning is for, optionally expanded. */
  @SerializedName("payment_intent")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<PaymentIntent> paymentIntent;

  /** Get ID of expandable {@code charge} object. */
  public String getCharge() {
    return (this.charge != null) ? this.charge.getId() : null;
  }

  public void setCharge(String id) {
    this.charge = ApiResource.setExpandableFieldId(id, this.charge);
  }

  /** Get expanded {@code charge}. */
  public Charge getChargeObject() {
    return (this.charge != null) ? this.charge.getExpanded() : null;
  }

  public void setChargeObject(Charge expandableObject) {
    this.charge = new ExpandableField<Charge>(expandableObject.getId(), expandableObject);
  }

  /** Get ID of expandable {@code paymentIntent} object. */
  public String getPaymentIntent() {
    return (this.paymentIntent != null) ? this.paymentIntent.getId() : null;
  }

  public void setPaymentIntent(String id) {
    this.paymentIntent = ApiResource.setExpandableFieldId(id, this.paymentIntent);
  }

  /** Get expanded {@code paymentIntent}. */
  public PaymentIntent getPaymentIntentObject() {
    return (this.paymentIntent != null) ? this.paymentIntent.getExpanded() : null;
  }

  public void setPaymentIntentObject(PaymentIntent expandableObject) {
    this.paymentIntent =
        new ExpandableField<PaymentIntent>(expandableObject.getId(), expandableObject);
  }

  /** Returns a list of early fraud warnings. */
  public static EarlyFraudWarningCollection list(Map<String, Object> params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of early fraud warnings. */
  public static EarlyFraudWarningCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/radar/early_fraud_warnings");
    return ApiResource.requestCollection(url, params, EarlyFraudWarningCollection.class, options);
  }

  /** Returns a list of early fraud warnings. */
  public static EarlyFraudWarningCollection list(EarlyFraudWarningListParams params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of early fraud warnings. */
  public static EarlyFraudWarningCollection list(
      EarlyFraudWarningListParams params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/radar/early_fraud_warnings");
    return ApiResource.requestCollection(url, params, EarlyFraudWarningCollection.class, options);
  }

  /**
   * Retrieves the details of an early fraud warning that has previously been created.
   *
   * <p>Please refer to the <a href="https://stripe.com/docs/api#early_fraud_warning_object">early
   * fraud warning</a> object reference for more details.
   */
  public static EarlyFraudWarning retrieve(String earlyFraudWarning) throws JaguarException {
    return retrieve(earlyFraudWarning, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves the details of an early fraud warning that has previously been created.
   *
   * <p>Please refer to the <a href="https://stripe.com/docs/api#early_fraud_warning_object">early
   * fraud warning</a> object reference for more details.
   */
  public static EarlyFraudWarning retrieve(String earlyFraudWarning, RequestOptions options)
      throws JaguarException {
    return retrieve(earlyFraudWarning, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves the details of an early fraud warning that has previously been created.
   *
   * <p>Please refer to the <a href="https://stripe.com/docs/api#early_fraud_warning_object">early
   * fraud warning</a> object reference for more details.
   */
  public static EarlyFraudWarning retrieve(
      String earlyFraudWarning, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format(
                "/v1/radar/early_fraud_warnings/%s", ApiResource.urlEncodeId(earlyFraudWarning)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, EarlyFraudWarning.class, options);
  }

  /**
   * Retrieves the details of an early fraud warning that has previously been created.
   *
   * <p>Please refer to the <a href="https://stripe.com/docs/api#early_fraud_warning_object">early
   * fraud warning</a> object reference for more details.
   */
  public static EarlyFraudWarning retrieve(
      String earlyFraudWarning, EarlyFraudWarningRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format(
                "/v1/radar/early_fraud_warnings/%s", ApiResource.urlEncodeId(earlyFraudWarning)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, EarlyFraudWarning.class, options);
  }
}
