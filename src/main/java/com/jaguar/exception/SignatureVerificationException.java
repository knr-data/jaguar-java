package com.jaguar.exception;

import lombok.Getter;

@Getter
public class SignatureVerificationException extends JaguarException {
  private static final long serialVersionUID = 2L;

  private final String sigHeader;

  public SignatureVerificationException(String message, String sigHeader) {
    super(message, null, null, 0);
    this.sigHeader = sigHeader;
  }
}
