package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/products/prod_123");
    final Product product = ApiResource.GSON.fromJson(data, Product.class);
    assertNotNull(product);
    assertNotNull(product.getId());
    assertEquals("product", product.getObject());
  }
}
