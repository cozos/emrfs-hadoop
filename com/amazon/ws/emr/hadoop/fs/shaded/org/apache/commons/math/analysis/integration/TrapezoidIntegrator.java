package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public class TrapezoidIntegrator
  extends UnivariateRealIntegratorImpl
{
  private double s;
  
  @Deprecated
  public TrapezoidIntegrator(UnivariateRealFunction f)
  {
    super(f, 64);
  }
  
  public TrapezoidIntegrator()
  {
    super(64);
  }
  
  double stage(UnivariateRealFunction f, double min, double max, int n)
    throws FunctionEvaluationException
  {
    if (n == 0)
    {
      s = (0.5D * (max - min) * (f.value(min) + f.value(max)));
      return s;
    }
    long np = 1L << n - 1;
    double sum = 0.0D;
    double spacing = (max - min) / np;
    double x = min + 0.5D * spacing;
    for (long i = 0L; i < np; i += 1L)
    {
      sum += f.value(x);
      x += spacing;
    }
    s = (0.5D * (s + sum * spacing));
    return s;
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
    
    double oldt = stage(f, min, max, 0);
    for (int i = 1; i <= maximalIterationCount; i++)
    {
      double t = stage(f, min, max, i);
      if (i >= minimalIterationCount)
      {
        double delta = Math.abs(t - oldt);
        double rLimit = relativeAccuracy * (Math.abs(oldt) + Math.abs(t)) * 0.5D;
        if ((delta <= rLimit) || (delta <= absoluteAccuracy))
        {
          setResult(t, i);
          return result;
        }
      }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration.TrapezoidIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */