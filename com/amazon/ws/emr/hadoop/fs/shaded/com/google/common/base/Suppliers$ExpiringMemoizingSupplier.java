package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
class Suppliers$ExpiringMemoizingSupplier<T>
  implements Supplier<T>, Serializable
{
  final Supplier<T> delegate;
  final long durationNanos;
  volatile transient T value;
  volatile transient long expirationNanos;
  private static final long serialVersionUID = 0L;
  
  Suppliers$ExpiringMemoizingSupplier(Supplier<T> delegate, long duration, TimeUnit unit)
  {
    this.delegate = ((Supplier)Preconditions.checkNotNull(delegate));
    durationNanos = unit.toNanos(duration);
    Preconditions.checkArgument(duration > 0L);
  }
  
  public T get()
  {
    long nanos = expirationNanos;
    long now = Platform.systemNanoTime();
    if ((nanos == 0L) || (now - nanos >= 0L)) {
      synchronized (this)
      {
        if (nanos == expirationNanos)
        {
          T t = delegate.get();
          value = t;
          nanos = now + durationNanos;
          
          expirationNanos = (nanos == 0L ? 1L : nanos);
          return t;
        }
      }
    }
    return (T)value;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(delegate));long l = durationNanos;return 62 + str.length() + "Suppliers.memoizeWithExpiration(" + str + ", " + l + ", NANOS)";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Suppliers.ExpiringMemoizingSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */