package com.jaguar.functional.issuing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.issuing.Transaction;
import com.jaguar.model.issuing.TransactionCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TransactionTest extends BaseJaguarTest {
  public static final String TRANSACTION_ID = "ipi_123";

  @Test
  public void testRetrieve() throws JaguarException {
    final Transaction transaction = Transaction.retrieve(TRANSACTION_ID);

    assertNotNull(transaction);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/issuing/transactions/%s", TRANSACTION_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Transaction transaction = Transaction.retrieve(TRANSACTION_ID);

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Transaction updatedTransaction = transaction.update(params);

    assertNotNull(updatedTransaction);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/transactions/%s", transaction.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    TransactionCollection transactions = Transaction.list(params);

    assertNotNull(transactions);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/issuing/transactions"), params);
  }
}
