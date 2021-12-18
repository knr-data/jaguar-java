package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ApplePayDomainTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/apple_pay/domains/apftw_123");
    final ApplePayDomain resource = ApiResource.GSON.fromJson(data, ApplePayDomain.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
