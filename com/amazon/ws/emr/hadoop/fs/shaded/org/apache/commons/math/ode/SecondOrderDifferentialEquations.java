package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

public abstract interface SecondOrderDifferentialEquations
{
  public abstract int getDimension();
  
  public abstract void computeSecondDerivatives(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.SecondOrderDifferentialEquations
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */