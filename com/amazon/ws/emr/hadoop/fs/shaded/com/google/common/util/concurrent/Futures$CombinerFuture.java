package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.util.concurrent.Callable;

final class Futures$CombinerFuture<V>
  extends ListenableFutureTask<V>
{
  ImmutableList<ListenableFuture<?>> futures;
  
  Futures$CombinerFuture(Callable<V> callable, ImmutableList<ListenableFuture<?>> futures)
  {
    super(callable);
    this.futures = futures;
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    ImmutableList<ListenableFuture<?>> futures = this.futures;
    if (super.cancel(mayInterruptIfRunning))
    {
      for (ListenableFuture<?> future : futures) {
        future.cancel(mayInterruptIfRunning);
      }
      return true;
    }
    return false;
  }
  
  protected void done()
  {
    super.done();
    futures = null;
  }
  
  protected void setException(Throwable t)
  {
    super.setException(t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.CombinerFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */