package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class Futures$FallbackFuture$1
  implements FutureCallback<V>
{
  Futures$FallbackFuture$1(Futures.FallbackFuture paramFallbackFuture, FutureFallback paramFutureFallback) {}
  
  public void onSuccess(V value)
  {
    this$0.set(value);
  }
  
  public void onFailure(Throwable t)
  {
    if (this$0.isCancelled()) {
      return;
    }
    try
    {
      Futures.FallbackFuture.access$102(this$0, val$fallback.create(t));
      if (this$0.isCancelled())
      {
        Futures.FallbackFuture.access$100(this$0).cancel(this$0.wasInterrupted());
        return;
      }
      Futures.addCallback(Futures.FallbackFuture.access$100(this$0), new FutureCallback()
      {
        public void onSuccess(V value)
        {
          this$0.set(value);
        }
        
        public void onFailure(Throwable t)
        {
          if (Futures.FallbackFuture.access$100(this$0).isCancelled()) {
            this$0.cancel(false);
          } else {
            this$0.setException(t);
          }
        }
      }, MoreExecutors.directExecutor());
    }
    catch (Throwable e)
    {
      this$0.setException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.FallbackFuture.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */