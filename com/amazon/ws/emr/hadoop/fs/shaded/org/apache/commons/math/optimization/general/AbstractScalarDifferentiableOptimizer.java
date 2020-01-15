package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableMultivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateVectorialFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.DifferentiableMultivariateRealOptimizer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.GoalType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealConvergenceChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.SimpleScalarValueChecker;

public abstract class AbstractScalarDifferentiableOptimizer
  implements DifferentiableMultivariateRealOptimizer
{
  public static final int DEFAULT_MAX_ITERATIONS = 100;
  protected RealConvergenceChecker checker;
  protected GoalType goal;
  protected double[] point;
  private int maxIterations;
  private int iterations;
  private int maxEvaluations;
  private int evaluations;
  private int gradientEvaluations;
  private DifferentiableMultivariateRealFunction function;
  private MultivariateVectorialFunction gradient;
  
  protected AbstractScalarDifferentiableOptimizer()
  {
    setConvergenceChecker(new SimpleScalarValueChecker());
    setMaxIterations(100);
    setMaxEvaluations(Integer.MAX_VALUE);
  }
  
  public void setMaxIterations(int maxIterations)
  {
    this.maxIterations = maxIterations;
  }
  
  public int getMaxIterations()
  {
    return maxIterations;
  }
  
  public int getIterations()
  {
    return iterations;
  }
  
  public void setMaxEvaluations(int maxEvaluations)
  {
    this.maxEvaluations = maxEvaluations;
  }
  
  public int getMaxEvaluations()
  {
    return maxEvaluations;
  }
  
  public int getEvaluations()
  {
    return evaluations;
  }
  
  public int getGradientEvaluations()
  {
    return gradientEvaluations;
  }
  
  public void setConvergenceChecker(RealConvergenceChecker convergenceChecker)
  {
    checker = convergenceChecker;
  }
  
  public RealConvergenceChecker getConvergenceChecker()
  {
    return checker;
  }
  
  protected void incrementIterationsCounter()
    throws OptimizationException
  {
    if (++iterations > maxIterations) {
      throw new OptimizationException(new MaxIterationsExceededException(maxIterations));
    }
  }
  
  protected double[] computeObjectiveGradient(double[] evaluationPoint)
    throws FunctionEvaluationException
  {
    gradientEvaluations += 1;
    return gradient.value(evaluationPoint);
  }
  
  protected double computeObjectiveValue(double[] evaluationPoint)
    throws FunctionEvaluationException
  {
    if (++evaluations > maxEvaluations) {
      throw new FunctionEvaluationException(new MaxEvaluationsExceededException(maxEvaluations), evaluationPoint);
    }
    return function.value(evaluationPoint);
  }
  
  public RealPointValuePair optimize(DifferentiableMultivariateRealFunction f, GoalType goalType, double[] startPoint)
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException
  {
    iterations = 0;
    evaluations = 0;
    gradientEvaluations = 0;
    
    function = f;
    gradient = f.gradient();
    goal = goalType;
    point = ((double[])startPoint.clone());
    
    return doOptimize();
  }
  
  protected abstract RealPointValuePair doOptimize()
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general.AbstractScalarDifferentiableOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */