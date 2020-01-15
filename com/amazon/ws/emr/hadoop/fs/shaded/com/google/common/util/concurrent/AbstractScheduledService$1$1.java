package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class AbstractScheduledService$1$1
  implements Runnable
{
  AbstractScheduledService$1$1(AbstractScheduledService.1 param1) {}
  
  public void run()
  {
    AbstractScheduledService.1.access$100(this$1).lock();
    try
    {
      this$1.this$0.runOneIteration();
    }
    catch (Throwable t)
    {
      try
      {
        this$1.this$0.shutDown();
      }
      catch (Exception ignored)
      {
        AbstractScheduledService.access$200().log(Level.WARNING, "Error while attempting to shut down the service after failure.", ignored);
      }
      this$1.notifyFailed(t);
      throw Throwables.propagate(t);
    }
    finally
    {
      AbstractScheduledService.1.access$100(this$1).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */