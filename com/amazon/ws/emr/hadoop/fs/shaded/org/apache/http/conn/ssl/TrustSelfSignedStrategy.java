package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class TrustSelfSignedStrategy
  implements TrustStrategy
{
  public static final TrustSelfSignedStrategy INSTANCE = new TrustSelfSignedStrategy();
  
  public boolean isTrusted(X509Certificate[] chain, String authType)
    throws CertificateException
  {
    return chain.length == 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.TrustSelfSignedStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */