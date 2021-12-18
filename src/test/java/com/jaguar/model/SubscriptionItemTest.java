package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class SubscriptionItemTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/subscription_items/si_123");
    final SubscriptionItem subscriptionItem =
        ApiResource.GSON.fromJson(data, SubscriptionItem.class);
    assertNotNull(subscriptionItem);
    assertNotNull(subscriptionItem.getId());
    assertEquals("subscription_item", subscriptionItem.getObject());
  }
}
