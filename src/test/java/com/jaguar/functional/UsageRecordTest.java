package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.UsageRecord;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class UsageRecordTest extends BaseJaguarTest {
  private static final String SUBSCRIPTION_ITEM_ID = "si_123";

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("quantity", 10);
    params.put("timestamp", System.currentTimeMillis() / 1000L);

    final UsageRecord resource =
        UsageRecord.createOnSubscriptionItem(SUBSCRIPTION_ITEM_ID, params, null);

    assertNotNull(resource);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/subscription_items/%s/usage_records", SUBSCRIPTION_ITEM_ID),
        params);
  }
}
