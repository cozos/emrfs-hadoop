package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

abstract interface CycleDetectingLockFactory$CycleDetectingLock
{
  public abstract CycleDetectingLockFactory.LockGraphNode getLockGraphNode();
  
  public abstract boolean isAcquiredByCurrentThread();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */