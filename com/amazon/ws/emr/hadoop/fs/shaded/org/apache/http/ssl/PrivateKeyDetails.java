package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public final class PrivateKeyDetails
{
  private final String type;
  private final X509Certificate[] certChain;
  
  public PrivateKeyDetails(String type, X509Certificate[] certChain)
  {
    this.type = ((String)Args.notNull(type, "Private key type"));
    this.certChain = certChain;
  }
  
  public String getType()
  {
    return type;
  }
  
  public X509Certificate[] getCertChain()
  {
    return certChain;
  }
  
  public String toString()
  {
    return type + ':' + Arrays.toString(certChain);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl.PrivateKeyDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */