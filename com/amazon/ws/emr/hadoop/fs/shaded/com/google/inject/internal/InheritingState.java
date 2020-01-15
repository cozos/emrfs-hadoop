package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListenerBinding;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class InheritingState
  implements State
{
  private final State parent;
  private final Map<Key<?>, Binding<?>> explicitBindingsMutable = .Maps.newLinkedHashMap();
  private final Map<Key<?>, Binding<?>> explicitBindings = Collections.unmodifiableMap(explicitBindingsMutable);
  private final Map<Class<? extends Annotation>, Scope> scopes = .Maps.newHashMap();
  private final List<TypeConverterBinding> converters = .Lists.newArrayList();
  private final List<MethodAspect> methodAspects = .Lists.newArrayList();
  private final List<TypeListenerBinding> listenerBindings = .Lists.newArrayList();
  private final WeakKeySet blacklistedKeys = new WeakKeySet();
  private final Object lock;
  
  InheritingState(State parent)
  {
    this.parent = ((State).Preconditions.checkNotNull(parent, "parent"));
    lock = (parent == State.NONE ? this : parent.lock());
  }
  
  public State parent()
  {
    return parent;
  }
  
  public <T> BindingImpl<T> getExplicitBinding(Key<T> key)
  {
    Binding<?> binding = (Binding)explicitBindings.get(key);
    return binding != null ? (BindingImpl)binding : parent.getExplicitBinding(key);
  }
  
  public Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel()
  {
    return explicitBindings;
  }
  
  public void putBinding(Key<?> key, BindingImpl<?> binding)
  {
    explicitBindingsMutable.put(key, binding);
  }
  
  public Scope getScope(Class<? extends Annotation> annotationType)
  {
    Scope scope = (Scope)scopes.get(annotationType);
    return scope != null ? scope : parent.getScope(annotationType);
  }
  
  public void putAnnotation(Class<? extends Annotation> annotationType, Scope scope)
  {
    scopes.put(annotationType, scope);
  }
  
  public Iterable<TypeConverterBinding> getConvertersThisLevel()
  {
    return converters;
  }
  
  public void addConverter(TypeConverterBinding typeConverterBinding)
  {
    converters.add(typeConverterBinding);
  }
  
  public TypeConverterBinding getConverter(String stringValue, TypeLiteral<?> type, Errors errors, Object source)
  {
    TypeConverterBinding matchingConverter = null;
    for (State s = this; s != State.NONE; s = s.parent()) {
      for (TypeConverterBinding converter : s.getConvertersThisLevel()) {
        if (converter.getTypeMatcher().matches(type))
        {
          if (matchingConverter != null) {
            errors.ambiguousTypeConversion(stringValue, source, type, matchingConverter, converter);
          }
          matchingConverter = converter;
        }
      }
    }
    return matchingConverter;
  }
  
  public void addMethodAspect(MethodAspect methodAspect)
  {
    methodAspects.add(methodAspect);
  }
  
  public .ImmutableList<MethodAspect> getMethodAspects()
  {
    return new .ImmutableList.Builder().addAll(parent.getMethodAspects()).addAll(methodAspects).build();
  }
  
  public void addTypeListener(TypeListenerBinding listenerBinding)
  {
    listenerBindings.add(listenerBinding);
  }
  
  public List<TypeListenerBinding> getTypeListenerBindings()
  {
    List<TypeListenerBinding> parentBindings = parent.getTypeListenerBindings();
    List<TypeListenerBinding> result = new ArrayList(parentBindings.size() + 1);
    
    result.addAll(parentBindings);
    result.addAll(listenerBindings);
    return result;
  }
  
  public void blacklist(Key<?> key, Object source)
  {
    parent.blacklist(key, source);
    blacklistedKeys.add(key, source);
  }
  
  public boolean isBlacklisted(Key<?> key)
  {
    return blacklistedKeys.contains(key);
  }
  
  public Set<Object> getSourcesForBlacklistedKey(Key<?> key)
  {
    return blacklistedKeys.getSources(key);
  }
  
  public Object lock()
  {
    return lock;
  }
  
  public Map<Class<? extends Annotation>, Scope> getScopes()
  {
    return scopes;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InheritingState
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */