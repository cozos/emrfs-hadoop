package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class NoopHostnameVerifier
  implements HostnameVerifier
{
  public static final NoopHostnameVerifier INSTANCE = new NoopHostnameVerifier();
  
  public boolean verify(String s, SSLSession sslSession)
  {
    return true;
  }
  
  public final String toString()
  {
    return "NO_OP";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.NoopHostnameVerifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */