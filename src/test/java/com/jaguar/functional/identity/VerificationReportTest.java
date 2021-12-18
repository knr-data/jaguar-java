package com.jaguar.functional.identity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.identity.VerificationReport;
import com.jaguar.model.identity.VerificationReportCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class VerificationReportTest extends BaseJaguarTest {
  public static final String VERIFICATION_REPORT_ID = "vr_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final VerificationReport verificationReport =
        VerificationReport.retrieve(VERIFICATION_REPORT_ID);

    assertNotNull(verificationReport);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/identity/verification_reports/%s", VERIFICATION_REPORT_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    VerificationReportCollection verificationReports = VerificationReport.list(params);

    assertNotNull(verificationReports);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/identity/verification_reports"), params);
  }
}
