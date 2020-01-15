package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public class CapacityManager
{
  private volatile int availableCapacity;
  private final int maxCapacity;
  private final Object lock = new Object();
  
  public CapacityManager(int maxCapacity)
  {
    this.maxCapacity = maxCapacity;
    availableCapacity = maxCapacity;
  }
  
  public boolean acquire()
  {
    return acquire(1);
  }
  
  public boolean acquire(int capacity)
  {
    if (capacity < 0) {
      throw new IllegalArgumentException("capacity to acquire cannot be negative");
    }
    if (availableCapacity < 0) {
      return true;
    }
    synchronized (lock)
    {
      if (availableCapacity - capacity >= 0)
      {
        availableCapacity -= capacity;
        return true;
      }
      return false;
    }
  }
  
  public void release()
  {
    release(1);
  }
  
  public void release(int capacity)
  {
    if (capacity < 0) {
      throw new IllegalArgumentException("capacity to release cannot be negative");
    }
    if ((availableCapacity >= 0) && (availableCapacity != maxCapacity)) {
      synchronized (lock)
      {
        availableCapacity = Math.min(availableCapacity + capacity, maxCapacity);
      }
    }
  }
  
  public int consumedCapacity()
  {
    return availableCapacity < 0 ? 0 : maxCapacity - availableCapacity;
  }
  
  public int availableCapacity()
  {
    return availableCapacity;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CapacityManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */