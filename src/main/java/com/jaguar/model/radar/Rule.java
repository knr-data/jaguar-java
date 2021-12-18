// File generated from our OpenAPI spec
package com.jaguar.model.radar;

import com.google.gson.annotations.SerializedName;
import com.jaguar.model.HasId;
import com.jaguar.model.JaguarObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Rule extends JaguarObject implements HasId {
  /** The action taken on the payment. */
  @SerializedName("action")
  String action;

  /** Always true for a deleted object. */
  @SerializedName("deleted")
  Boolean deleted;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** The predicate to evaluate the payment against. */
  @SerializedName("predicate")
  String predicate;
}
