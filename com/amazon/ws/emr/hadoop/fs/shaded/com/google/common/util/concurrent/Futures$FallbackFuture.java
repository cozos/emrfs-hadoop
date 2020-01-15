package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Executor;

class Futures$FallbackFuture<V>
  extends AbstractFuture<V>
{
  private volatile ListenableFuture<? extends V> running;
  
  Futures$FallbackFuture(ListenableFuture<? extends V> input, final FutureFallback<? extends V> fallback, Executor executor)
  {
    running = input;
    Futures.addCallback(running, new FutureCallback()
    {
      public void onSuccess(V value)
      {
        set(value);
      }
      
      public void onFailure(Throwable t)
      {
        if (isCancelled()) {
          return;
        }
        try
        {
          running = fallback.create(t);
          if (isCancelled())
          {
            running.cancel(wasInterrupted());
            return;
          }
          Futures.addCallback(running, new FutureCallback()
          {
            public void onSuccess(V value)
            {
              set(value);
            }
            
            public void onFailure(Throwable t)
            {
              if (running.isCancelled()) {
                cancel(false);
              } else {
                setException(t);
              }
            }
          }, MoreExecutors.directExecutor());
        }
        catch (Throwable e)
        {
          setException(e);
        }
      }
    }, executor);
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    if (super.cancel(mayInterruptIfRunning))
    {
      running.cancel(mayInterruptIfRunning);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.FallbackFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */