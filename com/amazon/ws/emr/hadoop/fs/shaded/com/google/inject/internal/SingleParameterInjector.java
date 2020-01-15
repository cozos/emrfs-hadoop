package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

final class SingleParameterInjector<T>
{
  private static final Object[] NO_ARGUMENTS = new Object[0];
  private final Dependency<T> dependency;
  private final InternalFactory<? extends T> factory;
  
  SingleParameterInjector(Dependency<T> dependency, InternalFactory<? extends T> factory)
  {
    this.dependency = dependency;
    this.factory = factory;
  }
  
  private T inject(Errors errors, InternalContext context)
    throws ErrorsException
  {
    Dependency previous = context.setDependency(dependency);
    try
    {
      return (T)factory.get(errors.withSource(dependency), context, dependency, false);
    }
    finally
    {
      context.setDependency(previous);
    }
  }
  
  static Object[] getAll(Errors errors, InternalContext context, SingleParameterInjector<?>[] parameterInjectors)
    throws ErrorsException
  {
    if (parameterInjectors == null) {
      return NO_ARGUMENTS;
    }
    int numErrorsBefore = errors.size();
    
    int size = parameterInjectors.length;
    Object[] parameters = new Object[size];
    for (int i = 0; i < size; i++)
    {
      SingleParameterInjector<?> parameterInjector = parameterInjectors[i];
      try
      {
        parameters[i] = parameterInjector.inject(errors, context);
      }
      catch (ErrorsException e)
      {
        errors.merge(e.getErrors());
      }
    }
    errors.throwIfNewErrors(numErrorsBefore);
    return parameters;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.SingleParameterInjector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */