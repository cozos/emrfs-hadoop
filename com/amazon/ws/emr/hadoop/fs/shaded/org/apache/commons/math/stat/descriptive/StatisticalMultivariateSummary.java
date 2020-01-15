package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;

public abstract interface StatisticalMultivariateSummary
{
  public abstract int getDimension();
  
  public abstract double[] getMean();
  
  public abstract RealMatrix getCovariance();
  
  public abstract double[] getStandardDeviation();
  
  public abstract double[] getMax();
  
  public abstract double[] getMin();
  
  public abstract long getN();
  
  public abstract double[] getGeometricMean();
  
  public abstract double[] getSum();
  
  public abstract double[] getSumSq();
  
  public abstract double[] getSumLog();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */