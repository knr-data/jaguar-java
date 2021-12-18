package com.jaguar.functional.issuing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.issuing.Dispute;
import com.jaguar.model.issuing.DisputeCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class DisputeTest extends BaseJaguarTest {
  public static final String DISPUTE_ID = "idp_123";

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("transaction", "ipi_123");

    final Dispute dispute = Dispute.create(params);

    assertNotNull(dispute);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/issuing/disputes"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Dispute dispute = Dispute.retrieve(DISPUTE_ID);

    assertNotNull(dispute);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/issuing/disputes/%s", DISPUTE_ID));
  }

  @Test
  public void testsubmit() throws JaguarException {
    final Dispute dispute = Dispute.retrieve(DISPUTE_ID);

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Dispute submitdDispute = dispute.submit(params);

    assertNotNull(submitdDispute);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/disputes/%s/submit", dispute.getId()),
        params);
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Dispute dispute = Dispute.retrieve(DISPUTE_ID);

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Dispute updatedDispute = dispute.update(params);

    assertNotNull(updatedDispute);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/disputes/%s", dispute.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    DisputeCollection disputes = Dispute.list(params);

    assertNotNull(disputes);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/issuing/disputes"), params);
  }
}
