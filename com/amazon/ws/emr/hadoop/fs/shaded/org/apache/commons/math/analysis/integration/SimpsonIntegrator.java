package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public class SimpsonIntegrator
  extends UnivariateRealIntegratorImpl
{
  @Deprecated
  public SimpsonIntegrator(UnivariateRealFunction f)
  {
    super(f, 64);
  }
  
  public SimpsonIntegrator()
  {
    super(64);
  }
  
  @Deprecated
  public double integrate(double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException, IllegalArgumentException
  {
    return integrate(f, min, max);
  }
  
  public double integrate(UnivariateRealFunction f, double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException, IllegalArgumentException
  {
    clearResult();
    verifyInterval(min, max);
    verifyIterationCount();
    
    TrapezoidIntegrator qtrap = new TrapezoidIntegrator();
    if (minimalIterationCount == 1)
    {
      double s = (4.0D * qtrap.stage(f, min, max, 1) - qtrap.stage(f, min, max, 0)) / 3.0D;
      setResult(s, 1);
      return result;
    }
    double olds = 0.0D;
    double oldt = qtrap.stage(f, min, max, 0);
    for (int i = 1; i <= maximalIterationCount; i++)
    {
      double t = qtrap.stage(f, min, max, i);
      double s = (4.0D * t - oldt) / 3.0D;
      if (i >= minimalIterationCount)
      {
        double delta = Math.abs(s - olds);
        double rLimit = relativeAccuracy * (Math.abs(olds) + Math.abs(s)) * 0.5D;
        if ((delta <= rLimit) || (delta <= absoluteAccuracy))
        {
          setResult(s, i);
          return result;
        }
      }
      olds = s;
      oldt = t;
    }
    throw new MaxIterationsExceededException(maximalIterationCount);
  }
  
  protected void verifyIterationCount()
    throws IllegalArgumentException
  {
    super.verifyIterationCount();
    if (maximalIterationCount > 64) {
      throw MathRuntimeException.createIllegalArgumentException("invalid iteration limits: min={0}, max={1}", new Object[] { Integer.valueOf(0), Integer.valueOf(64) });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration.SimpsonIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */