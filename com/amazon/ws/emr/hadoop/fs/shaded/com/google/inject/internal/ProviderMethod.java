package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Exposed;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateBinder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..StackTraceElements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderWithDependencies;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class ProviderMethod<T>
  implements ProviderWithDependencies<T>
{
  private final Key<T> key;
  private final Class<? extends Annotation> scopeAnnotation;
  private final Object instance;
  private final Method method;
  private final .ImmutableSet<Dependency<?>> dependencies;
  private final List<Provider<?>> parameterProviders;
  private final boolean exposed;
  
  ProviderMethod(Key<T> key, Method method, Object instance, .ImmutableSet<Dependency<?>> dependencies, List<Provider<?>> parameterProviders, Class<? extends Annotation> scopeAnnotation)
  {
    this.key = key;
    this.scopeAnnotation = scopeAnnotation;
    this.instance = instance;
    this.dependencies = dependencies;
    this.method = method;
    this.parameterProviders = parameterProviders;
    exposed = method.isAnnotationPresent(Exposed.class);
    
    method.setAccessible(true);
  }
  
  public Key<T> getKey()
  {
    return key;
  }
  
  public Method getMethod()
  {
    return method;
  }
  
  public Object getInstance()
  {
    return instance;
  }
  
  public void configure(Binder binder)
  {
    binder = binder.withSource(method);
    if (scopeAnnotation != null) {
      binder.bind(key).toProvider(this).in(scopeAnnotation);
    } else {
      binder.bind(key).toProvider(this);
    }
    if (exposed) {
      ((PrivateBinder)binder).expose(key);
    }
  }
  
  public T get()
  {
    Object[] parameters = new Object[parameterProviders.size()];
    for (int i = 0; i < parameters.length; i++) {
      parameters[i] = ((Provider)parameterProviders.get(i)).get();
    }
    try
    {
      return (T)method.invoke(instance, parameters);
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
    catch (InvocationTargetException e)
    {
      throw Exceptions.throwCleanly(e);
    }
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return dependencies;
  }
  
  public String toString()
  {
    return "@Provides " + .StackTraceElements.forMember(method).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof ProviderMethod))
    {
      ProviderMethod o = (ProviderMethod)obj;
      return (method.equals(method)) && (instance.equals(instance));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { method });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProviderMethod
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */