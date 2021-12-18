package com.jaguar.functional.billingportal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.billingportal.Configuration;
import com.jaguar.model.billingportal.ConfigurationCollection;
import com.jaguar.net.ApiResource;
import com.jaguar.param.billingportal.ConfigurationCreateParams;
import com.jaguar.param.billingportal.ConfigurationUpdateParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ConfigurationTest extends BaseJaguarTest {
  public static final String SESSION_ID = "bpc_123";

  private Configuration getConfigurationFixture() throws JaguarException {
    final Configuration configuration = Configuration.retrieve(SESSION_ID);
    resetNetworkSpy();
    return configuration;
  }

  @Test
  public void testCreate() throws JaguarException {

    List<ConfigurationCreateParams.Features.CustomerUpdate.AllowedUpdate> allowedUpdates =
        new ArrayList<>();
    allowedUpdates.add(ConfigurationCreateParams.Features.CustomerUpdate.AllowedUpdate.ADDRESS);
    ConfigurationCreateParams params =
        ConfigurationCreateParams.builder()
            .setBusinessProfile(
                ConfigurationCreateParams.BusinessProfile.builder()
                    .setPrivacyPolicyUrl("https://example.com/privacy")
                    .setTermsOfServiceUrl("https://example.com/tos")
                    .build())
            .setFeatures(
                ConfigurationCreateParams.Features.builder()
                    .setCustomerUpdate(
                        ConfigurationCreateParams.Features.CustomerUpdate.builder()
                            .setAllowedUpdates(allowedUpdates)
                            .setEnabled(true)
                            .build())
                    .build())
            .build();

    final Configuration configuration = Configuration.create(params);

    assertNotNull(configuration);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/billing_portal/configurations"),
        params.toMap());
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Configuration configuration = Configuration.retrieve(SESSION_ID);

    assertNotNull(configuration);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/billing_portal/configurations/%s", configuration.getId()));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final Configuration configuration = getConfigurationFixture();

    ConfigurationUpdateParams params = ConfigurationUpdateParams.builder().setActive(false).build();

    final Configuration updatedConfiguration = configuration.update(params);

    assertNotNull(updatedConfiguration);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/billing_portal/configurations/%s", configuration.getId()),
        params.toMap());
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final ConfigurationCollection coupons = Configuration.list(params);

    assertNotNull(coupons);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/billing_portal/configurations"));
  }
}
