package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergingAlgorithm;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public abstract interface UnivariateRealSolver
  extends ConvergingAlgorithm
{
  public abstract void setFunctionValueAccuracy(double paramDouble);
  
  public abstract double getFunctionValueAccuracy();
  
  public abstract void resetFunctionValueAccuracy();
  
  @Deprecated
  public abstract double solve(double paramDouble1, double paramDouble2)
    throws ConvergenceException, FunctionEvaluationException;
  
  public abstract double solve(UnivariateRealFunction paramUnivariateRealFunction, double paramDouble1, double paramDouble2)
    throws ConvergenceException, FunctionEvaluationException;
  
  @Deprecated
  public abstract double solve(double paramDouble1, double paramDouble2, double paramDouble3)
    throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;
  
  public abstract double solve(UnivariateRealFunction paramUnivariateRealFunction, double paramDouble1, double paramDouble2, double paramDouble3)
    throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException;
  
  public abstract double getResult();
  
  public abstract double getFunctionValue();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.UnivariateRealSolver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */