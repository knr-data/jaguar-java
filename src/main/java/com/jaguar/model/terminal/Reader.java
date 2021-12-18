// File generated from our OpenAPI spec
package com.jaguar.model.terminal;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.ExpandableField;
import com.jaguar.model.HasId;
import com.jaguar.model.MetadataStore;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.terminal.ReaderCreateParams;
import com.jaguar.param.terminal.ReaderListParams;
import com.jaguar.param.terminal.ReaderRetrieveParams;
import com.jaguar.param.terminal.ReaderUpdateParams;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Reader extends ApiResource implements HasId, MetadataStore<Reader> {
  /** Always true for a deleted object. */
  @SerializedName("deleted")
  Boolean deleted;

  /** The current software version of the reader. */
  @SerializedName("device_sw_version")
  String deviceSwVersion;

  /**
   * Type of reader, one of {@code bbpos_chipper2x}, {@code bbpos_wisepos_e}, or {@code
   * verifone_P400}.
   */
  @SerializedName("device_type")
  String deviceType;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** The local IP address of the reader. */
  @SerializedName("ip_address")
  String ipAddress;

  /** Custom label given to the reader for easier identification. */
  @SerializedName("label")
  String label;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /** The location identifier of the reader. */
  @SerializedName("location")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Location> location;

  /**
   * Set of <a href="https://stripe.com/docs/api/metadata">key-value pairs</a> that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code terminal.reader}.
   */
  @SerializedName("object")
  String object;

  /** Serial number of the reader. */
  @SerializedName("serial_number")
  String serialNumber;

  /** The networking status of the reader. */
  @SerializedName("status")
  String status;

  /** Get ID of expandable {@code location} object. */
  public String getLocation() {
    return (this.location != null) ? this.location.getId() : null;
  }

  public void setLocation(String id) {
    this.location = ApiResource.setExpandableFieldId(id, this.location);
  }

  /** Get expanded {@code location}. */
  public Location getLocationObject() {
    return (this.location != null) ? this.location.getExpanded() : null;
  }

  public void setLocationObject(Location expandableObject) {
    this.location = new ExpandableField<Location>(expandableObject.getId(), expandableObject);
  }

  /**
   * Updates a <code>Reader</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged.
   */
  @Override
  public Reader update(Map<String, Object> params) throws JaguarException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates a <code>Reader</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged.
   */
  @Override
  public Reader update(Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/terminal/readers/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Reader.class, options);
  }

  /**
   * Updates a <code>Reader</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged.
   */
  public Reader update(ReaderUpdateParams params) throws JaguarException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates a <code>Reader</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged.
   */
  public Reader update(ReaderUpdateParams params, RequestOptions options) throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/terminal/readers/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Reader.class, options);
  }

  /** Retrieves a <code>Reader</code> object. */
  public static Reader retrieve(String reader) throws JaguarException {
    return retrieve(reader, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves a <code>Reader</code> object. */
  public static Reader retrieve(String reader, RequestOptions options) throws JaguarException {
    return retrieve(reader, (Map<String, Object>) null, options);
  }

  /** Retrieves a <code>Reader</code> object. */
  public static Reader retrieve(String reader, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/terminal/readers/%s", ApiResource.urlEncodeId(reader)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Reader.class, options);
  }

  /** Retrieves a <code>Reader</code> object. */
  public static Reader retrieve(String reader, ReaderRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/terminal/readers/%s", ApiResource.urlEncodeId(reader)));
    return ApiResource.request(ApiResource.RequestMethod.GET, url, params, Reader.class, options);
  }

  /** Creates a new <code>Reader</code> object. */
  public static Reader create(Map<String, Object> params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new <code>Reader</code> object. */
  public static Reader create(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/terminal/readers");
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Reader.class, options);
  }

  /** Creates a new <code>Reader</code> object. */
  public static Reader create(ReaderCreateParams params) throws JaguarException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new <code>Reader</code> object. */
  public static Reader create(ReaderCreateParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/terminal/readers");
    return ApiResource.request(ApiResource.RequestMethod.POST, url, params, Reader.class, options);
  }

  /** Returns a list of <code>Reader</code> objects. */
  public static ReaderCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of <code>Reader</code> objects. */
  public static ReaderCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/terminal/readers");
    return ApiResource.requestCollection(url, params, ReaderCollection.class, options);
  }

  /** Returns a list of <code>Reader</code> objects. */
  public static ReaderCollection list(ReaderListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of <code>Reader</code> objects. */
  public static ReaderCollection list(ReaderListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/terminal/readers");
    return ApiResource.requestCollection(url, params, ReaderCollection.class, options);
  }

  /** Deletes a <code>Reader</code> object. */
  public Reader delete() throws JaguarException {
    return delete((Map<String, Object>) null, (RequestOptions) null);
  }

  /** Deletes a <code>Reader</code> object. */
  public Reader delete(RequestOptions options) throws JaguarException {
    return delete((Map<String, Object>) null, options);
  }

  /** Deletes a <code>Reader</code> object. */
  public Reader delete(Map<String, Object> params) throws JaguarException {
    return delete(params, (RequestOptions) null);
  }

  /** Deletes a <code>Reader</code> object. */
  public Reader delete(Map<String, Object> params, RequestOptions options) throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/terminal/readers/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.DELETE, url, params, Reader.class, options);
  }
}
