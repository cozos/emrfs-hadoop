package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class ClientExecutionTimeoutException
  extends SdkClientException
{
  private static final long serialVersionUID = 4861767589924758934L;
  
  public ClientExecutionTimeoutException()
  {
    this("Client execution did not complete before the specified timeout configuration.");
  }
  
  public ClientExecutionTimeoutException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionTimeoutException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */