package com.jaguar.exception;

public class ApiException extends JaguarException {
  private static final long serialVersionUID = 2L;

  public ApiException(
      String message, String requestId, String code, Integer statusCode, Throwable e) {
    super(message, requestId, code, statusCode, e);
  }
}
