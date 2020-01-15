package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public abstract interface UnivariateRealInterpolator
{
  public abstract UnivariateRealFunction interpolate(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */