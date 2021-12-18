package com.jaguar.functional.terminal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.terminal.ConnectionToken;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ConnectionTokenTest extends BaseJaguarTest {
  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();

    final ConnectionToken connectionToken = ConnectionToken.create(params);

    assertNotNull(connectionToken);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/terminal/connection_tokens"), params);
  }
}
