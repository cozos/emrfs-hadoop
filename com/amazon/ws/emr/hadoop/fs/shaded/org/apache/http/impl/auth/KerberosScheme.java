package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

public class KerberosScheme
  extends GGSSchemeBase
{
  private static final String KERBEROS_OID = "1.2.840.113554.1.2.2";
  
  public KerberosScheme(boolean stripPort, boolean useCanonicalHostname)
  {
    super(stripPort, useCanonicalHostname);
  }
  
  public KerberosScheme(boolean stripPort)
  {
    super(stripPort);
  }
  
  public KerberosScheme() {}
  
  public String getSchemeName()
  {
    return "Kerberos";
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
    return generateGSSToken(input, new Oid("1.2.840.113554.1.2.2"), authServer, credentials);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.KerberosScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */