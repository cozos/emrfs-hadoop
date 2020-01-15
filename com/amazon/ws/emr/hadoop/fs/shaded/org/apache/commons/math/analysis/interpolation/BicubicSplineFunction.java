package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.BivariateRealFunction;

class BicubicSplineFunction
  implements BivariateRealFunction
{
  private final double a00;
  private final double a01;
  private final double a02;
  private final double a03;
  private final double a10;
  private final double a11;
  private final double a12;
  private final double a13;
  private final double a20;
  private final double a21;
  private final double a22;
  private final double a23;
  private final double a30;
  private final double a31;
  private final double a32;
  private final double a33;
  
  public BicubicSplineFunction(double[] a)
  {
    a00 = a[0];
    a10 = a[1];
    a20 = a[2];
    a30 = a[3];
    a01 = a[4];
    a11 = a[5];
    a21 = a[6];
    a31 = a[7];
    a02 = a[8];
    a12 = a[9];
    a22 = a[10];
    a32 = a[11];
    a03 = a[12];
    a13 = a[13];
    a23 = a[14];
    a33 = a[15];
  }
  
  public double value(double x, double y)
  {
    if ((x < 0.0D) || (x > 1.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(x), Integer.valueOf(0), Integer.valueOf(1) });
    }
    if ((y < 0.0D) || (y > 1.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(y), Integer.valueOf(0), Integer.valueOf(1) });
    }
    double x2 = x * x;
    double x3 = x2 * x;
    double y2 = y * y;
    double y3 = y2 * y;
    
    return a00 + a01 * y + a02 * y2 + a03 * y3 + a10 * x + a11 * x * y + a12 * x * y2 + a13 * x * y3 + a20 * x2 + a21 * x2 * y + a22 * x2 * y2 + a23 * x2 * y3 + a30 * x3 + a31 * x3 * y + a32 * x3 * y2 + a33 * x3 * y3;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.BicubicSplineFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */