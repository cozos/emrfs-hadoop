package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public class NewtonSolver
  extends UnivariateRealSolverImpl
{
  @Deprecated
  public NewtonSolver(DifferentiableUnivariateRealFunction f)
  {
    super(f, 100, 1.0E-6D);
  }
  
  public NewtonSolver()
  {
    super(100, 1.0E-6D);
  }
  
  @Deprecated
  public double solve(double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    return solve(f, min, max);
  }
  
  @Deprecated
  public double solve(double min, double max, double startValue)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    return solve(f, min, max, startValue);
  }
  
  public double solve(UnivariateRealFunction f, double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    return solve(f, min, max, UnivariateRealSolverUtils.midpoint(min, max));
  }
  
  public double solve(UnivariateRealFunction f, double min, double max, double startValue)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    try
    {
      UnivariateRealFunction derivative = ((DifferentiableUnivariateRealFunction)f).derivative();
      
      clearResult();
      verifySequence(min, startValue, max);
      
      double x0 = startValue;
      
      int i = 0;
      while (i < maximalIterationCount)
      {
        double x1 = x0 - f.value(x0) / derivative.value(x0);
        if (Math.abs(x1 - x0) <= absoluteAccuracy)
        {
          setResult(x1, i);
          return x1;
        }
        x0 = x1;
        i++;
      }
      throw new MaxIterationsExceededException(maximalIterationCount);
    }
    catch (ClassCastException cce)
    {
      throw MathRuntimeException.createIllegalArgumentException("function is not differentiable", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.NewtonSolver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */