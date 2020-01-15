package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public abstract interface TrustStrategy
{
  public abstract boolean isTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl.TrustStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */