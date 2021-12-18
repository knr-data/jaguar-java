package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class CardTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/customers/cus_123/cards/card_123");
    final Card resource = ApiResource.GSON.fromJson(data, Card.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
