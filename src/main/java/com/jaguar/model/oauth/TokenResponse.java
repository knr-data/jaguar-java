package com.jaguar.model.oauth;

import com.jaguar.model.JaguarObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TokenResponse extends JaguarObject {
  Boolean livemode;
  String scope;
  String stripeUserId;
}
