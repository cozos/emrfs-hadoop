package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Erf;
import java.io.Serializable;

public class NormalDistributionImpl
  extends AbstractContinuousDistribution
  implements NormalDistribution, Serializable
{
  public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9D;
  private static final long serialVersionUID = 8589540077390120676L;
  private static final double SQRT2PI = Math.sqrt(6.283185307179586D);
  private double mean = 0.0D;
  private double standardDeviation = 1.0D;
  private final double solverAbsoluteAccuracy;
  
  public NormalDistributionImpl(double mean, double sd)
  {
    this(mean, sd, 1.0E-9D);
  }
  
  public NormalDistributionImpl(double mean, double sd, double inverseCumAccuracy)
  {
    setMeanInternal(mean);
    setStandardDeviationInternal(sd);
    solverAbsoluteAccuracy = inverseCumAccuracy;
  }
  
  public NormalDistributionImpl()
  {
    this(0.0D, 1.0D);
  }
  
  public double getMean()
  {
    return mean;
  }
  
  @Deprecated
  public void setMean(double mean)
  {
    setMeanInternal(mean);
  }
  
  private void setMeanInternal(double newMean)
  {
    mean = newMean;
  }
  
  public double getStandardDeviation()
  {
    return standardDeviation;
  }
  
  @Deprecated
  public void setStandardDeviation(double sd)
  {
    setStandardDeviationInternal(sd);
  }
  
  private void setStandardDeviationInternal(double sd)
  {
    if (sd <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("standard deviation must be positive ({0})", new Object[] { Double.valueOf(sd) });
    }
    standardDeviation = sd;
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
    double x0 = x - mean;
    return Math.exp(-x0 * x0 / (2.0D * standardDeviation * standardDeviation)) / (standardDeviation * SQRT2PI);
  }
  
  public double cumulativeProbability(double x)
    throws MathException
  {
    try
    {
      return 0.5D * (1.0D + Erf.erf((x - mean) / (standardDeviation * Math.sqrt(2.0D))));
    }
    catch (MaxIterationsExceededException ex)
    {
      if (x < mean - 20.0D * standardDeviation) {
        return 0.0D;
      }
      if (x > mean + 20.0D * standardDeviation) {
        return 1.0D;
      }
      throw ex;
    }
  }
  
  protected double getSolverAbsoluteAccuracy()
  {
    return solverAbsoluteAccuracy;
  }
  
  public double inverseCumulativeProbability(double p)
    throws MathException
  {
    if (p == 0.0D) {
      return Double.NEGATIVE_INFINITY;
    }
    if (p == 1.0D) {
      return Double.POSITIVE_INFINITY;
    }
    return super.inverseCumulativeProbability(p);
  }
  
  protected double getDomainLowerBound(double p)
  {
    double ret;
    double ret;
    if (p < 0.5D) {
      ret = -1.7976931348623157E308D;
    } else {
      ret = mean;
    }
    return ret;
  }
  
  protected double getDomainUpperBound(double p)
  {
    double ret;
    double ret;
    if (p < 0.5D) {
      ret = mean;
    } else {
      ret = Double.MAX_VALUE;
    }
    return ret;
  }
  
  protected double getInitialDomain(double p)
  {
    double ret;
    double ret;
    if (p < 0.5D)
    {
      ret = mean - standardDeviation;
    }
    else
    {
      double ret;
      if (p > 0.5D) {
        ret = mean + standardDeviation;
      } else {
        ret = mean;
      }
    }
    return ret;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.NormalDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */