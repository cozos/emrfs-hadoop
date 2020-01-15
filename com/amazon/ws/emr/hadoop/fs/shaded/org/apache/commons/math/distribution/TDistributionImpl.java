package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Gamma;
import java.io.Serializable;

public class TDistributionImpl
  extends AbstractContinuousDistribution
  implements TDistribution, Serializable
{
  public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9D;
  private static final long serialVersionUID = -5852615386664158222L;
  private double degreesOfFreedom;
  private final double solverAbsoluteAccuracy;
  
  public TDistributionImpl(double degreesOfFreedom, double inverseCumAccuracy)
  {
    setDegreesOfFreedomInternal(degreesOfFreedom);
    solverAbsoluteAccuracy = inverseCumAccuracy;
  }
  
  public TDistributionImpl(double degreesOfFreedom)
  {
    this(degreesOfFreedom, 1.0E-9D);
  }
  
  @Deprecated
  public void setDegreesOfFreedom(double degreesOfFreedom)
  {
    setDegreesOfFreedomInternal(degreesOfFreedom);
  }
  
  private void setDegreesOfFreedomInternal(double newDegreesOfFreedom)
  {
    if (newDegreesOfFreedom <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("degrees of freedom must be positive ({0})", new Object[] { Double.valueOf(newDegreesOfFreedom) });
    }
    degreesOfFreedom = newDegreesOfFreedom;
  }
  
  public double getDegreesOfFreedom()
  {
    return degreesOfFreedom;
  }
  
  public double density(double x)
  {
    double n = degreesOfFreedom;
    double nPlus1Over2 = (n + 1.0D) / 2.0D;
    return Math.exp(Gamma.logGamma(nPlus1Over2) - 0.5D * (Math.log(3.141592653589793D) + Math.log(n)) - Gamma.logGamma(n / 2.0D) - nPlus1Over2 * Math.log(1.0D + x * x / n));
  }
  
  public double cumulativeProbability(double x)
    throws MathException
  {
    double ret;
    double ret;
    if (x == 0.0D)
    {
      ret = 0.5D;
    }
    else
    {
      double t = Beta.regularizedBeta(degreesOfFreedom / (degreesOfFreedom + x * x), 0.5D * degreesOfFreedom, 0.5D);
      double ret;
      if (x < 0.0D) {
        ret = 0.5D * t;
      } else {
        ret = 1.0D - 0.5D * t;
      }
    }
    return ret;
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
    return -1.7976931348623157E308D;
  }
  
  protected double getDomainUpperBound(double p)
  {
    return Double.MAX_VALUE;
  }
  
  protected double getInitialDomain(double p)
  {
    return 0.0D;
  }
  
  protected double getSolverAbsoluteAccuracy()
  {
    return solverAbsoluteAccuracy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.TDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */