package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import javax.inject.Provider;

final class BoundProviderFactory<T>
  implements InternalFactory<T>, CreationListener
{
  private final InjectorImpl injector;
  final Key<? extends Provider<? extends T>> providerKey;
  final Object source;
  private InternalFactory<? extends Provider<? extends T>> providerFactory;
  
  BoundProviderFactory(InjectorImpl injector, Key<? extends Provider<? extends T>> providerKey, Object source)
  {
    this.injector = injector;
    this.providerKey = providerKey;
    this.source = source;
  }
  
  public void notify(Errors errors)
  {
    try
    {
      providerFactory = injector.getInternalFactory(providerKey, errors.withSource(source), InjectorImpl.JitLimitation.NEW_OR_EXISTING_JIT);
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
    }
  }
  
  public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
    throws ErrorsException
  {
    errors = errors.withSource(providerKey);
    Provider<? extends T> provider = (Provider)providerFactory.get(errors, context, dependency, true);
    try
    {
      return (T)errors.checkForNull(provider.get(), source, dependency);
    }
    catch (RuntimeException userException)
    {
      throw errors.errorInProvider(userException).toException();
    }
  }
  
  public String toString()
  {
    return providerKey.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BoundProviderFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */