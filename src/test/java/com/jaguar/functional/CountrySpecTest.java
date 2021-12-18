package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.CountrySpec;
import com.jaguar.model.CountrySpecCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CountrySpecTest extends BaseJaguarTest {
  public static final String COUNTRY_SPEC_ID = "US";

  @Test
  public void testRetrieve() throws JaguarException {
    final CountrySpec countrySpec = CountrySpec.retrieve(COUNTRY_SPEC_ID);

    assertNotNull(countrySpec);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/country_specs/%s", COUNTRY_SPEC_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    CountrySpecCollection countrySpecs = CountrySpec.list(params);

    assertNotNull(countrySpecs);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/country_specs"), params);
  }
}
