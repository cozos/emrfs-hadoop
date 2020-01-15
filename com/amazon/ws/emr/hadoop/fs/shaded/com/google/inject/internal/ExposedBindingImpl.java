package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ExposedBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import java.util.Set;

public final class ExposedBindingImpl<T>
  extends BindingImpl<T>
  implements ExposedBinding<T>
{
  private final PrivateElements privateElements;
  
  public ExposedBindingImpl(InjectorImpl injector, Object source, Key<T> key, InternalFactory<T> factory, PrivateElements privateElements)
  {
    super(injector, key, source, factory, Scoping.UNSCOPED);
    this.privateElements = privateElements;
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return .ImmutableSet.of(Dependency.get(Key.get(Injector.class)));
  }
  
  public PrivateElements getPrivateElements()
  {
    return privateElements;
  }
  
  public String toString()
  {
    return new .ToStringBuilder(ExposedBinding.class).add("key", getKey()).add("source", getSource()).add("privateElements", privateElements).toString();
  }
  
  public void applyTo(Binder binder)
  {
    throw new UnsupportedOperationException("This element represents a synthetic binding.");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ExposedBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */