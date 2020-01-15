package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class MoreExecutors$ScheduledListeningDecorator
  extends MoreExecutors.ListeningDecorator
  implements ListeningScheduledExecutorService
{
  final ScheduledExecutorService delegate;
  
  MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService delegate)
  {
    super(delegate);
    this.delegate = ((ScheduledExecutorService)Preconditions.checkNotNull(delegate));
  }
  
  public ListenableScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit)
  {
    ListenableFutureTask<Void> task = ListenableFutureTask.create(command, null);
    
    ScheduledFuture<?> scheduled = delegate.schedule(task, delay, unit);
    return new ListenableScheduledTask(task, scheduled);
  }
  
  public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit)
  {
    ListenableFutureTask<V> task = ListenableFutureTask.create(callable);
    ScheduledFuture<?> scheduled = delegate.schedule(task, delay, unit);
    return new ListenableScheduledTask(task, scheduled);
  }
  
  public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
  {
    NeverSuccessfulListenableFutureTask task = new NeverSuccessfulListenableFutureTask(command);
    
    ScheduledFuture<?> scheduled = delegate.scheduleAtFixedRate(task, initialDelay, period, unit);
    
    return new ListenableScheduledTask(task, scheduled);
  }
  
  public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
  {
    NeverSuccessfulListenableFutureTask task = new NeverSuccessfulListenableFutureTask(command);
    
    ScheduledFuture<?> scheduled = delegate.scheduleWithFixedDelay(task, initialDelay, delay, unit);
    
    return new ListenableScheduledTask(task, scheduled);
  }
  
  private static final class ListenableScheduledTask<V>
    extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V>
    implements ListenableScheduledFuture<V>
  {
    private final ScheduledFuture<?> scheduledDelegate;
    
    public ListenableScheduledTask(ListenableFuture<V> listenableDelegate, ScheduledFuture<?> scheduledDelegate)
    {
      super();
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
  
  private static final class NeverSuccessfulListenableFutureTask
    extends AbstractFuture<Void>
    implements Runnable
  {
    private final Runnable delegate;
    
    public NeverSuccessfulListenableFutureTask(Runnable delegate)
    {
      this.delegate = ((Runnable)Preconditions.checkNotNull(delegate));
    }
    
    public void run()
    {
      try
      {
        delegate.run();
      }
      catch (Throwable t)
      {
        setException(t);
        throw Throwables.propagate(t);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */