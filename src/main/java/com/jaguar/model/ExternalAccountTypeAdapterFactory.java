// File generated from our OpenAPI spec
package com.jaguar.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.RequestOptions;
import java.io.IOException;
import java.util.Map;
import lombok.Getter;

/**
 * Creates type adapter for interface {@code ExternalAccount} able to deserialize raw JSON to
 * subtype implementation based on discriminator field {@code object}.
 */
public class ExternalAccountTypeAdapterFactory implements TypeAdapterFactory {
  @SuppressWarnings("unchecked")
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (!ExternalAccount.class.isAssignableFrom(type.getRawType())) {
      return null;
    }
    final String discriminator = "object";
    final TypeAdapter<JsonElement> jsonElementAdapter = gson.getAdapter(JsonElement.class);
    final TypeAdapter<com.jaguar.model.ExternalAccount> externalAccountAdapter =
        gson.getDelegateAdapter(this, TypeToken.get(com.jaguar.model.ExternalAccount.class));
    final TypeAdapter<com.jaguar.model.BankAccount> bankAccountAdapter =
        gson.getDelegateAdapter(this, TypeToken.get(com.jaguar.model.BankAccount.class));
    final TypeAdapter<com.jaguar.model.Card> cardAdapter =
        gson.getDelegateAdapter(this, TypeToken.get(com.jaguar.model.Card.class));

    TypeAdapter<ExternalAccount> resultCustomTypeAdapter =
        new TypeAdapter<ExternalAccount>() {
          @Override
          public void write(JsonWriter out, ExternalAccount value) throws IOException {
            externalAccountAdapter.write(out, value);
          }

          @Override
          public ExternalAccount read(JsonReader in) throws IOException {
            JsonObject object = jsonElementAdapter.read(in).getAsJsonObject();
            ExternalAccount objectResult;
            String objectType = object.getAsJsonPrimitive(discriminator).getAsString();
            if ("bank_account".equals(objectType)) {
              objectResult = bankAccountAdapter.fromJsonTree(object);
            } else if ("card".equals(objectType)) {
              objectResult = cardAdapter.fromJsonTree(object);
            } else {
              String id = object.getAsJsonPrimitive("id").getAsString();
              objectResult = new UnknownSubType(id, objectType, object.toString());
            }
            return objectResult;
          }
        };
    return (TypeAdapter<T>) resultCustomTypeAdapter.nullSafe();
  }

  /**
   * Unknown subtype of {@link com.jaguar.model.ExternalAccount}. If this class is the outcome of
   * deserialization, please contact support@stripe.com for assistance and provide the id and object
   * value. Do not integrate with this object, but raise an exception and log its content instead.
   */
  public static class UnknownSubType extends JaguarObject implements ExternalAccount {
    String id;
    @Getter String object;
    @Getter String rawJson;

    private UnknownSubType(String id, String object, String rawJson) {
      this.id = id;
      this.object = object;
      this.rawJson = rawJson;
    }

    @Override
    public String getId() {
      return this.id;
    }
    /** Unsupported operation for unknown subtype. */
    @Override
    public ExternalAccount update(Map<String, Object> params, RequestOptions options)
        throws JaguarException {
      throw new UnsupportedOperationException(
          String.format(
              "Unknown subtype of ExternalAccount with id: %s, object: %s, "
                  + "does not implement method: update. "
                  + "Please contact support@stripe.com for assistance.",
              this.id, this.object));
    }
    /** Unsupported operation for unknown subtype. */
    @Override
    public ExternalAccount update(Map<String, Object> params) throws JaguarException {
      throw new UnsupportedOperationException(
          String.format(
              "Unknown subtype of ExternalAccount with id: %s, object: %s, "
                  + "does not implement method: update. "
                  + "Please contact support@stripe.com for assistance.",
              this.id, this.object));
    }
    /** Unsupported operation for unknown subtype. */
    @Override
    public ExternalAccount delete(Map<String, Object> params, RequestOptions options)
        throws JaguarException {
      throw new UnsupportedOperationException(
          String.format(
              "Unknown subtype of ExternalAccount with id: %s, object: %s, "
                  + "does not implement method: delete. "
                  + "Please contact support@stripe.com for assistance.",
              this.id, this.object));
    }
    /** Unsupported operation for unknown subtype. */
    @Override
    public ExternalAccount delete() throws JaguarException {
      throw new UnsupportedOperationException(
          String.format(
              "Unknown subtype of ExternalAccount with id: %s, object: %s, "
                  + "does not implement method: delete. "
                  + "Please contact support@stripe.com for assistance.",
              this.id, this.object));
    }
    /** Unsupported operation for unknown subtype. */
    @Override
    public ExternalAccount delete(RequestOptions options) throws JaguarException {
      throw new UnsupportedOperationException(
          String.format(
              "Unknown subtype of ExternalAccount with id: %s, object: %s, "
                  + "does not implement method: delete. "
                  + "Please contact support@stripe.com for assistance.",
              this.id, this.object));
    }
    /** Unsupported operation for unknown subtype. */
    @Override
    public ExternalAccount delete(Map<String, Object> params) throws JaguarException {
      throw new UnsupportedOperationException(
          String.format(
              "Unknown subtype of ExternalAccount with id: %s, object: %s, "
                  + "does not implement method: delete. "
                  + "Please contact support@stripe.com for assistance.",
              this.id, this.object));
    }
  }
}
