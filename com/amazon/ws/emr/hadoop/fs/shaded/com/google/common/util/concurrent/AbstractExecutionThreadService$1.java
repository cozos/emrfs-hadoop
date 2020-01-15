package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

class AbstractExecutionThreadService$1
  extends AbstractService
{
  AbstractExecutionThreadService$1(AbstractExecutionThreadService paramAbstractExecutionThreadService) {}
  
  protected final void doStart()
  {
    Executor executor = MoreExecutors.renamingDecorator(this$0.executor(), new Supplier()
    {
      public String get()
      {
        return this$0.serviceName();
      }
    });
    executor.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          this$0.startUp();
          notifyStarted();
          if (isRunning()) {
            try
            {
              this$0.run();
            }
            catch (Throwable t)
            {
              try
              {
                this$0.shutDown();
              }
              catch (Exception ignored)
              {
                AbstractExecutionThreadService.access$000().log(Level.WARNING, "Error while attempting to shut down the service after failure.", ignored);
              }
              throw t;
            }
          }
          this$0.shutDown();
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
    this$0.triggerShutdown();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractExecutionThreadService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */