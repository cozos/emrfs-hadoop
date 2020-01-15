package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ProvisionException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class InjectorImpl$4
  implements Provider<T>
{
  InjectorImpl$4(InjectorImpl paramInjectorImpl, Dependency paramDependency, InternalFactory paramInternalFactory) {}
  
  public T get()
  {
    final Errors errors = new Errors(val$dependency);
    try
    {
      T t = this$0.callInContext(new ContextualCallable()
      {
        public T call(InternalContext context)
          throws ErrorsException
        {
          Dependency previous = context.setDependency(val$dependency);
          try
          {
            return (T)val$factory.get(errors, context, val$dependency, false);
          }
          finally
          {
            context.setDependency(previous);
          }
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
    return val$factory.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.4
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */