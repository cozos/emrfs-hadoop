package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask<V>
  extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V>
  implements ListenableScheduledFuture<V>
{
  private final ScheduledFuture<?> scheduledDelegate;
  
  public MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(ListenableFuture<V> listenableDelegate, ScheduledFuture<?> scheduledDelegate)
  {
    super(listenableDelegate);
    this.scheduledDelegate = scheduledDelegate;
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    boolean cancelled = super.cancel(mayInterruptIfRunning);
    if (cancelled) {
      scheduledDelegate.cancel(mayInterruptIfRunning);
    }
    return cancelled;
  }
  
  public long getDelay(TimeUnit unit)
  {
    return scheduledDelegate.getDelay(unit);
  }
  
  public int compareTo(Delayed other)
  {
    return scheduledDelegate.compareTo(other);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.ListenableScheduledTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */