// File generated from our OpenAPI spec
package com.jaguar.model;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AutomaticPaymentMethodsPaymentIntent extends JaguarObject {
  /** Automatically calculates compatible payment methods. */
  @SerializedName("enabled")
  Boolean enabled;
}
