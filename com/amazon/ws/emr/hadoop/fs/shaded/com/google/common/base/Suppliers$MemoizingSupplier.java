package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;

@VisibleForTesting
class Suppliers$MemoizingSupplier<T>
  implements Supplier<T>, Serializable
{
  final Supplier<T> delegate;
  volatile transient boolean initialized;
  transient T value;
  private static final long serialVersionUID = 0L;
  
  Suppliers$MemoizingSupplier(Supplier<T> delegate)
  {
    this.delegate = delegate;
  }
  
  public T get()
  {
    if (!initialized) {
      synchronized (this)
      {
        if (!initialized)
        {
          T t = delegate.get();
          value = t;
          initialized = true;
          return t;
        }
      }
    }
    return (T)value;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(delegate));return 19 + str.length() + "Suppliers.memoize(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Suppliers.MemoizingSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */