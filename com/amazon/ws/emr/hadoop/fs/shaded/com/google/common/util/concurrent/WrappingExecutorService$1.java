package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.concurrent.Callable;

class WrappingExecutorService$1
  implements Runnable
{
  WrappingExecutorService$1(WrappingExecutorService paramWrappingExecutorService, Callable paramCallable) {}
  
  public void run()
  {
    try
    {
      val$wrapped.call();
    }
    catch (Exception e)
    {
      Throwables.propagate(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.WrappingExecutorService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */