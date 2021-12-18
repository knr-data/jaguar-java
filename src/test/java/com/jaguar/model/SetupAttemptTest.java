package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class SetupAttemptTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    // Keep the fixture to have `action` deserialize properly
    final SetupAttempt resource =
        ApiResource.GSON.fromJson(
            getResourceAsString("/api_fixtures/setup_attempt.json"), SetupAttempt.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
