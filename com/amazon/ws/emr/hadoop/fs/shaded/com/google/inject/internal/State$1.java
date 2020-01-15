package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListenerBinding;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class State$1
  implements State
{
  public State parent()
  {
    throw new UnsupportedOperationException();
  }
  
  public <T> BindingImpl<T> getExplicitBinding(Key<T> key)
  {
    return null;
  }
  
  public Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel()
  {
    throw new UnsupportedOperationException();
  }
  
  public void putBinding(Key<?> key, BindingImpl<?> binding)
  {
    throw new UnsupportedOperationException();
  }
  
  public Scope getScope(Class<? extends Annotation> scopingAnnotation)
  {
    return null;
  }
  
  public void putAnnotation(Class<? extends Annotation> annotationType, Scope scope)
  {
    throw new UnsupportedOperationException();
  }
  
  public void addConverter(TypeConverterBinding typeConverterBinding)
  {
    throw new UnsupportedOperationException();
  }
  
  public TypeConverterBinding getConverter(String stringValue, TypeLiteral<?> type, Errors errors, Object source)
  {
    throw new UnsupportedOperationException();
  }
  
  public Iterable<TypeConverterBinding> getConvertersThisLevel()
  {
    return .ImmutableSet.of();
  }
  
  public void addMethodAspect(MethodAspect methodAspect)
  {
    throw new UnsupportedOperationException();
  }
  
  public .ImmutableList<MethodAspect> getMethodAspects()
  {
    return .ImmutableList.of();
  }
  
  public void addTypeListener(TypeListenerBinding typeListenerBinding)
  {
    throw new UnsupportedOperationException();
  }
  
  public List<TypeListenerBinding> getTypeListenerBindings()
  {
    return .ImmutableList.of();
  }
  
  public void blacklist(Key<?> key, Object source) {}
  
  public boolean isBlacklisted(Key<?> key)
  {
    return true;
  }
  
  public Set<Object> getSourcesForBlacklistedKey(Key<?> key)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object lock()
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<Class<? extends Annotation>, Scope> getScopes()
  {
    return .ImmutableMap.of();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.State.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */