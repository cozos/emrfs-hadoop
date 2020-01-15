package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import javax.net.ssl.KeyManager;

public final class FileStoreTlsKeyManagersProvider
  extends AbstractFileTlsKeyManagersProvider
{
  private static final Log log = LogFactory.getLog(FileStoreTlsKeyManagersProvider.class);
  private final File storePath;
  private final String storeType;
  private final char[] password;
  
  public FileStoreTlsKeyManagersProvider(File storePath, String storeType, String password)
  {
    this.storePath = ((File)ValidationUtils.assertNotNull(storePath, "storePath"));
    this.storeType = ValidationUtils.assertStringNotEmpty(storeType, "storeType");
    this.password = (password != null ? password.toCharArray() : null);
  }
  
  public KeyManager[] getKeyManagers()
  {
    try
    {
      return createKeyManagers(storePath, storeType, password);
    }
    catch (Exception e)
    {
      if (log.isWarnEnabled()) {
        log.warn(String.format("Unable to create KeyManagers from file %s", new Object[] { storePath.getAbsolutePath() }), e);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.FileStoreTlsKeyManagersProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */