package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class UsernamePasswordCredentials
  implements Credentials, Serializable
{
  private static final long serialVersionUID = 243343858802739403L;
  private final BasicUserPrincipal principal;
  private final String password;
  
  @Deprecated
  public UsernamePasswordCredentials(String usernamePassword)
  {
    Args.notNull(usernamePassword, "Username:password string");
    int atColon = usernamePassword.indexOf(':');
    if (atColon >= 0)
    {
      principal = new BasicUserPrincipal(usernamePassword.substring(0, atColon));
      password = usernamePassword.substring(atColon + 1);
    }
    else
    {
      principal = new BasicUserPrincipal(usernamePassword);
      password = null;
    }
  }
  
  public UsernamePasswordCredentials(String userName, String password)
  {
    Args.notNull(userName, "Username");
    principal = new BasicUserPrincipal(userName);
    this.password = password;
  }
  
  public Principal getUserPrincipal()
  {
    return principal;
  }
  
  public String getUserName()
  {
    return principal.getName();
  }
  
  public String getPassword()
  {
    return password;
  }
  
  public int hashCode()
  {
    return principal.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o instanceof UsernamePasswordCredentials))
    {
      UsernamePasswordCredentials that = (UsernamePasswordCredentials)o;
      if (LangUtils.equals(principal, principal)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return principal.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.UsernamePasswordCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */