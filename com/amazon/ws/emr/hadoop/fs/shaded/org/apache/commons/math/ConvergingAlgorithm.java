package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public abstract interface ConvergingAlgorithm
{
  public abstract void setMaximalIterationCount(int paramInt);
  
  public abstract int getMaximalIterationCount();
  
  public abstract void resetMaximalIterationCount();
  
  public abstract void setAbsoluteAccuracy(double paramDouble);
  
  public abstract double getAbsoluteAccuracy();
  
  public abstract void resetAbsoluteAccuracy();
  
  public abstract void setRelativeAccuracy(double paramDouble);
  
  public abstract double getRelativeAccuracy();
  
  public abstract void resetRelativeAccuracy();
  
  public abstract int getIterationCount();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergingAlgorithm
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */