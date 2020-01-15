package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

@Beta
public class DeadEvent
{
  private final Object source;
  private final Object event;
  
  public DeadEvent(Object source, Object event)
  {
    this.source = Preconditions.checkNotNull(source);
    this.event = Preconditions.checkNotNull(event);
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public Object getEvent()
  {
    return event;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.DeadEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */