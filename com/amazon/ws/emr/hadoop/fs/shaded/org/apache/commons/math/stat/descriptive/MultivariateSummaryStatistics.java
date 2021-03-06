package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.DimensionMismatchException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment.GeometricMean;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment.Mean;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment.VectorialCovariance;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.rank.Max;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.rank.Min;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.summary.Sum;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.summary.SumOfLogs;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.summary.SumOfSquares;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;
import java.io.Serializable;
import java.util.Arrays;

public class MultivariateSummaryStatistics
  implements StatisticalMultivariateSummary, Serializable
{
  private static final long serialVersionUID = 2271900808994826718L;
  private int k;
  private long n = 0L;
  private StorelessUnivariateStatistic[] sumImpl;
  private StorelessUnivariateStatistic[] sumSqImpl;
  private StorelessUnivariateStatistic[] minImpl;
  private StorelessUnivariateStatistic[] maxImpl;
  private StorelessUnivariateStatistic[] sumLogImpl;
  private StorelessUnivariateStatistic[] geoMeanImpl;
  private StorelessUnivariateStatistic[] meanImpl;
  private VectorialCovariance covarianceImpl;
  
  public MultivariateSummaryStatistics(int k, boolean isCovarianceBiasCorrected)
  {
    this.k = k;
    
    sumImpl = new StorelessUnivariateStatistic[k];
    sumSqImpl = new StorelessUnivariateStatistic[k];
    minImpl = new StorelessUnivariateStatistic[k];
    maxImpl = new StorelessUnivariateStatistic[k];
    sumLogImpl = new StorelessUnivariateStatistic[k];
    geoMeanImpl = new StorelessUnivariateStatistic[k];
    meanImpl = new StorelessUnivariateStatistic[k];
    for (int i = 0; i < k; i++)
    {
      sumImpl[i] = new Sum();
      sumSqImpl[i] = new SumOfSquares();
      minImpl[i] = new Min();
      maxImpl[i] = new Max();
      sumLogImpl[i] = new SumOfLogs();
      geoMeanImpl[i] = new GeometricMean();
      meanImpl[i] = new Mean();
    }
    covarianceImpl = new VectorialCovariance(k, isCovarianceBiasCorrected);
  }
  
  public void addValue(double[] value)
    throws DimensionMismatchException
  {
    checkDimension(value.length);
    for (int i = 0; i < k; i++)
    {
      double v = value[i];
      sumImpl[i].increment(v);
      sumSqImpl[i].increment(v);
      minImpl[i].increment(v);
      maxImpl[i].increment(v);
      sumLogImpl[i].increment(v);
      geoMeanImpl[i].increment(v);
      meanImpl[i].increment(v);
    }
    covarianceImpl.increment(value);
    n += 1L;
  }
  
  public int getDimension()
  {
    return k;
  }
  
  public long getN()
  {
    return n;
  }
  
  private double[] getResults(StorelessUnivariateStatistic[] stats)
  {
    double[] results = new double[stats.length];
    for (int i = 0; i < results.length; i++) {
      results[i] = stats[i].getResult();
    }
    return results;
  }
  
  public double[] getSum()
  {
    return getResults(sumImpl);
  }
  
  public double[] getSumSq()
  {
    return getResults(sumSqImpl);
  }
  
  public double[] getSumLog()
  {
    return getResults(sumLogImpl);
  }
  
  public double[] getMean()
  {
    return getResults(meanImpl);
  }
  
  public double[] getStandardDeviation()
  {
    double[] stdDev = new double[k];
    if (getN() < 1L)
    {
      Arrays.fill(stdDev, NaN.0D);
    }
    else if (getN() < 2L)
    {
      Arrays.fill(stdDev, 0.0D);
    }
    else
    {
      RealMatrix matrix = covarianceImpl.getResult();
      for (int i = 0; i < k; i++) {
        stdDev[i] = Math.sqrt(matrix.getEntry(i, i));
      }
    }
    return stdDev;
  }
  
  public RealMatrix getCovariance()
  {
    return covarianceImpl.getResult();
  }
  
  public double[] getMax()
  {
    return getResults(maxImpl);
  }
  
  public double[] getMin()
  {
    return getResults(minImpl);
  }
  
  public double[] getGeometricMean()
  {
    return getResults(geoMeanImpl);
  }
  
  public String toString()
  {
    StringBuffer outBuffer = new StringBuffer();
    outBuffer.append("MultivariateSummaryStatistics:\n");
    outBuffer.append("n: " + getN() + "\n");
    append(outBuffer, getMin(), "min: ", ", ", "\n");
    append(outBuffer, getMax(), "max: ", ", ", "\n");
    append(outBuffer, getMean(), "mean: ", ", ", "\n");
    append(outBuffer, getGeometricMean(), "geometric mean: ", ", ", "\n");
    append(outBuffer, getSumSq(), "sum of squares: ", ", ", "\n");
    append(outBuffer, getSumLog(), "sum of logarithms: ", ", ", "\n");
    append(outBuffer, getStandardDeviation(), "standard deviation: ", ", ", "\n");
    outBuffer.append("covariance: " + getCovariance().toString() + "\n");
    return outBuffer.toString();
  }
  
  private void append(StringBuffer buffer, double[] data, String prefix, String separator, String suffix)
  {
    buffer.append(prefix);
    for (int i = 0; i < data.length; i++)
    {
      if (i > 0) {
        buffer.append(separator);
      }
      buffer.append(data[i]);
    }
    buffer.append(suffix);
  }
  
  public void clear()
  {
    n = 0L;
    for (int i = 0; i < k; i++)
    {
      minImpl[i].clear();
      maxImpl[i].clear();
      sumImpl[i].clear();
      sumLogImpl[i].clear();
      sumSqImpl[i].clear();
      geoMeanImpl[i].clear();
      meanImpl[i].clear();
    }
    covarianceImpl.clear();
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if (!(object instanceof MultivariateSummaryStatistics)) {
      return false;
    }
    MultivariateSummaryStatistics stat = (MultivariateSummaryStatistics)object;
    return (MathUtils.equals(stat.getGeometricMean(), getGeometricMean())) && (MathUtils.equals(stat.getMax(), getMax())) && (MathUtils.equals(stat.getMean(), getMean())) && (MathUtils.equals(stat.getMin(), getMin())) && (MathUtils.equals(stat.getN(), getN())) && (MathUtils.equals(stat.getSum(), getSum())) && (MathUtils.equals(stat.getSumSq(), getSumSq())) && (MathUtils.equals(stat.getSumLog(), getSumLog())) && (stat.getCovariance().equals(getCovariance()));
  }
  
  public int hashCode()
  {
    int result = 31 + MathUtils.hash(getGeometricMean());
    result = result * 31 + MathUtils.hash(getGeometricMean());
    result = result * 31 + MathUtils.hash(getMax());
    result = result * 31 + MathUtils.hash(getMean());
    result = result * 31 + MathUtils.hash(getMin());
    result = result * 31 + MathUtils.hash(getN());
    result = result * 31 + MathUtils.hash(getSum());
    result = result * 31 + MathUtils.hash(getSumSq());
    result = result * 31 + MathUtils.hash(getSumLog());
    result = result * 31 + getCovariance().hashCode();
    return result;
  }
  
  private void setImpl(StorelessUnivariateStatistic[] newImpl, StorelessUnivariateStatistic[] oldImpl)
    throws DimensionMismatchException, IllegalStateException
  {
    checkEmpty();
    checkDimension(newImpl.length);
    System.arraycopy(newImpl, 0, oldImpl, 0, newImpl.length);
  }
  
  public StorelessUnivariateStatistic[] getSumImpl()
  {
    return (StorelessUnivariateStatistic[])sumImpl.clone();
  }
  
  public void setSumImpl(StorelessUnivariateStatistic[] sumImpl)
    throws DimensionMismatchException
  {
    setImpl(sumImpl, this.sumImpl);
  }
  
  public StorelessUnivariateStatistic[] getSumsqImpl()
  {
    return (StorelessUnivariateStatistic[])sumSqImpl.clone();
  }
  
  public void setSumsqImpl(StorelessUnivariateStatistic[] sumsqImpl)
    throws DimensionMismatchException
  {
    setImpl(sumsqImpl, sumSqImpl);
  }
  
  public StorelessUnivariateStatistic[] getMinImpl()
  {
    return (StorelessUnivariateStatistic[])minImpl.clone();
  }
  
  public void setMinImpl(StorelessUnivariateStatistic[] minImpl)
    throws DimensionMismatchException
  {
    setImpl(minImpl, this.minImpl);
  }
  
  public StorelessUnivariateStatistic[] getMaxImpl()
  {
    return (StorelessUnivariateStatistic[])maxImpl.clone();
  }
  
  public void setMaxImpl(StorelessUnivariateStatistic[] maxImpl)
    throws DimensionMismatchException
  {
    setImpl(maxImpl, this.maxImpl);
  }
  
  public StorelessUnivariateStatistic[] getSumLogImpl()
  {
    return (StorelessUnivariateStatistic[])sumLogImpl.clone();
  }
  
  public void setSumLogImpl(StorelessUnivariateStatistic[] sumLogImpl)
    throws DimensionMismatchException
  {
    setImpl(sumLogImpl, this.sumLogImpl);
  }
  
  public StorelessUnivariateStatistic[] getGeoMeanImpl()
  {
    return (StorelessUnivariateStatistic[])geoMeanImpl.clone();
  }
  
  public void setGeoMeanImpl(StorelessUnivariateStatistic[] geoMeanImpl)
    throws DimensionMismatchException
  {
    setImpl(geoMeanImpl, this.geoMeanImpl);
  }
  
  public StorelessUnivariateStatistic[] getMeanImpl()
  {
    return (StorelessUnivariateStatistic[])meanImpl.clone();
  }
  
  public void setMeanImpl(StorelessUnivariateStatistic[] meanImpl)
    throws DimensionMismatchException
  {
    setImpl(meanImpl, this.meanImpl);
  }
  
  private void checkEmpty()
  {
    if (n > 0L) {
      throw MathRuntimeException.createIllegalStateException("{0} values have been added before statistic is configured", new Object[] { Long.valueOf(n) });
    }
  }
  
  private void checkDimension(int dimension)
    throws DimensionMismatchException
  {
    if (dimension != k) {
      throw new DimensionMismatchException(dimension, k);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */