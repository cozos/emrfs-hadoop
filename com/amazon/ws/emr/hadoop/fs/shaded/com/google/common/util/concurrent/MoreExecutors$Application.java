package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
class MoreExecutors$Application
{
  final ExecutorService getExitingExecutorService(ThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit)
  {
    MoreExecutors.access$000(executor);
    ExecutorService service = Executors.unconfigurableExecutorService(executor);
    addDelayedShutdownHook(service, terminationTimeout, timeUnit);
    return service;
  }
  
  final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit)
  {
    MoreExecutors.access$000(executor);
    ScheduledExecutorService service = Executors.unconfigurableScheduledExecutorService(executor);
    addDelayedShutdownHook(service, terminationTimeout, timeUnit);
    return service;
  }
  
  final void addDelayedShutdownHook(final ExecutorService service, final long terminationTimeout, TimeUnit timeUnit)
  {
    Preconditions.checkNotNull(service);
    Preconditions.checkNotNull(timeUnit);
    String str = String.valueOf(String.valueOf(service));addShutdownHook(MoreExecutors.newThread(24 + str.length() + "DelayedShutdownHook-for-" + str, new Runnable()
    {
      public void run()
      {
        try
        {
          service.shutdown();
          service.awaitTermination(terminationTimeout, val$timeUnit);
        }
        catch (InterruptedException ignored) {}
      }
    }));
  }
  
  final ExecutorService getExitingExecutorService(ThreadPoolExecutor executor)
  {
    return getExitingExecutorService(executor, 120L, TimeUnit.SECONDS);
  }
  
  final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor)
  {
    return getExitingScheduledExecutorService(executor, 120L, TimeUnit.SECONDS);
  }
  
  @VisibleForTesting
  void addShutdownHook(Thread hook)
  {
    Runtime.getRuntime().addShutdownHook(hook);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.Application
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */