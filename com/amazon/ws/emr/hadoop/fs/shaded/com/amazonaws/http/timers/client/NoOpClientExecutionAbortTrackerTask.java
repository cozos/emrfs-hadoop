package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;

public class NoOpClientExecutionAbortTrackerTask
  implements ClientExecutionAbortTrackerTask
{
  public static final NoOpClientExecutionAbortTrackerTask INSTANCE = new NoOpClientExecutionAbortTrackerTask();
  
  public void setCurrentHttpRequest(HttpRequestBase newRequest) {}
  
  public boolean hasTimeoutExpired()
  {
    return false;
  }
  
  public boolean isEnabled()
  {
    return false;
  }
  
  public void cancelTask() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.NoOpClientExecutionAbortTrackerTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */