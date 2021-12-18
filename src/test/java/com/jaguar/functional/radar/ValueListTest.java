package com.jaguar.functional.radar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.radar.ValueList;
import com.jaguar.model.radar.ValueListCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ValueListTest extends BaseJaguarTest {
  public static final String VALUE_LIST_ID = "rsl_123";

  private ValueList getValueListFixture() throws JaguarException {
    final ValueList valueList = ValueList.retrieve(VALUE_LIST_ID);
    resetNetworkSpy();
    return valueList;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("alias", "alias");
    params.put("name", "name");

    final ValueList valueList = ValueList.create(params);

    assertNotNull(valueList);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/radar/value_lists"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final ValueList valueList = ValueList.retrieve(VALUE_LIST_ID);

    assertNotNull(valueList);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/radar/value_lists/%s", VALUE_LIST_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final ValueList valueList = getValueListFixture();

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final ValueList updatedValueList = valueList.update(params);

    assertNotNull(updatedValueList);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/radar/value_lists/%s", valueList.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final ValueListCollection valueLists = ValueList.list(params);

    assertNotNull(valueLists);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/radar/value_lists"));
  }

  @Test
  public void testDelete() throws JaguarException {
    final ValueList valueList = getValueListFixture();

    final ValueList deletedValueList = valueList.delete();

    assertNotNull(deletedValueList);
    assertTrue(deletedValueList.getDeleted());
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/radar/value_lists/%s", valueList.getId()));
  }
}
