package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventHandler;

class AbstractIntegrator$EndTimeChecker
  implements EventHandler
{
  private final double endTime;
  
  public AbstractIntegrator$EndTimeChecker(double endTime)
  {
    this.endTime = endTime;
  }
  
  public int eventOccurred(double t, double[] y, boolean increasing)
  {
    return 0;
  }
  
  public double g(double t, double[] y)
  {
    return t - endTime;
  }
  
  public void resetState(double t, double[] y) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.AbstractIntegrator.EndTimeChecker
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */