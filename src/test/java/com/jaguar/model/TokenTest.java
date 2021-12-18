package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class TokenTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/tokens/tok_123");
    final Token token = ApiResource.GSON.fromJson(data, Token.class);
    assertNotNull(token);
    assertNotNull(token.getId());
    assertEquals("token", token.getObject());
  }
}
