package com.jaguar.model.radar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class ValueListTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/radar/value_lists/rsl_123");
    final ValueList valueList = ApiResource.GSON.fromJson(data, ValueList.class);

    assertNotNull(valueList);
    assertNotNull(valueList.getId());
    assertEquals("radar.value_list", valueList.getObject());
  }
}
