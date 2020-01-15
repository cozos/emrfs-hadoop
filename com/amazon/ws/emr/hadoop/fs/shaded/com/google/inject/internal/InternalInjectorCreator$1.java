package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class InternalInjectorCreator$1
  implements ContextualCallable<Void>
{
  Dependency<?> dependency = Dependency.get(val$binding.getKey());
  
  InternalInjectorCreator$1(InternalInjectorCreator paramInternalInjectorCreator, BindingImpl paramBindingImpl, Errors paramErrors) {}
  
  public Void call(InternalContext context)
  {
    Dependency previous = context.setDependency(dependency);
    Errors errorsForBinding = val$errors.withSource(dependency);
    try
    {
      val$binding.getInternalFactory().get(errorsForBinding, context, dependency, false);
    }
    catch (ErrorsException e)
    {
      errorsForBinding.merge(e.getErrors());
    }
    finally
    {
      context.setDependency(previous);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalInjectorCreator.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */