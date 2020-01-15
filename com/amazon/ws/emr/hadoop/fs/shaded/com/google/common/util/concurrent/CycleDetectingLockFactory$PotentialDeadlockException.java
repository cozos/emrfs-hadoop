package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;

@Beta
public final class CycleDetectingLockFactory$PotentialDeadlockException
  extends CycleDetectingLockFactory.ExampleStackTrace
{
  private final CycleDetectingLockFactory.ExampleStackTrace conflictingStackTrace;
  
  private CycleDetectingLockFactory$PotentialDeadlockException(CycleDetectingLockFactory.LockGraphNode node1, CycleDetectingLockFactory.LockGraphNode node2, CycleDetectingLockFactory.ExampleStackTrace conflictingStackTrace)
  {
    super(node1, node2);
    this.conflictingStackTrace = conflictingStackTrace;
    initCause(conflictingStackTrace);
  }
  
  public CycleDetectingLockFactory.ExampleStackTrace getConflictingStackTrace()
  {
    return conflictingStackTrace;
  }
  
  public String getMessage()
  {
    StringBuilder message = new StringBuilder(super.getMessage());
    for (Throwable t = conflictingStackTrace; t != null; t = t.getCause()) {
      message.append(", ").append(t.getMessage());
    }
    return message.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */