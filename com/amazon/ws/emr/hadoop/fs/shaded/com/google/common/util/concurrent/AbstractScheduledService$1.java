package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class AbstractScheduledService$1
  extends AbstractService
{
  private volatile Future<?> runningTask;
  private volatile ScheduledExecutorService executorService;
  private final ReentrantLock lock = new ReentrantLock();
  private final Runnable task = new Runnable()
  {
    public void run()
    {
      lock.lock();
      try
      {
        this$0.runOneIteration();
      }
      catch (Throwable t)
      {
        try
        {
          this$0.shutDown();
        }
        catch (Exception ignored)
        {
          AbstractScheduledService.access$200().log(Level.WARNING, "Error while attempting to shut down the service after failure.", ignored);
        }
        notifyFailed(t);
        throw Throwables.propagate(t);
      }
      finally
      {
        lock.unlock();
      }
    }
  };
  
  AbstractScheduledService$1(AbstractScheduledService paramAbstractScheduledService) {}
  
  protected final void doStart()
  {
    executorService = MoreExecutors.renamingDecorator(this$0.executor(), new Supplier()
    {
      public String get()
      {
        String str1 = String.valueOf(String.valueOf(this$0.serviceName()));String str2 = String.valueOf(String.valueOf(state()));return 1 + str1.length() + str2.length() + str1 + " " + str2;
      }
    });
    executorService.execute(new Runnable()
    {
      public void run()
      {
        lock.lock();
        try
        {
          this$0.startUp();
          runningTask = this$0.scheduler().schedule(AbstractScheduledService.access$400(this$0), executorService, task);
          notifyStarted();
        }
        catch (Throwable t)
        {
          notifyFailed(t);
          throw Throwables.propagate(t);
        }
        finally
        {
          lock.unlock();
        }
      }
    });
  }
  
  protected final void doStop()
  {
    runningTask.cancel(false);
    executorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          lock.lock();
          try
          {
            if (state() != Service.State.STOPPING) {
              return;
            }
            this$0.shutDown();
          }
          finally
          {
            lock.unlock();
          }
          notifyStopped();
        }
        catch (Throwable t)
        {
          notifyFailed(t);
          throw Throwables.propagate(t);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */