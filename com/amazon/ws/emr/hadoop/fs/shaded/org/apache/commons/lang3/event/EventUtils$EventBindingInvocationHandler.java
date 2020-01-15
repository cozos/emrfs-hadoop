package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class EventUtils$EventBindingInvocationHandler
  implements InvocationHandler
{
  private final Object target;
  private final String methodName;
  private final Set<String> eventTypes;
  
  EventUtils$EventBindingInvocationHandler(Object target, String methodName, String[] eventTypes)
  {
    this.target = target;
    this.methodName = methodName;
    this.eventTypes = new HashSet(Arrays.asList(eventTypes));
  }
  
  public Object invoke(Object proxy, Method method, Object[] parameters)
    throws Throwable
  {
    if ((eventTypes.isEmpty()) || (eventTypes.contains(method.getName())))
    {
      if (hasMatchingParametersMethod(method)) {
        return MethodUtils.invokeMethod(target, methodName, parameters);
      }
      return MethodUtils.invokeMethod(target, methodName, new Object[0]);
    }
    return null;
  }
  
  private boolean hasMatchingParametersMethod(Method method)
  {
    return MethodUtils.getAccessibleMethod(target.getClass(), methodName, method.getParameterTypes()) != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.event.EventUtils.EventBindingInvocationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */