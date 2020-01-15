package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

final class CycleDetectingLockFactory$CycleDetectingReentrantLock
  extends ReentrantLock
  implements CycleDetectingLockFactory.CycleDetectingLock
{
  private final CycleDetectingLockFactory.LockGraphNode lockGraphNode;
  
  private CycleDetectingLockFactory$CycleDetectingReentrantLock(CycleDetectingLockFactory paramCycleDetectingLockFactory, CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean fair)
  {
    super(fair);
    this.lockGraphNode = ((CycleDetectingLockFactory.LockGraphNode)Preconditions.checkNotNull(lockGraphNode));
  }
  
  public CycleDetectingLockFactory.LockGraphNode getLockGraphNode()
  {
    return lockGraphNode;
  }
  
  public boolean isAcquiredByCurrentThread()
  {
    return isHeldByCurrentThread();
  }
  
  public void lock()
  {
    CycleDetectingLockFactory.access$600(this$0, this);
    try
    {
      super.lock();
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, this);
    }
  }
  
  public void lockInterruptibly()
    throws InterruptedException
  {
    CycleDetectingLockFactory.access$600(this$0, this);
    try
    {
      super.lockInterruptibly();
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, this);
    }
  }
  
  public boolean tryLock()
  {
    CycleDetectingLockFactory.access$600(this$0, this);
    try
    {
      return super.tryLock();
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, this);
    }
  }
  
  public boolean tryLock(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    CycleDetectingLockFactory.access$600(this$0, this);
    try
    {
      return super.tryLock(timeout, unit);
    }
    finally
    {
      CycleDetectingLockFactory.access$700(this$0, this);
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
      CycleDetectingLockFactory.access$700(this$0, this);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */