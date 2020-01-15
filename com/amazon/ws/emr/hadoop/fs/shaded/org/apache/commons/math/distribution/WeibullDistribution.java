package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

public abstract interface WeibullDistribution
  extends ContinuousDistribution
{
  public abstract double getShape();
  
  public abstract double getScale();
  
  @Deprecated
  public abstract void setShape(double paramDouble);
  
  @Deprecated
  public abstract void setScale(double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.WeibullDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */