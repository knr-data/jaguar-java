package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.ApplePayDomain;
import com.jaguar.model.ApplePayDomainCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ApplePayDomainTest extends BaseJaguarTest {
  public static final String DOMAIN_ID = "apftw_123";

  private ApplePayDomain getDomainFixture() throws JaguarException {
    final ApplePayDomain domain = ApplePayDomain.retrieve(DOMAIN_ID);
    resetNetworkSpy();
    return domain;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("domain_name", "stripe.com");

    final ApplePayDomain domain = ApplePayDomain.create(params);

    assertNotNull(domain);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/apple_pay/domains"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final ApplePayDomain domain = ApplePayDomain.retrieve(DOMAIN_ID);

    assertNotNull(domain);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/apple_pay/domains/%s", DOMAIN_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final ApplePayDomainCollection domains = ApplePayDomain.list(params);

    assertNotNull(domains);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/apple_pay/domains"), params);
  }

  @Test
  public void testDelete() throws JaguarException {
    final ApplePayDomain domain = getDomainFixture();

    final ApplePayDomain deletedDomain = domain.delete();

    assertNotNull(deletedDomain);
    assertTrue(deletedDomain.getDeleted());
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/apple_pay/domains/%s", domain.getId()));
  }
}
