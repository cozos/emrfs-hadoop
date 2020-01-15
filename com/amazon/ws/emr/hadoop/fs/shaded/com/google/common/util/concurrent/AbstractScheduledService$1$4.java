package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.locks.ReentrantLock;

class AbstractScheduledService$1$4
  implements Runnable
{
  AbstractScheduledService$1$4(AbstractScheduledService.1 param1) {}
  
  public void run()
  {
    try
    {
      AbstractScheduledService.1.access$100(this$1).lock();
      try
      {
        if (this$1.state() != Service.State.STOPPING) {
          return;
        }
        this$1.this$0.shutDown();
      }
      finally
      {
        AbstractScheduledService.1.access$100(this$1).unlock();
      }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.1.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */