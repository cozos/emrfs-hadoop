package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;

public abstract interface StepHandlerWithJacobians
{
  public abstract boolean requiresDenseOutput();
  
  public abstract void reset();
  
  public abstract void handleStep(StepInterpolatorWithJacobians paramStepInterpolatorWithJacobians, boolean paramBoolean)
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.StepHandlerWithJacobians
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */