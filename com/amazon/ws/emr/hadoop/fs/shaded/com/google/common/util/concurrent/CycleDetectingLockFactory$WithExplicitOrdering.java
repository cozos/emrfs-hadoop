package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Beta
public final class CycleDetectingLockFactory$WithExplicitOrdering<E extends Enum<E>>
  extends CycleDetectingLockFactory
{
  private final Map<E, CycleDetectingLockFactory.LockGraphNode> lockGraphNodes;
  
  @VisibleForTesting
  CycleDetectingLockFactory$WithExplicitOrdering(CycleDetectingLockFactory.Policy policy, Map<E, CycleDetectingLockFactory.LockGraphNode> lockGraphNodes)
  {
    super(policy, null);
    this.lockGraphNodes = lockGraphNodes;
  }
  
  public ReentrantLock newReentrantLock(E rank)
  {
    return newReentrantLock(rank, false);
  }
  
  public ReentrantLock newReentrantLock(E rank, boolean fair)
  {
    return policy == CycleDetectingLockFactory.Policies.DISABLED ? new ReentrantLock(fair) : new CycleDetectingLockFactory.CycleDetectingReentrantLock(this, (CycleDetectingLockFactory.LockGraphNode)lockGraphNodes.get(rank), fair, null);
  }
  
  public ReentrantReadWriteLock newReentrantReadWriteLock(E rank)
  {
    return newReentrantReadWriteLock(rank, false);
  }
  
  public ReentrantReadWriteLock newReentrantReadWriteLock(E rank, boolean fair)
  {
    return policy == CycleDetectingLockFactory.Policies.DISABLED ? new ReentrantReadWriteLock(fair) : new CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock(this, (CycleDetectingLockFactory.LockGraphNode)lockGraphNodes.get(rank), fair, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */