package com.jaguar.functional.sigma;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.sigma.ScheduledQueryRun;
import com.jaguar.model.sigma.ScheduledQueryRunCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ScheduledQueryRunTest extends BaseJaguarTest {
  public static final String RUN_ID = "sqr_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final ScheduledQueryRun run = ScheduledQueryRun.retrieve(RUN_ID);

    assertNotNull(run);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/sigma/scheduled_query_runs/%s", RUN_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    ScheduledQueryRunCollection runs = ScheduledQueryRun.list(params);

    assertNotNull(runs);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/sigma/scheduled_query_runs"), params);
  }
}
