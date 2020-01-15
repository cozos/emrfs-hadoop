package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;

public class SdkInterruptedException
  extends InterruptedException
{
  private static final long serialVersionUID = 8194951388566545094L;
  private final transient Response<?> response;
  
  public SdkInterruptedException(Response<?> response)
  {
    this.response = response;
  }
  
  public Response<?> getResponse()
  {
    return response;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.SdkInterruptedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */