package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

public class CircularRedirectException
  extends RedirectException
{
  private static final long serialVersionUID = 6830063487001091803L;
  
  public CircularRedirectException() {}
  
  public CircularRedirectException(String message)
  {
    super(message);
  }
  
  public CircularRedirectException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CircularRedirectException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */