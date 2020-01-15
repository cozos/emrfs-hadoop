package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class InjectorImpl$4$1
  implements ContextualCallable<T>
{
  InjectorImpl$4$1(InjectorImpl.4 param4, Errors paramErrors) {}
  
  public T call(InternalContext context)
    throws ErrorsException
  {
    Dependency previous = context.setDependency(this$1.val$dependency);
    try
    {
      return (T)this$1.val$factory.get(val$errors, context, this$1.val$dependency, false);
    }
    finally
    {
      context.setDependency(previous);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.4.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */