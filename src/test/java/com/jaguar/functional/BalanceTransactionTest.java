package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.BalanceTransaction;
import com.jaguar.model.BalanceTransactionCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BalanceTransactionTest extends BaseJaguarTest {
  public static final String RESOURCE_ID = "bt_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final BalanceTransaction balanceTransaction = BalanceTransaction.retrieve(RESOURCE_ID);

    assertNotNull(balanceTransaction);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/balance_transactions/%s", RESOURCE_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final BalanceTransactionCollection balanceTransactions = BalanceTransaction.list(params);

    assertNotNull(balanceTransactions);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/balance_transactions"), params);
  }
}
