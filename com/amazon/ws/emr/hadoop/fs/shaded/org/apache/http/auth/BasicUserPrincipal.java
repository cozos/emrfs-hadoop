package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public final class BasicUserPrincipal
  implements Principal, Serializable
{
  private static final long serialVersionUID = -2266305184969850467L;
  private final String username;
  
  public BasicUserPrincipal(String username)
  {
    Args.notNull(username, "User name");
    this.username = username;
  }
  
  public String getName()
  {
    return username;
  }
  
  public int hashCode()
  {
    int hash = 17;
    hash = LangUtils.hashCode(hash, username);
    return hash;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o instanceof BasicUserPrincipal))
    {
      BasicUserPrincipal that = (BasicUserPrincipal)o;
      if (LangUtils.equals(username, username)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder buffer = new StringBuilder();
    buffer.append("[principal: ");
    buffer.append(username);
    buffer.append("]");
    return buffer.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.BasicUserPrincipal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */