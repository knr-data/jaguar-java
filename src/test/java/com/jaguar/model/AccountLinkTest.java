package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class AccountLinkTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getResourceAsString("/api_fixtures/account_link.json");
    final AccountLink resource = ApiResource.GSON.fromJson(data, AccountLink.class);
    assertNotNull(resource);
    assertEquals("account_link", resource.getObject());
  }
}
