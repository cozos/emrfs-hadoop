package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateRealFunction;

public abstract interface MultivariateRealInterpolator
{
  public abstract MultivariateRealFunction interpolate(double[][] paramArrayOfDouble, double[] paramArrayOfDouble1)
    throws MathException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.MultivariateRealInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */