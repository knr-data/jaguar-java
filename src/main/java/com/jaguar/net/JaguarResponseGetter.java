package com.jaguar.net;

import com.jaguar.exception.JaguarException;
import com.jaguar.model.JaguarObjectInterface;
import java.io.InputStream;
import java.util.Map;

public interface JaguarResponseGetter {
  <T extends JaguarObjectInterface> T request(
      ApiResource.RequestMethod method,
      String url,
      Map<String, Object> params,
      Class<T> clazz,
      RequestOptions options)
      throws JaguarException;

  <T extends JaguarObjectInterface> T oauthRequest(
      ApiResource.RequestMethod method,
      String url,
      Map<String, Object> params,
      Class<T> clazz,
      RequestOptions options)
      throws JaguarException;

  default InputStream requestStream(
      ApiResource.RequestMethod method,
      String url,
      Map<String, Object> params,
      RequestOptions options)
      throws JaguarException {
    throw new UnsupportedOperationException(
        "requestStream is unimplemented for this StripeResponseGetter");
  }
}
