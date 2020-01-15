package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

public abstract interface FirstOrderDifferentialEquations
{
  public abstract int getDimension();
  
  public abstract void computeDerivatives(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */