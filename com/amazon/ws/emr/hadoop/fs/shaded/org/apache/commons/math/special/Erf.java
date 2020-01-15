package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class Erf
{
  public static double erf(double x)
    throws MathException
  {
    double ret = Gamma.regularizedGammaP(0.5D, x * x, 1.0E-15D, 10000);
    if (x < 0.0D) {
      ret = -ret;
    }
    return ret;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Erf
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */