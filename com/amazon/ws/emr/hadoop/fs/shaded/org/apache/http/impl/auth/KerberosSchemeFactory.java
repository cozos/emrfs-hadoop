package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class KerberosSchemeFactory
  implements AuthSchemeFactory, AuthSchemeProvider
{
  private final boolean stripPort;
  private final boolean useCanonicalHostname;
  
  public KerberosSchemeFactory(boolean stripPort, boolean useCanonicalHostname)
  {
    this.stripPort = stripPort;
    this.useCanonicalHostname = useCanonicalHostname;
  }
  
  public KerberosSchemeFactory(boolean stripPort)
  {
    this.stripPort = stripPort;
    useCanonicalHostname = true;
  }
  
  public KerberosSchemeFactory()
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
    return new KerberosScheme(stripPort, useCanonicalHostname);
  }
  
  public AuthScheme create(HttpContext context)
  {
    return new KerberosScheme(stripPort, useCanonicalHostname);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.KerberosSchemeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */