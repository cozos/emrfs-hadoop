package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class InjectorImpl$3
  implements InternalFactory<T>
{
  InjectorImpl$3(InjectorImpl paramInjectorImpl, BindingImpl paramBindingImpl, Key paramKey) {}
  
  public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
    throws ErrorsException
  {
    return (T)val$targetBinding.getInternalFactory().get(errors.withSource(val$targetKey), context, dependency, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */