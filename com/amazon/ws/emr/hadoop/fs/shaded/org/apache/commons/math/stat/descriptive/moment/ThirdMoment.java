package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment;

import java.io.Serializable;

public class ThirdMoment
  extends SecondMoment
  implements Serializable
{
  private static final long serialVersionUID = -7818711964045118679L;
  protected double m3;
  protected double nDevSq;
  
  public ThirdMoment()
  {
    m3 = NaN.0D;
    nDevSq = NaN.0D;
  }
  
  public ThirdMoment(ThirdMoment original)
  {
    copy(original, this);
  }
  
  public void increment(double d)
  {
    if (n < 1L) {
      m3 = (m2 = m1 = 0.0D);
    }
    double prevM2 = m2;
    super.increment(d);
    nDevSq = (nDev * nDev);
    double n0 = n;
    m3 = (m3 - 3.0D * nDev * prevM2 + (n0 - 1.0D) * (n0 - 2.0D) * nDevSq * dev);
  }
  
  public double getResult()
  {
    return m3;
  }
  
  public void clear()
  {
    super.clear();
    m3 = NaN.0D;
    nDevSq = NaN.0D;
  }
  
  public ThirdMoment copy()
  {
    ThirdMoment result = new ThirdMoment();
    copy(this, result);
    return result;
  }
  
  public static void copy(ThirdMoment source, ThirdMoment dest)
  {
    SecondMoment.copy(source, dest);
    m3 = m3;
    nDevSq = nDevSq;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment.ThirdMoment
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */