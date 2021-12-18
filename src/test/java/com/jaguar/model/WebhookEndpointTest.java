package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class WebhookEndpointTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/webhook_endpoints/we_123");
    final WebhookEndpoint resource = ApiResource.GSON.fromJson(data, WebhookEndpoint.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
