package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.HasDependencies;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderInstanceBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderWithExtensionVisitor;
import java.util.Set;

final class ProviderInstanceBindingImpl<T>
  extends BindingImpl<T>
  implements ProviderInstanceBinding<T>
{
  final Provider<? extends T> providerInstance;
  final .ImmutableSet<InjectionPoint> injectionPoints;
  
  public ProviderInstanceBindingImpl(InjectorImpl injector, Key<T> key, Object source, InternalFactory<? extends T> internalFactory, Scoping scoping, Provider<? extends T> providerInstance, Set<InjectionPoint> injectionPoints)
  {
    super(injector, key, source, internalFactory, scoping);
    this.providerInstance = providerInstance;
    this.injectionPoints = .ImmutableSet.copyOf(injectionPoints);
  }
  
  public ProviderInstanceBindingImpl(Object source, Key<T> key, Scoping scoping, Set<InjectionPoint> injectionPoints, Provider<? extends T> providerInstance)
  {
    super(source, key, scoping);
    this.injectionPoints = .ImmutableSet.copyOf(injectionPoints);
    this.providerInstance = providerInstance;
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    if ((providerInstance instanceof ProviderWithExtensionVisitor)) {
      return (V)((ProviderWithExtensionVisitor)providerInstance).acceptExtensionVisitor(visitor, this);
    }
    return (V)visitor.visit(this);
  }
  
  public Provider<? extends T> getProviderInstance()
  {
    return providerInstance;
  }
  
  public Set<InjectionPoint> getInjectionPoints()
  {
    return injectionPoints;
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return (providerInstance instanceof HasDependencies) ? .ImmutableSet.copyOf(((HasDependencies)providerInstance).getDependencies()) : Dependency.forInjectionPoints(injectionPoints);
  }
  
  public BindingImpl<T> withScoping(Scoping scoping)
  {
    return new ProviderInstanceBindingImpl(getSource(), getKey(), scoping, injectionPoints, providerInstance);
  }
  
  public BindingImpl<T> withKey(Key<T> key)
  {
    return new ProviderInstanceBindingImpl(getSource(), key, getScoping(), injectionPoints, providerInstance);
  }
  
  public void applyTo(Binder binder)
  {
    getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toProvider(getProviderInstance()));
  }
  
  public String toString()
  {
    return new .ToStringBuilder(ProviderInstanceBinding.class).add("key", getKey()).add("source", getSource()).add("scope", getScoping()).add("provider", providerInstance).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof ProviderInstanceBindingImpl))
    {
      ProviderInstanceBindingImpl<?> o = (ProviderInstanceBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(providerInstance, providerInstance));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProviderInstanceBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */