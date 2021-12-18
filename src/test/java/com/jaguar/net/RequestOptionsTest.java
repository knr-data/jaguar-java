package com.jaguar.net;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.jaguar.Jaguar;

import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import org.junit.jupiter.api.Test;

public class RequestOptionsTest {

  @Test
  public void testPersistentValuesInToBuilder() {
    RequestOptions opts =
        RequestOptions.builder()
            .setApiKey("sk_foo")
            .setClientId("123")
            .setIdempotencyKey("123")
            .setStripeAccount("acct_bar")
            .setStripeVersionOverride("2015-05-05")
            .setConnectTimeout(100)
            .setReadTimeout(100)
            .setConnectionProxy(
                new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 1234)))
            .setProxyCredential(new PasswordAuthentication("username", "password".toCharArray()))
            .build();

    RequestOptions optsRebuilt = opts.toBuilder().build();

    // only api keys and account should persist
    // assuming these are stable across a given stripe integration
    assertEquals("sk_foo", optsRebuilt.getApiKey());
    assertEquals("acct_bar", optsRebuilt.getStripeAccount());

    assertNull(optsRebuilt.getClientId());
    assertNull(optsRebuilt.getIdempotencyKey());
    assertNull(optsRebuilt.getStripeVersionOverride());
    assertEquals(Jaguar.DEFAULT_CONNECT_TIMEOUT, optsRebuilt.getConnectTimeout());
    assertEquals(Jaguar.DEFAULT_READ_TIMEOUT, optsRebuilt.getReadTimeout());
    assertEquals(Jaguar.getConnectionProxy(), optsRebuilt.getConnectionProxy());
    assertEquals(Jaguar.getProxyCredential(), optsRebuilt.getProxyCredential());
  }

  @Test
  public void testStripeVersionOverride() {
    String stripeVersionOverride = "2015-05-05";

    RequestOptions.RequestOptionsBuilder builder =
        RequestOptions.builder().setStripeVersionOverride(stripeVersionOverride);

    assertEquals(stripeVersionOverride, builder.getStripeVersionOverride());

    builder.clearStripeVersionOverride();
    assertNull(builder.getStripeVersionOverride());
  }

  @Test
  public void testHashCodeEqualOverride() {
    Proxy connectionProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8080));
    PasswordAuthentication proxyCredential =
        new PasswordAuthentication("username", "password".toCharArray());

    RequestOptions opts1 =
        RequestOptions.builder()
            .setApiKey("sk_foo")
            .setClientId("123")
            .setIdempotencyKey("123")
            .setStripeAccount("acct_bar")
            .setStripeVersionOverride("2015-05-05")
            .setConnectTimeout(100)
            .setReadTimeout(200)
            .setConnectionProxy(connectionProxy)
            .setProxyCredential(proxyCredential)
            .build();

    RequestOptions opts2 =
        RequestOptions.builder()
            .setApiKey("sk_foo")
            .setClientId("123")
            .setIdempotencyKey("123")
            .setStripeAccount("acct_bar")
            .setStripeVersionOverride("2015-05-05")
            .setConnectTimeout(100)
            .setReadTimeout(200)
            .setConnectionProxy(connectionProxy)
            .setProxyCredential(proxyCredential)
            .build();

    assertEquals(opts1, opts2);
    assertEquals(opts1.hashCode(), opts2.hashCode());
  }

  @Test
  public void testTimeoutDefaultValues() {
    int origConnectTimeout = Jaguar.getConnectTimeout();
    int origReadTimeout = Jaguar.getReadTimeout();

    try {
      Jaguar.setConnectTimeout(123);
      Jaguar.setReadTimeout(234);

      RequestOptions opts = RequestOptions.builder().build();

      assertEquals(123, opts.getConnectTimeout());
      assertEquals(234, opts.getReadTimeout());
    } finally {
      Jaguar.setConnectTimeout(origConnectTimeout);
      Jaguar.setReadTimeout(origReadTimeout);
    }
  }

  @Test
  public void testProxyDefaultValues() {
    Proxy origConnectionProxy = Jaguar.getConnectionProxy();
    PasswordAuthentication origProxyCredential = Jaguar.getProxyCredential();

    try {
      Proxy newConnectionProxy =
          new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8080));
      PasswordAuthentication newProxyCredential =
          new PasswordAuthentication("username", "password".toCharArray());

      Jaguar.setConnectionProxy(newConnectionProxy);
      Jaguar.setProxyCredential(newProxyCredential);

      RequestOptions opts = RequestOptions.builder().build();

      assertEquals(newConnectionProxy, opts.getConnectionProxy());
      assertEquals(newProxyCredential, opts.getProxyCredential());
    } finally {
      Jaguar.setConnectionProxy(origConnectionProxy);
      Jaguar.setProxyCredential(origProxyCredential);
    }
  }
}
