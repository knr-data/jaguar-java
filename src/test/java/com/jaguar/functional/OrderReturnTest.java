package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.OrderReturn;
import com.jaguar.model.OrderReturnCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OrderReturnTest extends BaseJaguarTest {
  public static final String RETURN_ID = "orret_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final OrderReturn orderReturn = OrderReturn.retrieve(RETURN_ID);

    assertNotNull(orderReturn);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/order_returns/%s", RETURN_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final OrderReturnCollection orderReturns = OrderReturn.list(params);

    assertNotNull(orderReturns);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/order_returns", params);
  }
}
