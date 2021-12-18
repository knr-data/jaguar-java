package com.jaguar.functional.checkout;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.LineItemCollection;
import com.jaguar.model.checkout.Session;
import com.jaguar.net.ApiResource;
import com.jaguar.param.checkout.SessionListLineItemsParams;
import org.junit.jupiter.api.Test;

public class SessionTest extends BaseJaguarTest {
  public static final String SESSION_ID = "cs_123";

  @Test
  public void testListLineItems() throws JaguarException {

    Session session = Session.retrieve(SESSION_ID);

    SessionListLineItemsParams params = SessionListLineItemsParams.builder().build();

    final LineItemCollection lineItems = session.listLineItems(params);

    assertNotNull(lineItems);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/checkout/sessions/cs_123/line_items"),
        params.toMap());
  }
}
