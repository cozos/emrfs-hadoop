package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface ZipfDistribution
  extends IntegerDistribution
{
  public abstract int getNumberOfElements();
  
  @Deprecated
  public abstract void setNumberOfElements(int paramInt);
  
  public abstract double getExponent();
  
  @Deprecated
  public abstract void setExponent(double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.ZipfDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */