package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.complex;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

public class ComplexUtils
{
  public static Complex polar2Complex(double r, double theta)
  {
    if (r < 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("negative complex module {0}", new Object[] { Double.valueOf(r) });
    }
    return new Complex(r * Math.cos(theta), r * Math.sin(theta));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.complex.ComplexUtils
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */