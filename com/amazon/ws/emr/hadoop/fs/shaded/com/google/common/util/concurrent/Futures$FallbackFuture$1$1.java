package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class Futures$FallbackFuture$1$1
  implements FutureCallback<V>
{
  Futures$FallbackFuture$1$1(Futures.FallbackFuture.1 param1) {}
  
  public void onSuccess(V value)
  {
    this$1.this$0.set(value);
  }
  
  public void onFailure(Throwable t)
  {
    if (Futures.FallbackFuture.access$100(this$1.this$0).isCancelled()) {
      this$1.this$0.cancel(false);
    } else {
      this$1.this$0.setException(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.FallbackFuture.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */