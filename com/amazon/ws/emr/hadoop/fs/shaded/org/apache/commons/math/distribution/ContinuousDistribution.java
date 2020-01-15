package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public abstract interface ContinuousDistribution
  extends Distribution
{
  public abstract double inverseCumulativeProbability(double paramDouble)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.ContinuousDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */