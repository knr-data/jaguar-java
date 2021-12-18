package com.jaguar.functional.radar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.radar.ValueListItem;
import com.jaguar.model.radar.ValueListItemCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ValueListItemTest extends BaseJaguarTest {
  public static final String VALUE_LIST_ID = "rsli_123";

  private ValueListItem getValueListItemFixture() throws JaguarException {
    final ValueListItem valueListItem = ValueListItem.retrieve(VALUE_LIST_ID);
    resetNetworkSpy();
    return valueListItem;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("value", "value");
    params.put("value_list", "rsl_123");

    final ValueListItem valueListItem = ValueListItem.create(params);

    assertNotNull(valueListItem);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/radar/value_list_items"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final ValueListItem valueListItem = ValueListItem.retrieve(VALUE_LIST_ID);

    assertNotNull(valueListItem);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/radar/value_list_items/%s", VALUE_LIST_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("value_list", "rsl_123");
    params.put("limit", 1);

    final ValueListItemCollection valueListItems = ValueListItem.list(params);

    assertNotNull(valueListItems);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/radar/value_list_items"));
  }

  @Test
  public void testDelete() throws JaguarException {
    final ValueListItem valueListItem = getValueListItemFixture();

    final ValueListItem deletedValueListItem = valueListItem.delete();

    assertNotNull(deletedValueListItem);
    assertTrue(deletedValueListItem.getDeleted());
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/radar/value_list_items/%s", valueListItem.getId()));
  }
}
