package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;
import java.io.Serializable;

public class StatisticalSummaryValues
  implements Serializable, StatisticalSummary
{
  private static final long serialVersionUID = -5108854841843722536L;
  private final double mean;
  private final double variance;
  private final long n;
  private final double max;
  private final double min;
  private final double sum;
  
  public StatisticalSummaryValues(double mean, double variance, long n, double max, double min, double sum)
  {
    this.mean = mean;
    this.variance = variance;
    this.n = n;
    this.max = max;
    this.min = min;
    this.sum = sum;
  }
  
  public double getMax()
  {
    return max;
  }
  
  public double getMean()
  {
    return mean;
  }
  
  public double getMin()
  {
    return min;
  }
  
  public long getN()
  {
    return n;
  }
  
  public double getSum()
  {
    return sum;
  }
  
  public double getStandardDeviation()
  {
    return Math.sqrt(variance);
  }
  
  public double getVariance()
  {
    return variance;
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if (!(object instanceof StatisticalSummaryValues)) {
      return false;
    }
    StatisticalSummaryValues stat = (StatisticalSummaryValues)object;
    return (MathUtils.equals(stat.getMax(), getMax())) && (MathUtils.equals(stat.getMean(), getMean())) && (MathUtils.equals(stat.getMin(), getMin())) && (MathUtils.equals(stat.getN(), getN())) && (MathUtils.equals(stat.getSum(), getSum())) && (MathUtils.equals(stat.getVariance(), getVariance()));
  }
  
  public int hashCode()
  {
    int result = 31 + MathUtils.hash(getMax());
    result = result * 31 + MathUtils.hash(getMean());
    result = result * 31 + MathUtils.hash(getMin());
    result = result * 31 + MathUtils.hash(getN());
    result = result * 31 + MathUtils.hash(getSum());
    result = result * 31 + MathUtils.hash(getVariance());
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.StatisticalSummaryValues
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */