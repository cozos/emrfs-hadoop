package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.CombinedEventsManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractIntegrator
  implements FirstOrderIntegrator
{
  protected Collection<StepHandler> stepHandlers;
  protected double stepStart;
  protected double stepSize;
  protected CombinedEventsManager eventsHandlersManager;
  private final String name;
  private int maxEvaluations;
  private int evaluations;
  private transient FirstOrderDifferentialEquations equations;
  
  public AbstractIntegrator(String name)
  {
    this.name = name;
    stepHandlers = new ArrayList();
    stepStart = NaN.0D;
    stepSize = NaN.0D;
    eventsHandlersManager = new CombinedEventsManager();
    setMaxEvaluations(-1);
    resetEvaluations();
  }
  
  protected AbstractIntegrator()
  {
    this(null);
  }
  
  public String getName()
  {
    return name;
  }
  
  public void addStepHandler(StepHandler handler)
  {
    stepHandlers.add(handler);
  }
  
  public Collection<StepHandler> getStepHandlers()
  {
    return Collections.unmodifiableCollection(stepHandlers);
  }
  
  public void clearStepHandlers()
  {
    stepHandlers.clear();
  }
  
  public void addEventHandler(EventHandler function, double maxCheckInterval, double convergence, int maxIterationCount)
  {
    eventsHandlersManager.addEventHandler(function, maxCheckInterval, convergence, maxIterationCount);
  }
  
  public Collection<EventHandler> getEventHandlers()
  {
    return eventsHandlersManager.getEventsHandlers();
  }
  
  public void clearEventHandlers()
  {
    eventsHandlersManager.clearEventsHandlers();
  }
  
  protected boolean requiresDenseOutput()
  {
    for (StepHandler handler : stepHandlers) {
      if (handler.requiresDenseOutput()) {
        return true;
      }
    }
    return false;
  }
  
  public double getCurrentStepStart()
  {
    return stepStart;
  }
  
  public double getCurrentSignedStepsize()
  {
    return stepSize;
  }
  
  public void setMaxEvaluations(int maxEvaluations)
  {
    this.maxEvaluations = (maxEvaluations < 0 ? Integer.MAX_VALUE : maxEvaluations);
  }
  
  public int getMaxEvaluations()
  {
    return maxEvaluations;
  }
  
  public int getEvaluations()
  {
    return evaluations;
  }
  
  protected void resetEvaluations()
  {
    evaluations = 0;
  }
  
  protected void setEquations(FirstOrderDifferentialEquations equations)
  {
    this.equations = equations;
  }
  
  public void computeDerivatives(double t, double[] y, double[] yDot)
    throws DerivativeException
  {
    if (++evaluations > maxEvaluations) {
      throw new DerivativeException(new MaxEvaluationsExceededException(maxEvaluations));
    }
    equations.computeDerivatives(t, y, yDot);
  }
  
  protected void sanityChecks(FirstOrderDifferentialEquations ode, double t0, double[] y0, double t, double[] y)
    throws IntegratorException
  {
    if (ode.getDimension() != y0.length) {
      throw new IntegratorException("dimensions mismatch: ODE problem has dimension {0}, initial state vector has dimension {1}", new Object[] { Integer.valueOf(ode.getDimension()), Integer.valueOf(y0.length) });
    }
    if (ode.getDimension() != y.length) {
      throw new IntegratorException("dimensions mismatch: ODE problem has dimension {0}, final state vector has dimension {1}", new Object[] { Integer.valueOf(ode.getDimension()), Integer.valueOf(y.length) });
    }
    if (Math.abs(t - t0) <= 1.0E-12D * Math.max(Math.abs(t0), Math.abs(t))) {
      throw new IntegratorException("too small integration interval: length = {0}", new Object[] { Double.valueOf(Math.abs(t - t0)) });
    }
  }
  
  protected CombinedEventsManager addEndTimeChecker(double startTime, double endTime, CombinedEventsManager manager)
  {
    CombinedEventsManager newManager = new CombinedEventsManager();
    for (EventState state : manager.getEventsStates()) {
      newManager.addEventHandler(state.getEventHandler(), state.getMaxCheckInterval(), state.getConvergence(), state.getMaxIterationCount());
    }
    newManager.addEventHandler(new EndTimeChecker(endTime), Double.POSITIVE_INFINITY, Math.ulp(Math.max(Math.abs(startTime), Math.abs(endTime))), 100);
    
    return newManager;
  }
  
  private static class EndTimeChecker
    implements EventHandler
  {
    private final double endTime;
    
    public EndTimeChecker(double endTime)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.AbstractIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */