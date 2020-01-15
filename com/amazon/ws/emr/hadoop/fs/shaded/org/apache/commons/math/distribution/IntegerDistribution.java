package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public abstract interface IntegerDistribution
  extends DiscreteDistribution
{
  public abstract double probability(int paramInt);
  
  public abstract double cumulativeProbability(int paramInt)
    throws MathException;
  
  public abstract double cumulativeProbability(int paramInt1, int paramInt2)
    throws MathException;
  
  public abstract int inverseCumulativeProbability(double paramDouble)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.IntegerDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */