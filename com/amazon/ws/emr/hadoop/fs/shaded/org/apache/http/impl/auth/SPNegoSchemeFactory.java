package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class SPNegoSchemeFactory
  implements AuthSchemeFactory, AuthSchemeProvider
{
  private final boolean stripPort;
  private final boolean useCanonicalHostname;
  
  public SPNegoSchemeFactory(boolean stripPort, boolean useCanonicalHostname)
  {
    this.stripPort = stripPort;
    this.useCanonicalHostname = useCanonicalHostname;
  }
  
  public SPNegoSchemeFactory(boolean stripPort)
  {
    this.stripPort = stripPort;
    useCanonicalHostname = true;
  }
  
  public SPNegoSchemeFactory()
  {
    this(true, true);
  }
  
  public boolean isStripPort()
  {
    return stripPort;
  }
  
  public boolean isUseCanonicalHostname()
  {
    return useCanonicalHostname;
  }
  
  public AuthScheme newInstance(HttpParams params)
  {
    return new SPNegoScheme(stripPort, useCanonicalHostname);
  }
  
  public AuthScheme create(HttpContext context)
  {
    return new SPNegoScheme(stripPort, useCanonicalHostname);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.SPNegoSchemeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */