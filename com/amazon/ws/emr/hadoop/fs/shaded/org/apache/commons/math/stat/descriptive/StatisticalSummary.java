package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

public abstract interface StatisticalSummary
{
  public abstract double getMean();
  
  public abstract double getVariance();
  
  public abstract double getStandardDeviation();
  
  public abstract double getMax();
  
  public abstract double getMin();
  
  public abstract long getN();
  
  public abstract double getSum();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.StatisticalSummary
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */