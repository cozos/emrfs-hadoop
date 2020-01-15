package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class EventBus$EventWithSubscriber
{
  final Object event;
  final EventSubscriber subscriber;
  
  public EventBus$EventWithSubscriber(Object event, EventSubscriber subscriber)
  {
    this.event = Preconditions.checkNotNull(event);
    this.subscriber = ((EventSubscriber)Preconditions.checkNotNull(subscriber));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.EventBus.EventWithSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */