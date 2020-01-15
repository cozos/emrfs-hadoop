package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.TimeoutThreadPoolBuilder;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SdkInternalApi
@ThreadSafe
public class ClientExecutionTimer
{
  private static final String threadNamePrefix = "AwsSdkClientExecutionTimerThread";
  private volatile ScheduledThreadPoolExecutor executor;
  
  public ClientExecutionAbortTrackerTask startTimer(int clientExecutionTimeoutMillis)
  {
    if (isTimeoutDisabled(clientExecutionTimeoutMillis)) {
      return NoOpClientExecutionAbortTrackerTask.INSTANCE;
    }
    if (executor == null) {
      initializeExecutor();
    }
    return scheduleTimerTask(clientExecutionTimeoutMillis);
  }
  
  private synchronized void initializeExecutor()
  {
    if (executor == null) {
      executor = TimeoutThreadPoolBuilder.buildDefaultTimeoutThreadPool("AwsSdkClientExecutionTimerThread");
    }
  }
  
  @SdkTestInternalApi
  public ScheduledThreadPoolExecutor getExecutor()
  {
    return executor;
  }
  
  public synchronized void shutdown()
  {
    if (executor != null) {
      executor.shutdown();
    }
  }
  
  private ClientExecutionAbortTrackerTask scheduleTimerTask(int clientExecutionTimeoutMillis)
  {
    ClientExecutionAbortTask timerTask = new ClientExecutionAbortTaskImpl(Thread.currentThread());
    ScheduledFuture<?> timerTaskFuture = executor.schedule(timerTask, clientExecutionTimeoutMillis, TimeUnit.MILLISECONDS);
    
    return new ClientExecutionAbortTrackerTaskImpl(timerTask, timerTaskFuture);
  }
  
  private boolean isTimeoutDisabled(int clientExecutionTimeoutMillis)
  {
    return clientExecutionTimeoutMillis <= 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionTimer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */