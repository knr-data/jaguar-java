package com.jaguar.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class JaguarRawJsonObjectDeserializer implements JsonDeserializer<JaguarRawJsonObject> {
  /** Deserializes a JSON payload into a {@link JaguarRawJsonObject} object. */
  @Override
  public JaguarRawJsonObject deserialize(
      JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JaguarRawJsonObject object = new JaguarRawJsonObject();
    object.json = json.getAsJsonObject();
    return object;
  }
}
