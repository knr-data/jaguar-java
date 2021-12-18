// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.BitcoinTransactionCollectionListParams;
import java.util.Map;

public class BitcoinTransactionCollection extends JaguarCollection<BitcoinTransaction> {
  /** List bitcoin transacitons for a given receiver. */
  public BitcoinTransactionCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** List bitcoin transacitons for a given receiver. */
  public BitcoinTransactionCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, BitcoinTransactionCollection.class, options);
  }

  /** List bitcoin transacitons for a given receiver. */
  public BitcoinTransactionCollection list(BitcoinTransactionCollectionListParams params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** List bitcoin transacitons for a given receiver. */
  public BitcoinTransactionCollection list(
      BitcoinTransactionCollectionListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, BitcoinTransactionCollection.class, options);
  }
}
