package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;

public abstract class AbstractStorelessUnivariateStatistic
  extends AbstractUnivariateStatistic
  implements StorelessUnivariateStatistic
{
  public double evaluate(double[] values)
  {
    if (values == null) {
      throw MathRuntimeException.createIllegalArgumentException("input values array is null", new Object[0]);
    }
    return evaluate(values, 0, values.length);
  }
  
  public double evaluate(double[] values, int begin, int length)
  {
    if (test(values, begin, length))
    {
      clear();
      incrementAll(values, begin, length);
    }
    return getResult();
  }
  
  public abstract StorelessUnivariateStatistic copy();
  
  public abstract void clear();
  
  public abstract double getResult();
  
  public abstract void increment(double paramDouble);
  
  public void incrementAll(double[] values)
  {
    if (values == null) {
      throw MathRuntimeException.createIllegalArgumentException("input values array is null", new Object[0]);
    }
    incrementAll(values, 0, values.length);
  }
  
  public void incrementAll(double[] values, int begin, int length)
  {
    if (test(values, begin, length))
    {
      int k = begin + length;
      for (int i = begin; i < k; i++) {
        increment(values[i]);
      }
    }
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if (!(object instanceof AbstractStorelessUnivariateStatistic)) {
      return false;
    }
    AbstractStorelessUnivariateStatistic stat = (AbstractStorelessUnivariateStatistic)object;
    return (MathUtils.equals(stat.getResult(), getResult())) && (MathUtils.equals(stat.getN(), getN()));
  }
  
  public int hashCode()
  {
    return 31 * (31 + MathUtils.hash(getResult())) + MathUtils.hash(getN());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */