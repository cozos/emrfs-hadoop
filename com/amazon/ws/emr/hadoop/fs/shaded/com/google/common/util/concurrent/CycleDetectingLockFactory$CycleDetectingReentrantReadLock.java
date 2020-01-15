package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

class CycleDetectingLockFactory$CycleDetectingReentrantReadLock
  extends ReentrantReadWriteLock.ReadLock
{
  final CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock;
  
  CycleDetectingLockFactory$CycleDetectingReentrantReadLock(CycleDetectingLockFactory paramCycleDetectingLockFactory, CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock)
  {
    super(readWriteLock);
    this.readWriteLock = readWriteLock;
  }
  
  public void lock()
  {
    CycleDetectingLockFactory.access$600(this$0, readWriteLock);
    try
    {
      super.lock();
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, readWriteLock);
    }
  }
  
  public void lockInterruptibly()
    throws InterruptedException
  {
    CycleDetectingLockFactory.access$600(this$0, readWriteLock);
    try
    {
      super.lockInterruptibly();
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, readWriteLock);
    }
  }
  
  public boolean tryLock()
  {
    CycleDetectingLockFactory.access$600(this$0, readWriteLock);
    try
    {
      return super.tryLock();
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, readWriteLock);
    }
  }
  
  public boolean tryLock(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    CycleDetectingLockFactory.access$600(this$0, readWriteLock);
    try
    {
      return super.tryLock(timeout, unit);
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, readWriteLock);
    }
  }
  
  public void unlock()
  {
    try
    {
      super.unlock();
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, readWriteLock);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */