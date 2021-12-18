package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class SourceTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/sources/src_123");
    final Source source = ApiResource.GSON.fromJson(data, Source.class);
    assertNotNull(source);
    assertNotNull(source.getId());
    assertEquals("source", source.getObject());
  }
}
