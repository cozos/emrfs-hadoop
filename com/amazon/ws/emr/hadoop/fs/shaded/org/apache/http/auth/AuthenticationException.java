package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;

public class AuthenticationException
  extends ProtocolException
{
  private static final long serialVersionUID = -6794031905674764776L;
  
  public AuthenticationException() {}
  
  public AuthenticationException(String message)
  {
    super(message);
  }
  
  public AuthenticationException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */