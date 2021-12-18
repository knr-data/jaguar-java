package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.FileLink;
import com.jaguar.model.FileLinkCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FileLinkTest extends BaseJaguarTest {
  public static final String FILE_LINK_ID = "link_123";

  private FileLink getFileLinkFixture() throws JaguarException {
    final FileLink fileLink = FileLink.retrieve(FILE_LINK_ID);
    resetNetworkSpy();
    return fileLink;
  }

  @Test
  public void testCreate() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("file", "file_123");

    final FileLink fileLink = FileLink.create(params);

    assertNotNull(fileLink);
    verifyRequest(ApiResource.RequestMethod.POST, String.format("/v1/file_links"), params);
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final FileLink fileLink = FileLink.retrieve(FILE_LINK_ID);

    assertNotNull(fileLink);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/file_links/%s", FILE_LINK_ID));
  }

  @Test
  public void testUpdate() throws JaguarException {
    final FileLink fileLink = getFileLinkFixture();

    final Map<String, String> metadata = new HashMap<>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<>();
    params.put("metadata", metadata);

    final FileLink updatedFileLink = fileLink.update(params);

    assertNotNull(updatedFileLink);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/file_links/%s", fileLink.getId()),
        params);
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("file", "file_123");
    params.put("limit", 1);

    final FileLinkCollection fileLinks = FileLink.list(params);

    assertNotNull(fileLinks);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/file_links"));
  }
}
