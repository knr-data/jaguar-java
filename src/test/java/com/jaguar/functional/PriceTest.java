package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Price;
import com.jaguar.model.PriceCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PriceTest extends BaseJaguarTest {
  public static final String PRICE_ID = "price_123";

  private Price getPriceFixture() throws JaguarException {
    final Price price = Price.retrieve(PRICE_ID);
    resetNetworkSpy();
    return price;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> recurringParams = new HashMap<>();
    recurringParams.put("interval", "month");

    final Map<String, Object> productDataParams = new HashMap<>();
    productDataParams.put("name", "Product name");

    final Map<String, Object> params = new HashMap<>();
    params.put("unit_amount", 1000);
    params.put("currency", "usd");
    params.put("recurring", recurringParams);
    params.put("product_data", productDataParams);

    final Price price = Price.create(params);

    assertNotNull(price);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/prices", params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Price price = Price.retrieve(PRICE_ID);

    assertNotNull(price);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/prices/%s", PRICE_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Price price = getPriceFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("nickname", "Updated Name");

    final Price updatedPrice = price.update(params);

    assertNotNull(updatedPrice);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/prices/%s", price.getId()), params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    PriceCollection prices = Price.list(params);

    assertNotNull(prices);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/prices", params);
  }
}
