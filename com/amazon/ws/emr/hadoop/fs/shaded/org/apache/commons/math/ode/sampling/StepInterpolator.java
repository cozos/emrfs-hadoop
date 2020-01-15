package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import java.io.Externalizable;

public abstract interface StepInterpolator
  extends Externalizable
{
  public abstract double getPreviousTime();
  
  public abstract double getCurrentTime();
  
  public abstract double getInterpolatedTime();
  
  public abstract void setInterpolatedTime(double paramDouble);
  
  public abstract double[] getInterpolatedState()
    throws DerivativeException;
  
  public abstract double[] getInterpolatedDerivatives()
    throws DerivativeException;
  
  public abstract boolean isForward();
  
  public abstract StepInterpolator copy()
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */