package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public class SecantSolver
  extends UnivariateRealSolverImpl
{
  @Deprecated
  public SecantSolver(UnivariateRealFunction f)
  {
    super(f, 100, 1.0E-6D);
  }
  
  public SecantSolver()
  {
    super(100, 1.0E-6D);
  }
  
  @Deprecated
  public double solve(double min, double max)
    throws ConvergenceException, FunctionEvaluationException
  {
    return solve(f, min, max);
  }
  
  @Deprecated
  public double solve(double min, double max, double initial)
    throws ConvergenceException, FunctionEvaluationException
  {
    return solve(f, min, max, initial);
  }
  
  public double solve(UnivariateRealFunction f, double min, double max, double initial)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    return solve(f, min, max);
  }
  
  public double solve(UnivariateRealFunction f, double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    clearResult();
    verifyInterval(min, max);
    
    double x0 = min;
    double x1 = max;
    double y0 = f.value(x0);
    double y1 = f.value(x1);
    if (y0 * y1 >= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("function values at endpoints do not have different signs, endpoints: [{0}, {1}], values: [{2}, {3}]", new Object[] { Double.valueOf(min), Double.valueOf(max), Double.valueOf(y0), Double.valueOf(y1) });
    }
    double x2 = x0;
    double y2 = y0;
    double oldDelta = x2 - x1;
    int i = 0;
    while (i < maximalIterationCount)
    {
      if (Math.abs(y2) < Math.abs(y1))
      {
        x0 = x1;
        x1 = x2;
        x2 = x0;
        y0 = y1;
        y1 = y2;
        y2 = y0;
      }
      if (Math.abs(y1) <= functionValueAccuracy)
      {
        setResult(x1, i);
        return result;
      }
      if (Math.abs(oldDelta) < Math.max(relativeAccuracy * Math.abs(x1), absoluteAccuracy))
      {
        setResult(x1, i);
        return result;
      }
      double delta;
      double delta;
      if (Math.abs(y1) > Math.abs(y0))
      {
        delta = 0.5D * oldDelta;
      }
      else
      {
        delta = (x0 - x1) / (1.0D - y0 / y1);
        if (delta / oldDelta > 1.0D) {
          delta = 0.5D * oldDelta;
        }
      }
      x0 = x1;
      y0 = y1;
      x1 += delta;
      y1 = f.value(x1);
      if ((y1 > 0.0D ? 1 : 0) == (y2 > 0.0D ? 1 : 0))
      {
        x2 = x0;
        y2 = y0;
      }
      oldDelta = x2 - x1;
      i++;
    }
    throw new MaxIterationsExceededException(maximalIterationCount);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.SecantSolver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */