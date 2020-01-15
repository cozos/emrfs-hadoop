package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

@Beta
public final class AbstractScheduledService$CustomScheduler$Schedule
{
  private final long delay;
  private final TimeUnit unit;
  
  public AbstractScheduledService$CustomScheduler$Schedule(long delay, TimeUnit unit)
  {
    this.delay = delay;
    this.unit = ((TimeUnit)Preconditions.checkNotNull(unit));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */