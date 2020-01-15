package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class InjectorImpl$2
  implements InternalFactory<T>
{
  InjectorImpl$2(InjectorImpl paramInjectorImpl, Key paramKey, BindingImpl paramBindingImpl, Class paramClass1, Class paramClass2) {}
  
  public T get(Errors errors, InternalContext context, Dependency dependency, boolean linked)
    throws ErrorsException
  {
    errors = errors.withSource(val$providerKey);
    Provider<?> provider = (Provider)val$providerBinding.getInternalFactory().get(errors, context, dependency, true);
    try
    {
      Object o = provider.get();
      if ((o != null) && (!val$rawType.isInstance(o))) {
        throw errors.subtypeNotProvided(val$providerType, val$rawType).toException();
      }
      return (T)o;
    }
    catch (RuntimeException e)
    {
      throw errors.errorInProvider(e).toException();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */