package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.ApplicationFee;
import com.jaguar.model.FeeRefund;
import com.jaguar.model.FeeRefundCollection;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.FeeRefundCollectionCreateParams;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FeeRefundTest extends BaseJaguarTest {
  public static final String FEE_ID = "fee_123";
  public static final String REFUND_ID = "fr_123";

  private ApplicationFee getFeeFixture() throws JaguarException {
    final ApplicationFee fee = ApplicationFee.retrieve(FEE_ID);
    resetNetworkSpy();
    return fee;
  }

  private FeeRefund getRefundFixture(ApplicationFee fee) throws JaguarException {
    final FeeRefund refund = fee.getRefunds().retrieve(REFUND_ID);
    resetNetworkSpy();
    return refund;
  }

  @Test
  public void testCreate() throws JaguarException {
    final ApplicationFee fee = getFeeFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("amount", 100);

    final FeeRefund refund = fee.getRefunds().create(params);

    assertNotNull(refund);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/application_fees/%s/refunds", fee.getId()),
        params);
  }

  @Test
  public void testCreateWithTypedParams() throws JaguarException {
    final ApplicationFee fee = getFeeFixture();

    FeeRefundCollectionCreateParams typedParams =
        FeeRefundCollectionCreateParams.builder().setAmount(100L).build();

    final FeeRefund refund = fee.getRefunds().create(typedParams, RequestOptions.getDefault());

    assertNotNull(refund);
    Map<String, Object> param = new HashMap<>();
    param.put("amount", 100);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/application_fees/%s/refunds", fee.getId()),
        param);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final ApplicationFee fee = getFeeFixture();

    final FeeRefund refund = fee.getRefunds().retrieve(REFUND_ID);

    assertNotNull(refund);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/application_fees/%s/refunds/%s", fee.getId(), REFUND_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final ApplicationFee fee = getFeeFixture();
    final FeeRefund refund = getRefundFixture(fee);

    Map<String, Object> metadata = new HashMap<>();
    metadata.put("key", "value");
    Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final FeeRefund updatedRefund = refund.update(params);

    assertNotNull(updatedRefund);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/application_fees/%s/refunds/%s", fee.getId(), refund.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final ApplicationFee fee = getFeeFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final FeeRefundCollection refunds = fee.getRefunds().list(params);

    assertNotNull(refunds);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/application_fees/%s/refunds", fee.getId()),
        params);
  }
}
