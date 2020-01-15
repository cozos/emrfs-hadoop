package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;

@ThreadSafe
public final class ClockSkewAdjuster$ClockSkewAdjustment
{
  private final boolean shouldAdjustForSkew;
  private final int adjustmentInSeconds;
  
  private ClockSkewAdjuster$ClockSkewAdjustment(boolean shouldAdjust, int adjustmentInSeconds)
  {
    shouldAdjustForSkew = shouldAdjust;
    this.adjustmentInSeconds = adjustmentInSeconds;
  }
  
  public boolean shouldAdjustForSkew()
  {
    return shouldAdjustForSkew;
  }
  
  public int inSeconds()
  {
    if (!shouldAdjustForSkew) {
      throw new IllegalStateException("An adjustment is not recommended.");
    }
    return adjustmentInSeconds;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.ClockSkewAdjuster.ClockSkewAdjustment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */