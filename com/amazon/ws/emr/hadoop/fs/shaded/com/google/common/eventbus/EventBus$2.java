package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import java.util.LinkedList;
import java.util.Queue;

class EventBus$2
  extends ThreadLocal<Queue<EventBus.EventWithSubscriber>>
{
  EventBus$2(EventBus paramEventBus) {}
  
  protected Queue<EventBus.EventWithSubscriber> initialValue()
  {
    return new LinkedList();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.EventBus.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */