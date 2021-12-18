package com.jaguar.exception;

public class IdempotencyException extends JaguarException {
  private static final long serialVersionUID = 2L;

  public IdempotencyException(String message, String requestId, String code, Integer statusCode) {
    super(message, requestId, code, statusCode);
  }
}
