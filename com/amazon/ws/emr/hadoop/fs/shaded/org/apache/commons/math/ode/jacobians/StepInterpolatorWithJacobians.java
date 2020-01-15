package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import java.io.Externalizable;

public abstract interface StepInterpolatorWithJacobians
  extends Externalizable
{
  public abstract double getPreviousTime();
  
  public abstract double getCurrentTime();
  
  public abstract double getInterpolatedTime();
  
  public abstract void setInterpolatedTime(double paramDouble);
  
  public abstract double[] getInterpolatedY()
    throws DerivativeException;
  
  public abstract double[][] getInterpolatedDyDy0()
    throws DerivativeException;
  
  public abstract double[][] getInterpolatedDyDp()
    throws DerivativeException;
  
  public abstract double[] getInterpolatedYDot()
    throws DerivativeException;
  
  public abstract double[][] getInterpolatedDyDy0Dot()
    throws DerivativeException;
  
  public abstract double[][] getInterpolatedDyDpDot()
    throws DerivativeException;
  
  public abstract boolean isForward();
  
  public abstract StepInterpolatorWithJacobians copy()
    throws DerivativeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */