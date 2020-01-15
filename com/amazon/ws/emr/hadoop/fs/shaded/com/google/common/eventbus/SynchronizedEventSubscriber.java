package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class SynchronizedEventSubscriber
  extends EventSubscriber
{
  public SynchronizedEventSubscriber(Object target, Method method)
  {
    super(target, method);
  }
  
  public void handleEvent(Object event)
    throws InvocationTargetException
  {
    synchronized (this)
    {
      super.handleEvent(event);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.SynchronizedEventSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */