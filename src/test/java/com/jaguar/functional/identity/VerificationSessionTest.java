package com.jaguar.functional.identity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.identity.VerificationSession;
import com.jaguar.model.identity.VerificationSessionCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class VerificationSessionTest extends BaseJaguarTest {
  public static final String VERIFICATION_SESSION_ID = "vs_123";

  @Test
  public void testCancel() throws JaguarException {
    final VerificationSession verificationSession =
        VerificationSession.retrieve(VERIFICATION_SESSION_ID);

    final VerificationSession cancelledVerificationSession =
        verificationSession.cancel((Map<String, Object>) null);

    assertNotNull(cancelledVerificationSession);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/identity/verification_sessions/%s/cancel", verificationSession.getId()),
        null);
  }

  @Test
  public void testRedact() throws JaguarException {
    final VerificationSession verificationSession =
        VerificationSession.retrieve(VERIFICATION_SESSION_ID);

    final VerificationSession redactedVerificationSession =
        verificationSession.redact((Map<String, Object>) null);

    assertNotNull(redactedVerificationSession);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/identity/verification_sessions/%s/redact", verificationSession.getId()),
        null);
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("type", "id_number");

    final VerificationSession verificationSession = VerificationSession.create(params);

    assertNotNull(verificationSession);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/identity/verification_sessions", params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final VerificationSession verificationSession =
        VerificationSession.retrieve(VERIFICATION_SESSION_ID);

    assertNotNull(verificationSession);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/identity/verification_sessions/%s", VERIFICATION_SESSION_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final VerificationSession verificationSession =
        VerificationSession.retrieve(VERIFICATION_SESSION_ID);

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final VerificationSession updatedVerificationSession = verificationSession.update(params);

    assertNotNull(updatedVerificationSession);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/identity/verification_sessions/%s", verificationSession.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    VerificationSessionCollection verificationSessions = VerificationSession.list(params);

    assertNotNull(verificationSessions);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/identity/verification_sessions"), params);
  }
}
