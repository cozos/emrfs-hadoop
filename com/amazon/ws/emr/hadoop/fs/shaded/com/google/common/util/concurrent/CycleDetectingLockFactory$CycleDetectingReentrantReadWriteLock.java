package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

final class CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock
  extends ReentrantReadWriteLock
  implements CycleDetectingLockFactory.CycleDetectingLock
{
  private final CycleDetectingLockFactory.CycleDetectingReentrantReadLock readLock;
  private final CycleDetectingLockFactory.CycleDetectingReentrantWriteLock writeLock;
  private final CycleDetectingLockFactory.LockGraphNode lockGraphNode;
  
  private CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory paramCycleDetectingLockFactory, CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean fair)
  {
    super(fair);
    readLock = new CycleDetectingLockFactory.CycleDetectingReentrantReadLock(paramCycleDetectingLockFactory, this);
    writeLock = new CycleDetectingLockFactory.CycleDetectingReentrantWriteLock(paramCycleDetectingLockFactory, this);
    this.lockGraphNode = ((CycleDetectingLockFactory.LockGraphNode)Preconditions.checkNotNull(lockGraphNode));
  }
  
  public ReentrantReadWriteLock.ReadLock readLock()
  {
    return readLock;
  }
  
  public ReentrantReadWriteLock.WriteLock writeLock()
  {
    return writeLock;
  }
  
  public CycleDetectingLockFactory.LockGraphNode getLockGraphNode()
  {
    return lockGraphNode;
  }
  
  public boolean isAcquiredByCurrentThread()
  {
    return (isWriteLockedByCurrentThread()) || (getReadHoldCount() > 0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */