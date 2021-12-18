package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Subscription;
import org.junit.jupiter.api.Test;

public class JaguarObjectTest extends BaseJaguarTest {
  @Test
  public void testGetRawJsonObject() throws JaguarException {
    final Subscription subscription = Subscription.retrieve("sub_123");

    // Access `id`, a string element
    assertEquals(
        subscription.getId(),
        subscription.getRawJsonObject().getAsJsonPrimitive("id").getAsString());

    // Access `created`, a number element
    assertEquals(
        subscription.getCreated(),
        subscription.getRawJsonObject().getAsJsonPrimitive("created").getAsLong());

    // Access `items[data][0][id]`, a deeply nested string element
    assertEquals(
        subscription.getItems().getData().get(0).getId(),
        subscription
            .getRawJsonObject()
            .getAsJsonObject("items")
            .getAsJsonArray("data")
            .get(0)
            .getAsJsonObject()
            .getAsJsonPrimitive("id")
            .getAsString());
  }
}
