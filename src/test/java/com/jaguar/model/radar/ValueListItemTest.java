package com.jaguar.model.radar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ValueListItemTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/radar/value_lists/rsli_123");
    final ValueListItem valueListItem = ApiResource.GSON.fromJson(data, ValueListItem.class);

    assertNotNull(valueListItem);
    assertNotNull(valueListItem.getId());
    assertEquals("radar.value_list", valueListItem.getObject());
  }
}
