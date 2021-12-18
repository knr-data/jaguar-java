// File generated from our OpenAPI spec
package com.jaguar.model;

import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.PersonCollectionCreateParams;
import com.jaguar.param.PersonCollectionListParams;
import com.jaguar.param.PersonCollectionRetrieveParams;
import java.util.Map;

public class PersonCollection extends JaguarCollection<Person> {
  /**
   * Returns a list of people associated with the account’s legal entity. The people are returned
   * sorted by creation date, with the most recent people appearing first.
   */
  public PersonCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of people associated with the account’s legal entity. The people are returned
   * sorted by creation date, with the most recent people appearing first.
   */
  public PersonCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, PersonCollection.class, options);
  }

  /**
   * Returns a list of people associated with the account’s legal entity. The people are returned
   * sorted by creation date, with the most recent people appearing first.
   */
  public PersonCollection list(PersonCollectionListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of people associated with the account’s legal entity. The people are returned
   * sorted by creation date, with the most recent people appearing first.
   */
  public PersonCollection list(PersonCollectionListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, PersonCollection.class, options);
  }

  /** Retrieves an existing person. */
  public Person retrieve(String id) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves an existing person. */
  public Person retrieve(String id, RequestOptions options) throws JaguarException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /** Retrieves an existing person. */
  public Person retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Person.class, options);
  }

  /** Retrieves an existing person. */
  public Person retrieve(String id, PersonCollectionRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("%s/%s", this.getUrl(), ApiResource.urlEncodeId(id)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Person.class, options);
  }

  /** Creates a new person. */
  public Person create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new person. */
  public Person create(Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Person.class, options);
  }

  /** Creates a new person. */
  public Person create(PersonCollectionCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new person. */
  public Person create(PersonCollectionCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), this.getUrl());
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Person.class, options);
  }
}
