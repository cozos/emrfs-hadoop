package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

abstract interface ConstructionProxy<T>
{
  public abstract T newInstance(Object... paramVarArgs)
    throws InvocationTargetException;
  
  public abstract InjectionPoint getInjectionPoint();
  
  public abstract Constructor<T> getConstructor();
  
  public abstract .ImmutableMap<Method, List<MethodInterceptor>> getMethodInterceptors();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructionProxy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */