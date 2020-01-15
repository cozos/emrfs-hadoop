package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;

public abstract interface StepHandler
{
  public abstract boolean requiresDenseOutput();
  
  public abstract void reset();
  
  public abstract void handleStep(StepInterpolator paramStepInterpolator, boolean paramBoolean)
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */