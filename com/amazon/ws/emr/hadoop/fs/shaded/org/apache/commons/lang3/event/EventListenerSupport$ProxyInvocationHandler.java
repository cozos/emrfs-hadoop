package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.event;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EventListenerSupport$ProxyInvocationHandler
  implements InvocationHandler
{
  protected EventListenerSupport$ProxyInvocationHandler(EventListenerSupport paramEventListenerSupport) {}
  
  public Object invoke(Object unusedProxy, Method method, Object[] args)
    throws Throwable
  {
    for (L listener : EventListenerSupport.access$000(this$0)) {
      method.invoke(listener, args);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.event.EventListenerSupport.ProxyInvocationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */