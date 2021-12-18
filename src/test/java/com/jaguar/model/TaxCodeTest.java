package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class TaxCodeTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/tax_codes/txr_123");
    final TaxCode taxCode = ApiResource.GSON.fromJson(data, TaxCode.class);
    assertNotNull(taxCode);
    assertNotNull(taxCode.getId());
    assertEquals("tax_code", taxCode.getObject());
  }
}
