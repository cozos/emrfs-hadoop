package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class SSLContexts
{
  public static SSLContext createDefault()
    throws SSLInitializationException
  {
    try
    {
      SSLContext sslcontext = SSLContext.getInstance("TLS");
      sslcontext.init(null, null, null);
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
  
  public static SSLContext createSystemDefault()
    throws SSLInitializationException
  {
    try
    {
      return SSLContext.getDefault();
    }
    catch (NoSuchAlgorithmException ex) {}
    return createDefault();
  }
  
  public static SSLContextBuilder custom()
  {
    return new SSLContextBuilder();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLContexts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */