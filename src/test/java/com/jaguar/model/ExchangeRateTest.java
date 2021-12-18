package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ExchangeRateTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/exchange_rates/usd");
    final ExchangeRate resource = ApiResource.GSON.fromJson(data, ExchangeRate.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
