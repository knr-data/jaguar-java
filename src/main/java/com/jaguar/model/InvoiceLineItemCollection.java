// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.InvoiceLineItemCollectionListParams;
import java.util.Map;

public class InvoiceLineItemCollection extends JaguarCollection<InvoiceLineItem> {
  /**
   * When retrieving an invoice, you’ll get a <strong>lines</strong> property containing the total
   * count of line items and the first handful of those items. There is also a URL where you can
   * retrieve the full (paginated) list of line items.
   */
  public InvoiceLineItemCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * When retrieving an invoice, you’ll get a <strong>lines</strong> property containing the total
   * count of line items and the first handful of those items. There is also a URL where you can
   * retrieve the full (paginated) list of line items.
   */
  public InvoiceLineItemCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, InvoiceLineItemCollection.class, options);
  }

  /**
   * When retrieving an invoice, you’ll get a <strong>lines</strong> property containing the total
   * count of line items and the first handful of those items. There is also a URL where you can
   * retrieve the full (paginated) list of line items.
   */
  public InvoiceLineItemCollection list(InvoiceLineItemCollectionListParams params)
      throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * When retrieving an invoice, you’ll get a <strong>lines</strong> property containing the total
   * count of line items and the first handful of those items. There is also a URL where you can
   * retrieve the full (paginated) list of line items.
   */
  public InvoiceLineItemCollection list(
      InvoiceLineItemCollectionListParams params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, InvoiceLineItemCollection.class, options);
  }
}
