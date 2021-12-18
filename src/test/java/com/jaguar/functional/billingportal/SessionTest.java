package com.jaguar.functional.billingportal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.billingportal.Session;
import com.jaguar.net.ApiResource;
import com.jaguar.param.billingportal.SessionCreateParams;
import org.junit.jupiter.api.Test;

public class SessionTest extends BaseJaguarTest {
  public static final String SESSION_ID = "bps_123";

  @Test
  public void testCreate() throws JaguarException {

    SessionCreateParams params =
        SessionCreateParams.builder()
            .setCustomer("cus_123")
            .setReturnUrl("https://stripe.com/return")
            .build();

    final Session session = Session.create(params);

    assertNotNull(session);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/billing_portal/sessions"),
        params.toMap());
  }
}
