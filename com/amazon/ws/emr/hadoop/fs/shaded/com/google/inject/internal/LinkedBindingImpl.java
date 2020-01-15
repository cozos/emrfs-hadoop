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
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.LinkedKeyBinding;
import java.util.Set;

public final class LinkedBindingImpl<T>
  extends BindingImpl<T>
  implements LinkedKeyBinding<T>, HasDependencies
{
  final Key<? extends T> targetKey;
  
  public LinkedBindingImpl(InjectorImpl injector, Key<T> key, Object source, InternalFactory<? extends T> internalFactory, Scoping scoping, Key<? extends T> targetKey)
  {
    super(injector, key, source, internalFactory, scoping);
    this.targetKey = targetKey;
  }
  
  public LinkedBindingImpl(Object source, Key<T> key, Scoping scoping, Key<? extends T> targetKey)
  {
    super(source, key, scoping);
    this.targetKey = targetKey;
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public Key<? extends T> getLinkedKey()
  {
    return targetKey;
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return .ImmutableSet.of(Dependency.get(targetKey));
  }
  
  public BindingImpl<T> withScoping(Scoping scoping)
  {
    return new LinkedBindingImpl(getSource(), getKey(), scoping, targetKey);
  }
  
  public BindingImpl<T> withKey(Key<T> key)
  {
    return new LinkedBindingImpl(getSource(), key, getScoping(), targetKey);
  }
  
  public void applyTo(Binder binder)
  {
    getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).to(getLinkedKey()));
  }
  
  public String toString()
  {
    return new .ToStringBuilder(LinkedKeyBinding.class).add("key", getKey()).add("source", getSource()).add("scope", getScoping()).add("target", targetKey).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof LinkedBindingImpl))
    {
      LinkedBindingImpl<?> o = (LinkedBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(targetKey, targetKey));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping(), targetKey });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.LinkedBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */