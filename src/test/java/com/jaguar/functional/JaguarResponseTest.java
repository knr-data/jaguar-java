package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Customer;
import com.jaguar.model.CustomerCollection;
import com.jaguar.net.RequestOptions;
import com.jaguar.net.JaguarResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class JaguarResponseTest extends BaseJaguarTest {
  @Test
  public void testResponseIncluded() throws JaguarException {
    final String idempotencyKey = UUID.randomUUID().toString();
    final RequestOptions requestOptions =
        RequestOptions.builder().setIdempotencyKey(idempotencyKey).build();
    final Customer customer = Customer.create((Map<String, Object>) null, requestOptions);
    final Customer retrievedCustomer = Customer.retrieve(customer.getId(), requestOptions);
    final JaguarResponse response = retrievedCustomer.getLastResponse();
    assertNotNull(response);
    assertEquals(200, response.code());
    assertEquals(idempotencyKey, response.idempotencyKey());
    assertTrue(response.requestId().startsWith("req_"));
    assertTrue(response.body().length() > 0);
  }

  @Test
  public void testResponseIncludedList() throws JaguarException {
    final CustomerCollection customers = Customer.list(new HashMap<String, Object>());
    final JaguarResponse response = customers.getLastResponse();
    assertNotNull(response);
    assertEquals(200, response.code());
    assertTrue(response.requestId().startsWith("req_"));
    assertTrue(response.body().length() > 0);
  }
}
