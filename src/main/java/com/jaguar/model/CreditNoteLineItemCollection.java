// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.CreditNoteLineItemCollectionListParams;
import java.util.Map;

public class CreditNoteLineItemCollection extends JaguarCollection<CreditNoteLineItem> {
  /**
   * When retrieving a credit note, you’ll get a <strong>lines</strong> property containing the the
   * first handful of those items. There is also a URL where you can retrieve the full (paginated)
   * list of line items.
   */
  public CreditNoteLineItemCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * When retrieving a credit note, you’ll get a <strong>lines</strong> property containing the the
   * first handful of those items. There is also a URL where you can retrieve the full (paginated)
   * list of line items.
   */
  public CreditNoteLineItemCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, CreditNoteLineItemCollection.class, options);
  }

  /**
   * When retrieving a credit note, you’ll get a <strong>lines</strong> property containing the the
   * first handful of those items. There is also a URL where you can retrieve the full (paginated)
   * list of line items.
   */
  public CreditNoteLineItemCollection list(CreditNoteLineItemCollectionListParams params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * When retrieving a credit note, you’ll get a <strong>lines</strong> property containing the the
   * first handful of those items. There is also a URL where you can retrieve the full (paginated)
   * list of line items.
   */
  public CreditNoteLineItemCollection list(
      CreditNoteLineItemCollectionListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, CreditNoteLineItemCollection.class, options);
  }
}
