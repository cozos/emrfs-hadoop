package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T>
  implements ConcurrentInitializer<T>
{
  private final AtomicReference<T> reference = new AtomicReference();
  
  public T get()
    throws ConcurrentException
  {
    T result = reference.get();
    if (result == null)
    {
      result = initialize();
      if (!reference.compareAndSet(null, result)) {
        result = reference.get();
      }
    }
    return result;
  }
  
  protected abstract T initialize()
    throws ConcurrentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.AtomicInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */