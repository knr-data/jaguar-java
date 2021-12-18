package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class SubscriptionScheduleTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/subscription_schedules/sub_sched_123");
    final SubscriptionSchedule resource =
        ApiResource.GSON.fromJson(data, SubscriptionSchedule.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }

  @Test
  public void testDeserializeWithExpansions() throws Exception {
    // TODO: support expanding "phases.coupon" and "phases.plans.plan" with stripe-mock
    final String[] expansions = {"customer", "subscription"};

    final String data = getFixture("/v1/subscription_schedules/sub_sched_123", expansions);

    final SubscriptionSchedule resource =
        ApiResource.GSON.fromJson(data, SubscriptionSchedule.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());

    final Customer customer = resource.getCustomerObject();
    assertNotNull(customer);
    assertNotNull(customer.getId());
    assertEquals(resource.getCustomer(), customer.getId());

    final Subscription subscription = resource.getSubscriptionObject();
    assertNotNull(subscription);
    assertNotNull(subscription.getId());
    assertEquals(resource.getSubscription(), subscription.getId());
  }
}
