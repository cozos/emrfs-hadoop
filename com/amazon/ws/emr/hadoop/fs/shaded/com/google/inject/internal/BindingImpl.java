package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ElementVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InstanceBinding;

public abstract class BindingImpl<T>
  implements Binding<T>
{
  private final InjectorImpl injector;
  private final Key<T> key;
  private final Object source;
  private final Scoping scoping;
  private final InternalFactory<? extends T> internalFactory;
  private volatile Provider<T> provider;
  
  public BindingImpl(InjectorImpl injector, Key<T> key, Object source, InternalFactory<? extends T> internalFactory, Scoping scoping)
  {
    this.injector = injector;
    this.key = key;
    this.source = source;
    this.internalFactory = internalFactory;
    this.scoping = scoping;
  }
  
  protected BindingImpl(Object source, Key<T> key, Scoping scoping)
  {
    internalFactory = null;
    injector = null;
    this.source = source;
    this.key = key;
    this.scoping = scoping;
  }
  
  public Key<T> getKey()
  {
    return key;
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public Provider<T> getProvider()
  {
    if (provider == null)
    {
      if (injector == null) {
        throw new UnsupportedOperationException("getProvider() not supported for module bindings");
      }
      provider = injector.getProvider(key);
    }
    return provider;
  }
  
  public InternalFactory<? extends T> getInternalFactory()
  {
    return internalFactory;
  }
  
  public Scoping getScoping()
  {
    return scoping;
  }
  
  public boolean isConstant()
  {
    return this instanceof InstanceBinding;
  }
  
  public <V> V acceptVisitor(ElementVisitor<V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public <V> V acceptScopingVisitor(BindingScopingVisitor<V> visitor)
  {
    return (V)scoping.acceptVisitor(visitor);
  }
  
  protected BindingImpl<T> withScoping(Scoping scoping)
  {
    throw new AssertionError();
  }
  
  protected BindingImpl<T> withKey(Key<T> key)
  {
    throw new AssertionError();
  }
  
  public String toString()
  {
    return new .ToStringBuilder(Binding.class).add("key", key).add("scope", scoping).add("source", source).toString();
  }
  
  public InjectorImpl getInjector()
  {
    return injector;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */