package com.jaguar.model.sigma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ScheduledQueryRunTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/sigma/scheduled_query_runs/sqr_123");
    final ScheduledQueryRun run = ApiResource.GSON.fromJson(data, ScheduledQueryRun.class);

    assertNotNull(run);
    assertNotNull(run.getId());
    assertEquals("scheduled_query_run", run.getObject());
    assertNotNull(run.getFile());
    assertEquals("file", run.getFile().getObject());
  }
}
