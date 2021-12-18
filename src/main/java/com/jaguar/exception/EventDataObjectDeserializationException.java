package com.jaguar.exception;

import com.jaguar.model.EventDataObjectDeserializer;
import lombok.Getter;

public class EventDataObjectDeserializationException extends JaguarException {
  private static final long serialVersionUID = 2L;

  /**
   * JSON intended as event data object {@link EventDataObjectDeserializer#getObject()} that fails
   * deserialization.
   */
  @Getter private final String rawJson;

  public EventDataObjectDeserializationException(String message, String rawJson) {
    super(message, null, null, null);
    this.rawJson = rawJson;
  }
}
