package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface BinomialDistribution
  extends IntegerDistribution
{
  public abstract int getNumberOfTrials();
  
  public abstract double getProbabilityOfSuccess();
  
  @Deprecated
  public abstract void setNumberOfTrials(int paramInt);
  
  @Deprecated
  public abstract void setProbabilityOfSuccess(double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.BinomialDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */