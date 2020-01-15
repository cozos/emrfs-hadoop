package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class Futures$NonCancellationPropagatingFuture<V>
  extends AbstractFuture<V>
{
  Futures$NonCancellationPropagatingFuture(final ListenableFuture<V> delegate)
  {
    Preconditions.checkNotNull(delegate);
    Futures.addCallback(delegate, new FutureCallback()
    {
      public void onSuccess(V result)
      {
        set(result);
      }
      
      public void onFailure(Throwable t)
      {
        if (delegate.isCancelled()) {
          cancel(false);
        } else {
          setException(t);
        }
      }
    }, MoreExecutors.directExecutor());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.NonCancellationPropagatingFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */