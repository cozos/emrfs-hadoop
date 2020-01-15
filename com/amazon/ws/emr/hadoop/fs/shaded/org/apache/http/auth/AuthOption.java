package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public final class AuthOption
{
  private final AuthScheme authScheme;
  private final Credentials creds;
  
  public AuthOption(AuthScheme authScheme, Credentials creds)
  {
    Args.notNull(authScheme, "Auth scheme");
    Args.notNull(creds, "User credentials");
    this.authScheme = authScheme;
    this.creds = creds;
  }
  
  public AuthScheme getAuthScheme()
  {
    return authScheme;
  }
  
  public Credentials getCredentials()
  {
    return creds;
  }
  
  public String toString()
  {
    return authScheme.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthOption
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */