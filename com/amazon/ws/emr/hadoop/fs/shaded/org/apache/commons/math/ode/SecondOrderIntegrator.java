package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

public abstract interface SecondOrderIntegrator
  extends ODEIntegrator
{
  public abstract void integrate(SecondOrderDifferentialEquations paramSecondOrderDifferentialEquations, double paramDouble1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4)
    throws DerivativeException, IntegratorException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.SecondOrderIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */