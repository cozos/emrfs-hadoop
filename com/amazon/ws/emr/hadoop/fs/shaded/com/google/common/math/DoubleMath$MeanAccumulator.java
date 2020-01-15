package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

@GwtIncompatible("com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.DoubleUtils")
final class DoubleMath$MeanAccumulator
{
  private long count = 0L;
  private double mean = 0.0D;
  
  void add(double value)
  {
    Preconditions.checkArgument(DoubleUtils.isFinite(value));
    count += 1L;
    
    mean += (value - mean) / count;
  }
  
  double mean()
  {
    Preconditions.checkArgument(count > 0L, "Cannot take mean of 0 values");
    return mean;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.DoubleMath.MeanAccumulator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */