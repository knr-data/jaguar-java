package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.ImmutableMap;
import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.FileCollection;
import com.jaguar.net.ApiResource;
import com.jaguar.net.RequestOptions;
import com.jaguar.param.FileCreateParams;
import com.jaguar.param.FileListParams;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FileTest extends BaseJaguarTest {
  public static final String FILE_ID = "file_123";

  @Test
  public void testCreateWithFile() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("purpose", "dispute_evidence");
    params.put("file", new File(getClass().getResource("/test.png").getFile()));

    final com.jaguar.model.File file = com.jaguar.model.File.create(params);

    assertNotNull(file);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/files", params, null);
  }

  @Test
  public void testCreateWithFileWithTypedParams() throws JaguarException {
    File fileObject = new File(getClass().getResource("/test.png").getFile());
    FileCreateParams fileCreateParams =
        FileCreateParams.builder()
            .setPurpose(FileCreateParams.Purpose.DISPUTE_EVIDENCE)
            .setFileLinkData(
                FileCreateParams.FileLinkData.builder().setCreate(true).setExpiresAt(123L).build())
            .setFile(fileObject)
            .build();

    final com.jaguar.model.File file = com.jaguar.model.File.create(fileCreateParams);

    assertNotNull(file);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/files",
        ImmutableMap.of(
            "purpose",
            "dispute_evidence",
            "file",
            fileObject,
            "file_link_data",
            ImmutableMap.of("create", true, "expires_at", 123)),
        null);
  }

  @Test
  public void testThrowExceptionCreateWithNullTypedParams() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              com.jaguar.model.File.create((FileCreateParams) null, RequestOptions.getDefault());
            });
    assertTrue(exception.getMessage().contains("Found null params"));
  }

  @Test
  public void testCreateWithFileInputStream() throws IOException, JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("purpose", "dispute_evidence");
    FileInputStream value = new FileInputStream(getClass().getResource("/test.png").getFile());
    params.put("file", value);

    final com.jaguar.model.File file = com.jaguar.model.File.create(params);

    assertNotNull(file);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/files", params, null);
  }

  @Test
  public void testCreateWithByteArrayInputStream() throws IOException, JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("purpose", "dispute_evidence");
    ByteArrayInputStream value =
        new ByteArrayInputStream("file contents".getBytes(StandardCharsets.UTF_8));
    params.put("file", value);

    final com.jaguar.model.File file = com.jaguar.model.File.create(params);

    assertNotNull(file);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/files", params, null);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final com.jaguar.model.File file = com.jaguar.model.File.retrieve(FILE_ID);

    assertNotNull(file);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/files/%s", FILE_ID));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final FileCollection files = com.jaguar.model.File.list(params);

    assertNotNull(files);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/files", params);
  }

  @Test
  public void testListWithTypedParams() throws JaguarException {
    FileListParams params = FileListParams.builder().setLimit(1L).build();

    final FileCollection files = com.jaguar.model.File.list(params);

    assertNotNull(files);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/files", ImmutableMap.of("limit", 1));
  }
}
