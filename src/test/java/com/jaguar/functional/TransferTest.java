package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Transfer;
import com.jaguar.model.TransferCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TransferTest extends BaseJaguarTest {
  public static final String TRANSFER_ID = "tr_123";

  private Transfer getTransferFixture() throws JaguarException {
    final Transfer transfer = Transfer.retrieve(TRANSFER_ID);
    resetNetworkSpy();
    return transfer;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("amount", 100);
    params.put("currency", "usd");
    params.put("destination", "acct_123");

    final Transfer transfer = Transfer.create(params);

    assertNotNull(transfer);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/transfers", params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Transfer transfer = Transfer.retrieve(TRANSFER_ID);

    assertNotNull(transfer);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/transfers/%s", TRANSFER_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    Transfer transfer = getTransferFixture();

    final Map<String, Object> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Transfer updatedTransfer = transfer.update(params);

    assertNotNull(updatedTransfer);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/transfers/%s", transfer.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final TransferCollection transfers = Transfer.list(params);

    assertNotNull(transfers);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/transfers", params);
  }
}
