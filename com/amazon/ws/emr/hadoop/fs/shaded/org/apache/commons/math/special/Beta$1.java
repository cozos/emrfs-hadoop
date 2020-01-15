package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.ContinuedFraction;

final class Beta$1
  extends ContinuedFraction
{
  Beta$1(double paramDouble1, double paramDouble2) {}
  
  protected double getB(int n, double x)
  {
    double ret;
    double ret;
    if (n % 2 == 0)
    {
      double m = n / 2.0D;
      ret = m * (val$b - m) * x / ((val$a + 2.0D * m - 1.0D) * (val$a + 2.0D * m));
    }
    else
    {
      double m = (n - 1.0D) / 2.0D;
      ret = -((val$a + m) * (val$a + val$b + m) * x) / ((val$a + 2.0D * m) * (val$a + 2.0D * m + 1.0D));
    }
    return ret;
  }
  
  protected double getA(int n, double x)
  {
    return 1.0D;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Beta.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */