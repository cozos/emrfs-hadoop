package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

class HarmonicFitter$ParametricHarmonicFunction
  implements ParametricRealFunction
{
  public double value(double x, double[] parameters)
  {
    double a = parameters[0];
    double omega = parameters[1];
    double phi = parameters[2];
    return a * Math.cos(omega * x + phi);
  }
  
  public double[] gradient(double x, double[] parameters)
  {
    double a = parameters[0];
    double omega = parameters[1];
    double phi = parameters[2];
    double alpha = omega * x + phi;
    double cosAlpha = Math.cos(alpha);
    double sinAlpha = Math.sin(alpha);
    return new double[] { cosAlpha, -a * x * sinAlpha, -a * sinAlpha };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.HarmonicFitter.ParametricHarmonicFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */