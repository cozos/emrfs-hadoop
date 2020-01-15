package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Field;
import java.util.List;

final class SingleFieldInjector
  implements SingleMemberInjector
{
  final Field field;
  final InjectionPoint injectionPoint;
  final Dependency<?> dependency;
  final InternalFactory<?> factory;
  
  public SingleFieldInjector(InjectorImpl injector, InjectionPoint injectionPoint, Errors errors)
    throws ErrorsException
  {
    this.injectionPoint = injectionPoint;
    field = ((Field)injectionPoint.getMember());
    dependency = ((Dependency)injectionPoint.getDependencies().get(0));
    
    field.setAccessible(true);
    factory = injector.getInternalFactory(dependency.getKey(), errors, InjectorImpl.JitLimitation.NO_JIT);
  }
  
  public InjectionPoint getInjectionPoint()
  {
    return injectionPoint;
  }
  
  public void inject(Errors errors, InternalContext context, Object o)
  {
    errors = errors.withSource(dependency);
    
    Dependency previous = context.setDependency(dependency);
    try
    {
      Object value = factory.get(errors, context, dependency, false);
      field.set(o, value);
    }
    catch (ErrorsException e)
    {
      errors.withSource(injectionPoint).merge(e.getErrors());
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
    finally
    {
      context.setDependency(previous);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.SingleFieldInjector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */