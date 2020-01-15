package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

final class Futures$WrappedCombiner<T>
  implements Callable<T>
{
  final Callable<T> delegate;
  Futures.CombinerFuture<T> outputFuture;
  
  Futures$WrappedCombiner(Callable<T> delegate)
  {
    this.delegate = ((Callable)Preconditions.checkNotNull(delegate));
  }
  
  public T call()
    throws Exception
  {
    try
    {
      return (T)delegate.call();
    }
    catch (ExecutionException e)
    {
      outputFuture.setException(e.getCause());
    }
    catch (CancellationException e)
    {
      outputFuture.cancel(false);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.WrappedCombiner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */