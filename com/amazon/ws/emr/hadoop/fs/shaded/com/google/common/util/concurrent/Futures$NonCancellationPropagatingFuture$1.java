package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class Futures$NonCancellationPropagatingFuture$1
  implements FutureCallback<V>
{
  Futures$NonCancellationPropagatingFuture$1(Futures.NonCancellationPropagatingFuture paramNonCancellationPropagatingFuture, ListenableFuture paramListenableFuture) {}
  
  public void onSuccess(V result)
  {
    this$0.set(result);
  }
  
  public void onFailure(Throwable t)
  {
    if (val$delegate.isCancelled()) {
      this$0.cancel(false);
    } else {
      this$0.setException(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.NonCancellationPropagatingFuture.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */