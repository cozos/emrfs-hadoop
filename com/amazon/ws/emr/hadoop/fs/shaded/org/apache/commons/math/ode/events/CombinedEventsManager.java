package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CombinedEventsManager
{
  private final List<EventState> states;
  private EventState first;
  private boolean initialized;
  
  public CombinedEventsManager()
  {
    states = new ArrayList();
    first = null;
    initialized = false;
  }
  
  public void addEventHandler(EventHandler handler, double maxCheckInterval, double convergence, int maxIterationCount)
  {
    states.add(new EventState(handler, maxCheckInterval, convergence, maxIterationCount));
  }
  
  public Collection<EventHandler> getEventsHandlers()
  {
    List<EventHandler> list = new ArrayList();
    for (EventState state : states) {
      list.add(state.getEventHandler());
    }
    return Collections.unmodifiableCollection(list);
  }
  
  public void clearEventsHandlers()
  {
    states.clear();
  }
  
  public Collection<EventState> getEventsStates()
  {
    return states;
  }
  
  public boolean isEmpty()
  {
    return states.isEmpty();
  }
  
  public boolean evaluateStep(StepInterpolator interpolator)
    throws DerivativeException, IntegratorException
  {
    try
    {
      first = null;
      if (states.isEmpty()) {
        return false;
      }
      if (!initialized)
      {
        double t0 = interpolator.getPreviousTime();
        interpolator.setInterpolatedTime(t0);
        double[] y = interpolator.getInterpolatedState();
        for (EventState state : states) {
          state.reinitializeBegin(t0, y);
        }
        initialized = true;
      }
      for (EventState state : states) {
        if (state.evaluateStep(interpolator)) {
          if (first == null) {
            first = state;
          } else if (interpolator.isForward())
          {
            if (state.getEventTime() < first.getEventTime()) {
              first = state;
            }
          }
          else if (state.getEventTime() > first.getEventTime()) {
            first = state;
          }
        }
      }
      return first != null;
    }
    catch (EventException se)
    {
      throw new IntegratorException(se);
    }
    catch (ConvergenceException ce)
    {
      throw new IntegratorException(ce);
    }
  }
  
  public double getEventTime()
  {
    return first == null ? NaN.0D : first.getEventTime();
  }
  
  public void stepAccepted(double t, double[] y)
    throws IntegratorException
  {
    try
    {
      for (EventState state : states) {
        state.stepAccepted(t, y);
      }
    }
    catch (EventException se)
    {
      throw new IntegratorException(se);
    }
  }
  
  public boolean stop()
  {
    for (EventState state : states) {
      if (state.stop()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean reset(double t, double[] y)
    throws IntegratorException
  {
    try
    {
      boolean resetDerivatives = false;
      for (EventState state : states) {
        if (state.reset(t, y)) {
          resetDerivatives = true;
        }
      }
      return resetDerivatives;
    }
    catch (EventException se)
    {
      throw new IntegratorException(se);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.CombinedEventsManager
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */