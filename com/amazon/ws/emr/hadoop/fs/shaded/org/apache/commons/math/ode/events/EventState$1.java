package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;

class EventState$1
  implements UnivariateRealFunction
{
  EventState$1(EventState paramEventState, StepInterpolator paramStepInterpolator) {}
  
  public double value(double t)
    throws FunctionEvaluationException
  {
    try
    {
      val$interpolator.setInterpolatedTime(t);
      return EventState.access$000(this$0).g(t, val$interpolator.getInterpolatedState());
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventState.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */