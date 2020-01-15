package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.logging.Level;
import java.util.logging.Logger;

class AbstractExecutionThreadService$1$2
  implements Runnable
{
  AbstractExecutionThreadService$1$2(AbstractExecutionThreadService.1 param1) {}
  
  public void run()
  {
    try
    {
      this$1.this$0.startUp();
      this$1.notifyStarted();
      if (this$1.isRunning()) {
        try
        {
          this$1.this$0.run();
        }
        catch (Throwable t)
        {
          try
          {
            this$1.this$0.shutDown();
          }
          catch (Exception ignored)
          {
            AbstractExecutionThreadService.access$000().log(Level.WARNING, "Error while attempting to shut down the service after failure.", ignored);
          }
          throw t;
        }
      }
      this$1.this$0.shutDown();
      this$1.notifyStopped();
    }
    catch (Throwable t)
    {
      this$1.notifyFailed(t);
      throw Throwables.propagate(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractExecutionThreadService.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */