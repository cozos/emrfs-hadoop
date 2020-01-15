package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;

public abstract interface AuthScheme
{
  public abstract void processChallenge(Header paramHeader)
    throws MalformedChallengeException;
  
  public abstract String getSchemeName();
  
  public abstract String getParameter(String paramString);
  
  public abstract String getRealm();
  
  public abstract boolean isConnectionBased();
  
  public abstract boolean isComplete();
  
  @Deprecated
  public abstract Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest)
    throws AuthenticationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */