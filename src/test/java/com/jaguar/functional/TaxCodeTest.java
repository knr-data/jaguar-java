package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.TaxCode;
import com.jaguar.model.TaxCodeCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TaxCodeTest extends BaseJaguarTest {
  public static final String TAX_CODE_ID = "txcd_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final TaxCode taxCode = TaxCode.retrieve(TAX_CODE_ID);

    assertNotNull(taxCode);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/tax_codes/%s", TAX_CODE_ID));
    assertEquals("tax_code", taxCode.getObject());
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final TaxCodeCollection taxCodes = TaxCode.list(params);

    assertNotNull(taxCodes);
    assertEquals(1, taxCodes.getData().size());
    assertEquals("tax_code", taxCodes.getData().get(0).getObject());
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/tax_codes", params);
  }
}
