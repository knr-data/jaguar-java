package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Account;
import com.jaguar.model.LoginLink;
import com.jaguar.net.ApiResource;
import java.io.IOException;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LoginLinkTest extends BaseJaguarTest {
  public static final String ACCOUNT_ID = "acct_123";

  @Test
  public void testCreate() throws IOException, JaguarException {
    final Account account = Account.retrieve(ACCOUNT_ID, null);

    final LoginLink link = LoginLink.createOnAccount(ACCOUNT_ID, (Map<String, Object>) null, null);

    stubRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/accounts/%s/login_links", account.getId()),
        null,
        LoginLink.class,
        getResourceAsString("/api_fixtures/login_link.json"));

    assertNotNull(link);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/accounts/%s/login_links", account.getId()));
  }
}
