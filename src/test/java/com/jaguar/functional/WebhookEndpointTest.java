package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.WebhookEndpoint;
import com.jaguar.model.WebhookEndpointCollection;
import com.jaguar.net.ApiResource;
import com.jaguar.param.WebhookEndpointCreateParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class WebhookEndpointTest extends BaseJaguarTest {
  public static final String WEBHOOK_ENDPOINT_ID = "we_123";

  private WebhookEndpoint getWebhookEndpointFixture() throws JaguarException {
    final WebhookEndpoint endpoint = WebhookEndpoint.retrieve(WEBHOOK_ENDPOINT_ID);
    resetNetworkSpy();
    return endpoint;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = createUntypedParams();

    final WebhookEndpoint endpoint = WebhookEndpoint.create(params);

    assertNotNull(endpoint);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/webhook_endpoints"), params);
  }

  private Map<String, Object> createUntypedParams() {
    final List<String> enabledEvents = new ArrayList<>();
    enabledEvents.add("charge.succeeded");

    final Map<String, Object> params = new HashMap<>();
    params.put("enabled_events", enabledEvents);
    params.put("url", "https://stripe.com");
    return params;
  }

  @Test
  public void testCreateWithTypedParams() throws JaguarException {
    final Map<String, Object> untypedParams = createUntypedParams();

    WebhookEndpointCreateParams createParams =
        WebhookEndpointCreateParams.builder()
            .addEnabledEvent(WebhookEndpointCreateParams.EnabledEvent.CHARGE__SUCCEEDED)
            .setUrl("https://stripe.com")
            .build();

    final WebhookEndpoint endpoint = WebhookEndpoint.create(createParams);

    assertNotNull(endpoint);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/webhook_endpoints"), untypedParams);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final WebhookEndpoint endpoint = WebhookEndpoint.retrieve(WEBHOOK_ENDPOINT_ID);

    assertNotNull(endpoint);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/webhook_endpoints/%s", WEBHOOK_ENDPOINT_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final WebhookEndpoint endpoint = getWebhookEndpointFixture();

    final List<String> enabledEvents = new ArrayList<>();
    enabledEvents.add("charge.succeeded");

    final Map<String, Object> params = new HashMap<>();
    params.put("enabled_events", enabledEvents);

    final WebhookEndpoint updatedWebhookEndpoint = endpoint.update(params);

    assertNotNull(updatedWebhookEndpoint);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/webhook_endpoints/%s", endpoint.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final WebhookEndpointCollection endpoints = WebhookEndpoint.list(params);

    assertNotNull(endpoints);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/webhook_endpoints"));
  }

  @Test
  public void testDelete() throws JaguarException {
    final WebhookEndpoint endpoint = getWebhookEndpointFixture();

    final WebhookEndpoint deletedWebhookEndpoint = endpoint.delete();

    assertNotNull(deletedWebhookEndpoint);
    assertTrue(deletedWebhookEndpoint.getDeleted());
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        String.format("/v1/webhook_endpoints/%s", endpoint.getId()));
  }
}
