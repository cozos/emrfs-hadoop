package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;

public final class SystemPropertyTlsKeyManagersProvider
  extends AbstractFileTlsKeyManagersProvider
{
  private static final Log log = LogFactory.getLog(SystemPropertyTlsKeyManagersProvider.class);
  private static final String KEY_STORE_PROPERTY = "javax.net.ssl.keyStore";
  private static final String KEY_STORE_PASSWORD_PROPERTY = "javax.net.ssl.keyStorePassword";
  private static final String KEY_STORE_TYPE_PROPERTY = "javax.net.ssl.keyStoreType";
  
  public KeyManager[] getKeyManagers()
  {
    String keyStorePath = getKeyStore();
    if (keyStorePath == null) {
      return null;
    }
    String type = getKeyStoreType();
    String password = getKeyStorePassword();
    char[] passwordChars = null;
    if (password != null) {
      passwordChars = password.toCharArray();
    }
    try
    {
      return createKeyManagers(new File(keyStorePath), type, passwordChars);
    }
    catch (Exception e)
    {
      log.warn("Unable to load KeyManager from system properties", e);
    }
    return null;
  }
  
  private static String getKeyStore()
  {
    return System.getProperty("javax.net.ssl.keyStore");
  }
  
  private static String getKeyStoreType()
  {
    return System.getProperty("javax.net.ssl.keyStoreType", KeyStore.getDefaultType());
  }
  
  private static String getKeyStorePassword()
  {
    return System.getProperty("javax.net.ssl.keyStorePassword");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.SystemPropertyTlsKeyManagersProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */