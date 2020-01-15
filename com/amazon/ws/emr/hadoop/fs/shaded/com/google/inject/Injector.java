package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface Injector
{
  public abstract void injectMembers(Object paramObject);
  
  public abstract <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> paramTypeLiteral);
  
  public abstract <T> MembersInjector<T> getMembersInjector(Class<T> paramClass);
  
  public abstract Map<Key<?>, Binding<?>> getBindings();
  
  public abstract Map<Key<?>, Binding<?>> getAllBindings();
  
  public abstract <T> Binding<T> getBinding(Key<T> paramKey);
  
  public abstract <T> Binding<T> getBinding(Class<T> paramClass);
  
  public abstract <T> Binding<T> getExistingBinding(Key<T> paramKey);
  
  public abstract <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> paramTypeLiteral);
  
  public abstract <T> Provider<T> getProvider(Key<T> paramKey);
  
  public abstract <T> Provider<T> getProvider(Class<T> paramClass);
  
  public abstract <T> T getInstance(Key<T> paramKey);
  
  public abstract <T> T getInstance(Class<T> paramClass);
  
  public abstract Injector getParent();
  
  public abstract Injector createChildInjector(Iterable<? extends Module> paramIterable);
  
  public abstract Injector createChildInjector(Module... paramVarArgs);
  
  public abstract Map<Class<? extends Annotation>, Scope> getScopeBindings();
  
  public abstract Set<TypeConverterBinding> getTypeConverterBindings();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */