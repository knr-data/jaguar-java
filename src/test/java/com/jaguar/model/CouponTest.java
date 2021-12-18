package com.jaguar.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class CouponTest extends BaseJaguarTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/coupons/COUPON_ID");
    final Coupon resource = ApiResource.GSON.fromJson(data, Coupon.class);
    assertNotNull(resource);
    assertNotNull(resource.getId());
  }
}
