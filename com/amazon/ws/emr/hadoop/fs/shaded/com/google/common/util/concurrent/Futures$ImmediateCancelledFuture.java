package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;

class Futures$ImmediateCancelledFuture<V>
  extends Futures.ImmediateFuture<V>
{
  private final CancellationException thrown;
  
  Futures$ImmediateCancelledFuture()
  {
    super(null);
    thrown = new CancellationException("Immediate cancelled future.");
  }
  
  public boolean isCancelled()
  {
    return true;
  }
  
  public V get()
  {
    throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", thrown);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.ImmediateCancelledFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */