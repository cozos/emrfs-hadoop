package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

public abstract class AbstractUnivariateStatistic
  implements UnivariateStatistic
{
  public double evaluate(double[] values)
  {
    test(values, 0, 0);
    return evaluate(values, 0, values.length);
  }
  
  public abstract double evaluate(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
  
  public abstract UnivariateStatistic copy();
  
  protected boolean test(double[] values, int begin, int length)
  {
    if (values == null) {
      throw MathRuntimeException.createIllegalArgumentException("input values array is null", new Object[0]);
    }
    if (begin < 0) {
      throw MathRuntimeException.createIllegalArgumentException("start position cannot be negative ({0})", new Object[] { Integer.valueOf(begin) });
    }
    if (length < 0) {
      throw MathRuntimeException.createIllegalArgumentException("length cannot be negative ({0})", new Object[] { Integer.valueOf(length) });
    }
    if (begin + length > values.length) {
      throw MathRuntimeException.createIllegalArgumentException("subarray ends after array end", new Object[0]);
    }
    if (length == 0) {
      return false;
    }
    return true;
  }
  
  protected boolean test(double[] values, double[] weights, int begin, int length)
  {
    if (weights == null) {
      throw MathRuntimeException.createIllegalArgumentException("input weights array is null", new Object[0]);
    }
    if (weights.length != values.length) {
      throw MathRuntimeException.createIllegalArgumentException("Different number of weights and values", new Object[0]);
    }
    boolean containsPositiveWeight = false;
    for (int i = begin; i < begin + length; i++)
    {
      if (Double.isNaN(weights[i])) {
        throw MathRuntimeException.createIllegalArgumentException("NaN weight at index {0}", new Object[] { Integer.valueOf(i) });
      }
      if (Double.isInfinite(weights[i])) {
        throw MathRuntimeException.createIllegalArgumentException("Infinite weight at index {0}", new Object[] { Integer.valueOf(i) });
      }
      if (weights[i] < 0.0D) {
        throw MathRuntimeException.createIllegalArgumentException("negative weight {0} at index {1} ", new Object[] { Double.valueOf(weights[i]), Integer.valueOf(i) });
      }
      if ((!containsPositiveWeight) && (weights[i] > 0.0D)) {
        containsPositiveWeight = true;
      }
    }
    if (!containsPositiveWeight) {
      throw MathRuntimeException.createIllegalArgumentException("weight array must contain at least one non-zero value", new Object[0]);
    }
    return test(values, begin, length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AbstractUnivariateStatistic
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */