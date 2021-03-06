package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface GammaDistribution
  extends ContinuousDistribution, HasDensity<Double>
{
  @Deprecated
  public abstract void setAlpha(double paramDouble);
  
  public abstract double getAlpha();
  
  @Deprecated
  public abstract void setBeta(double paramDouble);
  
  public abstract double getBeta();
  
  public abstract double density(Double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.GammaDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */