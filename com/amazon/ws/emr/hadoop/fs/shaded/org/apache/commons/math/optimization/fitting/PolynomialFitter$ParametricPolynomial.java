package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

class PolynomialFitter$ParametricPolynomial
  implements ParametricRealFunction
{
  public double[] gradient(double x, double[] parameters)
    throws FunctionEvaluationException
  {
    double[] gradient = new double[parameters.length];
    double xn = 1.0D;
    for (int i = 0; i < parameters.length; i++)
    {
      gradient[i] = xn;
      xn *= x;
    }
    return gradient;
  }
  
  public double value(double x, double[] parameters)
  {
    double y = 0.0D;
    for (int i = parameters.length - 1; i >= 0; i--) {
      y = y * x + parameters[i];
    }
    return y;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.PolynomialFitter.ParametricPolynomial
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */