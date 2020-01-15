package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class ProviderToInternalFactoryAdapter$1
  implements ContextualCallable<T>
{
  ProviderToInternalFactoryAdapter$1(ProviderToInternalFactoryAdapter paramProviderToInternalFactoryAdapter, Errors paramErrors) {}
  
  public T call(InternalContext context)
    throws ErrorsException
  {
    Dependency dependency = context.getDependency();
    
    return (T)ProviderToInternalFactoryAdapter.access$000(this$0).get(val$errors, context, dependency, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProviderToInternalFactoryAdapter.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */