package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Topup;
import com.jaguar.model.TopupCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TopupTest extends BaseJaguarTest {
  public static final String TOPUP_ID = "tu_123";

  private Topup getTopupFixture() throws JaguarException {
    final Topup topup = Topup.retrieve(TOPUP_ID);
    resetNetworkSpy();
    return topup;
  }

  @Test
  public void testCancel() throws JaguarException {
    final Topup topup = getTopupFixture();

    final Map<String, Object> params = new HashMap<>();

    final Topup canceledTopup = topup.cancel(params);

    assertNotNull(canceledTopup);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/topups/%s/cancel", topup.getId()),
        params);
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("amount", 100);
    params.put("currency", "usd");
    params.put("source", "src_123");
    params.put("description", "creating a topup");
    params.put("statement_descriptor", "topup");

    final Topup topup = Topup.create(params);

    assertNotNull(topup);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/topups", params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Topup topup = Topup.retrieve(TOPUP_ID);

    assertNotNull(topup);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/topups/%s", TOPUP_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Topup topup = getTopupFixture();

    final Map<String, Object> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Topup updatedTopup = topup.update(params);

    assertNotNull(updatedTopup);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/topups/%s", topup.getId()), params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final TopupCollection topups = Topup.list(params);

    assertNotNull(topups);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/topups", params);
  }
}
