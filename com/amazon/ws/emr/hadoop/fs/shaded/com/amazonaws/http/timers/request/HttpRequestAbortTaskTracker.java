package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract interface HttpRequestAbortTaskTracker
{
  public abstract boolean httpRequestAborted();
  
  public abstract boolean isEnabled();
  
  public abstract void cancelTask();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request.HttpRequestAbortTaskTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */