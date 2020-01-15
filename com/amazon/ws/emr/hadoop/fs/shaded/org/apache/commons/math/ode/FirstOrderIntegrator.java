package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

public abstract interface FirstOrderIntegrator
  extends ODEIntegrator
{
  public abstract double integrate(FirstOrderDifferentialEquations paramFirstOrderDifferentialEquations, double paramDouble1, double[] paramArrayOfDouble1, double paramDouble2, double[] paramArrayOfDouble2)
    throws DerivativeException, IntegratorException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */