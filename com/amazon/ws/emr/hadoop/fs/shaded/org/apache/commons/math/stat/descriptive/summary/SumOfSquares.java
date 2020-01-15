package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.summary;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic;
import java.io.Serializable;

public class SumOfSquares
  extends AbstractStorelessUnivariateStatistic
  implements Serializable
{
  private static final long serialVersionUID = 1460986908574398008L;
  private long n;
  private double value;
  
  public SumOfSquares()
  {
    n = 0L;
    value = NaN.0D;
  }
  
  public SumOfSquares(SumOfSquares original)
  {
    copy(original, this);
  }
  
  public void increment(double d)
  {
    if (n == 0L) {
      value = (d * d);
    } else {
      value += d * d;
    }
    n += 1L;
  }
  
  public double getResult()
  {
    return value;
  }
  
  public long getN()
  {
    return n;
  }
  
  public void clear()
  {
    value = NaN.0D;
    n = 0L;
  }
  
  public double evaluate(double[] values, int begin, int length)
  {
    double sumSq = NaN.0D;
    if (test(values, begin, length))
    {
      sumSq = 0.0D;
      for (int i = begin; i < begin + length; i++) {
        sumSq += values[i] * values[i];
      }
    }
    return sumSq;
  }
  
  public SumOfSquares copy()
  {
    SumOfSquares result = new SumOfSquares();
    copy(this, result);
    return result;
  }
  
  public static void copy(SumOfSquares source, SumOfSquares dest)
  {
    n = n;
    value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.summary.SumOfSquares
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */