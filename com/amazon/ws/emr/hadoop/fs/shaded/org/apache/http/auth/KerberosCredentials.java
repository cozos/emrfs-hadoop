package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.Serializable;
import java.security.Principal;
import org.ietf.jgss.GSSCredential;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class KerberosCredentials
  implements Credentials, Serializable
{
  private static final long serialVersionUID = 487421613855550713L;
  private final GSSCredential gssCredential;
  
  public KerberosCredentials(GSSCredential gssCredential)
  {
    this.gssCredential = gssCredential;
  }
  
  public GSSCredential getGSSCredential()
  {
    return gssCredential;
  }
  
  public Principal getUserPrincipal()
  {
    return null;
  }
  
  public String getPassword()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.KerberosCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */