package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

final class AsyncSettableFuture$NestedFuture<V>
  extends AbstractFuture<ListenableFuture<? extends V>>
{
  boolean setFuture(ListenableFuture<? extends V> value)
  {
    boolean result = set(value);
    if (isCancelled()) {
      value.cancel(wasInterrupted());
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AsyncSettableFuture.NestedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */