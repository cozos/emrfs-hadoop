package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;

@Deprecated
public class NegotiateSchemeFactory
  implements AuthSchemeFactory
{
  private final SpnegoTokenGenerator spengoGenerator;
  private final boolean stripPort;
  
  public NegotiateSchemeFactory(SpnegoTokenGenerator spengoGenerator, boolean stripPort)
  {
    this.spengoGenerator = spengoGenerator;
    this.stripPort = stripPort;
  }
  
  public NegotiateSchemeFactory(SpnegoTokenGenerator spengoGenerator)
  {
    this(spengoGenerator, false);
  }
  
  public NegotiateSchemeFactory()
  {
    this(null, false);
  }
  
  public AuthScheme newInstance(HttpParams params)
  {
    return new NegotiateScheme(spengoGenerator, stripPort);
  }
  
  public boolean isStripPort()
  {
    return stripPort;
  }
  
  public SpnegoTokenGenerator getSpengoGenerator()
  {
    return spengoGenerator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NegotiateSchemeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */