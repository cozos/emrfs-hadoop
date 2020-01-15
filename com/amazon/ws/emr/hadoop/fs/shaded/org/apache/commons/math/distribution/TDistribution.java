package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface TDistribution
  extends ContinuousDistribution
{
  @Deprecated
  public abstract void setDegreesOfFreedom(double paramDouble);
  
  public abstract double getDegreesOfFreedom();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.TDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */