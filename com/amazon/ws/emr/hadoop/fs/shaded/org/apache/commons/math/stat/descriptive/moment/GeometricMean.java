package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.summary.SumOfLogs;
import java.io.Serializable;

public class GeometricMean
  extends AbstractStorelessUnivariateStatistic
  implements Serializable
{
  private static final long serialVersionUID = -8178734905303459453L;
  private StorelessUnivariateStatistic sumOfLogs;
  
  public GeometricMean()
  {
    sumOfLogs = new SumOfLogs();
  }
  
  public GeometricMean(GeometricMean original)
  {
    copy(original, this);
  }
  
  public GeometricMean(SumOfLogs sumOfLogs)
  {
    this.sumOfLogs = sumOfLogs;
  }
  
  public GeometricMean copy()
  {
    GeometricMean result = new GeometricMean();
    copy(this, result);
    return result;
  }
  
  public void increment(double d)
  {
    sumOfLogs.increment(d);
  }
  
  public double getResult()
  {
    if (sumOfLogs.getN() > 0L) {
      return Math.exp(sumOfLogs.getResult() / sumOfLogs.getN());
    }
    return NaN.0D;
  }
  
  public void clear()
  {
    sumOfLogs.clear();
  }
  
  public double evaluate(double[] values, int begin, int length)
  {
    return Math.exp(sumOfLogs.evaluate(values, begin, length) / length);
  }
  
  public long getN()
  {
    return sumOfLogs.getN();
  }
  
  public void setSumLogImpl(StorelessUnivariateStatistic sumLogImpl)
  {
    checkEmpty();
    sumOfLogs = sumLogImpl;
  }
  
  public StorelessUnivariateStatistic getSumLogImpl()
  {
    return sumOfLogs;
  }
  
  public static void copy(GeometricMean source, GeometricMean dest)
  {
    sumOfLogs = sumOfLogs.copy();
  }
  
  private void checkEmpty()
  {
    if (getN() > 0L) {
      throw MathRuntimeException.createIllegalStateException("{0} values have been added before statistic is configured", new Object[] { Long.valueOf(getN()) });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment.GeometricMean
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */