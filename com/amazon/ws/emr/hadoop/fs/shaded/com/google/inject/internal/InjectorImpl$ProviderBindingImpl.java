package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.HasDependencies;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderBinding;
import java.util.Set;

class InjectorImpl$ProviderBindingImpl<T>
  extends BindingImpl<Provider<T>>
  implements ProviderBinding<Provider<T>>, HasDependencies
{
  final BindingImpl<T> providedBinding;
  
  InjectorImpl$ProviderBindingImpl(InjectorImpl injector, Key<Provider<T>> key, Binding<T> providedBinding)
  {
    super(injector, key, providedBinding.getSource(), createInternalFactory(providedBinding), Scoping.UNSCOPED);
    
    this.providedBinding = ((BindingImpl)providedBinding);
  }
  
  static <T> InternalFactory<Provider<T>> createInternalFactory(Binding<T> providedBinding)
  {
    Provider<T> provider = providedBinding.getProvider();
    new InternalFactory()
    {
      public Provider<T> get(Errors errors, InternalContext context, Dependency dependency, boolean linked)
      {
        return val$provider;
      }
    };
  }
  
  public Key<? extends T> getProvidedKey()
  {
    return providedBinding.getKey();
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super Provider<T>, V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public void applyTo(Binder binder)
  {
    throw new UnsupportedOperationException("This element represents a synthetic binding.");
  }
  
  public String toString()
  {
    return new .ToStringBuilder(ProviderBinding.class).add("key", getKey()).add("providedKey", getProvidedKey()).toString();
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return .ImmutableSet.of(Dependency.get(getProvidedKey()));
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof ProviderBindingImpl))
    {
      ProviderBindingImpl<?> o = (ProviderBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(providedBinding, providedBinding));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping(), providedBinding });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.ProviderBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */