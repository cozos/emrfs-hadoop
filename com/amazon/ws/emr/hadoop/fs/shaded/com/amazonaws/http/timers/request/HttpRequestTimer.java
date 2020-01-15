package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.TimeoutThreadPoolBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ThreadSafe
@SdkInternalApi
public class HttpRequestTimer
{
  private static final String threadNamePrefix = "AwsSdkRequestTimerThread";
  private volatile ScheduledThreadPoolExecutor executor;
  
  public HttpRequestAbortTaskTracker startTimer(HttpRequestBase apacheRequest, int requestTimeoutMillis)
  {
    if (isTimeoutDisabled(requestTimeoutMillis)) {
      return NoOpHttpRequestAbortTaskTracker.INSTANCE;
    }
    if (executor == null) {
      initializeExecutor();
    }
    HttpRequestAbortTaskImpl timerTask = new HttpRequestAbortTaskImpl(apacheRequest);
    ScheduledFuture<?> timerTaskFuture = executor.schedule(timerTask, requestTimeoutMillis, TimeUnit.MILLISECONDS);
    return new HttpRequestAbortTaskTrackerImpl(timerTask, timerTaskFuture);
  }
  
  private boolean isTimeoutDisabled(int requestTimeoutMillis)
  {
    return requestTimeoutMillis <= 0;
  }
  
  private synchronized void initializeExecutor()
  {
    if (executor == null) {
      executor = TimeoutThreadPoolBuilder.buildDefaultTimeoutThreadPool("AwsSdkRequestTimerThread");
    }
  }
  
  public synchronized void shutdown()
  {
    if (executor != null) {
      executor.shutdown();
    }
  }
  
  @SdkTestInternalApi
  public ScheduledThreadPoolExecutor getExecutor()
  {
    return executor;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request.HttpRequestTimer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */