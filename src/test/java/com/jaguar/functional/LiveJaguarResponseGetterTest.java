import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.JsonSyntaxException;
import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.ApiException;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Subscription;
import com.jaguar.net.ApiResource;
import com.jaguar.net.HttpClient;
import com.jaguar.net.HttpHeaders;
import com.jaguar.net.HttpURLConnectionClient;
import com.jaguar.net.LiveJaguarResponseGetter;
import com.jaguar.net.JaguarRequest;
import com.jaguar.net.JaguarResponse;
import com.jaguar.net.JaguarResponseGetter;
import java.util.Collections;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LiveJaguarResponseGetterTest extends BaseJaguarTest {

  @Test
  public void testInvalidJson() throws JaguarException {
    HttpClient spy = Mockito.spy(new HttpURLConnectionClient());
    JaguarResponseGetter srg = new LiveJaguarResponseGetter(spy);
    ApiResource.setStripeResponseGetter(srg);
    JaguarResponse response =
        new JaguarResponse(200, HttpHeaders.of(Collections.emptyMap()), "invalid JSON");
    Mockito.doReturn(response).when(spy).requestWithRetries(Mockito.<JaguarRequest>any());
    Exception exception =
        assertThrows(
            ApiException.class,
            () -> {
              Subscription.retrieve("sub_123");
            });
    assertThat(
        exception.getMessage(), CoreMatchers.containsString("Invalid response object from API"));
    assertNotNull(exception.getCause());
    assertThat(exception.getCause(), CoreMatchers.instanceOf(JsonSyntaxException.class));
  }
}
