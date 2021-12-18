package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.ExchangeRate;
import com.jaguar.model.ExchangeRateCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ExchangeRateTest extends BaseJaguarTest {
  public static final String CURRENCY = "usd";

  @Test
  public void testRetrieve() throws JaguarException {
    final ExchangeRate rate = ExchangeRate.retrieve(CURRENCY);

    assertNotNull(rate);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/exchange_rates/usd"));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final ExchangeRateCollection rates = ExchangeRate.list(params);

    assertNotNull(rates);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/exchange_rates"));
  }
}
