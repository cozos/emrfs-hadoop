package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;

final class Futures$6
  implements Runnable
{
  Futures$6(ListenableFuture paramListenableFuture, FutureCallback paramFutureCallback) {}
  
  public void run()
  {
    V value;
    try
    {
      value = Uninterruptibles.getUninterruptibly(val$future);
    }
    catch (ExecutionException e)
    {
      val$callback.onFailure(e.getCause());
      return;
    }
    catch (RuntimeException e)
    {
      val$callback.onFailure(e);
      return;
    }
    catch (Error e)
    {
      val$callback.onFailure(e);
      return;
    }
    val$callback.onSuccess(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */