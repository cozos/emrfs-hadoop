package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class AbstractScheduledService
  implements Service
{
  private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
  protected abstract void runOneIteration()
    throws Exception;
  
  protected void startUp()
    throws Exception
  {}
  
  protected void shutDown()
    throws Exception
  {}
  
  protected abstract Scheduler scheduler();
  
  public static abstract class Scheduler
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
  
  private final AbstractService delegate = new AbstractService()
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
          runOneIteration();
        }
        catch (Throwable t)
        {
          try
          {
            shutDown();
          }
          catch (Exception ignored)
          {
            AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", ignored);
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
    
    protected final void doStart()
    {
      executorService = MoreExecutors.renamingDecorator(executor(), new Supplier()
      {
        public String get()
        {
          String str1 = String.valueOf(String.valueOf(serviceName()));String str2 = String.valueOf(String.valueOf(state()));return 1 + str1.length() + str2.length() + str1 + " " + str2;
        }
      });
      executorService.execute(new Runnable()
      {
        public void run()
        {
          lock.lock();
          try
          {
            startUp();
            runningTask = scheduler().schedule(delegate, executorService, task);
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
              shutDown();
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
  };
  
  protected ScheduledExecutorService executor()
  {
    final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory()
    {
      public Thread newThread(Runnable runnable)
      {
        return MoreExecutors.newThread(serviceName(), runnable);
      }
    });
    addListener(new Service.Listener()
    {
      public void terminated(Service.State from)
      {
        executor.shutdown();
      }
      
      public void failed(Service.State from, Throwable failure)
      {
        executor.shutdown();
      }
    }, MoreExecutors.directExecutor());
    
    return executor;
  }
  
  protected String serviceName()
  {
    return getClass().getSimpleName();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(serviceName()));String str2 = String.valueOf(String.valueOf(state()));return 3 + str1.length() + str2.length() + str1 + " [" + str2 + "]";
  }
  
  public final boolean isRunning()
  {
    return delegate.isRunning();
  }
  
  public final Service.State state()
  {
    return delegate.state();
  }
  
  public final void addListener(Service.Listener listener, Executor executor)
  {
    delegate.addListener(listener, executor);
  }
  
  public final Throwable failureCause()
  {
    return delegate.failureCause();
  }
  
  public final Service startAsync()
  {
    delegate.startAsync();
    return this;
  }
  
  public final Service stopAsync()
  {
    delegate.stopAsync();
    return this;
  }
  
  public final void awaitRunning()
  {
    delegate.awaitRunning();
  }
  
  public final void awaitRunning(long timeout, TimeUnit unit)
    throws TimeoutException
  {
    delegate.awaitRunning(timeout, unit);
  }
  
  public final void awaitTerminated()
  {
    delegate.awaitTerminated();
  }
  
  public final void awaitTerminated(long timeout, TimeUnit unit)
    throws TimeoutException
  {
    delegate.awaitTerminated(timeout, unit);
  }
  
  @Beta
  public static abstract class CustomScheduler
    extends AbstractScheduledService.Scheduler
  {
    public CustomScheduler()
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */