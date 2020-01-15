package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;

@SdkInternalApi
public abstract interface ClientExecutionAbortTask
  extends Runnable
{
  public abstract void setCurrentHttpRequest(HttpRequestBase paramHttpRequestBase);
  
  public abstract boolean hasClientExecutionAborted();
  
  public abstract boolean isEnabled();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionAbortTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */