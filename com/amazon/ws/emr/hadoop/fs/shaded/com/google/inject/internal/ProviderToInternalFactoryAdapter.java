package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ProvisionException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

final class ProviderToInternalFactoryAdapter<T>
  implements Provider<T>
{
  private final InjectorImpl injector;
  private final InternalFactory<? extends T> internalFactory;
  
  public ProviderToInternalFactoryAdapter(InjectorImpl injector, InternalFactory<? extends T> internalFactory)
  {
    this.injector = injector;
    this.internalFactory = internalFactory;
  }
  
  public T get()
  {
    final Errors errors = new Errors();
    try
    {
      T t = injector.callInContext(new ContextualCallable()
      {
        public T call(InternalContext context)
          throws ErrorsException
        {
          Dependency dependency = context.getDependency();
          
          return (T)internalFactory.get(errors, context, dependency, true);
        }
      });
      errors.throwIfNewErrors(0);
      return t;
    }
    catch (ErrorsException e)
    {
      throw new ProvisionException(errors.merge(e.getErrors()).getMessages());
    }
  }
  
  public String toString()
  {
    return internalFactory.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProviderToInternalFactoryAdapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */