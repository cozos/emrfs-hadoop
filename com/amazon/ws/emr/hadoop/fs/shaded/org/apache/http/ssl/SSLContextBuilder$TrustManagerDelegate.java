package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class SSLContextBuilder$TrustManagerDelegate
  implements X509TrustManager
{
  private final X509TrustManager trustManager;
  private final TrustStrategy trustStrategy;
  
  SSLContextBuilder$TrustManagerDelegate(X509TrustManager trustManager, TrustStrategy trustStrategy)
  {
    this.trustManager = trustManager;
    this.trustStrategy = trustStrategy;
  }
  
  public void checkClientTrusted(X509Certificate[] chain, String authType)
    throws CertificateException
  {
    trustManager.checkClientTrusted(chain, authType);
  }
  
  public void checkServerTrusted(X509Certificate[] chain, String authType)
    throws CertificateException
  {
    if (!trustStrategy.isTrusted(chain, authType)) {
      trustManager.checkServerTrusted(chain, authType);
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return trustManager.getAcceptedIssuers();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl.SSLContextBuilder.TrustManagerDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */