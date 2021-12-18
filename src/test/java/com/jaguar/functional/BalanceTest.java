package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Balance;
import com.jaguar.net.ApiResource;
import org.junit.jupiter.api.Test;

public class BalanceTest extends BaseJaguarTest {
  @Test
  public void testRetrieve() throws JaguarException {
    final Balance balance = Balance.retrieve();

    assertNotNull(balance);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/balance"));
  }
}
