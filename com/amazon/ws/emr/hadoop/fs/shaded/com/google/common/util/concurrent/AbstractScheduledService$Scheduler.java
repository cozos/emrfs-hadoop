package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractScheduledService$Scheduler
{
  public static Scheduler newFixedDelaySchedule(long initialDelay, long delay, final TimeUnit unit)
  {
    new Scheduler(initialDelay)
    {
      public Future<?> schedule(AbstractService service, ScheduledExecutorService executor, Runnable task)
      {
        return executor.scheduleWithFixedDelay(task, val$initialDelay, unit, val$unit);
      }
    };
  }
  
  public static Scheduler newFixedRateSchedule(long initialDelay, long period, final TimeUnit unit)
  {
    new Scheduler(initialDelay)
    {
      public Future<?> schedule(AbstractService service, ScheduledExecutorService executor, Runnable task)
      {
        return executor.scheduleAtFixedRate(task, val$initialDelay, unit, val$unit);
      }
    };
  }
  
  abstract Future<?> schedule(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.Scheduler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */