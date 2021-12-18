package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Mandate;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class MandateTest extends BaseJaguarTest {
  public static final String MANDATE_ID = "mandate_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final Mandate schedule = Mandate.retrieve(MANDATE_ID);

    assertNotNull(schedule);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/mandates/%s", MANDATE_ID));
  }
}
