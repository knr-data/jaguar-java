package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class CountrySpecTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/country_specs/us");
    final CountrySpec resource = ApiResource.GSON.fromJson(data, CountrySpec.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
