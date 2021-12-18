package com.jaguar.net;

import com.jaguar.Jaguar;
import com.jaguar.exception.AuthenticationException;
import com.jaguar.exception.InvalidRequestException;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.oauth.DeauthorizedAccount;
import com.jaguar.model.oauth.TokenResponse;
import java.util.HashMap;
import java.util.Map;

public final class OAuth {
  private static JaguarResponseGetter jaguarResponseGetter = new LiveJaguarResponseGetter();

  public static void setStripeResponseGetter(JaguarResponseGetter srg) {
    OAuth.jaguarResponseGetter = srg;
  }

  /**
   * Generates a URL to Stripe's OAuth form.
   *
   * @param params the parameters to include in the URL.
   * @param options the request options.
   * @return the URL to Stripe's OAuth form.
   */
  public static String authorizeUrl(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException {
    final String base = Jaguar.getConnectBase();

    params.put("client_id", getClientId(params, options));
    if (params.get("response_type") == null) {
      params.put("response_type", "code");
    }
    String query = FormEncoder.createQueryString(params);
    String url = base + "/oauth/authorize?" + query;
    return url;
  }

  /**
   * Uses an authorization code to connect an account to your platform and fetch the user's
   * credentials.
   *
   * @param params the request parameters.
   * @param options the request options.
   * @return the TokenResponse instance containing the response from the OAuth API.
   */
  public static TokenResponse token(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = Jaguar.getConnectBase() + "/oauth/token";
    return OAuth.jaguarResponseGetter.oauthRequest(
        ApiResource.RequestMethod.POST, url, params, TokenResponse.class, options);
  }

  /**
   * Disconnects an account from your platform.
   *
   * @param params the request parameters.
   * @param options the request options.
   * @return the DeauthorizedAccount instance containing the response from the OAuth API.
   */
  public static DeauthorizedAccount deauthorize(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    Map<String, Object> paramsCopy = new HashMap<>();
    paramsCopy.putAll(params);

    String url = Jaguar.getConnectBase() + "/oauth/deauthorize";
    paramsCopy.put("client_id", getClientId(paramsCopy, options));
    return OAuth.jaguarResponseGetter.oauthRequest(
        ApiResource.RequestMethod.POST, url, paramsCopy, DeauthorizedAccount.class, options);
  }

  /**
   * Returns the client_id to use in OAuth requests.
   *
   * @param params the request parameters.
   * @param options the request options.
   * @return the client_id.
   */
  private static String getClientId(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException {
    String clientId = Jaguar.clientId;
    if ((options != null) && (options.getClientId() != null)) {
      clientId = options.getClientId();
    }
    if ((params != null) && (params.get("client_id") != null)) {
      clientId = (String) params.get("client_id");
    }

    if (clientId == null) {
      throw new AuthenticationException(
          "No client_id provided. (HINT: set client_id key using 'Stripe.clientId = <CLIENT-ID>'. "
              + "You can find your client_ids in your Stripe dashboard at "
              + "https://dashboard.stripe.com/account/applications/settings, "
              + "after registering your account as a platform. See "
              + "https://stripe.com/docs/connect/standard-accounts for details, "
              + "or email support@stripe.com if you have any questions.",
          null,
          null,
          0);
    }

    return clientId;
  }
}
