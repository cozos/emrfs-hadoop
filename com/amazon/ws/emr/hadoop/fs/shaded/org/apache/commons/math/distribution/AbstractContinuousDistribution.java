package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils;
import java.io.Serializable;

public abstract class AbstractContinuousDistribution
  extends AbstractDistribution
  implements ContinuousDistribution, Serializable
{
  private static final long serialVersionUID = -38038050983108802L;
  private double solverAbsoluteAccuracy = 1.0E-6D;
  
  public double density(double x)
    throws MathRuntimeException
  {
    throw new MathRuntimeException(new UnsupportedOperationException(), "This distribution does not have a density function implemented", new Object[0]);
  }
  
  public double inverseCumulativeProbability(final double p)
    throws MathException
  {
    if ((p < 0.0D) || (p > 1.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(p), Double.valueOf(0.0D), Double.valueOf(1.0D) });
    }
    UnivariateRealFunction rootFindingFunction = new UnivariateRealFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        double ret = NaN.0D;
        try
        {
          ret = cumulativeProbability(x) - p;
        }
        catch (MathException ex)
        {
          throw new FunctionEvaluationException(ex, x, ex.getPattern(), ex.getArguments());
        }
        if (Double.isNaN(ret)) {
          throw new FunctionEvaluationException(x, "Cumulative probability function returned NaN for argument {0} p = {1}", new Object[] { Double.valueOf(x), Double.valueOf(p) });
        }
        return ret;
      }
    };
    double lowerBound = getDomainLowerBound(p);
    double upperBound = getDomainUpperBound(p);
    double[] bracket = null;
    try
    {
      bracket = UnivariateRealSolverUtils.bracket(rootFindingFunction, getInitialDomain(p), lowerBound, upperBound);
    }
    catch (ConvergenceException ex)
    {
      if (Math.abs(rootFindingFunction.value(lowerBound)) < getSolverAbsoluteAccuracy()) {
        return lowerBound;
      }
      if (Math.abs(rootFindingFunction.value(upperBound)) < getSolverAbsoluteAccuracy()) {
        return upperBound;
      }
      throw new MathException(ex);
    }
    double root = UnivariateRealSolverUtils.solve(rootFindingFunction, bracket[0], bracket[1], getSolverAbsoluteAccuracy());
    
    return root;
  }
  
  protected abstract double getInitialDomain(double paramDouble);
  
  protected abstract double getDomainLowerBound(double paramDouble);
  
  protected abstract double getDomainUpperBound(double paramDouble);
  
  protected double getSolverAbsoluteAccuracy()
  {
    return solverAbsoluteAccuracy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.AbstractContinuousDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */