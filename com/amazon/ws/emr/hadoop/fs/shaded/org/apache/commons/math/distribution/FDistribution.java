package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface FDistribution
  extends ContinuousDistribution
{
  @Deprecated
  public abstract void setNumeratorDegreesOfFreedom(double paramDouble);
  
  public abstract double getNumeratorDegreesOfFreedom();
  
  @Deprecated
  public abstract void setDenominatorDegreesOfFreedom(double paramDouble);
  
  public abstract double getDenominatorDegreesOfFreedom();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.FDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */