package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class LoginLinkTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getResourceAsString("/api_fixtures/login_link.json");
    final LoginLink link = ApiResource.GSON.fromJson(data, LoginLink.class);
    assertNotNull(link);
    assertNotNull(link.getUrl());
  }
}
