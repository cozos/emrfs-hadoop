package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class AbstractScheduledService$CustomScheduler
  extends AbstractScheduledService.Scheduler
{
  public AbstractScheduledService$CustomScheduler()
  {
    super(null);
  }
  
  private class ReschedulableCallable
    extends ForwardingFuture<Void>
    implements Callable<Void>
  {
    private final Runnable wrappedRunnable;
    private final ScheduledExecutorService executor;
    private final AbstractService service;
    private final ReentrantLock lock = new ReentrantLock();
    @GuardedBy("lock")
    private Future<Void> currentFuture;
    
    ReschedulableCallable(AbstractService service, ScheduledExecutorService executor, Runnable runnable)
    {
      wrappedRunnable = runnable;
      this.executor = executor;
      this.service = service;
    }
    
    public Void call()
      throws Exception
    {
      wrappedRunnable.run();
      reschedule();
      return null;
    }
    
    public void reschedule()
    {
      lock.lock();
      try
      {
        if ((currentFuture == null) || (!currentFuture.isCancelled()))
        {
          AbstractScheduledService.CustomScheduler.Schedule schedule = getNextSchedule();
          currentFuture = executor.schedule(this, delay, unit);
        }
      }
      catch (Throwable e)
      {
        service.notifyFailed(e);
      }
      finally
      {
        lock.unlock();
      }
    }
    
    public boolean cancel(boolean mayInterruptIfRunning)
    {
      lock.lock();
      try
      {
        return currentFuture.cancel(mayInterruptIfRunning);
      }
      finally
      {
        lock.unlock();
      }
    }
    
    protected Future<Void> delegate()
    {
      throw new UnsupportedOperationException("Only cancel is supported by this future");
    }
  }
  
  final Future<?> schedule(AbstractService service, ScheduledExecutorService executor, Runnable runnable)
  {
    ReschedulableCallable task = new ReschedulableCallable(service, executor, runnable);
    task.reschedule();
    return task;
  }
  
  protected abstract Schedule getNextSchedule()
    throws Exception;
  
  @Beta
  protected static final class Schedule
  {
    private final long delay;
    private final TimeUnit unit;
    
    public Schedule(long delay, TimeUnit unit)
    {
      this.delay = delay;
      this.unit = ((TimeUnit)Preconditions.checkNotNull(unit));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */