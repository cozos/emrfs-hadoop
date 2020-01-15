package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergingAlgorithm;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public abstract interface UnivariateRealIntegrator
  extends ConvergingAlgorithm
{
  public abstract void setMinimalIterationCount(int paramInt);
  
  public abstract int getMinimalIterationCount();
  
  public abstract void resetMinimalIterationCount();
  
  @Deprecated
  public abstract double integrate(double paramDouble1, double paramDouble2)
    throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;
  
  public abstract double integrate(UnivariateRealFunction paramUnivariateRealFunction, double paramDouble1, double paramDouble2)
    throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;
  
  public abstract double getResult()
    throws IllegalStateException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */