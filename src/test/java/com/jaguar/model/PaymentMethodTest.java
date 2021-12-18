package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class PaymentMethodTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/payment_methods/pm_123");
    final PaymentMethod resource = ApiResource.GSON.fromJson(data, PaymentMethod.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
