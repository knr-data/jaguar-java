package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.ApplicationFee;
import com.jaguar.model.ApplicationFeeCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ApplicationFeeTest extends BaseJaguarTest {
  public static final String FEE_ID = "fee_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final ApplicationFee fee = ApplicationFee.retrieve(FEE_ID);

    assertNotNull(fee);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/application_fees/%s", FEE_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final ApplicationFeeCollection fees = ApplicationFee.list(params);

    assertNotNull(fees);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/application_fees"), params);
  }
}
