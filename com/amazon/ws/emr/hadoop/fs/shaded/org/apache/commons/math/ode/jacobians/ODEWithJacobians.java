package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;

public abstract interface ODEWithJacobians
  extends FirstOrderDifferentialEquations
{
  public abstract int getParametersDimension();
  
  public abstract void computeJacobians(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[][] paramArrayOfDouble3, double[][] paramArrayOfDouble4)
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.ODEWithJacobians
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */