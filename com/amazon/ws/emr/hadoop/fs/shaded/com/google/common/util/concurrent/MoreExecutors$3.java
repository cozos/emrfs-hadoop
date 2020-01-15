package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

final class MoreExecutors$3
  extends WrappingExecutorService
{
  MoreExecutors$3(ExecutorService x0, Supplier paramSupplier)
  {
    super(x0);
  }
  
  protected <T> Callable<T> wrapTask(Callable<T> callable)
  {
    return Callables.threadRenaming(callable, val$nameSupplier);
  }
  
  protected Runnable wrapTask(Runnable command)
  {
    return Callables.threadRenaming(command, val$nameSupplier);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */