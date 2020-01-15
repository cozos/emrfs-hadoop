package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.HasDependencies;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderKeyBinding;
import java.util.Set;
import javax.inject.Provider;

final class LinkedProviderBindingImpl<T>
  extends BindingImpl<T>
  implements ProviderKeyBinding<T>, HasDependencies
{
  final Key<? extends Provider<? extends T>> providerKey;
  
  public LinkedProviderBindingImpl(InjectorImpl injector, Key<T> key, Object source, InternalFactory<? extends T> internalFactory, Scoping scoping, Key<? extends Provider<? extends T>> providerKey)
  {
    super(injector, key, source, internalFactory, scoping);
    this.providerKey = providerKey;
  }
  
  LinkedProviderBindingImpl(Object source, Key<T> key, Scoping scoping, Key<? extends Provider<? extends T>> providerKey)
  {
    super(source, key, scoping);
    this.providerKey = providerKey;
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public Key<? extends Provider<? extends T>> getProviderKey()
  {
    return providerKey;
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return .ImmutableSet.of(Dependency.get(providerKey));
  }
  
  public BindingImpl<T> withScoping(Scoping scoping)
  {
    return new LinkedProviderBindingImpl(getSource(), getKey(), scoping, providerKey);
  }
  
  public BindingImpl<T> withKey(Key<T> key)
  {
    return new LinkedProviderBindingImpl(getSource(), key, getScoping(), providerKey);
  }
  
  public void applyTo(Binder binder)
  {
    getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toProvider(getProviderKey()));
  }
  
  public String toString()
  {
    return new .ToStringBuilder(ProviderKeyBinding.class).add("key", getKey()).add("source", getSource()).add("scope", getScoping()).add("provider", providerKey).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof LinkedProviderBindingImpl))
    {
      LinkedProviderBindingImpl<?> o = (LinkedProviderBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(providerKey, providerKey));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping(), providerKey });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.LinkedProviderBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */