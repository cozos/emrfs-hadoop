package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface HypergeometricDistribution
  extends IntegerDistribution
{
  public abstract int getNumberOfSuccesses();
  
  public abstract int getPopulationSize();
  
  public abstract int getSampleSize();
  
  @Deprecated
  public abstract void setNumberOfSuccesses(int paramInt);
  
  @Deprecated
  public abstract void setPopulationSize(int paramInt);
  
  @Deprecated
  public abstract void setSampleSize(int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.HypergeometricDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */