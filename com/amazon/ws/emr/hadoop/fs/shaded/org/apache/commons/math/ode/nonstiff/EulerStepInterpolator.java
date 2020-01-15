package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;

class EulerStepInterpolator
  extends RungeKuttaStepInterpolator
{
  private static final long serialVersionUID = -7179861704951334960L;
  
  public EulerStepInterpolator() {}
  
  public EulerStepInterpolator(EulerStepInterpolator interpolator)
  {
    super(interpolator);
  }
  
  protected StepInterpolator doCopy()
  {
    return new EulerStepInterpolator(this);
  }
  
  protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH)
    throws DerivativeException
  {
    for (int i = 0; i < interpolatedState.length; i++) {
      interpolatedState[i] = (currentState[i] - oneMinusThetaH * yDotK[0][i]);
    }
    System.arraycopy(yDotK[0], 0, interpolatedDerivatives, 0, interpolatedDerivatives.length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.EulerStepInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */