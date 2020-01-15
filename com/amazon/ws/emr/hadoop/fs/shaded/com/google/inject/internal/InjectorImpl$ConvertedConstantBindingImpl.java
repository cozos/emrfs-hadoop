package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ConvertedConstantBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Providers;
import java.util.Set;

class InjectorImpl$ConvertedConstantBindingImpl<T>
  extends BindingImpl<T>
  implements ConvertedConstantBinding<T>
{
  final T value;
  final Provider<T> provider;
  final Binding<String> originalBinding;
  final TypeConverterBinding typeConverterBinding;
  
  InjectorImpl$ConvertedConstantBindingImpl(InjectorImpl injector, Key<T> key, T value, Binding<String> originalBinding, TypeConverterBinding typeConverterBinding)
  {
    super(injector, key, originalBinding.getSource(), new ConstantFactory(Initializables.of(value)), Scoping.UNSCOPED);
    
    this.value = value;
    provider = Providers.of(value);
    this.originalBinding = originalBinding;
    this.typeConverterBinding = typeConverterBinding;
  }
  
  public Provider<T> getProvider()
  {
    return provider;
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public T getValue()
  {
    return (T)value;
  }
  
  public TypeConverterBinding getTypeConverterBinding()
  {
    return typeConverterBinding;
  }
  
  public Key<String> getSourceKey()
  {
    return originalBinding.getKey();
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return .ImmutableSet.of(Dependency.get(getSourceKey()));
  }
  
  public void applyTo(Binder binder)
  {
    throw new UnsupportedOperationException("This element represents a synthetic binding.");
  }
  
  public String toString()
  {
    return new .ToStringBuilder(ConvertedConstantBinding.class).add("key", getKey()).add("sourceKey", getSourceKey()).add("value", value).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof ConvertedConstantBindingImpl))
    {
      ConvertedConstantBindingImpl<?> o = (ConvertedConstantBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(value, value));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping(), value });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.ConvertedConstantBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */