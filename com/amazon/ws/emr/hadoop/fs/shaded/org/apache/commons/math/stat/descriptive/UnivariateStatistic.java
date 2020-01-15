package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

public abstract interface UnivariateStatistic
{
  public abstract double evaluate(double[] paramArrayOfDouble);
  
  public abstract double evaluate(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
  
  public abstract UnivariateStatistic copy();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.UnivariateStatistic
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */