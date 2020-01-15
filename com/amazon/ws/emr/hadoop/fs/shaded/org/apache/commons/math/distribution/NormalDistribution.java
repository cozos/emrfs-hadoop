package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface NormalDistribution
  extends ContinuousDistribution, HasDensity<Double>
{
  public abstract double getMean();
  
  @Deprecated
  public abstract void setMean(double paramDouble);
  
  public abstract double getStandardDeviation();
  
  @Deprecated
  public abstract void setStandardDeviation(double paramDouble);
  
  public abstract double density(Double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.NormalDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */