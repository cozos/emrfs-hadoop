package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface PascalDistribution
  extends IntegerDistribution
{
  public abstract int getNumberOfSuccesses();
  
  public abstract double getProbabilityOfSuccess();
  
  @Deprecated
  public abstract void setNumberOfSuccesses(int paramInt);
  
  @Deprecated
  public abstract void setProbabilityOfSuccess(double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.PascalDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */