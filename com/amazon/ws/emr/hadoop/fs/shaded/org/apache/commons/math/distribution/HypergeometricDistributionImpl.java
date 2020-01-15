package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;
import java.io.Serializable;

public class HypergeometricDistributionImpl
  extends AbstractIntegerDistribution
  implements HypergeometricDistribution, Serializable
{
  private static final long serialVersionUID = -436928820673516179L;
  private int numberOfSuccesses;
  private int populationSize;
  private int sampleSize;
  
  public HypergeometricDistributionImpl(int populationSize, int numberOfSuccesses, int sampleSize)
  {
    if (numberOfSuccesses > populationSize) {
      throw MathRuntimeException.createIllegalArgumentException("number of successes ({0}) must be less than or equal to population size ({1})", new Object[] { Integer.valueOf(numberOfSuccesses), Integer.valueOf(populationSize) });
    }
    if (sampleSize > populationSize) {
      throw MathRuntimeException.createIllegalArgumentException("sample size ({0}) must be less than or equal to population size ({1})", new Object[] { Integer.valueOf(sampleSize), Integer.valueOf(populationSize) });
    }
    setPopulationSizeInternal(populationSize);
    setSampleSizeInternal(sampleSize);
    setNumberOfSuccessesInternal(numberOfSuccesses);
  }
  
  public double cumulativeProbability(int x)
  {
    int[] domain = getDomain(populationSize, numberOfSuccesses, sampleSize);
    double ret;
    double ret;
    if (x < domain[0])
    {
      ret = 0.0D;
    }
    else
    {
      double ret;
      if (x >= domain[1]) {
        ret = 1.0D;
      } else {
        ret = innerCumulativeProbability(domain[0], x, 1, populationSize, numberOfSuccesses, sampleSize);
      }
    }
    return ret;
  }
  
  private int[] getDomain(int n, int m, int k)
  {
    return new int[] { getLowerDomain(n, m, k), getUpperDomain(m, k) };
  }
  
  protected int getDomainLowerBound(double p)
  {
    return getLowerDomain(populationSize, numberOfSuccesses, sampleSize);
  }
  
  protected int getDomainUpperBound(double p)
  {
    return getUpperDomain(sampleSize, numberOfSuccesses);
  }
  
  private int getLowerDomain(int n, int m, int k)
  {
    return Math.max(0, m - (n - k));
  }
  
  public int getNumberOfSuccesses()
  {
    return numberOfSuccesses;
  }
  
  public int getPopulationSize()
  {
    return populationSize;
  }
  
  public int getSampleSize()
  {
    return sampleSize;
  }
  
  private int getUpperDomain(int m, int k)
  {
    return Math.min(k, m);
  }
  
  public double probability(int x)
  {
    int[] domain = getDomain(populationSize, numberOfSuccesses, sampleSize);
    double ret;
    double ret;
    if ((x < domain[0]) || (x > domain[1]))
    {
      ret = 0.0D;
    }
    else
    {
      double p = sampleSize / populationSize;
      double q = (populationSize - sampleSize) / populationSize;
      double p1 = SaddlePointExpansion.logBinomialProbability(x, numberOfSuccesses, p, q);
      
      double p2 = SaddlePointExpansion.logBinomialProbability(sampleSize - x, populationSize - numberOfSuccesses, p, q);
      
      double p3 = SaddlePointExpansion.logBinomialProbability(sampleSize, populationSize, p, q);
      
      ret = Math.exp(p1 + p2 - p3);
    }
    return ret;
  }
  
  private double probability(int n, int m, int k, int x)
  {
    return Math.exp(MathUtils.binomialCoefficientLog(m, x) + MathUtils.binomialCoefficientLog(n - m, k - x) - MathUtils.binomialCoefficientLog(n, k));
  }
  
  @Deprecated
  public void setNumberOfSuccesses(int num)
  {
    setNumberOfSuccessesInternal(num);
  }
  
  private void setNumberOfSuccessesInternal(int num)
  {
    if (num < 0) {
      throw MathRuntimeException.createIllegalArgumentException("number of successes must be non-negative ({0})", new Object[] { Integer.valueOf(num) });
    }
    numberOfSuccesses = num;
  }
  
  @Deprecated
  public void setPopulationSize(int size)
  {
    setPopulationSizeInternal(size);
  }
  
  private void setPopulationSizeInternal(int size)
  {
    if (size <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("population size must be positive ({0})", new Object[] { Integer.valueOf(size) });
    }
    populationSize = size;
  }
  
  @Deprecated
  public void setSampleSize(int size)
  {
    setSampleSizeInternal(size);
  }
  
  private void setSampleSizeInternal(int size)
  {
    if (size < 0) {
      throw MathRuntimeException.createIllegalArgumentException("sample size must be positive ({0})", new Object[] { Integer.valueOf(size) });
    }
    sampleSize = size;
  }
  
  public double upperCumulativeProbability(int x)
  {
    int[] domain = getDomain(populationSize, numberOfSuccesses, sampleSize);
    double ret;
    double ret;
    if (x < domain[0])
    {
      ret = 1.0D;
    }
    else
    {
      double ret;
      if (x > domain[1]) {
        ret = 0.0D;
      } else {
        ret = innerCumulativeProbability(domain[1], x, -1, populationSize, numberOfSuccesses, sampleSize);
      }
    }
    return ret;
  }
  
  private double innerCumulativeProbability(int x0, int x1, int dx, int n, int m, int k)
  {
    double ret = probability(n, m, k, x0);
    while (x0 != x1)
    {
      x0 += dx;
      ret += probability(n, m, k, x0);
    }
    return ret;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.HypergeometricDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */