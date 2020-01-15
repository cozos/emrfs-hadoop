package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public class LegendreGaussIntegrator
  extends UnivariateRealIntegratorImpl
{
  private static final double[] ABSCISSAS_2 = { -1.0D / Math.sqrt(3.0D), 1.0D / Math.sqrt(3.0D) };
  private static final double[] WEIGHTS_2 = { 1.0D, 1.0D };
  private static final double[] ABSCISSAS_3 = { -Math.sqrt(0.6D), 0.0D, Math.sqrt(0.6D) };
  private static final double[] WEIGHTS_3 = { 0.5555555555555556D, 0.8888888888888888D, 0.5555555555555556D };
  private static final double[] ABSCISSAS_4 = { -Math.sqrt((15.0D + 2.0D * Math.sqrt(30.0D)) / 35.0D), -Math.sqrt((15.0D - 2.0D * Math.sqrt(30.0D)) / 35.0D), Math.sqrt((15.0D - 2.0D * Math.sqrt(30.0D)) / 35.0D), Math.sqrt((15.0D + 2.0D * Math.sqrt(30.0D)) / 35.0D) };
  private static final double[] WEIGHTS_4 = { (90.0D - 5.0D * Math.sqrt(30.0D)) / 180.0D, (90.0D + 5.0D * Math.sqrt(30.0D)) / 180.0D, (90.0D + 5.0D * Math.sqrt(30.0D)) / 180.0D, (90.0D - 5.0D * Math.sqrt(30.0D)) / 180.0D };
  private static final double[] ABSCISSAS_5 = { -Math.sqrt((35.0D + 2.0D * Math.sqrt(70.0D)) / 63.0D), -Math.sqrt((35.0D - 2.0D * Math.sqrt(70.0D)) / 63.0D), 0.0D, Math.sqrt((35.0D - 2.0D * Math.sqrt(70.0D)) / 63.0D), Math.sqrt((35.0D + 2.0D * Math.sqrt(70.0D)) / 63.0D) };
  private static final double[] WEIGHTS_5 = { (322.0D - 13.0D * Math.sqrt(70.0D)) / 900.0D, (322.0D + 13.0D * Math.sqrt(70.0D)) / 900.0D, 0.5688888888888889D, (322.0D + 13.0D * Math.sqrt(70.0D)) / 900.0D, (322.0D - 13.0D * Math.sqrt(70.0D)) / 900.0D };
  private final double[] abscissas;
  private final double[] weights;
  
  public LegendreGaussIntegrator(int n, int defaultMaximalIterationCount)
    throws IllegalArgumentException
  {
    super(defaultMaximalIterationCount);
    switch (n)
    {
    case 2: 
      abscissas = ABSCISSAS_2;
      weights = WEIGHTS_2;
      break;
    case 3: 
      abscissas = ABSCISSAS_3;
      weights = WEIGHTS_3;
      break;
    case 4: 
      abscissas = ABSCISSAS_4;
      weights = WEIGHTS_4;
      break;
    case 5: 
      abscissas = ABSCISSAS_5;
      weights = WEIGHTS_5;
      break;
    default: 
      throw MathRuntimeException.createIllegalArgumentException("{0} points Legendre-Gauss integrator not supported, number of points must be in the {1}-{2} range", new Object[] { Integer.valueOf(n), Integer.valueOf(2), Integer.valueOf(5) });
    }
  }
  
  @Deprecated
  public double integrate(double min, double max)
    throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException
  {
    return integrate(f, min, max);
  }
  
  public double integrate(UnivariateRealFunction f, double min, double max)
    throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException
  {
    clearResult();
    verifyInterval(min, max);
    verifyIterationCount();
    
    double oldt = stage(f, min, max, 1);
    
    int n = 2;
    for (int i = 0; i < maximalIterationCount; i++)
    {
      double t = stage(f, min, max, n);
      
      double delta = Math.abs(t - oldt);
      double limit = Math.max(absoluteAccuracy, relativeAccuracy * (Math.abs(oldt) + Math.abs(t)) * 0.5D);
      if ((i + 1 >= minimalIterationCount) && (delta <= limit))
      {
        setResult(t, i);
        return result;
      }
      double ratio = Math.min(4.0D, Math.pow(delta / limit, 0.5D / abscissas.length));
      n = Math.max((int)(ratio * n), n + 1);
      oldt = t;
    }
    throw new MaxIterationsExceededException(maximalIterationCount);
  }
  
  private double stage(UnivariateRealFunction f, double min, double max, int n)
    throws FunctionEvaluationException
  {
    double step = (max - min) / n;
    double halfStep = step / 2.0D;
    
    double midPoint = min + halfStep;
    double sum = 0.0D;
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < abscissas.length; j++) {
        sum += weights[j] * f.value(midPoint + halfStep * abscissas[j]);
      }
      midPoint += step;
    }
    return halfStep * sum;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration.LegendreGaussIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */