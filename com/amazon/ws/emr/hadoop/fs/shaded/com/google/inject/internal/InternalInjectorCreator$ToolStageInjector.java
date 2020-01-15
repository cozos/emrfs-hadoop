package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

class InternalInjectorCreator$ToolStageInjector
  implements Injector
{
  private final Injector delegateInjector;
  
  InternalInjectorCreator$ToolStageInjector(Injector delegateInjector)
  {
    this.delegateInjector = delegateInjector;
  }
  
  public void injectMembers(Object o)
  {
    throw new UnsupportedOperationException("Injector.injectMembers(Object) is not supported in Stage.TOOL");
  }
  
  public Map<Key<?>, Binding<?>> getBindings()
  {
    return delegateInjector.getBindings();
  }
  
  public Map<Key<?>, Binding<?>> getAllBindings()
  {
    return delegateInjector.getAllBindings();
  }
  
  public <T> Binding<T> getBinding(Key<T> key)
  {
    return delegateInjector.getBinding(key);
  }
  
  public <T> Binding<T> getBinding(Class<T> type)
  {
    return delegateInjector.getBinding(type);
  }
  
  public <T> Binding<T> getExistingBinding(Key<T> key)
  {
    return delegateInjector.getExistingBinding(key);
  }
  
  public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> type)
  {
    return delegateInjector.findBindingsByType(type);
  }
  
  public Injector getParent()
  {
    return delegateInjector.getParent();
  }
  
  public Injector createChildInjector(Iterable<? extends Module> modules)
  {
    return delegateInjector.createChildInjector(modules);
  }
  
  public Injector createChildInjector(Module... modules)
  {
    return delegateInjector.createChildInjector(modules);
  }
  
  public Map<Class<? extends Annotation>, Scope> getScopeBindings()
  {
    return delegateInjector.getScopeBindings();
  }
  
  public Set<TypeConverterBinding> getTypeConverterBindings()
  {
    return delegateInjector.getTypeConverterBindings();
  }
  
  public <T> Provider<T> getProvider(Key<T> key)
  {
    throw new UnsupportedOperationException("Injector.getProvider(Key<T>) is not supported in Stage.TOOL");
  }
  
  public <T> Provider<T> getProvider(Class<T> type)
  {
    throw new UnsupportedOperationException("Injector.getProvider(Class<T>) is not supported in Stage.TOOL");
  }
  
  public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral)
  {
    throw new UnsupportedOperationException("Injector.getMembersInjector(TypeLiteral<T>) is not supported in Stage.TOOL");
  }
  
  public <T> MembersInjector<T> getMembersInjector(Class<T> type)
  {
    throw new UnsupportedOperationException("Injector.getMembersInjector(Class<T>) is not supported in Stage.TOOL");
  }
  
  public <T> T getInstance(Key<T> key)
  {
    throw new UnsupportedOperationException("Injector.getInstance(Key<T>) is not supported in Stage.TOOL");
  }
  
  public <T> T getInstance(Class<T> type)
  {
    throw new UnsupportedOperationException("Injector.getInstance(Class<T>) is not supported in Stage.TOOL");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalInjectorCreator.ToolStageInjector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */