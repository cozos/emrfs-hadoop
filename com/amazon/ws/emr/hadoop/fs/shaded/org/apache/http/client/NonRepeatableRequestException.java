package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;

public class NonRepeatableRequestException
  extends ProtocolException
{
  private static final long serialVersionUID = 82685265288806048L;
  
  public NonRepeatableRequestException() {}
  
  public NonRepeatableRequestException(String message)
  {
    super(message);
  }
  
  public NonRepeatableRequestException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.NonRepeatableRequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */