package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import java.security.Principal;

public abstract interface Credentials
{
  public abstract Principal getUserPrincipal();
  
  public abstract String getPassword();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */