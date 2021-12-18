package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.Jaguar;
import com.jaguar.exception.ApiConnectionException;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Balance;
import com.jaguar.net.RequestOptions;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import org.junit.jupiter.api.Test;

public class TimeoutTest extends BaseJaguarTest {
  @Test
  public void testReadTimeout() throws IOException, JaguarException {
    // Create a local server that does nothing to trigger a read timeout
    try (final ServerSocket serverSocket =
        new ServerSocket(0, 1, Inet4Address.getByName("localhost"))) {
      Jaguar.overrideApiBase(String.format("http://localhost:%d", serverSocket.getLocalPort()));

      final RequestOptions options = RequestOptions.builder().setReadTimeout(1).build();

      Throwable exception =
          assertThrows(
              ApiConnectionException.class,
              () -> {
                Balance.retrieve(options);
              });
      assertTrue(exception.getMessage().contains("Read timed out"));
    }
  }
}
