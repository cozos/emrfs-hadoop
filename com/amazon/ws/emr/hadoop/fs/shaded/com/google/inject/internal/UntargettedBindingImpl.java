package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.UntargettedBinding;

final class UntargettedBindingImpl<T>
  extends BindingImpl<T>
  implements UntargettedBinding<T>
{
  UntargettedBindingImpl(InjectorImpl injector, Key<T> key, Object source)
  {
    super(injector, key, source, new InternalFactory()
    {
      public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
      {
        throw new AssertionError();
      }
    }, Scoping.UNSCOPED);
  }
  
  public UntargettedBindingImpl(Object source, Key<T> key, Scoping scoping)
  {
    super(source, key, scoping);
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    return (V)visitor.visit(this);
  }
  
  public BindingImpl<T> withScoping(Scoping scoping)
  {
    return new UntargettedBindingImpl(getSource(), getKey(), scoping);
  }
  
  public BindingImpl<T> withKey(Key<T> key)
  {
    return new UntargettedBindingImpl(getSource(), key, getScoping());
  }
  
  public void applyTo(Binder binder)
  {
    getScoping().applyTo(binder.withSource(getSource()).bind(getKey()));
  }
  
  public String toString()
  {
    return new .ToStringBuilder(UntargettedBinding.class).add("key", getKey()).add("source", getSource()).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof UntargettedBindingImpl))
    {
      UntargettedBindingImpl<?> o = (UntargettedBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.UntargettedBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */