package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Customer;
import com.jaguar.model.CustomerCollection;
import com.jaguar.model.Discount;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CustomerTest extends BaseJaguarTest {
  public static final String CUSTOMER_ID = "cus_123";

  private Customer getCustomerFixture() throws JaguarException {
    final Customer customer = Customer.retrieve(CUSTOMER_ID);
    resetNetworkSpy();
    return customer;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();

    final Customer customer = Customer.create(params);

    assertNotNull(customer);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/customers"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Customer customer = Customer.retrieve(CUSTOMER_ID);

    assertNotNull(customer);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/customers/%s", CUSTOMER_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Customer customer = getCustomerFixture();

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Customer updatedCustomer = customer.update(params);

    assertNotNull(updatedCustomer);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/customers/%s", customer.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final CustomerCollection customers = Customer.list(params);

    assertNotNull(customers);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/customers"), params);
  }

  @Test
  public void testDelete() throws JaguarException {
    final Customer customer = getCustomerFixture();

    final Customer deletedCustomer = customer.delete();

    assertNotNull(deletedCustomer);
    assertTrue(deletedCustomer.getDeleted());
    verifyRequest(
        ApiResource.RequestMethod.DELETE, String.format("/v1/customers/%s", customer.getId()));
  }

  @Test
  public void testDeleteDiscount() throws JaguarException {
    final Customer customer = getCustomerFixture();

    // stripe-mock does not support /v1/customers/%s/discount endpoint, so we stub the request
    stubRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/customers/%s/discount", customer.getId()),
        null,
        Discount.class,
        null);

    customer.deleteDiscount();

    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/customers/%s/discount", customer.getId()));
  }
}
