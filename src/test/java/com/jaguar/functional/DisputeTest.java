package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Dispute;
import com.jaguar.model.DisputeCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class DisputeTest extends BaseJaguarTest {
  public static final String DISPUTE_ID = "dp_123";

  private Dispute getDisputeFixture() throws JaguarException {
    final Dispute dispute = Dispute.retrieve(DISPUTE_ID);
    resetNetworkSpy();
    return dispute;
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Dispute dispute = Dispute.retrieve(DISPUTE_ID);

    assertNotNull(dispute);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/disputes/%s", DISPUTE_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Dispute dispute = getDisputeFixture();

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Dispute updatedDispute = dispute.update(params);

    assertNotNull(updatedDispute);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/disputes/%s", dispute.getId()), params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final DisputeCollection disputes = Dispute.list(params);

    assertNotNull(disputes);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/disputes"), params);
  }

  @Test
  public void testClose() throws JaguarException {
    final Dispute dispute = getDisputeFixture();

    final Dispute closedDispute = dispute.close();

    assertNotNull(closedDispute);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/disputes/%s/close", dispute.getId()));
  }
}
