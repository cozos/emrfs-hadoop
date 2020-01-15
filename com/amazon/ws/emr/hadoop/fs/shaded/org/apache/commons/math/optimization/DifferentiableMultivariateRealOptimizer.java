package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableMultivariateRealFunction;

public abstract interface DifferentiableMultivariateRealOptimizer
{
  public abstract void setMaxIterations(int paramInt);
  
  public abstract int getMaxIterations();
  
  public abstract int getIterations();
  
  public abstract void setMaxEvaluations(int paramInt);
  
  public abstract int getMaxEvaluations();
  
  public abstract int getEvaluations();
  
  public abstract int getGradientEvaluations();
  
  public abstract void setConvergenceChecker(RealConvergenceChecker paramRealConvergenceChecker);
  
  public abstract RealConvergenceChecker getConvergenceChecker();
  
  public abstract RealPointValuePair optimize(DifferentiableMultivariateRealFunction paramDifferentiableMultivariateRealFunction, GoalType paramGoalType, double[] paramArrayOfDouble)
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */