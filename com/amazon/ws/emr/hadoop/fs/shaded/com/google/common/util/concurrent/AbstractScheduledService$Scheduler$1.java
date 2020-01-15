package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class AbstractScheduledService$Scheduler$1
  extends AbstractScheduledService.Scheduler
{
  AbstractScheduledService$Scheduler$1(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    super(null);
  }
  
  public Future<?> schedule(AbstractService service, ScheduledExecutorService executor, Runnable task)
  {
    return executor.scheduleWithFixedDelay(task, val$initialDelay, val$delay, val$unit);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.Scheduler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */