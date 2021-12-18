package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class QuoteTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/quotes/qt_123");
    final Quote quote = ApiResource.GSON.fromJson(data, Quote.class);
    assertNotNull(quote);
    assertNotNull(quote.getId());
    assertEquals("quote", quote.getObject());
  }
}
