package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

public abstract class LazyInitializer<T>
  implements ConcurrentInitializer<T>
{
  private volatile T object;
  
  public T get()
    throws ConcurrentException
  {
    T result = object;
    if (result == null) {
      synchronized (this)
      {
        result = object;
        if (result == null) {
          object = (result = initialize());
        }
      }
    }
    return result;
  }
  
  protected abstract T initialize()
    throws ConcurrentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.LazyInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */