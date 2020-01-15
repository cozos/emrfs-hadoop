package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class Futures$ImmediateFailedCheckedFuture<V, X extends Exception>
  extends Futures.ImmediateFuture<V>
  implements CheckedFuture<V, X>
{
  private final X thrown;
  
  Futures$ImmediateFailedCheckedFuture(X thrown)
  {
    super(null);
    this.thrown = thrown;
  }
  
  public V get()
    throws ExecutionException
  {
    throw new ExecutionException(thrown);
  }
  
  public V checkedGet()
    throws Exception
  {
    throw thrown;
  }
  
  public V checkedGet(long timeout, TimeUnit unit)
    throws Exception
  {
    Preconditions.checkNotNull(unit);
    throw thrown;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.ImmediateFailedCheckedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */