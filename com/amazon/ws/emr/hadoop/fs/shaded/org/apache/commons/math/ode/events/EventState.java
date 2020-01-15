package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.BrentSolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;

public class EventState
{
  private final EventHandler handler;
  private final double maxCheckInterval;
  private final double convergence;
  private final int maxIterationCount;
  private double t0;
  private double g0;
  private boolean g0Positive;
  private boolean pendingEvent;
  private double pendingEventTime;
  private double previousEventTime;
  private boolean forward;
  private boolean increasing;
  private int nextAction;
  
  public EventState(EventHandler handler, double maxCheckInterval, double convergence, int maxIterationCount)
  {
    this.handler = handler;
    this.maxCheckInterval = maxCheckInterval;
    this.convergence = Math.abs(convergence);
    this.maxIterationCount = maxIterationCount;
    
    t0 = NaN.0D;
    g0 = NaN.0D;
    g0Positive = true;
    pendingEvent = false;
    pendingEventTime = NaN.0D;
    previousEventTime = NaN.0D;
    increasing = true;
    nextAction = 3;
  }
  
  public EventHandler getEventHandler()
  {
    return handler;
  }
  
  public double getMaxCheckInterval()
  {
    return maxCheckInterval;
  }
  
  public double getConvergence()
  {
    return convergence;
  }
  
  public int getMaxIterationCount()
  {
    return maxIterationCount;
  }
  
  public void reinitializeBegin(double tStart, double[] yStart)
    throws EventException
  {
    t0 = tStart;
    g0 = handler.g(tStart, yStart);
    g0Positive = (g0 >= 0.0D);
  }
  
  public boolean evaluateStep(final StepInterpolator interpolator)
    throws DerivativeException, EventException, ConvergenceException
  {
    try
    {
      forward = interpolator.isForward();
      double t1 = interpolator.getCurrentTime();
      int n = Math.max(1, (int)Math.ceil(Math.abs(t1 - t0) / maxCheckInterval));
      double h = (t1 - t0) / n;
      
      double ta = t0;
      double ga = g0;
      double tb = t0 + (interpolator.isForward() ? convergence : -convergence);
      for (int i = 0; i < n; i++)
      {
        tb += h;
        interpolator.setInterpolatedTime(tb);
        double gb = handler.g(tb, interpolator.getInterpolatedState());
        if ((g0Positive ^ gb >= 0.0D))
        {
          if (ga * gb > 0.0D)
          {
            double epsilon = (forward ? 0.25D : -0.25D) * convergence;
            for (int k = 0; (k < 4) && (ga * gb > 0.0D); k++)
            {
              ta += epsilon;
              interpolator.setInterpolatedTime(ta);
              ga = handler.g(ta, interpolator.getInterpolatedState());
            }
            if (ga * gb > 0.0D) {
              throw MathRuntimeException.createInternalError(null);
            }
          }
          increasing = (gb >= ga);
          
          UnivariateRealFunction f = new UnivariateRealFunction()
          {
            public double value(double t)
              throws FunctionEvaluationException
            {
              try
              {
                interpolator.setInterpolatedTime(t);
                return handler.g(t, interpolator.getInterpolatedState());
              }
              catch (DerivativeException e)
              {
                throw new FunctionEvaluationException(e, t);
              }
              catch (EventException e)
              {
                throw new FunctionEvaluationException(e, t);
              }
            }
          };
          BrentSolver solver = new BrentSolver();
          solver.setAbsoluteAccuracy(convergence);
          solver.setMaximalIterationCount(maxIterationCount);
          double root = ta <= tb ? solver.solve(f, ta, tb) : solver.solve(f, tb, ta);
          if ((Math.abs(root - ta) <= convergence) && (Math.abs(root - previousEventTime) <= convergence))
          {
            ta = tb;
            ga = gb;
          }
          else if ((Double.isNaN(previousEventTime)) || (Math.abs(previousEventTime - root) > convergence))
          {
            pendingEventTime = root;
            if ((pendingEvent) && (Math.abs(t1 - pendingEventTime) <= convergence)) {
              return false;
            }
            pendingEvent = true;
            return true;
          }
        }
        else
        {
          ta = tb;
          ga = gb;
        }
      }
      pendingEvent = false;
      pendingEventTime = NaN.0D;
      return false;
    }
    catch (FunctionEvaluationException e)
    {
      Throwable cause = e.getCause();
      if ((cause != null) && ((cause instanceof DerivativeException))) {
        throw ((DerivativeException)cause);
      }
      if ((cause != null) && ((cause instanceof EventException))) {
        throw ((EventException)cause);
      }
      throw new EventException(e);
    }
  }
  
  public double getEventTime()
  {
    return pendingEventTime;
  }
  
  public void stepAccepted(double t, double[] y)
    throws EventException
  {
    t0 = t;
    g0 = handler.g(t, y);
    if (pendingEvent)
    {
      previousEventTime = t;
      g0Positive = increasing;
      nextAction = handler.eventOccurred(t, y, !(increasing ^ forward));
    }
    else
    {
      g0Positive = (g0 >= 0.0D);
      nextAction = 3;
    }
  }
  
  public boolean stop()
  {
    return nextAction == 0;
  }
  
  public boolean reset(double t, double[] y)
    throws EventException
  {
    if (!pendingEvent) {
      return false;
    }
    if (nextAction == 1) {
      handler.resetState(t, y);
    }
    pendingEvent = false;
    pendingEventTime = NaN.0D;
    
    return (nextAction == 1) || (nextAction == 2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventState
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */