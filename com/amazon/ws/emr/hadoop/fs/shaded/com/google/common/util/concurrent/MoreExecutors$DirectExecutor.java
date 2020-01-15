package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Executor;

 enum MoreExecutors$DirectExecutor
  implements Executor
{
  INSTANCE;
  
  private MoreExecutors$DirectExecutor() {}
  
  public void execute(Runnable command)
  {
    command.run();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.DirectExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */