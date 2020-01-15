package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface CauchyDistribution
  extends ContinuousDistribution
{
  public abstract double getMedian();
  
  public abstract double getScale();
  
  @Deprecated
  public abstract void setMedian(double paramDouble);
  
  @Deprecated
  public abstract void setScale(double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.CauchyDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */