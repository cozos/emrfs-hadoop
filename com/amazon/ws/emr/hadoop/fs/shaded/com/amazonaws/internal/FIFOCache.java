package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

@ThreadSafe
public final class FIFOCache<T>
{
  private final BoundedLinkedHashMap<String, T> map;
  private final ReentrantReadWriteLock.ReadLock rlock;
  private final ReentrantReadWriteLock.WriteLock wlock;
  
  public FIFOCache(int maxSize)
  {
    if (maxSize < 1) {
      throw new IllegalArgumentException("maxSize " + maxSize + " must be at least 1");
    }
    map = new BoundedLinkedHashMap(maxSize);
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    rlock = lock.readLock();
    wlock = lock.writeLock();
  }
  
  public T add(String key, T value)
  {
    wlock.lock();
    try
    {
      return (T)map.put(key, value);
    }
    finally
    {
      wlock.unlock();
    }
  }
  
  public T get(String key)
  {
    rlock.lock();
    try
    {
      return (T)map.get(key);
    }
    finally
    {
      rlock.unlock();
    }
  }
  
  public int size()
  {
    rlock.lock();
    try
    {
      return map.size();
    }
    finally
    {
      rlock.unlock();
    }
  }
  
  public int getMaxSize()
  {
    return map.getMaxSize();
  }
  
  public String toString()
  {
    rlock.lock();
    try
    {
      return map.toString();
    }
    finally
    {
      rlock.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.FIFOCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */