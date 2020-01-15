package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling;

public class DummyStepHandler
  implements StepHandler
{
  public static DummyStepHandler getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  public boolean requiresDenseOutput()
  {
    return false;
  }
  
  public void reset() {}
  
  public void handleStep(StepInterpolator interpolator, boolean isLast) {}
  
  private static class LazyHolder
  {
    private static final DummyStepHandler INSTANCE = new DummyStepHandler(null);
  }
  
  private Object readResolve()
  {
    return LazyHolder.INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.DummyStepHandler
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */