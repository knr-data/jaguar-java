package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.annotations.SerializedName;
import com.jaguar.BaseJaguarTest;
import com.jaguar.Jaguar;
import com.jaguar.exception.InvalidRequestException;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.HasId;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.util.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import lombok.Cleanup;
import lombok.Getter;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Test;

public class JaguarResponseStreamTest extends BaseJaguarTest {

  private static class TestResource extends ApiResource implements HasId {
    @Getter(onMethod_ = {@Override})
    @SerializedName("id")
    String id;

    public static TestResource retrieve(String id) throws JaguarException {
      return ApiResource.request(
          ApiResource.RequestMethod.GET,
          String.format("%s/v1/foos/%s", Jaguar.getApiBase(), ApiResource.urlEncodeId(id)),
          (Map<String, Object>) null,
          TestResource.class,
          (RequestOptions) null);
    }

    public InputStream pdf() throws JaguarException {
      String url =
          String.format(
              "%s%s",
              Jaguar.getApiBase(),
              String.format("/v1/foobars/%s/pdf", ApiResource.urlEncodeId(this.getId())));
      return ApiResource.requestStream(
          ApiResource.RequestMethod.POST, url, (Map<String, Object>) null, (RequestOptions) null);
    }
  }

  @Test
  public void testStreamedResponseSuccess()
      throws JaguarException, IOException, InterruptedException {
    @Cleanup MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody("{\"id\": \"foo_123\"}"));
    server.enqueue(new MockResponse().setBody("}this is a pdf, not valid json{"));
    server.start();

    Jaguar.overrideApiBase(server.url("").toString());

    TestResource t = TestResource.retrieve("foo_123");
    server.takeRequest();
    assertEquals("foo_123", t.id);

    InputStream stream = t.pdf();

    final String body = StreamUtils.readToEnd(stream, ApiResource.CHARSET);
    stream.close();
    assertEquals("}this is a pdf, not valid json{", body);
    server.shutdown();
  }

  @Test
  public void testStreamedResponseFailure()
      throws JaguarException, IOException, InterruptedException {
    @Cleanup MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody("{\"id\": \"foo_123\"}"));
    server.enqueue(
        new MockResponse()
            .setResponseCode(400)
            .setBody("{\"error\": {\"message\": \"bad bad bad\"}}"));
    server.start();

    Jaguar.overrideApiBase(server.url("").toString());

    TestResource r = TestResource.retrieve("foo_123");
    server.takeRequest();
    assertEquals("foo_123", r.id);

    assertThrows(
        InvalidRequestException.class,
        () -> {
          r.pdf();
        });
    server.shutdown();
  }
}
