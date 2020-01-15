package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Callback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

class ProxyFactory$ProxyConstructor<T>
  implements ConstructionProxy<T>
{
  final Class<?> enhanced;
  final InjectionPoint injectionPoint;
  final Constructor<T> constructor;
  final .Callback[] callbacks;
  final .FastConstructor fastConstructor;
  final .ImmutableMap<Method, List<MethodInterceptor>> methodInterceptors;
  
  ProxyFactory$ProxyConstructor(.Enhancer enhancer, InjectionPoint injectionPoint, .Callback[] callbacks, .ImmutableMap<Method, List<MethodInterceptor>> methodInterceptors)
  {
    enhanced = enhancer.createClass();
    this.injectionPoint = injectionPoint;
    constructor = ((Constructor)injectionPoint.getMember());
    this.callbacks = callbacks;
    this.methodInterceptors = methodInterceptors;
    
    .FastClass fastClass = BytecodeGen.newFastClass(enhanced, BytecodeGen.Visibility.forMember(constructor));
    fastConstructor = fastClass.getConstructor(constructor.getParameterTypes());
  }
  
  public T newInstance(Object... arguments)
    throws InvocationTargetException
  {
    .Enhancer.registerCallbacks(enhanced, callbacks);
    try
    {
      return (T)fastConstructor.newInstance(arguments);
    }
    finally
    {
      .Enhancer.registerCallbacks(enhanced, null);
    }
  }
  
  public InjectionPoint getInjectionPoint()
  {
    return injectionPoint;
  }
  
  public Constructor<T> getConstructor()
  {
    return constructor;
  }
  
  public .ImmutableMap<Method, List<MethodInterceptor>> getMethodInterceptors()
  {
    return methodInterceptors;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProxyFactory.ProxyConstructor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */