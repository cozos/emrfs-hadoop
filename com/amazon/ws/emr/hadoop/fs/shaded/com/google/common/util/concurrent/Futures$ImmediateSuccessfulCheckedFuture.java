package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class Futures$ImmediateSuccessfulCheckedFuture<V, X extends Exception>
  extends Futures.ImmediateFuture<V>
  implements CheckedFuture<V, X>
{
  @Nullable
  private final V value;
  
  Futures$ImmediateSuccessfulCheckedFuture(@Nullable V value)
  {
    super(null);
    this.value = value;
  }
  
  public V get()
  {
    return (V)value;
  }
  
  public V checkedGet()
  {
    return (V)value;
  }
  
  public V checkedGet(long timeout, TimeUnit unit)
  {
    Preconditions.checkNotNull(unit);
    return (V)value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.ImmediateSuccessfulCheckedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */