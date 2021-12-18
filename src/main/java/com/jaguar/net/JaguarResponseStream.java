package com.jaguar.net;

import com.jaguar.util.StreamUtils;
import java.io.IOException;
import java.io.InputStream;

public class JaguarResponseStream extends AbstractJaguarResponse<InputStream> {
  /**
   * Initializes a new instance of the {@link JaguarResponseStream} class.
   *
   * @param code the HTTP status code of the response
   * @param headers the HTTP headers of the response
   * @param body streaming body response
   * @throws NullPointerException if {@code headers} or {@code body} is {@code null}
   */
  public JaguarResponseStream(int code, HttpHeaders headers, InputStream body) {
    super(code, headers, body);
  }

  /**
   * Buffers the entire response body into a string, constructing the appropriate StripeResponse
   *
   * @return the StripeResponse
   */
  JaguarResponse unstream() throws IOException {
    final String bodyString = StreamUtils.readToEnd(this.body, ApiResource.CHARSET);
    this.body.close();
    return new JaguarResponse(this.code, this.headers, bodyString);
  }
}
