package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

final class DefaultConstructionProxyFactory<T>
  implements ConstructionProxyFactory<T>
{
  private final InjectionPoint injectionPoint;
  
  DefaultConstructionProxyFactory(InjectionPoint injectionPoint)
  {
    this.injectionPoint = injectionPoint;
  }
  
  public ConstructionProxy<T> create()
  {
    final Constructor<T> constructor = (Constructor)injectionPoint.getMember();
    if (Modifier.isPublic(constructor.getModifiers()))
    {
      Class<T> classToConstruct = constructor.getDeclaringClass();
      try
      {
        final .FastConstructor fastConstructor = BytecodeGen.newFastClass(classToConstruct, BytecodeGen.Visibility.forMember(constructor)).getConstructor(constructor);
        
        new ConstructionProxy()
        {
          public T newInstance(Object... arguments)
            throws InvocationTargetException
          {
            return (T)fastConstructor.newInstance(arguments);
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
            return .ImmutableMap.of();
          }
        };
      }
      catch (.CodeGenerationException e)
      {
        if (!Modifier.isPublic(classToConstruct.getModifiers())) {
          constructor.setAccessible(true);
        }
      }
    }
    else
    {
      constructor.setAccessible(true);
    }
    new ConstructionProxy()
    {
      public T newInstance(Object... arguments)
        throws InvocationTargetException
      {
        try
        {
          return (T)constructor.newInstance(arguments);
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
        return injectionPoint;
      }
      
      public Constructor<T> getConstructor()
      {
        return constructor;
      }
      
      public .ImmutableMap<Method, List<MethodInterceptor>> getMethodInterceptors()
      {
        return .ImmutableMap.of();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.DefaultConstructionProxyFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */