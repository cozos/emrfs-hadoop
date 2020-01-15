package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class ConcurrentUtils$ConstantFuture<T>
  implements Future<T>
{
  private final T value;
  
  ConcurrentUtils$ConstantFuture(T value)
  {
    this.value = value;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  public T get()
  {
    return (T)value;
  }
  
  public T get(long timeout, TimeUnit unit)
  {
    return (T)value;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.ConcurrentUtils.ConstantFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */