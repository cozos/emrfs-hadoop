package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;
import java.io.Serializable;

public class PascalDistributionImpl
  extends AbstractIntegerDistribution
  implements PascalDistribution, Serializable
{
  private static final long serialVersionUID = 6751309484392813623L;
  private int numberOfSuccesses;
  private double probabilityOfSuccess;
  
  public PascalDistributionImpl(int r, double p)
  {
    setNumberOfSuccessesInternal(r);
    setProbabilityOfSuccessInternal(p);
  }
  
  public int getNumberOfSuccesses()
  {
    return numberOfSuccesses;
  }
  
  public double getProbabilityOfSuccess()
  {
    return probabilityOfSuccess;
  }
  
  @Deprecated
  public void setNumberOfSuccesses(int successes)
  {
    setNumberOfSuccessesInternal(successes);
  }
  
  private void setNumberOfSuccessesInternal(int successes)
  {
    if (successes < 0) {
      throw MathRuntimeException.createIllegalArgumentException("number of successes must be non-negative ({0})", new Object[] { Integer.valueOf(successes) });
    }
    numberOfSuccesses = successes;
  }
  
  @Deprecated
  public void setProbabilityOfSuccess(double p)
  {
    setProbabilityOfSuccessInternal(p);
  }
  
  private void setProbabilityOfSuccessInternal(double p)
  {
    if ((p < 0.0D) || (p > 1.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(p), Double.valueOf(0.0D), Double.valueOf(1.0D) });
    }
    probabilityOfSuccess = p;
  }
  
  protected int getDomainLowerBound(double p)
  {
    return -1;
  }
  
  protected int getDomainUpperBound(double p)
  {
    return 2147483646;
  }
  
  public double cumulativeProbability(int x)
    throws MathException
  {
    double ret;
    double ret;
    if (x < 0) {
      ret = 0.0D;
    } else {
      ret = Beta.regularizedBeta(probabilityOfSuccess, numberOfSuccesses, x + 1);
    }
    return ret;
  }
  
  public double probability(int x)
  {
    double ret;
    double ret;
    if (x < 0) {
      ret = 0.0D;
    } else {
      ret = MathUtils.binomialCoefficientDouble(x + numberOfSuccesses - 1, numberOfSuccesses - 1) * Math.pow(probabilityOfSuccess, numberOfSuccesses) * Math.pow(1.0D - probabilityOfSuccess, x);
    }
    return ret;
  }
  
  public int inverseCumulativeProbability(double p)
    throws MathException
  {
    int ret;
    int ret;
    if (p == 0.0D)
    {
      ret = -1;
    }
    else
    {
      int ret;
      if (p == 1.0D) {
        ret = Integer.MAX_VALUE;
      } else {
        ret = super.inverseCumulativeProbability(p);
      }
    }
    return ret;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.PascalDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */