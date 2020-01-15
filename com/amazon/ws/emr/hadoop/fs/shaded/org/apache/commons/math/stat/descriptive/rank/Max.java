package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.rank;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic;
import java.io.Serializable;

public class Max
  extends AbstractStorelessUnivariateStatistic
  implements Serializable
{
  private static final long serialVersionUID = -5593383832225844641L;
  private long n;
  private double value;
  
  public Max()
  {
    n = 0L;
    value = NaN.0D;
  }
  
  public Max(Max original)
  {
    copy(original, this);
  }
  
  public void increment(double d)
  {
    if ((d > value) || (Double.isNaN(value))) {
      value = d;
    }
    n += 1L;
  }
  
  public void clear()
  {
    value = NaN.0D;
    n = 0L;
  }
  
  public double getResult()
  {
    return value;
  }
  
  public long getN()
  {
    return n;
  }
  
  public double evaluate(double[] values, int begin, int length)
  {
    double max = NaN.0D;
    if (test(values, begin, length))
    {
      max = values[begin];
      for (int i = begin; i < begin + length; i++) {
        if (!Double.isNaN(values[i])) {
          max = max > values[i] ? max : values[i];
        }
      }
    }
    return max;
  }
  
  public Max copy()
  {
    Max result = new Max();
    copy(this, result);
    return result;
  }
  
  public static void copy(Max source, Max dest)
  {
    n = n;
    value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.rank.Max
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */