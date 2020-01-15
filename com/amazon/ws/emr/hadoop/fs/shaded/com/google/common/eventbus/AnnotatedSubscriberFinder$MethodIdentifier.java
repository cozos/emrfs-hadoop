package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

final class AnnotatedSubscriberFinder$MethodIdentifier
{
  private final String name;
  private final List<Class<?>> parameterTypes;
  
  AnnotatedSubscriberFinder$MethodIdentifier(Method method)
  {
    name = method.getName();
    parameterTypes = Arrays.asList(method.getParameterTypes());
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { name, parameterTypes });
  }
  
  public boolean equals(@Nullable Object o)
  {
    if ((o instanceof MethodIdentifier))
    {
      MethodIdentifier ident = (MethodIdentifier)o;
      return (name.equals(name)) && (parameterTypes.equals(parameterTypes));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.AnnotatedSubscriberFinder.MethodIdentifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */