package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

class DefaultConstructionProxyFactory$1
  implements ConstructionProxy<T>
{
  DefaultConstructionProxyFactory$1(DefaultConstructionProxyFactory paramDefaultConstructionProxyFactory, .FastConstructor paramFastConstructor, Constructor paramConstructor) {}
  
  public T newInstance(Object... arguments)
    throws InvocationTargetException
  {
    return (T)val$fastConstructor.newInstance(arguments);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.DefaultConstructionProxyFactory.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */