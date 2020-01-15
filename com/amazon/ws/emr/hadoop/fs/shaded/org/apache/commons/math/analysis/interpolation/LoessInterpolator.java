package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialSplineFunction;
import java.io.Serializable;
import java.util.Arrays;

public class LoessInterpolator
  implements UnivariateRealInterpolator, Serializable
{
  public static final double DEFAULT_BANDWIDTH = 0.3D;
  public static final int DEFAULT_ROBUSTNESS_ITERS = 2;
  public static final double DEFAULT_ACCURACY = 1.0E-12D;
  private static final long serialVersionUID = 5204927143605193821L;
  private final double bandwidth;
  private final int robustnessIters;
  private final double accuracy;
  
  public LoessInterpolator()
  {
    bandwidth = 0.3D;
    robustnessIters = 2;
    accuracy = 1.0E-12D;
  }
  
  public LoessInterpolator(double bandwidth, int robustnessIters)
    throws MathException
  {
    this(bandwidth, robustnessIters, 1.0E-12D);
  }
  
  public LoessInterpolator(double bandwidth, int robustnessIters, double accuracy)
    throws MathException
  {
    if ((bandwidth < 0.0D) || (bandwidth > 1.0D)) {
      throw new MathException("bandwidth must be in the interval [0,1], but got {0}", new Object[] { Double.valueOf(bandwidth) });
    }
    this.bandwidth = bandwidth;
    if (robustnessIters < 0) {
      throw new MathException("the number of robustness iterations must be non-negative, but got {0}", new Object[] { Integer.valueOf(robustnessIters) });
    }
    this.robustnessIters = robustnessIters;
    this.accuracy = accuracy;
  }
  
  public final PolynomialSplineFunction interpolate(double[] xval, double[] yval)
    throws MathException
  {
    return new SplineInterpolator().interpolate(xval, smooth(xval, yval));
  }
  
  public final double[] smooth(double[] xval, double[] yval, double[] weights)
    throws MathException
  {
    if (xval.length != yval.length) {
      throw new MathException("Loess expects the abscissa and ordinate arrays to be of the same size, but got {0} abscissae and {1} ordinatae", new Object[] { Integer.valueOf(xval.length), Integer.valueOf(yval.length) });
    }
    int n = xval.length;
    if (n == 0) {
      throw new MathException("Loess expects at least 1 point", new Object[0]);
    }
    checkAllFiniteReal(xval, "all abscissae must be finite real numbers, but {0}-th is {1}");
    checkAllFiniteReal(yval, "all ordinatae must be finite real numbers, but {0}-th is {1}");
    checkAllFiniteReal(weights, "all weights must be finite real numbers, but {0}-th is {1}");
    
    checkStrictlyIncreasing(xval);
    if (n == 1) {
      return new double[] { yval[0] };
    }
    if (n == 2) {
      return new double[] { yval[0], yval[1] };
    }
    int bandwidthInPoints = (int)(bandwidth * n);
    if (bandwidthInPoints < 2) {
      throw new MathException("the bandwidth must be large enough to accomodate at least 2 points. There are {0}  data points, and bandwidth must be at least {1}  but it is only {2}", new Object[] { Integer.valueOf(n), Double.valueOf(2.0D / n), Double.valueOf(bandwidth) });
    }
    double[] res = new double[n];
    
    double[] residuals = new double[n];
    double[] sortedResiduals = new double[n];
    
    double[] robustnessWeights = new double[n];
    
    Arrays.fill(robustnessWeights, 1.0D);
    for (int iter = 0; iter <= robustnessIters; iter++)
    {
      int[] bandwidthInterval = { 0, bandwidthInPoints - 1 };
      for (int i = 0; i < n; i++)
      {
        double x = xval[i];
        if (i > 0) {
          updateBandwidthInterval(xval, weights, i, bandwidthInterval);
        }
        int ileft = bandwidthInterval[0];
        int iright = bandwidthInterval[1];
        int edge;
        int edge;
        if (xval[i] - xval[ileft] > xval[iright] - xval[i]) {
          edge = ileft;
        } else {
          edge = iright;
        }
        double sumWeights = 0.0D;
        double sumX = 0.0D;
        double sumXSquared = 0.0D;
        double sumY = 0.0D;
        double sumXY = 0.0D;
        double denom = Math.abs(1.0D / (xval[edge] - x));
        for (int k = ileft; k <= iright; k++)
        {
          double xk = xval[k];
          double yk = yval[k];
          double dist = k < i ? x - xk : xk - x;
          double w = tricube(dist * denom) * robustnessWeights[k] * weights[k];
          double xkw = xk * w;
          sumWeights += w;
          sumX += xkw;
          sumXSquared += xk * xkw;
          sumY += yk * w;
          sumXY += yk * xkw;
        }
        double meanX = sumX / sumWeights;
        double meanY = sumY / sumWeights;
        double meanXY = sumXY / sumWeights;
        double meanXSquared = sumXSquared / sumWeights;
        double beta;
        double beta;
        if (Math.sqrt(Math.abs(meanXSquared - meanX * meanX)) < accuracy) {
          beta = 0.0D;
        } else {
          beta = (meanXY - meanX * meanY) / (meanXSquared - meanX * meanX);
        }
        double alpha = meanY - beta * meanX;
        
        res[i] = (beta * x + alpha);
        residuals[i] = Math.abs(yval[i] - res[i]);
      }
      if (iter == robustnessIters) {
        break;
      }
      System.arraycopy(residuals, 0, sortedResiduals, 0, n);
      Arrays.sort(sortedResiduals);
      double medianResidual = sortedResiduals[(n / 2)];
      if (Math.abs(medianResidual) < accuracy) {
        break;
      }
      for (int i = 0; i < n; i++)
      {
        double arg = residuals[i] / (6.0D * medianResidual);
        if (arg >= 1.0D)
        {
          robustnessWeights[i] = 0.0D;
        }
        else
        {
          double w = 1.0D - arg * arg;
          robustnessWeights[i] = (w * w);
        }
      }
    }
    return res;
  }
  
  public final double[] smooth(double[] xval, double[] yval)
    throws MathException
  {
    if (xval.length != yval.length) {
      throw new MathException("Loess expects the abscissa and ordinate arrays to be of the same size, but got {0} abscissae and {1} ordinatae", new Object[] { Integer.valueOf(xval.length), Integer.valueOf(yval.length) });
    }
    double[] unitWeights = new double[xval.length];
    Arrays.fill(unitWeights, 1.0D);
    
    return smooth(xval, yval, unitWeights);
  }
  
  private static void updateBandwidthInterval(double[] xval, double[] weights, int i, int[] bandwidthInterval)
  {
    int left = bandwidthInterval[0];
    int right = bandwidthInterval[1];
    
    int nextRight = nextNonzero(weights, right);
    if ((nextRight < xval.length) && (xval[nextRight] - xval[i] < xval[i] - xval[left]))
    {
      int nextLeft = nextNonzero(weights, bandwidthInterval[0]);
      bandwidthInterval[0] = nextLeft;
      bandwidthInterval[1] = nextRight;
    }
  }
  
  private static int nextNonzero(double[] weights, int i)
  {
    int j = i + 1;
    while ((j < weights.length) && (weights[j] == 0.0D)) {
      j++;
    }
    return j;
  }
  
  private static double tricube(double x)
  {
    double tmp = 1.0D - x * x * x;
    return tmp * tmp * tmp;
  }
  
  private static void checkAllFiniteReal(double[] values, String pattern)
    throws MathException
  {
    for (int i = 0; i < values.length; i++)
    {
      double x = values[i];
      if ((Double.isInfinite(x)) || (Double.isNaN(x))) {
        throw new MathException(pattern, new Object[] { Integer.valueOf(i), Double.valueOf(x) });
      }
    }
  }
  
  private static void checkStrictlyIncreasing(double[] xval)
    throws MathException
  {
    for (int i = 0; i < xval.length; i++) {
      if ((i >= 1) && (xval[(i - 1)] >= xval[i])) {
        throw new MathException("the abscissae array must be sorted in a strictly increasing order, but the {0}-th element is {1} whereas {2}-th is {3}", new Object[] { Integer.valueOf(i - 1), Double.valueOf(xval[(i - 1)]), Integer.valueOf(i), Double.valueOf(xval[i]) });
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.LoessInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */