package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request;

public class NoOpHttpRequestAbortTaskTracker
  implements HttpRequestAbortTaskTracker
{
  public static final NoOpHttpRequestAbortTaskTracker INSTANCE = new NoOpHttpRequestAbortTaskTracker();
  
  public boolean httpRequestAborted()
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request.NoOpHttpRequestAbortTaskTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */