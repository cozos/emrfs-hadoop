package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;
import java.util.Collection;

public abstract interface ODEIntegrator
{
  public abstract String getName();
  
  public abstract void addStepHandler(StepHandler paramStepHandler);
  
  public abstract Collection<StepHandler> getStepHandlers();
  
  public abstract void clearStepHandlers();
  
  public abstract void addEventHandler(EventHandler paramEventHandler, double paramDouble1, double paramDouble2, int paramInt);
  
  public abstract Collection<EventHandler> getEventHandlers();
  
  public abstract void clearEventHandlers();
  
  public abstract double getCurrentStepStart();
  
  public abstract double getCurrentSignedStepsize();
  
  public abstract void setMaxEvaluations(int paramInt);
  
  public abstract int getMaxEvaluations();
  
  public abstract int getEvaluations();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.ODEIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */