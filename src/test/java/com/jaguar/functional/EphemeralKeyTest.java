package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.ImmutableMap;
import com.jaguar.BaseJaguarTest;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.EphemeralKey;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.EphemeralKeyCreateParams;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class EphemeralKeyTest extends BaseJaguarTest {

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("customer", "cus_123");

    // In actual usage, version override is likely different from the pinned API version.
    // Passing the same API version here to comply with stripe-mock `-strict-version-check`
    // flag--it errors on passing API version different from that in OpenAPI spec.
    final RequestOptions options =
        RequestOptions.builder().setStripeVersionOverride(Jaguar.API_VERSION).build();

    final EphemeralKey key = EphemeralKey.create(params, options);

    assertNotNull(key);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/ephemeral_keys", params, options);
  }

  @Test
  public void testThrowExceptionCreateWithNullTypedParams() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              EphemeralKey.create((EphemeralKeyCreateParams) null, RequestOptions.getDefault());
            });
    assertTrue(exception.getMessage().contains("Found null params"));
  }

  @Test
  public void testCreateWithTypedParams() throws JaguarException {
    EphemeralKeyCreateParams createParams =
        EphemeralKeyCreateParams.builder()
            .setCustomer("cust_123")
            .setIssuingCard("card_123")
            .build();

    final RequestOptions options =
        RequestOptions.builder().setStripeVersionOverride(Jaguar.API_VERSION).build();

    final EphemeralKey key = EphemeralKey.create(createParams, options);

    assertNotNull(key);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/ephemeral_keys",
        ImmutableMap.of(
            "customer", "cust_123",
            "issuing_card", "card_123"),
        options);
  }

  @Test
  public void testCreateWithoutApiVersionOverride() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("customer", "cus_123");

    final RequestOptions options = RequestOptions.getDefault();
    assertNull(options.getStripeVersionOverride());

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          EphemeralKey.create(params, options);
        });

    // create with typed params should have same validation behavior
    EphemeralKeyCreateParams typedParams =
        EphemeralKeyCreateParams.builder().setCustomer("cust_123").build();
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          EphemeralKey.create(typedParams, options);
        });
  }

  @Test
  public void testDelete() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("customer", "cus_123");

    // Passing the same API version here to comply with stripe-mock `-strict-version-check`
    // flag--it errors on passing API version different from that in OpenAPI spec.
    final RequestOptions options =
        RequestOptions.builder().setStripeVersionOverride(Jaguar.API_VERSION).build();

    final EphemeralKey key = EphemeralKey.create(params, options);

    final EphemeralKey deletedKey = key.delete();

    assertNotNull(deletedKey);
    verifyRequest(
        ApiResource.RequestMethod.DELETE, String.format("/v1/ephemeral_keys/%s", key.getId()));
  }
}
