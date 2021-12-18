package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.LineItemCollection;
import com.jaguar.model.Quote;
import com.jaguar.model.QuoteCollection;
import com.jaguar.net.ApiResource;
import com.jaguar.util.StreamUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class QuoteTest extends BaseJaguarTest {
  public static final String QUOTE_ID = "qt_123";

  private Quote getQuoteFixture() throws JaguarException {
    final Quote quote = Quote.retrieve(QUOTE_ID);
    resetNetworkSpy();
    return quote;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("customer", "cus_123");

    final Quote quote = Quote.create(params);

    assertNotNull(quote);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/quotes"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Quote quote = Quote.retrieve(QUOTE_ID);

    assertNotNull(quote);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/quotes/%s", QUOTE_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Quote quote = getQuoteFixture();

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final Quote updatedQuote = quote.update(params);

    assertNotNull(updatedQuote);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/quotes/%s", quote.getId()), params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    QuoteCollection quotes = Quote.list(params);

    assertNotNull(quotes);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/quotes"));
  }

  @Test
  public void testListLineItems() throws JaguarException {

    final Quote quote = getQuoteFixture();
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);
    LineItemCollection lineItems = quote.listLineItems(params);

    assertNotNull(lineItems);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/quotes/%s/line_items", QUOTE_ID));
  }

  @Test
  public void testListComputedUpfrontLineItems() throws JaguarException {

    final Quote quote = getQuoteFixture();
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);
    LineItemCollection lineItems = quote.listComputedUpfrontLineItems(params);

    assertNotNull(lineItems);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/quotes/%s/computed_upfront_line_items", QUOTE_ID));
  }

  @Test
  public void testFinalizeQuote() throws JaguarException {
    final Quote quote = getQuoteFixture();

    final Quote finalizedQuote = quote.finalizeQuote();

    assertNotNull(finalizedQuote);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/quotes/%s/finalize", quote.getId()));
  }

  @Test
  public void testAccept() throws JaguarException {
    final Quote quote = getQuoteFixture();

    final Quote acceptedQuote = quote.accept();

    assertNotNull(acceptedQuote);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/quotes/%s/accept", quote.getId()));
  }

  @Test
  public void testCancel() throws JaguarException {
    final Quote quote = getQuoteFixture();

    final Quote canceledQuote = quote.cancel();

    assertNotNull(canceledQuote);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/quotes/%s/cancel", quote.getId()));
  }

  @Test
  public void testPdf() throws JaguarException, java.io.IOException {
    final Quote quote = getQuoteFixture();

    final InputStream stream = quote.pdf();
    final String body = StreamUtils.readToEnd(stream, ApiResource.CHARSET);
    assertNotNull(stream);
    assertEquals(body, "Stripe binary response");
  }
}
