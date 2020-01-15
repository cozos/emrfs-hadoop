package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Gamma;
import java.io.Serializable;

public class PoissonDistributionImpl
  extends AbstractIntegerDistribution
  implements PoissonDistribution, Serializable
{
  public static final int DEFAULT_MAX_ITERATIONS = 10000000;
  public static final double DEFAULT_EPSILON = 1.0E-12D;
  private static final long serialVersionUID = -3349935121172596109L;
  private NormalDistribution normal;
  private double mean;
  private int maxIterations = 10000000;
  private double epsilon = 1.0E-12D;
  
  public PoissonDistributionImpl(double p)
  {
    this(p, new NormalDistributionImpl());
  }
  
  public PoissonDistributionImpl(double p, double epsilon, int maxIterations)
  {
    setMean(p);
    this.epsilon = epsilon;
    this.maxIterations = maxIterations;
  }
  
  public PoissonDistributionImpl(double p, double epsilon)
  {
    setMean(p);
    this.epsilon = epsilon;
  }
  
  public PoissonDistributionImpl(double p, int maxIterations)
  {
    setMean(p);
    this.maxIterations = maxIterations;
  }
  
  @Deprecated
  public PoissonDistributionImpl(double p, NormalDistribution z)
  {
    setNormalAndMeanInternal(z, p);
  }
  
  public double getMean()
  {
    return mean;
  }
  
  @Deprecated
  public void setMean(double p)
  {
    setNormalAndMeanInternal(normal, p);
  }
  
  private void setNormalAndMeanInternal(NormalDistribution z, double p)
  {
    if (p <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("the Poisson mean must be positive ({0})", new Object[] { Double.valueOf(p) });
    }
    mean = p;
    normal = z;
    normal.setMean(p);
    normal.setStandardDeviation(Math.sqrt(p));
  }
  
  public double probability(int x)
  {
    double ret;
    double ret;
    if ((x < 0) || (x == Integer.MAX_VALUE))
    {
      ret = 0.0D;
    }
    else
    {
      double ret;
      if (x == 0) {
        ret = Math.exp(-mean);
      } else {
        ret = Math.exp(-SaddlePointExpansion.getStirlingError(x) - SaddlePointExpansion.getDeviancePart(x, mean)) / Math.sqrt(6.283185307179586D * x);
      }
    }
    return ret;
  }
  
  public double cumulativeProbability(int x)
    throws MathException
  {
    if (x < 0) {
      return 0.0D;
    }
    if (x == Integer.MAX_VALUE) {
      return 1.0D;
    }
    return Gamma.regularizedGammaQ(x + 1.0D, mean, epsilon, maxIterations);
  }
  
  public double normalApproximateProbability(int x)
    throws MathException
  {
    return normal.cumulativeProbability(x + 0.5D);
  }
  
  protected int getDomainLowerBound(double p)
  {
    return 0;
  }
  
  protected int getDomainUpperBound(double p)
  {
    return Integer.MAX_VALUE;
  }
  
  @Deprecated
  public void setNormal(NormalDistribution value)
  {
    setNormalAndMeanInternal(value, mean);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.PoissonDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */