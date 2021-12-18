package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.PromotionCode;
import com.jaguar.model.PromotionCodeCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PromotionCodeTest extends BaseJaguarTest {
  public static final String PROMOTION_CODE_ID = "promo_123";

  private PromotionCode getPromotionCodeFixture() throws JaguarException {
    final PromotionCode promotionCode = PromotionCode.retrieve(PROMOTION_CODE_ID);
    resetNetworkSpy();
    return promotionCode;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("coupon", "co_123");
    params.put("code", "MYCODE");

    final PromotionCode promotionCode = PromotionCode.create(params);

    assertNotNull(promotionCode);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/promotion_codes"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final PromotionCode promotionCode = PromotionCode.retrieve(PROMOTION_CODE_ID);

    assertNotNull(promotionCode);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/promotion_codes/%s", PROMOTION_CODE_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final PromotionCode promotionCode = getPromotionCodeFixture();

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final PromotionCode updatedPromotionCode = promotionCode.update(params);

    assertNotNull(updatedPromotionCode);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/promotion_codes/%s", promotionCode.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final PromotionCodeCollection promotionCodes = PromotionCode.list(params);

    assertNotNull(promotionCodes);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/promotion_codes"));
  }
}
