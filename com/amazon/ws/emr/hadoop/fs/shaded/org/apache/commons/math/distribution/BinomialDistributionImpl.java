package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Beta;
import java.io.Serializable;

public class BinomialDistributionImpl
  extends AbstractIntegerDistribution
  implements BinomialDistribution, Serializable
{
  private static final long serialVersionUID = 6751309484392813623L;
  private int numberOfTrials;
  private double probabilityOfSuccess;
  
  public BinomialDistributionImpl(int trials, double p)
  {
    setNumberOfTrialsInternal(trials);
    setProbabilityOfSuccessInternal(p);
  }
  
  public int getNumberOfTrials()
  {
    return numberOfTrials;
  }
  
  public double getProbabilityOfSuccess()
  {
    return probabilityOfSuccess;
  }
  
  @Deprecated
  public void setNumberOfTrials(int trials)
  {
    setNumberOfTrialsInternal(trials);
  }
  
  private void setNumberOfTrialsInternal(int trials)
  {
    if (trials < 0) {
      throw MathRuntimeException.createIllegalArgumentException("number of trials must be non-negative ({0})", new Object[] { Integer.valueOf(trials) });
    }
    numberOfTrials = trials;
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
    return numberOfTrials;
  }
  
  public double cumulativeProbability(int x)
    throws MathException
  {
    double ret;
    double ret;
    if (x < 0)
    {
      ret = 0.0D;
    }
    else
    {
      double ret;
      if (x >= numberOfTrials) {
        ret = 1.0D;
      } else {
        ret = 1.0D - Beta.regularizedBeta(getProbabilityOfSuccess(), x + 1.0D, numberOfTrials - x);
      }
    }
    return ret;
  }
  
  public double probability(int x)
  {
    double ret;
    double ret;
    if ((x < 0) || (x > numberOfTrials)) {
      ret = 0.0D;
    } else {
      ret = Math.exp(SaddlePointExpansion.logBinomialProbability(x, numberOfTrials, probabilityOfSuccess, 1.0D - probabilityOfSuccess));
    }
    return ret;
  }
  
  public int inverseCumulativeProbability(double p)
    throws MathException
  {
    if (p == 0.0D) {
      return -1;
    }
    if (p == 1.0D) {
      return Integer.MAX_VALUE;
    }
    return super.inverseCumulativeProbability(p);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.BinomialDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */