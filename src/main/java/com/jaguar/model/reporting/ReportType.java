// File generated from our OpenAPI spec
package com.jaguar.model.reporting;

import com.google.gson.annotations.SerializedName;
import com.jaguar.Jaguar;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.HasId;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.reporting.ReportTypeListParams;
import com.jaguar.param.reporting.ReportTypeRetrieveParams;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ReportType extends ApiResource implements HasId {
  /**
   * Most recent time for which this Report Type is available. Measured in seconds since the Unix
   * epoch.
   */
  @SerializedName("data_available_end")
  Long dataAvailableEnd;

  /**
   * Earliest time for which this Report Type is available. Measured in seconds since the Unix
   * epoch.
   */
  @SerializedName("data_available_start")
  Long dataAvailableStart;

  /**
   * List of column names that are included by default when this Report Type gets run. (If the
   * Report Type doesn't support the {@code columns} parameter, this will be null.)
   */
  @SerializedName("default_columns")
  List<String> defaultColumns;

  /**
   * The <a href="https://stripe.com/docs/reporting/statements/api#available-report-types">ID of the
   * Report Type</a>, such as {@code balance.summary.1}.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /** Human-readable name of the Report Type. */
  @SerializedName("name")
  String name;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code reporting.report_type}.
   */
  @SerializedName("object")
  String object;

  /** When this Report Type was latest updated. Measured in seconds since the Unix epoch. */
  @SerializedName("updated")
  Long updated;

  /**
   * Version of the Report Type. Different versions report with the same ID will have the same
   * purpose, but may take different run parameters or have different result schemas.
   */
  @SerializedName("version")
  Long version;

  /**
   * Retrieves the details of a Report Type. (Certain report types require a <a
   * href="https://stripe.com/docs/keys#test-live-modes">live-mode API key</a>.)
   */
  public static ReportType retrieve(String reportType) throws JaguarException {
    return retrieve(reportType, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves the details of a Report Type. (Certain report types require a <a
   * href="https://stripe.com/docs/keys#test-live-modes">live-mode API key</a>.)
   */
  public static ReportType retrieve(String reportType, RequestOptions options)
      throws JaguarException {
    return retrieve(reportType, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves the details of a Report Type. (Certain report types require a <a
   * href="https://stripe.com/docs/keys#test-live-modes">live-mode API key</a>.)
   */
  public static ReportType retrieve(
      String reportType, Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/reporting/report_types/%s", ApiResource.urlEncodeId(reportType)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ReportType.class, options);
  }

  /**
   * Retrieves the details of a Report Type. (Certain report types require a <a
   * href="https://stripe.com/docs/keys#test-live-modes">live-mode API key</a>.)
   */
  public static ReportType retrieve(
      String reportType, ReportTypeRetrieveParams params, RequestOptions options)
      throws JaguarException {
    String url =
        String.format(
            "%s%s",
            Jaguar.getApiBase(),
            String.format("/v1/reporting/report_types/%s", ApiResource.urlEncodeId(reportType)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, ReportType.class, options);
  }

  /** Returns a full list of Report Types. */
  public static ReportTypeCollection list(Map<String, Object> params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a full list of Report Types. */
  public static ReportTypeCollection list(Map<String, Object> params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/reporting/report_types");
    return ApiResource.requestCollection(url, params, ReportTypeCollection.class, options);
  }

  /** Returns a full list of Report Types. */
  public static ReportTypeCollection list(ReportTypeListParams params) throws JaguarException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a full list of Report Types. */
  public static ReportTypeCollection list(ReportTypeListParams params, RequestOptions options)
      throws JaguarException {
    String url = String.format("%s%s", Jaguar.getApiBase(), "/v1/reporting/report_types");
    return ApiResource.requestCollection(url, params, ReportTypeCollection.class, options);
  }
}
