package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class TrustAllStrategy
  implements TrustStrategy
{
  public static final TrustAllStrategy INSTANCE = new TrustAllStrategy();
  
  public boolean isTrusted(X509Certificate[] chain, String authType)
    throws CertificateException
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.TrustAllStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */