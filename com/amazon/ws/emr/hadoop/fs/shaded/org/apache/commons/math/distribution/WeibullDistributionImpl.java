package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public class WeibullDistributionImpl
  extends AbstractContinuousDistribution
  implements WeibullDistribution, Serializable
{
  public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9D;
  private static final long serialVersionUID = 8589540077390120676L;
  private double shape;
  private double scale;
  private final double solverAbsoluteAccuracy;
  
  public WeibullDistributionImpl(double alpha, double beta)
  {
    this(alpha, beta, 1.0E-9D);
  }
  
  public WeibullDistributionImpl(double alpha, double beta, double inverseCumAccuracy)
  {
    setShapeInternal(alpha);
    setScaleInternal(beta);
    solverAbsoluteAccuracy = inverseCumAccuracy;
  }
  
  public double cumulativeProbability(double x)
  {
    double ret;
    double ret;
    if (x <= 0.0D) {
      ret = 0.0D;
    } else {
      ret = 1.0D - Math.exp(-Math.pow(x / scale, shape));
    }
    return ret;
  }
  
  public double getShape()
  {
    return shape;
  }
  
  public double getScale()
  {
    return scale;
  }
  
  public double density(double x)
  {
    if (x < 0.0D) {
      return 0.0D;
    }
    double xscale = x / scale;
    double xscalepow = Math.pow(xscale, shape - 1.0D);
    
    double xscalepowshape = xscalepow * xscale;
    
    return shape / scale * xscalepow * Math.exp(-xscalepowshape);
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
      ret = 0.0D;
    }
    else
    {
      double ret;
      if (p == 1.0D) {
        ret = Double.POSITIVE_INFINITY;
      } else {
        ret = scale * Math.pow(-Math.log(1.0D - p), 1.0D / shape);
      }
    }
    return ret;
  }
  
  @Deprecated
  public void setShape(double alpha)
  {
    setShapeInternal(alpha);
  }
  
  private void setShapeInternal(double alpha)
  {
    if (alpha <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("shape must be positive ({0})", new Object[] { Double.valueOf(alpha) });
    }
    shape = alpha;
  }
  
  @Deprecated
  public void setScale(double beta)
  {
    setScaleInternal(beta);
  }
  
  private void setScaleInternal(double beta)
  {
    if (beta <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("scale must be positive ({0})", new Object[] { Double.valueOf(beta) });
    }
    scale = beta;
  }
  
  protected double getDomainLowerBound(double p)
  {
    return 0.0D;
  }
  
  protected double getDomainUpperBound(double p)
  {
    return Double.MAX_VALUE;
  }
  
  protected double getInitialDomain(double p)
  {
    return Math.pow(scale * Math.log(2.0D), 1.0D / shape);
  }
  
  protected double getSolverAbsoluteAccuracy()
  {
    return solverAbsoluteAccuracy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.WeibullDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */