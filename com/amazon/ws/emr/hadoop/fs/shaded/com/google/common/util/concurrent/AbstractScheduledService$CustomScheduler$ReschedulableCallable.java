package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

class AbstractScheduledService$CustomScheduler$ReschedulableCallable
  extends ForwardingFuture<Void>
  implements Callable<Void>
{
  private final Runnable wrappedRunnable;
  private final ScheduledExecutorService executor;
  private final AbstractService service;
  private final ReentrantLock lock = new ReentrantLock();
  @GuardedBy("lock")
  private Future<Void> currentFuture;
  
  AbstractScheduledService$CustomScheduler$ReschedulableCallable(AbstractScheduledService.CustomScheduler paramCustomScheduler, AbstractService service, ScheduledExecutorService executor, Runnable runnable)
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
        AbstractScheduledService.CustomScheduler.Schedule schedule = this$0.getNextSchedule();
        currentFuture = executor.schedule(this, AbstractScheduledService.CustomScheduler.Schedule.access$700(schedule), AbstractScheduledService.CustomScheduler.Schedule.access$800(schedule));
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.ReschedulableCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */