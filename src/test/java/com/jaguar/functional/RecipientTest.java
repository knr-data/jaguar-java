package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Recipient;
import com.jaguar.model.RecipientCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Recipients are deprecated. All tests have been removed; the Java APIs will eventually be removed
 * as well.
 */
public class RecipientTest extends BaseJaguarTest {
  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    RecipientCollection recipients = Recipient.list(params);

    assertNotNull(recipients);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/recipients"));
  }
}
