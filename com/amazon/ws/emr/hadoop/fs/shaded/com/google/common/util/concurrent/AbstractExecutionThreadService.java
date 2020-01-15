package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public abstract class AbstractExecutionThreadService
  implements Service
{
  private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
  private final Service delegate = new AbstractService()
  {
    protected final void doStart()
    {
      Executor executor = MoreExecutors.renamingDecorator(executor(), new Supplier()
      {
        public String get()
        {
          return serviceName();
        }
      });
      executor.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            startUp();
            notifyStarted();
            if (isRunning()) {
              try
              {
                AbstractExecutionThreadService.this.run();
              }
              catch (Throwable t)
              {
                try
                {
                  shutDown();
                }
                catch (Exception ignored)
                {
                  AbstractExecutionThreadService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", ignored);
                }
                throw t;
              }
            }
            shutDown();
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
    
    protected void doStop()
    {
      triggerShutdown();
    }
  };
  
  protected void startUp()
    throws Exception
  {}
  
  protected abstract void run()
    throws Exception;
  
  protected void shutDown()
    throws Exception
  {}
  
  protected void triggerShutdown() {}
  
  protected Executor executor()
  {
    new Executor()
    {
      public void execute(Runnable command)
      {
        MoreExecutors.newThread(serviceName(), command).start();
      }
    };
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
  
  protected String serviceName()
  {
    return getClass().getSimpleName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractExecutionThreadService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */