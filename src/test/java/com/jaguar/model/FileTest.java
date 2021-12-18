package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class FileTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/files/file_123");
    final File file = ApiResource.GSON.fromJson(data, File.class);
    assertNotNull(file);
    assertNotNull(file.getId());
  }
}
