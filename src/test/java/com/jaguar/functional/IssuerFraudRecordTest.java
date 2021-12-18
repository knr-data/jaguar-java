package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.IssuerFraudRecord;
import com.jaguar.model.IssuerFraudRecordCollection;
import com.jaguar.net.ApiResource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class IssuerFraudRecordTest extends BaseJaguarTest {
  public static final String RECORD_ID = "issfr_123";

  @Test
  public void testRetrieve() throws IOException, JaguarException {
    final IssuerFraudRecord record = IssuerFraudRecord.retrieve(RECORD_ID);

    assertNotNull(record);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/issuer_fraud_records/%s", RECORD_ID));
  }

  @Test
  public void testList() throws IOException, JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final IssuerFraudRecordCollection records = IssuerFraudRecord.list(params);

    assertNotNull(records);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuer_fraud_records", params);
  }
}
