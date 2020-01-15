package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLInitializationException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;

public class SdkSSLContext
{
  public static final SSLContext getPreferredSSLContext(SecureRandom secureRandom)
  {
    return getPreferredSSLContext(null, secureRandom);
  }
  
  public static final SSLContext getPreferredSSLContext(KeyManager[] keyManagers, SecureRandom secureRandom)
  {
    try
    {
      SSLContext sslcontext = SSLContext.getInstance("TLS");
      
      sslcontext.init(keyManagers, null, secureRandom);
      return sslcontext;
    }
    catch (NoSuchAlgorithmException ex)
    {
      throw new SSLInitializationException(ex.getMessage(), ex);
    }
    catch (KeyManagementException ex)
    {
      throw new SSLInitializationException(ex.getMessage(), ex);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSSLContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */