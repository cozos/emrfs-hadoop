package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import javax.net.ssl.SSLException;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BrowserCompatHostnameVerifier
  extends AbstractVerifier
{
  public static final BrowserCompatHostnameVerifier INSTANCE = new BrowserCompatHostnameVerifier();
  
  public final void verify(String host, String[] cns, String[] subjectAlts)
    throws SSLException
  {
    verify(host, cns, subjectAlts, false);
  }
  
  public final String toString()
  {
    return "BROWSER_COMPATIBLE";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.BrowserCompatHostnameVerifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */