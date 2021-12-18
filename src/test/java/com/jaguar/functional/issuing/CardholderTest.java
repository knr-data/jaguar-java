package com.jaguar.functional.issuing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.issuing.Cardholder;
import com.jaguar.model.issuing.CardholderCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CardholderTest extends BaseJaguarTest {
  public static final String CARDHOLDER_ID = "ich_123";

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> address = new HashMap<>();
    address.put("city", "city");
    address.put("country", "US");
    address.put("line1", "line1");
    address.put("postal_code", "90210");

    final Map<String, Object> billing = new HashMap<>();
    billing.put("address", address);

    final Map<String, Object> params = new HashMap<>();
    params.put("billing", billing);
    params.put("name", "Jenny Rosen");
    params.put("type", "individual");

    final Cardholder cardholder = Cardholder.create(params);

    assertNotNull(cardholder);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/issuing/cardholders"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Cardholder cardholder = Cardholder.retrieve(CARDHOLDER_ID);

    assertNotNull(cardholder);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/issuing/cardholders/%s", CARDHOLDER_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Cardholder cardholder = Cardholder.retrieve(CARDHOLDER_ID);

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Cardholder updatedCardholder = cardholder.update(params);

    assertNotNull(updatedCardholder);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/cardholders/%s", cardholder.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    CardholderCollection cardholders = Cardholder.list(params);

    assertNotNull(cardholders);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/issuing/cardholders"), params);
  }
}
