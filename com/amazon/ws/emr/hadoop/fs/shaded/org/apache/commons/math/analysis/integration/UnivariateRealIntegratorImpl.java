package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergingAlgorithmImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public abstract class UnivariateRealIntegratorImpl
  extends ConvergingAlgorithmImpl
  implements UnivariateRealIntegrator
{
  private static final long serialVersionUID = 6248808456637441533L;
  protected int minimalIterationCount;
  protected int defaultMinimalIterationCount;
  protected boolean resultComputed = false;
  protected double result;
  @Deprecated
  protected UnivariateRealFunction f;
  
  @Deprecated
  protected UnivariateRealIntegratorImpl(UnivariateRealFunction f, int defaultMaximalIterationCount)
    throws IllegalArgumentException
  {
    super(defaultMaximalIterationCount, 1.0E-15D);
    if (f == null) {
      throw MathRuntimeException.createIllegalArgumentException("function is null", new Object[0]);
    }
    this.f = f;
    
    setRelativeAccuracy(1.0E-6D);
    defaultMinimalIterationCount = 3;
    minimalIterationCount = defaultMinimalIterationCount;
    
    verifyIterationCount();
  }
  
  protected UnivariateRealIntegratorImpl(int defaultMaximalIterationCount)
    throws IllegalArgumentException
  {
    super(defaultMaximalIterationCount, 1.0E-15D);
    
    setRelativeAccuracy(1.0E-6D);
    defaultMinimalIterationCount = 3;
    minimalIterationCount = defaultMinimalIterationCount;
    
    verifyIterationCount();
  }
  
  public double getResult()
    throws IllegalStateException
  {
    if (resultComputed) {
      return result;
    }
    throw MathRuntimeException.createIllegalStateException("no result available", new Object[0]);
  }
  
  protected final void setResult(double newResult, int iterationCount)
  {
    result = newResult;
    this.iterationCount = iterationCount;
    resultComputed = true;
  }
  
  protected final void clearResult()
  {
    iterationCount = 0;
    resultComputed = false;
  }
  
  public void setMinimalIterationCount(int count)
  {
    minimalIterationCount = count;
  }
  
  public int getMinimalIterationCount()
  {
    return minimalIterationCount;
  }
  
  public void resetMinimalIterationCount()
  {
    minimalIterationCount = defaultMinimalIterationCount;
  }
  
  protected void verifyInterval(double lower, double upper)
    throws IllegalArgumentException
  {
    if (lower >= upper) {
      throw MathRuntimeException.createIllegalArgumentException("endpoints do not specify an interval: [{0}, {1}]", new Object[] { Double.valueOf(lower), Double.valueOf(upper) });
    }
  }
  
  protected void verifyIterationCount()
    throws IllegalArgumentException
  {
    if ((minimalIterationCount <= 0) || (maximalIterationCount <= minimalIterationCount)) {
      throw MathRuntimeException.createIllegalArgumentException("invalid iteration limits: min={0}, max={1}", new Object[] { Integer.valueOf(minimalIterationCount), Integer.valueOf(maximalIterationCount) });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.integration.UnivariateRealIntegratorImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */