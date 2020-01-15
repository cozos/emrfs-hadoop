package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.BivariateRealFunction;

public abstract interface BivariateRealGridInterpolator
{
  public abstract BivariateRealFunction interpolate(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[][] paramArrayOfDouble)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.BivariateRealGridInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */