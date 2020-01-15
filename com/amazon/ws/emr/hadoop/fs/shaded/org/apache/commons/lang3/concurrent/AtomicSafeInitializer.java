package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicSafeInitializer<T>
  implements ConcurrentInitializer<T>
{
  private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference();
  private final AtomicReference<T> reference = new AtomicReference();
  
  public final T get()
    throws ConcurrentException
  {
    T result;
    while ((result = reference.get()) == null) {
      if (factory.compareAndSet(null, this)) {
        reference.set(initialize());
      }
    }
    return result;
  }
  
  protected abstract T initialize()
    throws ConcurrentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.AtomicSafeInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */