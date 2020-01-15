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
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InstanceBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Providers;
import java.util.Set;

final class InstanceBindingImpl<T>
  extends BindingImpl<T>
  implements InstanceBinding<T>
{
  final T instance;
  final Provider<T> provider;
  final .ImmutableSet<InjectionPoint> injectionPoints;
  
  public InstanceBindingImpl(InjectorImpl injector, Key<T> key, Object source, InternalFactory<? extends T> internalFactory, Set<InjectionPoint> injectionPoints, T instance)
  {
    super(injector, key, source, internalFactory, Scoping.EAGER_SINGLETON);
    this.injectionPoints = .ImmutableSet.copyOf(injectionPoints);
    this.instance = instance;
    provider = Providers.of(instance);
  }
  
  public InstanceBindingImpl(Object source, Key<T> key, Scoping scoping, Set<InjectionPoint> injectionPoints, T instance)
  {
    super(source, key, scoping);
    this.injectionPoints = .ImmutableSet.copyOf(injectionPoints);
    this.instance = instance;
    provider = Providers.of(instance);
  }
  
  public Provider<T> getProvider()
  {
    return provider;
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public T getInstance()
  {
    return (T)instance;
  }
  
  public Set<InjectionPoint> getInjectionPoints()
  {
    return injectionPoints;
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return (instance instanceof HasDependencies) ? .ImmutableSet.copyOf(((HasDependencies)instance).getDependencies()) : Dependency.forInjectionPoints(injectionPoints);
  }
  
  public BindingImpl<T> withScoping(Scoping scoping)
  {
    return new InstanceBindingImpl(getSource(), getKey(), scoping, injectionPoints, instance);
  }
  
  public BindingImpl<T> withKey(Key<T> key)
  {
    return new InstanceBindingImpl(getSource(), key, getScoping(), injectionPoints, instance);
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).bind(getKey()).toInstance(instance);
  }
  
  public String toString()
  {
    return new .ToStringBuilder(InstanceBinding.class).add("key", getKey()).add("source", getSource()).add("instance", instance).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof InstanceBindingImpl))
    {
      InstanceBindingImpl<?> o = (InstanceBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(instance, instance));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InstanceBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */