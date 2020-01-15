package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

public class SPNegoScheme
  extends GGSSchemeBase
{
  private static final String SPNEGO_OID = "1.3.6.1.5.5.2";
  
  public SPNegoScheme(boolean stripPort, boolean useCanonicalHostname)
  {
    super(stripPort, useCanonicalHostname);
  }
  
  public SPNegoScheme(boolean stripPort)
  {
    super(stripPort);
  }
  
  public SPNegoScheme() {}
  
  public String getSchemeName()
  {
    return "Negotiate";
  }
  
  public Header authenticate(Credentials credentials, HttpRequest request, HttpContext context)
    throws AuthenticationException
  {
    return super.authenticate(credentials, request, context);
  }
  
  protected byte[] generateToken(byte[] input, String authServer)
    throws GSSException
  {
    return super.generateToken(input, authServer);
  }
  
  protected byte[] generateToken(byte[] input, String authServer, Credentials credentials)
    throws GSSException
  {
    return generateGSSToken(input, new Oid("1.3.6.1.5.5.2"), authServer, credentials);
  }
  
  public String getParameter(String name)
  {
    Args.notNull(name, "Parameter name");
    return null;
  }
  
  public String getRealm()
  {
    return null;
  }
  
  public boolean isConnectionBased()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.SPNegoScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */