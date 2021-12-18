package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.SetupAttempt;
import com.jaguar.model.SetupAttemptCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SetupAttemptTest extends BaseJaguarTest {
  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("setup_intent", "seti_123");

    final SetupAttemptCollection setupAttempts = SetupAttempt.list(params);

    assertNotNull(setupAttempts);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/setup_attempts"), params);
  }
}
