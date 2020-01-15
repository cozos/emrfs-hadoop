package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public class ExponentialDistributionImpl
  extends AbstractContinuousDistribution
  implements ExponentialDistribution, Serializable
{
  public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9D;
  private static final long serialVersionUID = 2401296428283614780L;
  private double mean;
  private final double solverAbsoluteAccuracy;
  
  public ExponentialDistributionImpl(double mean)
  {
    this(mean, 1.0E-9D);
  }
  
  public ExponentialDistributionImpl(double mean, double inverseCumAccuracy)
  {
    setMeanInternal(mean);
    solverAbsoluteAccuracy = inverseCumAccuracy;
  }
  
  @Deprecated
  public void setMean(double mean)
  {
    setMeanInternal(mean);
  }
  
  private void setMeanInternal(double newMean)
  {
    if (newMean <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("mean must be positive ({0})", new Object[] { Double.valueOf(newMean) });
    }
    mean = newMean;
  }
  
  public double getMean()
  {
    return mean;
  }
  
  /**
   * @deprecated
   */
  public double density(Double x)
  {
    return density(x.doubleValue());
  }
  
  public double density(double x)
  {
    if (x < 0.0D) {
      return 0.0D;
    }
    return Math.exp(-x / mean) / mean;
  }
  
  public double cumulativeProbability(double x)
    throws MathException
  {
    double ret;
    double ret;
    if (x <= 0.0D) {
      ret = 0.0D;
    } else {
      ret = 1.0D - Math.exp(-x / mean);
    }
    return ret;
  }
  
  public double inverseCumulativeProbability(double p)
    throws MathException
  {
    if ((p < 0.0D) || (p > 1.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(p), Double.valueOf(0.0D), Double.valueOf(1.0D) });
    }
    double ret;
    double ret;
    if (p == 1.0D) {
      ret = Double.POSITIVE_INFINITY;
    } else {
      ret = -mean * Math.log(1.0D - p);
    }
    return ret;
  }
  
  protected double getDomainLowerBound(double p)
  {
    return 0.0D;
  }
  
  protected double getDomainUpperBound(double p)
  {
    if (p < 0.5D) {
      return mean;
    }
    return Double.MAX_VALUE;
  }
  
  protected double getInitialDomain(double p)
  {
    if (p < 0.5D) {
      return mean * 0.5D;
    }
    return mean;
  }
  
  protected double getSolverAbsoluteAccuracy()
  {
    return solverAbsoluteAccuracy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.ExponentialDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */