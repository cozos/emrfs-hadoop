package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

@Deprecated
public abstract interface X509HostnameVerifier
  extends HostnameVerifier
{
  public abstract void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException;
  
  public abstract void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException;
  
  public abstract void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.X509HostnameVerifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */