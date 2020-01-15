package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface ChiSquaredDistribution
  extends ContinuousDistribution, HasDensity<Double>
{
  @Deprecated
  public abstract void setDegreesOfFreedom(double paramDouble);
  
  public abstract double getDegreesOfFreedom();
  
  public abstract double density(Double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.ChiSquaredDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */