package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

public abstract interface StorelessUnivariateStatistic
  extends UnivariateStatistic
{
  public abstract void increment(double paramDouble);
  
  public abstract void incrementAll(double[] paramArrayOfDouble);
  
  public abstract void incrementAll(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
  
  public abstract double getResult();
  
  public abstract long getN();
  
  public abstract void clear();
  
  public abstract StorelessUnivariateStatistic copy();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */