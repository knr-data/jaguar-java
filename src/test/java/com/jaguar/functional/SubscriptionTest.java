package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Subscription;
import com.jaguar.model.SubscriptionCollection;
import com.jaguar.net.ApiResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SubscriptionTest extends BaseJaguarTest {
  public static final String SUBSCRIPTION_ID = "sub_123";

  private Subscription getSubscriptionFixture() throws JaguarException {
    final Subscription subscription = Subscription.retrieve(SUBSCRIPTION_ID);
    resetNetworkSpy();
    return subscription;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> item = new HashMap<>();
    item.put("plan", "silver-plan_123-898");
    final List<Object> items = new ArrayList<>();
    items.add(item);
    final Map<String, Object> params = new HashMap<>();
    params.put("customer", "cus_123");
    params.put("items", items);

    final Subscription subscription = Subscription.create(params);

    assertNotNull(subscription);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/subscriptions", params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Subscription subscription = Subscription.retrieve(SUBSCRIPTION_ID);

    assertNotNull(subscription);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/subscriptions/%s", SUBSCRIPTION_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Subscription subscription = getSubscriptionFixture();

    final Map<String, Object> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Subscription updatedSubscription = subscription.update(params);

    assertNotNull(updatedSubscription);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/subscriptions/%s", subscription.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final SubscriptionCollection subscriptions = Subscription.list(params);

    assertNotNull(subscriptions);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscriptions", params);
  }

  @Test
  public void testCancel() throws JaguarException {
    final Subscription subscription = getSubscriptionFixture();

    final Subscription canceledSubscription = subscription.cancel((Map<String, Object>) null);

    assertNotNull(canceledSubscription);
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/subscriptions/%s", subscription.getId()));
  }

  @Test
  public void testDeleteDiscount() throws JaguarException {
    final Subscription subscription = getSubscriptionFixture();

    subscription.deleteDiscount();

    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/subscriptions/%s/discount", subscription.getId()));
  }
}
