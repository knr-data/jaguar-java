package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.SubscriptionItem;
import com.jaguar.model.SubscriptionItemCollection;
import com.jaguar.model.UsageRecordSummaryCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SubscriptionItemTest extends BaseJaguarTest {
  public static final String ITEM_ID = "si_123";

  private SubscriptionItem getItemFixture() throws JaguarException {
    final SubscriptionItem item = SubscriptionItem.retrieve(ITEM_ID);
    resetNetworkSpy();
    return item;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("price", "price_123");
    params.put("subscription", "cus_123");
    params.put("quantity", 99);

    final SubscriptionItem subscriptionItem = SubscriptionItem.create(params);

    assertNotNull(subscriptionItem);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/subscription_items", params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final SubscriptionItem subscriptionItem = SubscriptionItem.retrieve(ITEM_ID);

    assertNotNull(subscriptionItem);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/subscription_items/%s", ITEM_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final SubscriptionItem subscriptionItem = getItemFixture();

    final Map<String, Object> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final SubscriptionItem updatedSubscriptionItem = subscriptionItem.update(params);

    assertNotNull(updatedSubscriptionItem);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/subscription_items/%s", subscriptionItem.getId()),
        params);
  }

  @Test
  public void testDelete() throws JaguarException {
    final SubscriptionItem subscriptionItem = getItemFixture();

    final SubscriptionItem deletedSubscriptionItem = subscriptionItem.delete();

    assertNotNull(deletedSubscriptionItem);
    assertTrue(deletedSubscriptionItem.getDeleted());
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/subscription_items/%s", subscriptionItem.getId()));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);
    params.put("subscription", "sub_123");

    final SubscriptionItemCollection subscriptionItems = SubscriptionItem.list(params);

    assertNotNull(subscriptionItems);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscription_items", params);
  }

  @Test
  public void testUsageRecordSummaries() throws JaguarException {
    final SubscriptionItem subscriptionItem = getItemFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final UsageRecordSummaryCollection summaries = subscriptionItem.usageRecordSummaries(params);

    assertNotNull(summaries);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/subscription_items/%s/usage_record_summaries", subscriptionItem.getId()),
        params);
  }
}
