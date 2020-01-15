package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.ContinuedFraction;

final class Gamma$1
  extends ContinuedFraction
{
  Gamma$1(double paramDouble) {}
  
  protected double getA(int n, double x)
  {
    return 2.0D * n + 1.0D - val$a + x;
  }
  
  protected double getB(int n, double x)
  {
    return n * (val$a - n);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Gamma.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */