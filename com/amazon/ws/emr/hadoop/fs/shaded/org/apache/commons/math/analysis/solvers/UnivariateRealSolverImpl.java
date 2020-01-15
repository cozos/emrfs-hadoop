package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergingAlgorithmImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public abstract class UnivariateRealSolverImpl
  extends ConvergingAlgorithmImpl
  implements UnivariateRealSolver
{
  protected double functionValueAccuracy;
  protected double defaultFunctionValueAccuracy;
  protected boolean resultComputed = false;
  protected double result;
  protected double functionValue;
  @Deprecated
  protected UnivariateRealFunction f;
  
  @Deprecated
  protected UnivariateRealSolverImpl(UnivariateRealFunction f, int defaultMaximalIterationCount, double defaultAbsoluteAccuracy)
  {
    super(defaultMaximalIterationCount, defaultAbsoluteAccuracy);
    if (f == null) {
      throw MathRuntimeException.createIllegalArgumentException("function to solve cannot be null", new Object[0]);
    }
    this.f = f;
    defaultFunctionValueAccuracy = 1.0E-15D;
    functionValueAccuracy = defaultFunctionValueAccuracy;
  }
  
  protected UnivariateRealSolverImpl(int defaultMaximalIterationCount, double defaultAbsoluteAccuracy)
  {
    super(defaultMaximalIterationCount, defaultAbsoluteAccuracy);
    defaultFunctionValueAccuracy = 1.0E-15D;
    functionValueAccuracy = defaultFunctionValueAccuracy;
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
  
  public void setFunctionValueAccuracy(double accuracy)
  {
    functionValueAccuracy = accuracy;
  }
  
  public double getFunctionValueAccuracy()
  {
    return functionValueAccuracy;
  }
  
  public void resetFunctionValueAccuracy()
  {
    functionValueAccuracy = defaultFunctionValueAccuracy;
  }
  
  protected final void setResult(double newResult, int iterationCount)
  {
    result = newResult;
    this.iterationCount = iterationCount;
    resultComputed = true;
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
    iterationCount = 0;
    resultComputed = false;
  }
  
  protected boolean isBracketing(double lower, double upper, UnivariateRealFunction function)
    throws FunctionEvaluationException
  {
    double f1 = function.value(lower);
    double f2 = function.value(upper);
    return ((f1 > 0.0D) && (f2 < 0.0D)) || ((f1 < 0.0D) && (f2 > 0.0D));
  }
  
  protected boolean isSequence(double start, double mid, double end)
  {
    return (start < mid) && (mid < end);
  }
  
  protected void verifyInterval(double lower, double upper)
  {
    if (lower >= upper) {
      throw MathRuntimeException.createIllegalArgumentException("endpoints do not specify an interval: [{0}, {1}]", new Object[] { Double.valueOf(lower), Double.valueOf(upper) });
    }
  }
  
  protected void verifySequence(double lower, double initial, double upper)
  {
    if (!isSequence(lower, initial, upper)) {
      throw MathRuntimeException.createIllegalArgumentException("invalid interval, initial value parameters:  lower={0}, initial={1}, upper={2}", new Object[] { Double.valueOf(lower), Double.valueOf(initial), Double.valueOf(upper) });
    }
  }
  
  protected void verifyBracketing(double lower, double upper, UnivariateRealFunction function)
    throws FunctionEvaluationException
  {
    verifyInterval(lower, upper);
    if (!isBracketing(lower, upper, function)) {
      throw MathRuntimeException.createIllegalArgumentException("function values at endpoints do not have different signs.  Endpoints: [{0}, {1}], Values: [{2}, {3}]", new Object[] { Double.valueOf(lower), Double.valueOf(upper), Double.valueOf(function.value(lower)), Double.valueOf(function.value(upper)) });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */