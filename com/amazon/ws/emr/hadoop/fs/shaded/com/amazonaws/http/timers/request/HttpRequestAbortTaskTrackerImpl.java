package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.concurrent.ScheduledFuture;

@SdkInternalApi
public class HttpRequestAbortTaskTrackerImpl
  implements HttpRequestAbortTaskTracker
{
  private final HttpRequestAbortTask task;
  private final ScheduledFuture<?> future;
  
  public HttpRequestAbortTaskTrackerImpl(HttpRequestAbortTask task, ScheduledFuture<?> future)
  {
    this.task = ((HttpRequestAbortTask)ValidationUtils.assertNotNull(task, "task"));
    this.future = ((ScheduledFuture)ValidationUtils.assertNotNull(future, "future"));
  }
  
  public boolean httpRequestAborted()
  {
    return task.httpRequestAborted();
  }
  
  public boolean isEnabled()
  {
    return task.isEnabled();
  }
  
  public void cancelTask()
  {
    future.cancel(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request.HttpRequestAbortTaskTrackerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */