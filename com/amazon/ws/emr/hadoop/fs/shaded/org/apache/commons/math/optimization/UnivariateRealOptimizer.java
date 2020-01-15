package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergingAlgorithm;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public abstract interface UnivariateRealOptimizer
  extends ConvergingAlgorithm
{
  public abstract void setMaxEvaluations(int paramInt);
  
  public abstract int getMaxEvaluations();
  
  public abstract int getEvaluations();
  
  public abstract double optimize(UnivariateRealFunction paramUnivariateRealFunction, GoalType paramGoalType, double paramDouble1, double paramDouble2)
    throws ConvergenceException, FunctionEvaluationException;
  
  public abstract double optimize(UnivariateRealFunction paramUnivariateRealFunction, GoalType paramGoalType, double paramDouble1, double paramDouble2, double paramDouble3)
    throws ConvergenceException, FunctionEvaluationException;
  
  public abstract double getResult();
  
  public abstract double getFunctionValue();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.UnivariateRealOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */