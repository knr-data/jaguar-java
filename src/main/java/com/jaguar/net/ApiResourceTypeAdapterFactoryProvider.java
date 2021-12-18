// File generated from our OpenAPI spec
package com.jaguar.net;

import com.google.gson.TypeAdapterFactory;
import com.jaguar.model.BalanceTransactionSourceTypeAdapterFactory;
import com.jaguar.model.ExternalAccountTypeAdapterFactory;
import com.jaguar.model.PaymentSourceTypeAdapterFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Provider for all {@link TypeAdapterFactory} required for deserializing subtypes of an interface.
 */
final class ApiResourceTypeAdapterFactoryProvider {
  private static final List<TypeAdapterFactory> factories = new ArrayList<>();

  static {
    factories.add(new BalanceTransactionSourceTypeAdapterFactory());
    factories.add(new ExternalAccountTypeAdapterFactory());
    factories.add(new PaymentSourceTypeAdapterFactory());
    factories.add(new ReflectionCheckingTypeAdapterFactory());
  }

  public static List<TypeAdapterFactory> getAll() {
    return factories;
  }
}
