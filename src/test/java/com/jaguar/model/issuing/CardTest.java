package com.jaguar.model.issuing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class CardTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/issuing/cards/ic_123");
    final Card card = ApiResource.GSON.fromJson(data, Card.class);

    assertNotNull(card);
    assertNotNull(card.getId());
    assertEquals("issuing.card", card.getObject());
    // assertNotNull(card.getCardholder());
    // assertEquals("issuing.cardholder", card.getCardholder().getObject());
  }
}
