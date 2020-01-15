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

abstract interface State
{
  public static final State NONE = new State()
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
  };
  
  public abstract State parent();
  
  public abstract <T> BindingImpl<T> getExplicitBinding(Key<T> paramKey);
  
  public abstract Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel();
  
  public abstract void putBinding(Key<?> paramKey, BindingImpl<?> paramBindingImpl);
  
  public abstract Scope getScope(Class<? extends Annotation> paramClass);
  
  public abstract void putAnnotation(Class<? extends Annotation> paramClass, Scope paramScope);
  
  public abstract void addConverter(TypeConverterBinding paramTypeConverterBinding);
  
  public abstract TypeConverterBinding getConverter(String paramString, TypeLiteral<?> paramTypeLiteral, Errors paramErrors, Object paramObject);
  
  public abstract Iterable<TypeConverterBinding> getConvertersThisLevel();
  
  public abstract void addMethodAspect(MethodAspect paramMethodAspect);
  
  public abstract .ImmutableList<MethodAspect> getMethodAspects();
  
  public abstract void addTypeListener(TypeListenerBinding paramTypeListenerBinding);
  
  public abstract List<TypeListenerBinding> getTypeListenerBindings();
  
  public abstract void blacklist(Key<?> paramKey, Object paramObject);
  
  public abstract boolean isBlacklisted(Key<?> paramKey);
  
  public abstract Set<Object> getSourcesForBlacklistedKey(Key<?> paramKey);
  
  public abstract Object lock();
  
  public abstract Map<Class<? extends Annotation>, Scope> getScopes();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.State
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */