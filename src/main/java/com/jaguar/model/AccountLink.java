// File generated from our OpenAPI spec
package com.jaguar.model;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.AccountLinkCreateParams;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AccountLink extends ApiResource {
  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /** The timestamp at which this account link will expire. */
  @SerializedName("expires_at")
  Long expiresAt;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code account_link}.
   */
  @SerializedName("object")
  String object;

  /** The URL for the account link. */
  @SerializedName("url")
  String url;

  /**
   * Creates an AccountLink object that includes a single-use Stripe URL that the platform can
   * redirect their user to in order to take them through the Connect Onboarding flow.
   */
  public static AccountLink create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Creates an AccountLink object that includes a single-use Stripe URL that the platform can
   * redirect their user to in order to take them through the Connect Onboarding flow.
   */
  public static AccountLink create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/account_links");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, AccountLink.class, options);
  }

  /**
   * Creates an AccountLink object that includes a single-use Stripe URL that the platform can
   * redirect their user to in order to take them through the Connect Onboarding flow.
   */
  public static AccountLink create(AccountLinkCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Creates an AccountLink object that includes a single-use Stripe URL that the platform can
   * redirect their user to in order to take them through the Connect Onboarding flow.
   */
  public static AccountLink create(AccountLinkCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/account_links");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, AccountLink.class, options);
  }
}
