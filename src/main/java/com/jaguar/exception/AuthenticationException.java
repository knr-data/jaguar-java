package com.jaguar.exception;

public class AuthenticationException extends JaguarException {
  private static final long serialVersionUID = 2L;

  public AuthenticationException(
      String message, String requestId, String code, Integer statusCode) {
    super(message, requestId, code, statusCode);
  }
}
