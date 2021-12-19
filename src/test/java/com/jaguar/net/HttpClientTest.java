package com.jaguar.net;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.withSettings;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.ApiConnectionException;
import com.jaguar.exception.JaguarException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HttpClientTest extends BaseJaguarTest {
  private HttpClient client;

  private JaguarRequest request;

  private HttpHeaders emptyHeaders = HttpHeaders.of(Collections.emptyMap());

  @BeforeEach
  public void setUpFixtures() throws JaguarException {
    this.client =
        Mockito.mock(
            HttpClient.class,
            withSettings().useConstructor().defaultAnswer(Mockito.CALLS_REAL_METHODS));
    this.client.networkRetriesSleep = false;

    this.request =
        new JaguarRequest(
            ApiResource.RequestMethod.GET,
            "http://example.com/get",
            null,
            RequestOptions.builder().setMaxNetworkRetries(2).build());
  }

  @Test
  public void testRequestWithRetriesConnectException() throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenThrow(new ApiConnectionException("foo", new ConnectException("timeout or something")))
        .thenReturn(new JaguarResponse(200, emptyHeaders, "{}"));

    JaguarResponse response = this.client.requestWithRetries(this.request);

    assertNotNull(response);
    assertEquals(200, response.code());
    assertEquals(1, response.numRetries());
  }

  @Test
  public void testRequestWithRetriesConnectExceptionRethrowAfterAllAttempts()
      throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenThrow(new ApiConnectionException("1", new ConnectException("timeout 1")))
        .thenThrow(new ApiConnectionException("2", new ConnectException("timeout 2")))
        .thenThrow(new ApiConnectionException("3", new ConnectException("timeout 3")));

    ApiConnectionException e =
        assertThrows(
            ApiConnectionException.class,
            () -> {
              this.client.requestWithRetries(this.request);
            });
    assertEquals("3", e.getMessage());
    assertNotNull(e.getCause());
    assertTrue(e.getCause() instanceof ConnectException);
    assertEquals("timeout 3", e.getCause().getMessage());
  }

  @Test
  public void testRequestWithRetriesSocketTimeoutException() throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenThrow(
            new ApiConnectionException("foo", new SocketTimeoutException("timeout or something")))
        .thenReturn(new JaguarResponse(200, emptyHeaders, "{}"));

    JaguarResponse response = this.client.requestWithRetries(this.request);

    assertNotNull(response);
    assertEquals(200, response.code());
    assertEquals(1, response.numRetries());
  }

  @Test
  public void testRequestWithRetriesSocketTimeoutExceptionRethrowAfterAllAttempts()
      throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenThrow(new ApiConnectionException("1", new SocketTimeoutException("timeout 1")))
        .thenThrow(new ApiConnectionException("2", new SocketTimeoutException("timeout 2")))
        .thenThrow(new ApiConnectionException("3", new SocketTimeoutException("timeout 3")));

    ApiConnectionException e =
        assertThrows(
            ApiConnectionException.class,
            () -> {
              this.client.requestWithRetries(this.request);
            });
    assertEquals("3", e.getMessage());
    assertNotNull(e.getCause());
    assertTrue(e.getCause() instanceof SocketTimeoutException);
    assertEquals("timeout 3", e.getCause().getMessage());
  }

  @Test
  public void testRequestWithRetriesStripeShouldRetryTrue() throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenReturn(
            new JaguarResponse(
                400,
                HttpHeaders.of(ImmutableMap.of("Stripe-Should-Retry", ImmutableList.of("true"))),
                "{}"))
        .thenReturn(new JaguarResponse(200, emptyHeaders, "{}"));

    JaguarResponse response = this.client.requestWithRetries(this.request);

    assertNotNull(response);
    assertEquals(200, response.code());
    assertEquals(1, response.numRetries());
  }

  @Test
  public void testRequestWithRetriesStripeShouldRetryFalse() throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenReturn(
            new JaguarResponse(
                400,
                HttpHeaders.of(ImmutableMap.of("Stripe-Should-Retry", ImmutableList.of("false"))),
                "{}"));

    JaguarResponse response = this.client.requestWithRetries(this.request);

    assertNotNull(response);
    assertEquals(400, response.code());
    assertEquals(0, response.numRetries());
  }

  @Test
  public void testRequestWithRetriesConflict() throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenReturn(new JaguarResponse(409, emptyHeaders, "{}"))
        .thenReturn(new JaguarResponse(200, emptyHeaders, "{}"));

    JaguarResponse response = this.client.requestWithRetries(this.request);

    assertNotNull(response);
    assertEquals(200, response.code());
    assertEquals(1, response.numRetries());
  }

  @Test
  public void testRequestWithRetriesConflictServiceUnavailable() throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenReturn(new JaguarResponse(503, emptyHeaders, "{}"))
        .thenReturn(new JaguarResponse(200, emptyHeaders, "{}"));

    JaguarResponse response = this.client.requestWithRetries(this.request);

    assertNotNull(response);
    assertEquals(200, response.code());
    assertEquals(1, response.numRetries());
  }

  @Test
  public void testRequestWithRetriesConflictInternalServerError() throws JaguarException {
    Mockito.when(this.client.request(this.request))
        .thenReturn(new JaguarResponse(500, emptyHeaders, "{}"))
        .thenReturn(new JaguarResponse(200, emptyHeaders, "{}"));

    JaguarResponse response = this.client.requestWithRetries(this.request);

    assertNotNull(response);
    assertEquals(200, response.code());
    assertEquals(1, response.numRetries());
  }
}
