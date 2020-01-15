package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.Method;

public class SubscriberExceptionContext
{
  private final EventBus eventBus;
  private final Object event;
  private final Object subscriber;
  private final Method subscriberMethod;
  
  SubscriberExceptionContext(EventBus eventBus, Object event, Object subscriber, Method subscriberMethod)
  {
    this.eventBus = ((EventBus)Preconditions.checkNotNull(eventBus));
    this.event = Preconditions.checkNotNull(event);
    this.subscriber = Preconditions.checkNotNull(subscriber);
    this.subscriberMethod = ((Method)Preconditions.checkNotNull(subscriberMethod));
  }
  
  public EventBus getEventBus()
  {
    return eventBus;
  }
  
  public Object getEvent()
  {
    return event;
  }
  
  public Object getSubscriber()
  {
    return subscriber;
  }
  
  public Method getSubscriberMethod()
  {
    return subscriberMethod;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.SubscriberExceptionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */