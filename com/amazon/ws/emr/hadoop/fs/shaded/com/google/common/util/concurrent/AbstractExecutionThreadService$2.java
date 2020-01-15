package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Executor;

class AbstractExecutionThreadService$2
  implements Executor
{
  AbstractExecutionThreadService$2(AbstractExecutionThreadService paramAbstractExecutionThreadService) {}
  
  public void execute(Runnable command)
  {
    MoreExecutors.newThread(this$0.serviceName(), command).start();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractExecutionThreadService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */