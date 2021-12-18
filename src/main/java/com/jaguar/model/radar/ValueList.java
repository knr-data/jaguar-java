// File generated from our OpenAPI spec
package com.jaguar.model.radar;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.HasId;
import com.jaguar.model.MetadataStore;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.radar.ValueListCreateParams;
import com.jaguar.param.radar.ValueListListParams;
import com.jaguar.param.radar.ValueListRetrieveParams;
import com.jaguar.param.radar.ValueListUpdateParams;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ValueList extends ApiResource implements HasId, MetadataStore<ValueList> {
  /** The name of the value list for use in rules. */
  @SerializedName("alias")
  String alias;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /** The name or email address of the user who created this value list. */
  @SerializedName("created_by")
  String createdBy;

  /** Always true for a deleted object. */
  @SerializedName("deleted")
  Boolean deleted;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /**
   * The type of items in the value list. One of {@code card_fingerprint}, {@code card_bin}, {@code
   * email}, {@code ip_address}, {@code country}, {@code string}, {@code case_sensitive_string}, or
   * {@code customer_id}.
   */
  @SerializedName("item_type")
  String itemType;

  /** List of items contained within this value list. */
  @SerializedName("list_items")
  ValueListItemCollection listItems;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of <a href="https://stripe.com/docs/api/metadata">key-value pairs</a> that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("metadata")
  Map<String, String> metadata;

  /** The name of the value list. */
  @SerializedName("name")
  String name;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code radar.value_list}.
   */
  @SerializedName("object")
  String object;

  /**
   * Returns a list of <code>ValueList</code> objects. The objects are sorted in descending order by
   * creation date, with the most recently created object appearing first.
   */
  public static ValueListCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of <code>ValueList</code> objects. The objects are sorted in descending order by
   * creation date, with the most recently created object appearing first.
   */
  public static ValueListCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/radar/value_lists");
    return ApiResource.requestCollection(url, params, ValueListCollection.class, options);
  }

  /**
   * Returns a list of <code>ValueList</code> objects. The objects are sorted in descending order by
   * creation date, with the most recently created object appearing first.
   */
  public static ValueListCollection list(ValueListListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of <code>ValueList</code> objects. The objects are sorted in descending order by
   * creation date, with the most recently created object appearing first.
   */
  public static ValueListCollection list(ValueListListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/radar/value_lists");
    return ApiResource.requestCollection(url, params, ValueListCollection.class, options);
  }

  /** Retrieves a <code>ValueList</code> object. */
  public static ValueList retrieve(String valueList) throws JaguarException {
    return retrieve(valueList, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves a <code>ValueList</code> object. */
  public static ValueList retrieve(String valueList, RequestOptions options)
      throws JaguarException {
    return retrieve(valueList, (Map<String, Object>) null, options);
  }

  /** Retrieves a <code>ValueList</code> object. */
  public static ValueList retrieve(
      String valueList, Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/radar/value_lists/%s", ApiResource.urlEncodeId(valueList)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ValueList.class, options);
  }

  /** Retrieves a <code>ValueList</code> object. */
  public static ValueList retrieve(
      String valueList, ValueListRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/radar/value_lists/%s", ApiResource.urlEncodeId(valueList)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ValueList.class, options);
  }

  /** Creates a new <code>ValueList</code> object, which can then be referenced in rules. */
  public static ValueList create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new <code>ValueList</code> object, which can then be referenced in rules. */
  public static ValueList create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/radar/value_lists");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ValueList.class, options);
  }

  /** Creates a new <code>ValueList</code> object, which can then be referenced in rules. */
  public static ValueList create(ValueListCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new <code>ValueList</code> object, which can then be referenced in rules. */
  public static ValueList create(ValueListCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/radar/value_lists");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ValueList.class, options);
  }

  /**
   * Updates a <code>ValueList</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged. Note that <code>item_type</code> is immutable.
   */
  @Override
  public ValueList update(Map<String, Object> params) throws JaguarException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates a <code>ValueList</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged. Note that <code>item_type</code> is immutable.
   */
  @Override
  public ValueList update(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/radar/value_lists/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ValueList.class, options);
  }

  /**
   * Updates a <code>ValueList</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged. Note that <code>item_type</code> is immutable.
   */
  public ValueList update(ValueListUpdateParams params) throws JaguarException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates a <code>ValueList</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged. Note that <code>item_type</code> is immutable.
   */
  public ValueList update(ValueListUpdateParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/radar/value_lists/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, ValueList.class, options);
  }

  /**
   * Deletes a <code>ValueList</code> object, also deleting any items contained within the value
   * list. To be deleted, a value list must not be referenced in any rules.
   */
  public ValueList delete() throws JaguarException {
    return delete((Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Deletes a <code>ValueList</code> object, also deleting any items contained within the value
   * list. To be deleted, a value list must not be referenced in any rules.
   */
  public ValueList delete(RequestOptions options) throws JaguarException {
    return delete((Map<String, Object>) null, options);
  }

  /**
   * Deletes a <code>ValueList</code> object, also deleting any items contained within the value
   * list. To be deleted, a value list must not be referenced in any rules.
   */
  public ValueList delete(Map<String, Object> params) throws JaguarException {
    return delete(params, (RequestOptions) null);
  }

  /**
   * Deletes a <code>ValueList</code> object, also deleting any items contained within the value
   * list. To be deleted, a value list must not be referenced in any rules.
   */
  public ValueList delete(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/radar/value_lists/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.DELETE, url, params, ValueList.class, options);
  }
}
