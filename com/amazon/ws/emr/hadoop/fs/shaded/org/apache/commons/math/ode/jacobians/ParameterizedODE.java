package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;

public abstract interface ParameterizedODE
  extends FirstOrderDifferentialEquations
{
  public abstract int getParametersDimension();
  
  public abstract void setParameter(int paramInt, double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.ParameterizedODE
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */