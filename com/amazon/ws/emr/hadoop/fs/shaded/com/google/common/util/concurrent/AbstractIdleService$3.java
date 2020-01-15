package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.concurrent.Executor;

class AbstractIdleService$3
  implements Executor
{
  AbstractIdleService$3(AbstractIdleService paramAbstractIdleService) {}
  
  public void execute(Runnable command)
  {
    MoreExecutors.newThread((String)AbstractIdleService.access$000(this$0).get(), command).start();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractIdleService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */