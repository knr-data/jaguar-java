package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.SubscriptionSchedule;
import com.jaguar.model.SubscriptionScheduleCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SubscriptionScheduleTest extends BaseJaguarTest {
  public static final String SCHEDULE_ID = "sub_sched_123";

  private SubscriptionSchedule getSubscriptionScheduleFixture() throws JaguarException {
    final SubscriptionSchedule schedule = SubscriptionSchedule.retrieve(SCHEDULE_ID);
    resetNetworkSpy();
    return schedule;
  }

  @Test
  public void testCancel() throws JaguarException {
    final SubscriptionSchedule schedule = getSubscriptionScheduleFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("invoice_now", true);

    final SubscriptionSchedule canceledSchedule = schedule.cancel(params);

    assertNotNull(canceledSchedule);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/subscription_schedules/%s/cancel", schedule.getId()),
        params);
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("customer", "cus_123");

    final SubscriptionSchedule schedule = SubscriptionSchedule.create(params);

    assertNotNull(schedule);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/subscription_schedules", params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final SubscriptionScheduleCollection schedules = SubscriptionSchedule.list(params);

    assertNotNull(schedules);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscription_schedules", params);
  }

  @Test
  public void testRelease() throws JaguarException {
    final SubscriptionSchedule schedule = getSubscriptionScheduleFixture();

    final Map<String, Object> params = new HashMap<>();
    params.put("preserve_cancel_date", true);

    final SubscriptionSchedule releasedSchedule = schedule.release(params);

    assertNotNull(releasedSchedule);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/subscription_schedules/%s/release", schedule.getId()),
        params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final SubscriptionSchedule schedule = SubscriptionSchedule.retrieve(SCHEDULE_ID);

    assertNotNull(schedule);
    verifyRequest(
        ApiResource.RequestMethod.GET, String.format("/v1/subscription_schedules/%s", SCHEDULE_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final SubscriptionSchedule schedule = getSubscriptionScheduleFixture();

    final Map<String, Object> metadata = new HashMap<>();
    metadata.put("foo", "bar");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final SubscriptionSchedule updatedSubscriptionSchedule = schedule.update(params);

    assertNotNull(updatedSubscriptionSchedule);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/subscription_schedules/%s", schedule.getId()),
        params);
  }
}
