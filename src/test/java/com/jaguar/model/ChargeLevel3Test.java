package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ChargeLevel3Test extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getResourceAsString("/api_fixtures/charge_level3.json");
    final Charge.Level3 object = ApiResource.GSON.fromJson(data, Charge.Level3.class);
    assertEquals("1234", object.getMerchantReference());
    assertEquals(2, object.getLineItems().size());
  }
}
