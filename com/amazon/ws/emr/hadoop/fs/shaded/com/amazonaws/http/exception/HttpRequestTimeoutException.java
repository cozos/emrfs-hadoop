package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.exception;

import java.io.IOException;

public class HttpRequestTimeoutException
  extends IOException
{
  private static final long serialVersionUID = -2588353895012259837L;
  
  public HttpRequestTimeoutException(String message)
  {
    super(message);
  }
  
  public HttpRequestTimeoutException(Throwable throwable)
  {
    this("Request did not complete before the request timeout configuration.", throwable);
  }
  
  public HttpRequestTimeoutException(String message, Throwable throwable)
  {
    super(message, throwable);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.exception.HttpRequestTimeoutException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */