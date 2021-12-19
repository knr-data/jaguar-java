package com.jaguar.net;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.jaguar.Jaguar;
import com.jaguar.exception.*;
import com.jaguar.exception.JaguarException;
import com.jaguar.exception.oauth.InvalidClientException;
import com.jaguar.exception.oauth.InvalidGrantException;
import com.jaguar.exception.oauth.InvalidScopeException;
import com.jaguar.exception.oauth.OAuthException;
import com.jaguar.exception.oauth.UnsupportedGrantTypeException;
import com.jaguar.exception.oauth.UnsupportedResponseTypeException;
import com.jaguar.model.JaguarError;
import com.jaguar.model.JaguarObject;
import com.jaguar.model.JaguarObjectInterface;
import com.jaguar.model.oauth.OAuthError;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class LiveJaguarResponseGetter implements JaguarResponseGetter {
  private final HttpClient httpClient;

  /**
   * Initializes a new instance of the {@link LiveJaguarResponseGetter} class with default
   * parameters.
   */
  public LiveJaguarResponseGetter() {
    this(null);
  }

  /**
   * Initializes a new instance of the {@link LiveJaguarResponseGetter} class.
   *
   * @param httpClient the HTTP client to use
   */
  public LiveJaguarResponseGetter(HttpClient httpClient) {
    this.httpClient = (httpClient != null) ? httpClient : buildDefaultHttpClient();
  }

  @Override
  public <T extends JaguarObjectInterface> T request(
      ApiResource.RequestMethod method,
      String url,
      Map<String, Object> params,
      Class<T> clazz,
      RequestOptions options)
      throws JaguarException {
    JaguarRequest request = new JaguarRequest(method, url, params, options);
    JaguarResponse response = httpClient.requestWithRetries(request);

    int responseCode = response.code();
    String responseBody = response.body();
    String requestId = response.requestId();

    if (responseCode < 200 || responseCode >= 300) {
      handleApiError(response);
    }

    T resource = null;
    try {
      resource = ApiResource.GSON.fromJson(responseBody, clazz);
    } catch (JsonSyntaxException e) {
      raiseMalformedJsonError(responseBody, responseCode, requestId, e);
    }

    resource.setLastResponse(response);

    return resource;
  }

  @Override
  public InputStream requestStream(
      ApiResource.RequestMethod method,
      String url,
      Map<String, Object> params,
      RequestOptions options)
      throws JaguarException {
    JaguarRequest request = new JaguarRequest(method, url, params, options);
    JaguarResponseStream responseStream = httpClient.requestStreamWithRetries(request);

    int responseCode = responseStream.code();

    if (responseCode < 200 || responseCode >= 300) {
      JaguarResponse response;
      try {
        response = responseStream.unstream();
      } catch (IOException e) {
        throw new ApiConnectionException(
            String.format(
                "IOException during API request to Stripe (%s): %s "
                    + "Please check your internet connection and try again. If this problem persists,"
                    + "you should check Stripe's service status at https://twitter.com/stripestatus,"
                    + " or let us know at support@stripe.com.",
                Jaguar.getApiBase(), e.getMessage()),
            e);
      }
      handleApiError(response);
    }

    return responseStream.body();
  }

  @Override
  public <T extends JaguarObjectInterface> T oauthRequest(
      ApiResource.RequestMethod method,
      String url,
      Map<String, Object> params,
      Class<T> clazz,
      RequestOptions options)
      throws JaguarException {
    JaguarRequest request = new JaguarRequest(method, url, params, options);
    JaguarResponse response = this.httpClient.requestWithRetries(request);

    int responseCode = response.code();
    String responseBody = response.body();
    String requestId = response.requestId();

    if (responseCode < 200 || responseCode >= 300) {
      handleOAuthError(response);
    }

    T resource = null;
    try {
      resource = ApiResource.GSON.fromJson(responseBody, clazz);
    } catch (JsonSyntaxException e) {
      raiseMalformedJsonError(responseBody, responseCode, requestId, e);
    }

    if (resource instanceof JaguarObject) {
      JaguarObject obj = (JaguarObject) resource;
      obj.setLastResponse(response);
    }

    return resource;
  }

  private static HttpClient buildDefaultHttpClient() {
    return new HttpURLConnectionClient();
  }

  private static void raiseMalformedJsonError(
      String responseBody, int responseCode, String requestId, Throwable e) throws ApiException {
    String details = e == null ? "none" : e.getMessage();
    throw new ApiException(
        String.format(
            "Invalid response object from API: %s. (HTTP response code was %d). Additional details: %s.",
            responseBody, responseCode, details),
        requestId,
        null,
        responseCode,
        e);
  }

  private static void handleApiError(JaguarResponse response) throws JaguarException {
    JaguarError error = null;
    JaguarException exception = null;

    try {
      JsonObject jsonObject =
          ApiResource.GSON.fromJson(response.body(), JsonObject.class).getAsJsonObject("error");
      error = ApiResource.GSON.fromJson(jsonObject, JaguarError.class);
    } catch (JsonSyntaxException e) {
      raiseMalformedJsonError(response.body(), response.code(), response.requestId(), e);
    }
    if (error == null) {
      raiseMalformedJsonError(response.body(), response.code(), response.requestId(), null);
    }

    error.setLastResponse(response);

    switch (response.code()) {
      case 400:
      case 404:
        if ("idempotency_error".equals(error.getType())) {
          exception =
              new IdempotencyException(
                  error.getMessage(), response.requestId(), error.getCode(), response.code());
        } else {
          exception =
              new InvalidRequestException(
                  error.getMessage(),
                  error.getParam(),
                  response.requestId(),
                  error.getCode(),
                  response.code(),
                  null);
        }
        break;
      case 401:
        exception =
            new AuthenticationException(
                error.getMessage(), response.requestId(), error.getCode(), response.code());
        break;
      case 402:
        exception =
            new CardException(
                error.getMessage(),
                response.requestId(),
                error.getCode(),
                error.getParam(),
                error.getDeclineCode(),
                error.getCharge(),
                response.code(),
                null);
        break;
      case 403:
        exception =
            new PermissionException(
                error.getMessage(), response.requestId(), error.getCode(), response.code());
        break;
      case 429:
        exception =
            new RateLimitException(
                error.getMessage(),
                error.getParam(),
                response.requestId(),
                error.getCode(),
                response.code(),
                null);
        break;
      default:
        exception =
            new ApiException(
                error.getMessage(), response.requestId(), error.getCode(), response.code(), null);
        break;
    }

    exception.setStripeError(error);

    throw exception;
  }

  private static void handleOAuthError(JaguarResponse response) throws JaguarException {
    OAuthError error = null;
    JaguarException exception = null;

    try {
      error = ApiResource.GSON.fromJson(response.body(), OAuthError.class);
    } catch (JsonSyntaxException e) {
      raiseMalformedJsonError(response.body(), response.code(), response.requestId(), e);
    }
    if (error == null) {
      raiseMalformedJsonError(response.body(), response.code(), response.requestId(), null);
    }

    error.setLastResponse(response);

    String code = error.getError();
    String description = (error.getErrorDescription() != null) ? error.getErrorDescription() : code;

    switch (code) {
      case "invalid_client":
        exception =
            new InvalidClientException(
                code, description, response.requestId(), response.code(), null);
        break;
      case "invalid_grant":
        exception =
            new InvalidGrantException(
                code, description, response.requestId(), response.code(), null);
        break;
      case "invalid_request":
        exception =
            new com.jaguar.exception.oauth.InvalidRequestException(
                code, description, response.requestId(), response.code(), null);
        break;
      case "invalid_scope":
        exception =
            new InvalidScopeException(
                code, description, response.requestId(), response.code(), null);
        break;
      case "unsupported_grant_type":
        exception =
            new UnsupportedGrantTypeException(
                code, description, response.requestId(), response.code(), null);
        break;
      case "unsupported_response_type":
        exception =
            new UnsupportedResponseTypeException(
                code, description, response.requestId(), response.code(), null);
        break;
      default:
        exception = new ApiException(code, response.requestId(), null, response.code(), null);
        break;
    }

    if (exception instanceof OAuthException) {
      ((OAuthException) exception).setOauthError(error);
    }

    throw exception;
  }
}
