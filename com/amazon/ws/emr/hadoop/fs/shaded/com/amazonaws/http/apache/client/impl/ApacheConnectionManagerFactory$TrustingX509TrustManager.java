package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class ApacheConnectionManagerFactory$TrustingX509TrustManager
  implements X509TrustManager
{
  private static final X509Certificate[] X509_CERTIFICATES = new X509Certificate[0];
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return X509_CERTIFICATES;
  }
  
  public void checkServerTrusted(X509Certificate[] chain, String authType)
    throws CertificateException
  {}
  
  public void checkClientTrusted(X509Certificate[] chain, String authType)
    throws CertificateException
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.ApacheConnectionManagerFactory.TrustingX509TrustManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */