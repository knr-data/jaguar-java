// File generated from our OpenAPI spec
package com.jaguar.model.terminal;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.terminal.ConnectionTokenCreateParams;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ConnectionToken extends ApiResource {
  /**
   * The id of the location that this connection token is scoped to. Note that location scoping only
   * applies to internet-connected readers. For more details, see <a
   * href="https://stripe.com/docs/terminal/fleet/locations#connection-tokens">the docs on scoping
   * connection tokens</a>.
   */
  @SerializedName("location")
  String location;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code terminal.connection_token}.
   */
  @SerializedName("object")
  String object;

  /** Your application should pass this token to the Stripe Terminal SDK. */
  @SerializedName("secret")
  String secret;

  /**
   * To connect to a reader the Stripe Terminal SDK needs to retrieve a short-lived connection token
   * from Stripe, proxied through your server. On your backend, add an endpoint that creates and
   * returns a connection token.
   */
  public static ConnectionToken create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * To connect to a reader the Stripe Terminal SDK needs to retrieve a short-lived connection token
   * from Stripe, proxied through your server. On your backend, add an endpoint that creates and
   * returns a connection token.
   */
  public static ConnectionToken create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/terminal/connection_tokens");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ConnectionToken.class, options);
  }

  /**
   * To connect to a reader the Stripe Terminal SDK needs to retrieve a short-lived connection token
   * from Stripe, proxied through your server. On your backend, add an endpoint that creates and
   * returns a connection token.
   */
  public static ConnectionToken create(ConnectionTokenCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /**
   * To connect to a reader the Stripe Terminal SDK needs to retrieve a short-lived connection token
   * from Stripe, proxied through your server. On your backend, add an endpoint that creates and
   * returns a connection token.
   */
  public static ConnectionToken create(ConnectionTokenCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/terminal/connection_tokens");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ConnectionToken.class, options);
  }
}
