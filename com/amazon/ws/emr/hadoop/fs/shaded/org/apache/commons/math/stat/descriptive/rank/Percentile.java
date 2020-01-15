package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.rank;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic;
import java.io.Serializable;
import java.util.Arrays;

public class Percentile
  extends AbstractUnivariateStatistic
  implements Serializable
{
  private static final long serialVersionUID = -8091216485095130416L;
  private double quantile = 0.0D;
  
  public Percentile()
  {
    this(50.0D);
  }
  
  public Percentile(double p)
  {
    setQuantile(p);
  }
  
  public Percentile(Percentile original)
  {
    copy(original, this);
  }
  
  public double evaluate(double[] values, double p)
  {
    test(values, 0, 0);
    return evaluate(values, 0, values.length, p);
  }
  
  public double evaluate(double[] values, int start, int length)
  {
    return evaluate(values, start, length, quantile);
  }
  
  public double evaluate(double[] values, int begin, int length, double p)
  {
    test(values, begin, length);
    if ((p > 100.0D) || (p <= 0.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("out of bounds quantile value: {0}, must be in (0, 100]", new Object[] { Double.valueOf(p) });
    }
    if (length == 0) {
      return NaN.0D;
    }
    if (length == 1) {
      return values[begin];
    }
    double n = length;
    double pos = p * (n + 1.0D) / 100.0D;
    double fpos = Math.floor(pos);
    int intPos = (int)fpos;
    double dif = pos - fpos;
    double[] sorted = new double[length];
    System.arraycopy(values, begin, sorted, 0, length);
    Arrays.sort(sorted);
    if (pos < 1.0D) {
      return sorted[0];
    }
    if (pos >= n) {
      return sorted[(length - 1)];
    }
    double lower = sorted[(intPos - 1)];
    double upper = sorted[intPos];
    return lower + dif * (upper - lower);
  }
  
  public double getQuantile()
  {
    return quantile;
  }
  
  public void setQuantile(double p)
  {
    if ((p <= 0.0D) || (p > 100.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("out of bounds quantile value: {0}, must be in (0, 100]", new Object[] { Double.valueOf(p) });
    }
    quantile = p;
  }
  
  public Percentile copy()
  {
    Percentile result = new Percentile();
    copy(this, result);
    return result;
  }
  
  public static void copy(Percentile source, Percentile dest)
  {
    quantile = quantile;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.rank.Percentile
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */