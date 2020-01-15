package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class AllowAllHostnameVerifier
  extends AbstractVerifier
{
  public static final AllowAllHostnameVerifier INSTANCE = new AllowAllHostnameVerifier();
  
  public final void verify(String host, String[] cns, String[] subjectAlts) {}
  
  public final String toString()
  {
    return "ALLOW_ALL";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.AllowAllHostnameVerifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */