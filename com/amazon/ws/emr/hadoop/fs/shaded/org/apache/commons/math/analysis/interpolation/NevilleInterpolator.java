package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialFunctionLagrangeForm;
import java.io.Serializable;

public class NevilleInterpolator
  implements UnivariateRealInterpolator, Serializable
{
  static final long serialVersionUID = 3003707660147873733L;
  
  public PolynomialFunctionLagrangeForm interpolate(double[] x, double[] y)
    throws MathException
  {
    return new PolynomialFunctionLagrangeForm(x, y);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.NevilleInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */