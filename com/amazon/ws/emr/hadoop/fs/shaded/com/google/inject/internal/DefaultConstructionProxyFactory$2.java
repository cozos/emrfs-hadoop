package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

class DefaultConstructionProxyFactory$2
  implements ConstructionProxy<T>
{
  DefaultConstructionProxyFactory$2(DefaultConstructionProxyFactory paramDefaultConstructionProxyFactory, Constructor paramConstructor) {}
  
  public T newInstance(Object... arguments)
    throws InvocationTargetException
  {
    try
    {
      return (T)val$constructor.newInstance(arguments);
    }
    catch (InstantiationException e)
    {
      throw new AssertionError(e);
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
  }
  
  public InjectionPoint getInjectionPoint()
  {
    return DefaultConstructionProxyFactory.access$000(this$0);
  }
  
  public Constructor<T> getConstructor()
  {
    return val$constructor;
  }
  
  public .ImmutableMap<Method, List<MethodInterceptor>> getMethodInterceptors()
  {
    return .ImmutableMap.of();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.DefaultConstructionProxyFactory.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */