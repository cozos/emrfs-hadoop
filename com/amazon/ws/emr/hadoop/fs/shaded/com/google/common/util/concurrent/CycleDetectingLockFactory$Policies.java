package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public enum CycleDetectingLockFactory$Policies
  implements CycleDetectingLockFactory.Policy
{
  THROW,  WARN,  DISABLED;
  
  private CycleDetectingLockFactory$Policies() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */