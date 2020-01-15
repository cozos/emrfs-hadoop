package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;

@SdkInternalApi
public class ClientExecutionAbortTaskImpl
  implements ClientExecutionAbortTask
{
  private volatile boolean hasTaskExecuted;
  private HttpRequestBase currentHttpRequest;
  private final Thread thread;
  
  public ClientExecutionAbortTaskImpl(Thread thread)
  {
    this.thread = thread;
  }
  
  public void run()
  {
    hasTaskExecuted = true;
    if (!thread.isInterrupted()) {
      thread.interrupt();
    }
    if (!currentHttpRequest.isAborted()) {
      currentHttpRequest.abort();
    }
  }
  
  public void setCurrentHttpRequest(HttpRequestBase newRequest)
  {
    currentHttpRequest = newRequest;
  }
  
  public boolean hasClientExecutionAborted()
  {
    return hasTaskExecuted;
  }
  
  public boolean isEnabled()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionAbortTaskImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */