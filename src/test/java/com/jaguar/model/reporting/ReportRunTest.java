package com.jaguar.model.reporting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ReportRunTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/reporting/report_runs/frr_123");
    final ReportRun reportRun = ApiResource.GSON.fromJson(data, ReportRun.class);

    assertNotNull(reportRun);
    assertNotNull(reportRun.getId());
    assertEquals("reporting.report_run", reportRun.getObject());
  }
}
