package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

final class FactoryProxy<T>
  implements InternalFactory<T>, CreationListener
{
  private final InjectorImpl injector;
  private final Key<T> key;
  private final Key<? extends T> targetKey;
  private final Object source;
  private InternalFactory<? extends T> targetFactory;
  
  FactoryProxy(InjectorImpl injector, Key<T> key, Key<? extends T> targetKey, Object source)
  {
    this.injector = injector;
    this.key = key;
    this.targetKey = targetKey;
    this.source = source;
  }
  
  public void notify(Errors errors)
  {
    try
    {
      targetFactory = injector.getInternalFactory(targetKey, errors.withSource(source), InjectorImpl.JitLimitation.NEW_OR_EXISTING_JIT);
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
    }
  }
  
  public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
    throws ErrorsException
  {
    return (T)targetFactory.get(errors.withSource(targetKey), context, dependency, true);
  }
  
  public String toString()
  {
    return new .ToStringBuilder(FactoryProxy.class).add("key", key).add("provider", targetFactory).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.FactoryProxy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */