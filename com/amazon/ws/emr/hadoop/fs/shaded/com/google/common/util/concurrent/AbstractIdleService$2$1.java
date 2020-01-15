package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;

class AbstractIdleService$2$1
  implements Runnable
{
  AbstractIdleService$2$1(AbstractIdleService.2 param2) {}
  
  public void run()
  {
    try
    {
      this$1.this$0.startUp();
      this$1.notifyStarted();
    }
    catch (Throwable t)
    {
      this$1.notifyFailed(t);
      throw Throwables.propagate(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractIdleService.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */