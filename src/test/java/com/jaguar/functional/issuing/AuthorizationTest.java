package com.jaguar.functional.issuing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.issuing.Authorization;
import com.jaguar.model.issuing.AuthorizationCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class AuthorizationTest extends BaseJaguarTest {
  public static final String AUTHORIZATION_ID = "iauth_123";

  @Test
  public void testApprove() throws JaguarException {
    final Authorization authorization = Authorization.retrieve(AUTHORIZATION_ID);

    final Authorization approvedAuthorization = authorization.approve((Map<String, Object>) null);

    assertNotNull(approvedAuthorization);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/authorizations/%s/approve", authorization.getId()),
        null);
  }

  @Test
  public void testDecline() throws JaguarException {
    final Authorization authorization = Authorization.retrieve(AUTHORIZATION_ID);

    final Authorization approvedAuthorization = authorization.decline((Map<String, Object>) null);

    assertNotNull(approvedAuthorization);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/authorizations/%s/decline", authorization.getId()),
        null);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Authorization authorization = Authorization.retrieve(AUTHORIZATION_ID);

    assertNotNull(authorization);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/issuing/authorizations/%s", AUTHORIZATION_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Authorization authorization = Authorization.retrieve(AUTHORIZATION_ID);

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Authorization updatedAuthorization = authorization.update(params);

    assertNotNull(updatedAuthorization);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/authorizations/%s", authorization.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    AuthorizationCollection authorizations = Authorization.list(params);

    assertNotNull(authorizations);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/issuing/authorizations"), params);
  }
}
