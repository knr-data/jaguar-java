package com.jaguar.model;

import com.jaguar.net.JaguarResponse;

public interface JaguarObjectInterface {
  public JaguarResponse getLastResponse();

  public void setLastResponse(JaguarResponse response);
}
