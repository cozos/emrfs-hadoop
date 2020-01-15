package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.univariate;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergingAlgorithmImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.UnivariateRealOptimizer;

public abstract class AbstractUnivariateRealOptimizer
  extends ConvergingAlgorithmImpl
  implements UnivariateRealOptimizer
{
  protected boolean resultComputed;
  protected double result;
  protected double functionValue;
  private int maxEvaluations;
  private int evaluations;
  
  protected AbstractUnivariateRealOptimizer(int defaultMaximalIterationCount, double defaultAbsoluteAccuracy)
  {
    super(defaultMaximalIterationCount, defaultAbsoluteAccuracy);
    resultComputed = false;
    setMaxEvaluations(Integer.MAX_VALUE);
  }
  
  protected void checkResultComputed()
    throws IllegalStateException
  {
    if (!resultComputed) {
      throw MathRuntimeException.createIllegalStateException("no result available", new Object[0]);
    }
  }
  
  public double getResult()
  {
    checkResultComputed();
    return result;
  }
  
  public double getFunctionValue()
  {
    checkResultComputed();
    return functionValue;
  }
  
  protected final void setResult(double x, double fx, int iterationCount)
  {
    result = x;
    functionValue = fx;
    this.iterationCount = iterationCount;
    resultComputed = true;
  }
  
  protected final void clearResult()
  {
    resultComputed = false;
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
  
  protected double computeObjectiveValue(UnivariateRealFunction f, double point)
    throws FunctionEvaluationException
  {
    if (++evaluations > maxEvaluations) {
      throw new FunctionEvaluationException(new MaxEvaluationsExceededException(maxEvaluations), point);
    }
    return f.value(point);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.univariate.AbstractUnivariateRealOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */