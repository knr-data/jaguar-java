package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Balance;
import com.jaguar.net.RequestOptions;
import com.jaguar.net.JaguarResponse;
import org.junit.jupiter.api.Test;

public class RequestOptionsTest extends BaseJaguarTest {
  @Test
  public void testApiVersion() throws JaguarException {
    final RequestOptions options = RequestOptions.builder().build();
    assertEquals(Jaguar.API_VERSION, options.getStripeVersion());
    assertNull(options.getStripeVersionOverride());

    final Balance balance = Balance.retrieve(options);
    final JaguarResponse response = balance.getLastResponse();

    assertNotNull(response);
    // stripe-mock doesn't send back a Stripe-Version header in the response.
    // assertEquals(Stripe.API_VERSION, response.headers().get("Stripe-Version"));
  }

  @Test
  public void testIdempotencyKey() throws JaguarException {
    final String idempotencyKey = "824d3177-9a1c-4124-a888-2c2fbd5f953a";

    final RequestOptions options =
        RequestOptions.builder().setIdempotencyKey(idempotencyKey).build();

    final Balance balance = Balance.retrieve(options);
    final JaguarResponse response = balance.getLastResponse();

    assertNotNull(response);
    assertEquals(idempotencyKey, response.idempotencyKey());
  }
}
