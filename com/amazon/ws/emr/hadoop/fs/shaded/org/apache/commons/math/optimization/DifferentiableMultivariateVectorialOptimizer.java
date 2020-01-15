package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction;

public abstract interface DifferentiableMultivariateVectorialOptimizer
{
  public abstract void setMaxIterations(int paramInt);
  
  public abstract int getMaxIterations();
  
  public abstract int getIterations();
  
  public abstract void setMaxEvaluations(int paramInt);
  
  public abstract int getMaxEvaluations();
  
  public abstract int getEvaluations();
  
  public abstract int getJacobianEvaluations();
  
  public abstract void setConvergenceChecker(VectorialConvergenceChecker paramVectorialConvergenceChecker);
  
  public abstract VectorialConvergenceChecker getConvergenceChecker();
  
  public abstract VectorialPointValuePair optimize(DifferentiableMultivariateVectorialFunction paramDifferentiableMultivariateVectorialFunction, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */