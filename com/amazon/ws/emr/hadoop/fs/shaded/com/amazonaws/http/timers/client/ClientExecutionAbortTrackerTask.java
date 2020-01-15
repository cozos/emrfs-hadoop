package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;

@SdkInternalApi
public abstract interface ClientExecutionAbortTrackerTask
{
  public abstract void setCurrentHttpRequest(HttpRequestBase paramHttpRequestBase);
  
  public abstract boolean hasTimeoutExpired();
  
  public abstract boolean isEnabled();
  
  public abstract void cancelTask();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionAbortTrackerTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */