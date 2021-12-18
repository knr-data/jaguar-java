package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Order;
import com.jaguar.model.OrderCollection;
import com.jaguar.model.OrderReturn;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OrderTest extends BaseJaguarTest {
  public static final String ORDER_ID = "or_123";

  private Order getOrderFixture() throws JaguarException {
    final Order order = Order.retrieve(ORDER_ID);
    resetNetworkSpy();
    return order;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("currency", "usd");

    final Order order = Order.create(params);

    assertNotNull(order);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/orders", params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Order order = Order.retrieve(ORDER_ID);

    assertNotNull(order);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/orders/%s", ORDER_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Order order = getOrderFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("status", "fulfilled");

    final Order updatedOrder = order.update(params);

    assertNotNull(updatedOrder);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/orders/%s", order.getId()), params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final OrderCollection orders = Order.list(params);

    assertNotNull(orders);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/orders", params);
  }

  @Test
  public void testPay() throws JaguarException {
    final Order order = Order.retrieve(ORDER_ID);

    final Map<String, Object> params = new HashMap<>();
    params.put("customer", "cus_123");

    final Order paidOrder = order.pay(params);

    assertNotNull(paidOrder);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/orders/%s/pay", order.getId()), params);
  }

  @Test
  public void testReturn() throws JaguarException {
    final Order order = Order.retrieve(ORDER_ID);

    final OrderReturn orderReturn = order.returnOrder((Map<String, Object>) null);

    assertNotNull(orderReturn);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/orders/%s/returns", order.getId()),
        null);
  }
}
