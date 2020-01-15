package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression;

public abstract interface MultipleLinearRegression
{
  public abstract double[] estimateRegressionParameters();
  
  public abstract double[][] estimateRegressionParametersVariance();
  
  public abstract double[] estimateResiduals();
  
  public abstract double estimateRegressandVariance();
  
  public abstract double[] estimateRegressionParametersStandardErrors();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression.MultipleLinearRegression
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */