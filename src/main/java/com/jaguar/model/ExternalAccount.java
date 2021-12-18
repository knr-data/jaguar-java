package com.jaguar.model;

import com.jaguar.exception.JaguarException;
import com.jaguar.net.RequestOptions;
import java.util.Map;

public interface ExternalAccount extends JaguarObjectInterface, HasId {
  ExternalAccount update(Map<String, Object> params, RequestOptions options) throws JaguarException;

  ExternalAccount update(Map<String, Object> params) throws JaguarException;

  ExternalAccount delete(Map<String, Object> params, RequestOptions options) throws JaguarException;

  ExternalAccount delete() throws JaguarException;

  ExternalAccount delete(RequestOptions options) throws JaguarException;

  ExternalAccount delete(Map<String, Object> params) throws JaguarException;
}
