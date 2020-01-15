package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class EventException
  extends MathException
{
  private static final long serialVersionUID = -898215297400035290L;
  
  public EventException(String specifier, Object... parts)
  {
    super(specifier, parts);
  }
  
  public EventException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.EventException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */