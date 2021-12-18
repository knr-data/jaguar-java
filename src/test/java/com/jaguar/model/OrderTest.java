package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class OrderTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/orders/or_123");
    final Order order = ApiResource.GSON.fromJson(data, Order.class);
    assertNotNull(order);
    assertNotNull(order.getId());
    assertEquals("order", order.getObject());
  }
}
