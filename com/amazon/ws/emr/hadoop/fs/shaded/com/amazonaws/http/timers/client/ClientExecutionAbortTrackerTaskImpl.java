package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import java.util.concurrent.ScheduledFuture;

@SdkInternalApi
public class ClientExecutionAbortTrackerTaskImpl
  implements ClientExecutionAbortTrackerTask
{
  private final ClientExecutionAbortTask task;
  private final ScheduledFuture<?> future;
  
  public ClientExecutionAbortTrackerTaskImpl(ClientExecutionAbortTask task, ScheduledFuture<?> future)
  {
    this.task = ((ClientExecutionAbortTask)ValidationUtils.assertNotNull(task, "task"));
    this.future = ((ScheduledFuture)ValidationUtils.assertNotNull(future, "future"));
  }
  
  public void setCurrentHttpRequest(HttpRequestBase newRequest)
  {
    task.setCurrentHttpRequest(newRequest);
  }
  
  public boolean hasTimeoutExpired()
  {
    return task.hasClientExecutionAborted();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionAbortTrackerTaskImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */