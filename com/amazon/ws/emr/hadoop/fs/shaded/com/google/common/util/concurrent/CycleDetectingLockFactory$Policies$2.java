package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;

 enum CycleDetectingLockFactory$Policies$2
{
  CycleDetectingLockFactory$Policies$2()
  {
    super(paramString, paramInt, null);
  }
  
  public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException e)
  {
    CycleDetectingLockFactory.access$100().log(Level.SEVERE, "Detected potential deadlock", e);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */