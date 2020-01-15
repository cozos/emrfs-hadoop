package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public class CauchyDistributionImpl
  extends AbstractContinuousDistribution
  implements CauchyDistribution, Serializable
{
  public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9D;
  private static final long serialVersionUID = 8589540077390120676L;
  private double median = 0.0D;
  private double scale = 1.0D;
  private final double solverAbsoluteAccuracy;
  
  public CauchyDistributionImpl()
  {
    this(0.0D, 1.0D);
  }
  
  public CauchyDistributionImpl(double median, double s)
  {
    this(median, s, 1.0E-9D);
  }
  
  public CauchyDistributionImpl(double median, double s, double inverseCumAccuracy)
  {
    setMedianInternal(median);
    setScaleInternal(s);
    solverAbsoluteAccuracy = inverseCumAccuracy;
  }
  
  public double cumulativeProbability(double x)
  {
    return 0.5D + Math.atan((x - median) / scale) / 3.141592653589793D;
  }
  
  public double getMedian()
  {
    return median;
  }
  
  public double getScale()
  {
    return scale;
  }
  
  public double density(double x)
  {
    double dev = x - median;
    return 0.3183098861837907D * (scale / (dev * dev + scale * scale));
  }
  
  public double inverseCumulativeProbability(double p)
  {
    if ((p < 0.0D) || (p > 1.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(p), Double.valueOf(0.0D), Double.valueOf(1.0D) });
    }
    double ret;
    double ret;
    if (p == 0.0D)
    {
      ret = Double.NEGATIVE_INFINITY;
    }
    else
    {
      double ret;
      if (p == 1.0D) {
        ret = Double.POSITIVE_INFINITY;
      } else {
        ret = median + scale * Math.tan(3.141592653589793D * (p - 0.5D));
      }
    }
    return ret;
  }
  
  @Deprecated
  public void setMedian(double median)
  {
    setMedianInternal(median);
  }
  
  private void setMedianInternal(double newMedian)
  {
    median = newMedian;
  }
  
  @Deprecated
  public void setScale(double s)
  {
    setScaleInternal(s);
  }
  
  private void setScaleInternal(double s)
  {
    if (s <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("scale must be positive ({0})", new Object[] { Double.valueOf(s) });
    }
    scale = s;
  }
  
  protected double getDomainLowerBound(double p)
  {
    double ret;
    double ret;
    if (p < 0.5D) {
      ret = -1.7976931348623157E308D;
    } else {
      ret = median;
    }
    return ret;
  }
  
  protected double getDomainUpperBound(double p)
  {
    double ret;
    double ret;
    if (p < 0.5D) {
      ret = median;
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
      ret = median - scale;
    }
    else
    {
      double ret;
      if (p > 0.5D) {
        ret = median + scale;
      } else {
        ret = median;
      }
    }
    return ret;
  }
  
  protected double getSolverAbsoluteAccuracy()
  {
    return solverAbsoluteAccuracy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.CauchyDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */