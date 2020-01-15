package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

public abstract interface WeightedEvaluation
{
  public abstract double evaluate(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  public abstract double evaluate(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.WeightedEvaluation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */