package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Payout;
import com.jaguar.model.PayoutCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PayoutTest extends BaseJaguarTest {
  public static final String PAYOUT_ID = "po_123";

  private Payout getPayoutFixture() throws JaguarException {
    final Payout payout = Payout.retrieve(PAYOUT_ID);
    resetNetworkSpy();
    return payout;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("amount", "10000");
    params.put("currency", "usd");

    final Payout payout = Payout.create(params);

    assertNotNull(payout);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/payouts"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Payout payout = Payout.retrieve(PAYOUT_ID);

    assertNotNull(payout);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/payouts/%s", PAYOUT_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Payout payout = getPayoutFixture();

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Payout updatedPayout = payout.update(params);

    assertNotNull(updatedPayout);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/payouts/%s", payout.getId()), params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final PayoutCollection payouts = Payout.list(params);

    assertNotNull(payouts);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/payouts"), params);
  }

  @Test
  public void testCancel() throws JaguarException {
    final Payout resource = getPayoutFixture();

    final Payout cancelledPayout = resource.cancel();

    assertNotNull(cancelledPayout);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/payouts/%s/cancel", resource.getId()));
  }

  @Test
  public void testReverse() throws JaguarException {
    final Payout resource = getPayoutFixture();

    final Payout reversedPayout = resource.reverse();

    assertNotNull(reversedPayout);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/payouts/%s/reverse", resource.getId()));
  }
}
