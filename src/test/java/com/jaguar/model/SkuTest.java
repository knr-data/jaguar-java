package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class SkuTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/skus/sku_123");
    final Sku sku = ApiResource.GSON.fromJson(data, Sku.class);
    assertNotNull(sku);
    assertNotNull(sku.getId());
    assertEquals("sku", sku.getObject());
    assertNull(sku.getProductObject());
  }

  @Test
  public void testDeserializeWithExpansions() throws Exception {
    final String[] expansions = {"product"};
    final String data = getFixture("/v1/skus/sku_123", expansions);
    final Sku sku = ApiResource.GSON.fromJson(data, Sku.class);
    assertNotNull(sku);
    final Product product = sku.getProductObject();
    assertNotNull(product);
    assertNotNull(product.getId());
    assertEquals(sku.getProduct(), product.getId());
  }
}
