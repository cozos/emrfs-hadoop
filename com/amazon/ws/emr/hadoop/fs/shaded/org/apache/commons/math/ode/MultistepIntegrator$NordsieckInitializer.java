package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;

class MultistepIntegrator$NordsieckInitializer
  implements StepHandler
{
  private final int n;
  
  public MultistepIntegrator$NordsieckInitializer(MultistepIntegrator paramMultistepIntegrator, int n)
  {
    this.n = n;
  }
  
  public void handleStep(StepInterpolator interpolator, boolean isLast)
    throws DerivativeException
  {
    double prev = interpolator.getPreviousTime();
    double curr = interpolator.getCurrentTime();
    this$0.stepStart = prev;
    this$0.stepSize = ((curr - prev) / (MultistepIntegrator.access$000(this$0) + 1));
    
    interpolator.setInterpolatedTime(prev);
    this$0.scaled = ((double[])interpolator.getInterpolatedDerivatives().clone());
    for (int j = 0; j < n; j++) {
      this$0.scaled[j] *= this$0.stepSize;
    }
    double[][] multistep = new double[MultistepIntegrator.access$000(this$0)][];
    for (int i = 1; i <= MultistepIntegrator.access$000(this$0); i++)
    {
      interpolator.setInterpolatedTime(prev + this$0.stepSize * i);
      double[] msI = (double[])interpolator.getInterpolatedDerivatives().clone();
      for (int j = 0; j < n; j++) {
        msI[j] *= this$0.stepSize;
      }
      multistep[(i - 1)] = msI;
    }
    this$0.nordsieck = this$0.initializeHighOrderDerivatives(this$0.scaled, multistep);
    
    throw new MultistepIntegrator.InitializationCompletedMarkerException();
  }
  
  public boolean requiresDenseOutput()
  {
    return true;
  }
  
  public void reset() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.MultistepIntegrator.NordsieckInitializer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */