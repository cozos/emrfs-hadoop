package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

public abstract interface ConcurrentInitializer<T>
{
  public abstract T get()
    throws ConcurrentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.ConcurrentInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */