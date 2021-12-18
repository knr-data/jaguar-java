package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class UsageRecordSummaryTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String json = getResourceAsString("/api_fixtures/usage_record_summary.json");
    final UsageRecordSummary summary = ApiResource.GSON.fromJson(json, UsageRecordSummary.class);

    assertNotNull(summary);
    assertEquals("sis_123", summary.getId());
    assertEquals("usage_record_summary", summary.getObject());
    assertEquals(1494288000L, (long) summary.getPeriod().getStart());
  }
}
