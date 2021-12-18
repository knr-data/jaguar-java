package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.AccountLink;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class AccountLinkTest extends BaseJaguarTest {
  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("account", "acct_123");
    params.put("refresh_url", "https://stripe.com/refresh");
    params.put("return_url", "https://stripe.com/return");
    params.put("type", "account_onboarding");

    final AccountLink accountLink = AccountLink.create(params);

    assertNotNull(accountLink);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/account_links"), params);
  }
}
