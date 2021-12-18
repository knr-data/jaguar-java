package com.jaguar.model.oauth;

import com.jaguar.model.JaguarObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OAuthError extends JaguarObject {
  String error;
  String errorDescription;
}
