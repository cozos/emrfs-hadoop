package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

public class InvalidCredentialsException
  extends AuthenticationException
{
  private static final long serialVersionUID = -4834003835215460648L;
  
  public InvalidCredentialsException() {}
  
  public InvalidCredentialsException(String message)
  {
    super(message);
  }
  
  public InvalidCredentialsException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.InvalidCredentialsException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */