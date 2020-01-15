package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public abstract interface PoissonDistribution
  extends IntegerDistribution
{
  public abstract double getMean();
  
  @Deprecated
  public abstract void setMean(double paramDouble);
  
  public abstract double normalApproximateProbability(int paramInt)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.PoissonDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */