package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;

class FirstOrderIntegratorWithJacobians$StepHandlerWrapper
  implements StepHandler
{
  private final StepHandlerWithJacobians handler;
  private final int n;
  private final int k;
  
  public FirstOrderIntegratorWithJacobians$StepHandlerWrapper(StepHandlerWithJacobians handler, int n, int k)
  {
    this.handler = handler;
    this.n = n;
    this.k = k;
  }
  
  public StepHandlerWithJacobians getHandler()
  {
    return handler;
  }
  
  public void handleStep(StepInterpolator interpolator, boolean isLast)
    throws DerivativeException
  {
    handler.handleStep(new FirstOrderIntegratorWithJacobians.StepInterpolatorWrapper(interpolator, n, k), isLast);
  }
  
  public boolean requiresDenseOutput()
  {
    return handler.requiresDenseOutput();
  }
  
  public void reset()
  {
    handler.reset();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.FirstOrderIntegratorWithJacobians.StepHandlerWrapper
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */