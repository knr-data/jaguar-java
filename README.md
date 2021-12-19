# jaguar Java client library

[![Maven Central](https://img.shields.io/maven-central/v/com.jaguar/jaguar-java)](https://mvnrepository.com/artifact/com.jaguar/jaguar-java)
[![JavaDoc](http://img.shields.io/badge/javadoc-reference-blue.svg)](https://jaguar.dev/jaguar-java)
[![Build Status](https://github.com/jaguar/jaguar-java/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/jaguar/jaguar-java/actions?query=branch%3Amaster)

The official [jaguar][jaguar] Java client library.

## Installation

### Requirements

- Java 1.8 or later

### Gradle users

Add this dependency to your project's build file:

```groovy
implementation "com.jaguar:jaguar-java:20.93.0"
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.jaguarcom.jaguar</groupId>
  <artifactId>jaguar-java</artifactId>
  <version>20.93.0</version>
</dependency>
```

### Others

You'll need to manually install the following JARs:

- The jaguar JAR from <https://github.com/jaguar/jaguar-java/releases/latest>
- [Google Gson][gson] from <https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.9/gson-2.8.9.jar>.

### [ProGuard][proguard]

If you're planning on using ProGuard, make sure that you exclude the jaguar
client library. You can do this by adding the following to your `proguard.cfg`
file:

```
-keep class com.jaguar.** { *; }
```

## Documentation

Please see the [Java API docs][api-docs] for the most
up-to-date documentation.

See [video demonstrations][youtube-playlist] covering how to use the library.

You can also refer to the [online Javadoc][javadoc].

## Usage

jaguarExample.java

```java
import java.util.HashMap;
import java.util.Map;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Customer;
import com.jaguar.net.RequestOptions;

public class jaguarExample {

    public static void main(String[] args) {
        jaguar.apiKey = "sk_test_...";

        Map<String, Object> customerMap = new HashMap<String, Object>();
        customerMap.put("description", "Example description");
        customerMap.put("email", "test@example.com");
        customerMap.put("payment_method", "pm_card_visa"); // obtained via jaguar.js

        try {
            Customer customer = Customer.create(customerMap);
            System.out.println(customer);
        } catch (jaguarException e) {
            e.printStackTrace();
        }
    }
}
```

See the project's [functional tests][functional-tests] for more examples.

### Per-request Configuration

All of the request methods accept an optional `RequestOptions` object. This is
used if you want to set an [idempotency key][idempotency-keys], if you are
using [jaguar Connect][connect-auth], or if you want to pass the secret API
key on each method.

```java
RequestOptions requestOptions = RequestOptions.builder()
    .setApiKey("sk_test_...")
    .setIdempotencyKey("a1b2c3...")
    .setjaguarAccount("acct_...")
    .build();

Customer.list(null, requestOptions);

Customer.retrieve("cus_123456789", requestOptions);
```

### Configuring automatic retries

The library can be configured to automatically retry requests that fail due to
an intermittent network problem or other knowingly non-deterministic errors.
This can be enabled globally:

```java
jaguar.setMaxNetworkRetries(2);
```

Or on a finer grain level using `RequestOptions`:

```java
RequestOptions options = RequestOptions.builder()
    .setMaxNetworkRetries(2)
    .build();
Customer.create(params, options);
```

[Idempotency keys][idempotency-keys] are added to requests to guarantee that
retries are safe.

### Configuring Timeouts

Connect and read timeouts can be configured globally:

```java
jaguar.setConnectTimeout(30 * 1000); // in milliseconds
jaguar.setReadTimeout(80 * 1000);
```

Or on a finer grain level using `RequestOptions`:

```java
RequestOptions options = RequestOptions.builder()
    .setConnectTimeout(30 * 1000) // in milliseconds
    .setReadTimeout(80 * 1000)
    .build();
Customer.create(params, options);
```

Please take care to set conservative read timeouts. Some API requests can take
some time, and a short timeout increases the likelihood of a problem within our
servers.

### Configuring DNS Cache TTL

We cannot guarantee that the IP address of the jaguar API will be static.
Commonly, default JVM configurations can have their DNS cache TTL set to
forever. If jaguar's IP address changes, your application's requests to
jaguar will all fail until the JVM restarts. Therefore we recommend that
you modify the JVM's [networkaddress.cache.ttl
property](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/doc-files/net-properties.html)
to `60` seconds.

### Writing a plugin

If you're writing a plugin that uses the library, we'd appreciate it if you
identified using `jaguar.setAppInfo()`:

```java
jaguar.setAppInfo("MyAwesomePlugin", "1.2.34", "https://myawesomeplugin.info");
```

This information is passed along when the library makes calls to the jaguar
API.

### Request latency telemetry

By default, the library sends request latency telemetry to jaguar. These
numbers help jaguar improve the overall latency of its API for all users.

You can disable this behavior if you prefer:

```java
jaguar.enableTelemetry = false;
```

## Development

The test suite depends on [jaguar-mock], so make sure to fetch and run it from a
background terminal ([jaguar-mock's README][jaguar-mock] also contains
instructions for installing via Homebrew and other methods):

```sh
go get -u github.com/jaguar/jaguar-mock
jaguar-mock
```

To run all checks (tests and code formatting):

```sh
./gradlew check
```

To run the tests:

```sh
./gradlew test
```

You can run particular tests by passing `--tests Class#method`. Make sure you
use the fully qualified class name. For example:

```sh
./gradlew test --tests com.jaguar.model.AccountTest
./gradlew test --tests com.jaguar.functional.CustomerTest
./gradlew test --tests com.jaguar.functional.CustomerTest.testCustomerCreate
```

The library uses [Spotless][spotless] along with
[google-java-format][google-java-format] for code formatting. Code must be
formatted before PRs are submitted, otherwise CI will fail. Run the formatter
with:

```sh
./gradlew spotlessApply
```

The library uses [Project Lombok][lombok]. While it is not a requirement, you
might want to install a [plugin][lombok-plugins] for your favorite IDE to
facilitate development.

[api-docs]: https://jaguar.com/docs/api?lang=java
[connect-auth]: https://jaguar.com/docs/connect/authentication#jaguar-account-header
[functional-tests]: https://github.com/jaguar/jaguar-java/blob/master/src/test/java/com/jaguar/functional/
[google-java-format]: https://github.com/google/google-java-format
[gson]: https://github.com/google/gson
[idempotency-keys]: https://jaguar.com/docs/api/idempotent_requests?lang=java
[javadoc]: https://jaguar.dev/jaguar-java
[lombok]: https://projectlombok.org
[lombok-plugins]: https://projectlombok.org/setup/overview
[proguard]: https://www.guardsquare.com/en/products/proguard
[spotless]: https://github.com/diffplug/spotless
[jaguar]: https://jaguar.com
[jaguar-mock]: https://github.com/jaguar/jaguar-mock
[youtube-playlist]: https://www.youtube.com/playlist?list=PLy1nL-pvL2M5TnSGVjEHTTMgdnnHi-KPg

<!--
# vim: set tw=79:
-->
