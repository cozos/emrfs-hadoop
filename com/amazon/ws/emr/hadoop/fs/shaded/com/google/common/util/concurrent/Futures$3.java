package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class Futures$3
  implements Future<O>
{
  Futures$3(Future paramFuture, Function paramFunction) {}
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    return val$input.cancel(mayInterruptIfRunning);
  }
  
  public boolean isCancelled()
  {
    return val$input.isCancelled();
  }
  
  public boolean isDone()
  {
    return val$input.isDone();
  }
  
  public O get()
    throws InterruptedException, ExecutionException
  {
    return (O)applyTransformation(val$input.get());
  }
  
  public O get(long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (O)applyTransformation(val$input.get(timeout, unit));
  }
  
  private O applyTransformation(I input)
    throws ExecutionException
  {
    try
    {
      return (O)val$function.apply(input);
    }
    catch (Throwable t)
    {
      throw new ExecutionException(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */