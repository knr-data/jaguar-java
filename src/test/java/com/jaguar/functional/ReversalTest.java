package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Transfer;
import com.jaguar.model.TransferReversal;
import com.jaguar.model.TransferReversalCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ReversalTest extends BaseJaguarTest {
  public static final String TRANSFER_ID = "tr_123";
  public static final String REVERSAL_ID = "trr_123";

  private Transfer getTransferFixture() throws JaguarException {
    final Transfer transfer = Transfer.retrieve(TRANSFER_ID);
    resetNetworkSpy();
    return transfer;
  }

  private TransferReversal getTransferReversalFixture(Transfer transfer) throws JaguarException {
    final TransferReversal reversal = transfer.getReversals().retrieve(REVERSAL_ID);
    resetNetworkSpy();
    return reversal;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Transfer transfer = getTransferFixture();

    Map<String, Object> params = new HashMap<>();
    params.put("amount", 100);

    final TransferReversal reversal = transfer.getReversals().create(params);

    assertNotNull(reversal);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/transfers/%s/reversals", transfer.getId()),
        params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Transfer transfer = getTransferFixture();

    final TransferReversal reversal = transfer.getReversals().retrieve(REVERSAL_ID);

    assertNotNull(reversal);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/transfers/%s/reversals/%s", transfer.getId(), REVERSAL_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Transfer transfer = getTransferFixture();
    final TransferReversal reversal = getTransferReversalFixture(transfer);

    final Map<String, Object> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final TransferReversal updatedTransferReversal = reversal.update(params);

    assertNotNull(updatedTransferReversal);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/transfers/%s/reversals/%s", transfer.getId(), reversal.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Transfer transfer = getTransferFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final TransferReversalCollection reversals = transfer.getReversals().list(params);

    assertNotNull(reversals);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/transfers/%s/reversals", transfer.getId()),
        params);
  }
}
