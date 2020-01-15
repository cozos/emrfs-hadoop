package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;

public class HarmonicFunction
  implements DifferentiableUnivariateRealFunction
{
  private final double a;
  private final double omega;
  private final double phi;
  
  public HarmonicFunction(double a, double omega, double phi)
  {
    this.a = a;
    this.omega = omega;
    this.phi = phi;
  }
  
  public double value(double x)
  {
    return a * Math.cos(omega * x + phi);
  }
  
  public HarmonicFunction derivative()
  {
    return new HarmonicFunction(a * omega, omega, phi + 1.5707963267948966D);
  }
  
  public double getAmplitude()
  {
    return a;
  }
  
  public double getPulsation()
  {
    return omega;
  }
  
  public double getPhase()
  {
    return phi;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.HarmonicFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */