package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;

public class StepNormalizer
  implements StepHandler
{
  private double h;
  private final FixedStepHandler handler;
  private double lastTime;
  private double[] lastState;
  private double[] lastDerivatives;
  private boolean forward;
  
  public StepNormalizer(double h, FixedStepHandler handler)
  {
    this.h = Math.abs(h);
    this.handler = handler;
    reset();
  }
  
  public boolean requiresDenseOutput()
  {
    return true;
  }
  
  public void reset()
  {
    lastTime = NaN.0D;
    lastState = null;
    lastDerivatives = null;
    forward = true;
  }
  
  public void handleStep(StepInterpolator interpolator, boolean isLast)
    throws DerivativeException
  {
    if (lastState == null)
    {
      lastTime = interpolator.getPreviousTime();
      interpolator.setInterpolatedTime(lastTime);
      lastState = ((double[])interpolator.getInterpolatedState().clone());
      lastDerivatives = ((double[])interpolator.getInterpolatedDerivatives().clone());
      
      forward = (interpolator.getCurrentTime() >= lastTime);
      if (!forward) {
        h = (-h);
      }
    }
    double nextTime = lastTime + h;
    boolean nextInStep = forward ^ nextTime > interpolator.getCurrentTime();
    while (nextInStep)
    {
      handler.handleStep(lastTime, lastState, lastDerivatives, false);
      
      lastTime = nextTime;
      interpolator.setInterpolatedTime(lastTime);
      System.arraycopy(interpolator.getInterpolatedState(), 0, lastState, 0, lastState.length);
      
      System.arraycopy(interpolator.getInterpolatedDerivatives(), 0, lastDerivatives, 0, lastDerivatives.length);
      
      nextTime += h;
      nextInStep = forward ^ nextTime > interpolator.getCurrentTime();
    }
    if (isLast) {
      handler.handleStep(lastTime, lastState, lastDerivatives, true);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepNormalizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */