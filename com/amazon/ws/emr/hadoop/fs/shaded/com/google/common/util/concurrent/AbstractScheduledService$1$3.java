package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.locks.ReentrantLock;

class AbstractScheduledService$1$3
  implements Runnable
{
  AbstractScheduledService$1$3(AbstractScheduledService.1 param1) {}
  
  public void run()
  {
    AbstractScheduledService.1.access$100(this$1).lock();
    try
    {
      this$1.this$0.startUp();
      AbstractScheduledService.1.access$302(this$1, this$1.this$0.scheduler().schedule(AbstractScheduledService.access$400(this$1.this$0), AbstractScheduledService.1.access$500(this$1), AbstractScheduledService.1.access$600(this$1)));
      this$1.notifyStarted();
    }
    catch (Throwable t)
    {
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractScheduledService.1.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */