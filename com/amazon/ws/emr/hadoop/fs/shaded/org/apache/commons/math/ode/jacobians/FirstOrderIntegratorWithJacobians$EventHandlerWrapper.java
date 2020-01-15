package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventHandler;

class FirstOrderIntegratorWithJacobians$EventHandlerWrapper
  implements EventHandler
{
  private final EventHandlerWithJacobians handler;
  private double[] y;
  private double[][] dydy0;
  private double[][] dydp;
  
  public FirstOrderIntegratorWithJacobians$EventHandlerWrapper(EventHandlerWithJacobians handler, int n, int k)
  {
    this.handler = handler;
    y = new double[n];
    dydy0 = new double[n][n];
    dydp = new double[n][k];
  }
  
  public EventHandlerWithJacobians getHandler()
  {
    return handler;
  }
  
  public int eventOccurred(double t, double[] z, boolean increasing)
    throws EventException
  {
    FirstOrderIntegratorWithJacobians.access$300(z, y, dydy0, dydp);
    return handler.eventOccurred(t, y, dydy0, dydp, increasing);
  }
  
  public double g(double t, double[] z)
    throws EventException
  {
    FirstOrderIntegratorWithJacobians.access$300(z, y, dydy0, dydp);
    return handler.g(t, y, dydy0, dydp);
  }
  
  public void resetState(double t, double[] z)
    throws EventException
  {
    FirstOrderIntegratorWithJacobians.access$300(z, y, dydy0, dydp);
    handler.resetState(t, y, dydy0, dydp);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.FirstOrderIntegratorWithJacobians.EventHandlerWrapper
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */