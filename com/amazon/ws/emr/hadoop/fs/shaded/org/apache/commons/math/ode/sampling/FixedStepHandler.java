package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;

public abstract interface FixedStepHandler
{
  public abstract void handleStep(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, boolean paramBoolean)
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.FixedStepHandler
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */