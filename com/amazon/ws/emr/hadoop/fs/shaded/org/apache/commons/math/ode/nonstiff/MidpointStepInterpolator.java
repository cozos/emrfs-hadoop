package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;

class MidpointStepInterpolator
  extends RungeKuttaStepInterpolator
{
  private static final long serialVersionUID = -865524111506042509L;
  
  public MidpointStepInterpolator() {}
  
  public MidpointStepInterpolator(MidpointStepInterpolator interpolator)
  {
    super(interpolator);
  }
  
  protected StepInterpolator doCopy()
  {
    return new MidpointStepInterpolator(this);
  }
  
  protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH)
    throws DerivativeException
  {
    double coeff1 = oneMinusThetaH * theta;
    double coeff2 = oneMinusThetaH * (1.0D + theta);
    double coeffDot2 = 2.0D * theta;
    double coeffDot1 = 1.0D - coeffDot2;
    for (int i = 0; i < interpolatedState.length; i++)
    {
      double yDot1 = yDotK[0][i];
      double yDot2 = yDotK[1][i];
      interpolatedState[i] = (currentState[i] + coeff1 * yDot1 - coeff2 * yDot2);
      interpolatedDerivatives[i] = (coeffDot1 * yDot1 + coeffDot2 * yDot2);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.MidpointStepInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */