package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AbstractStorelessUnivariateStatistic;
import java.io.Serializable;

public class StandardDeviation
  extends AbstractStorelessUnivariateStatistic
  implements Serializable
{
  private static final long serialVersionUID = 5728716329662425188L;
  private Variance variance = null;
  
  public StandardDeviation()
  {
    variance = new Variance();
  }
  
  public StandardDeviation(SecondMoment m2)
  {
    variance = new Variance(m2);
  }
  
  public StandardDeviation(StandardDeviation original)
  {
    copy(original, this);
  }
  
  public StandardDeviation(boolean isBiasCorrected)
  {
    variance = new Variance(isBiasCorrected);
  }
  
  public StandardDeviation(boolean isBiasCorrected, SecondMoment m2)
  {
    variance = new Variance(isBiasCorrected, m2);
  }
  
  public void increment(double d)
  {
    variance.increment(d);
  }
  
  public long getN()
  {
    return variance.getN();
  }
  
  public double getResult()
  {
    return Math.sqrt(variance.getResult());
  }
  
  public void clear()
  {
    variance.clear();
  }
  
  public double evaluate(double[] values)
  {
    return Math.sqrt(variance.evaluate(values));
  }
  
  public double evaluate(double[] values, int begin, int length)
  {
    return Math.sqrt(variance.evaluate(values, begin, length));
  }
  
  public double evaluate(double[] values, double mean, int begin, int length)
  {
    return Math.sqrt(variance.evaluate(values, mean, begin, length));
  }
  
  public double evaluate(double[] values, double mean)
  {
    return Math.sqrt(variance.evaluate(values, mean));
  }
  
  public boolean isBiasCorrected()
  {
    return variance.isBiasCorrected();
  }
  
  public void setBiasCorrected(boolean isBiasCorrected)
  {
    variance.setBiasCorrected(isBiasCorrected);
  }
  
  public StandardDeviation copy()
  {
    StandardDeviation result = new StandardDeviation();
    copy(this, result);
    return result;
  }
  
  public static void copy(StandardDeviation source, StandardDeviation dest)
  {
    variance = variance.copy();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment.StandardDeviation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */