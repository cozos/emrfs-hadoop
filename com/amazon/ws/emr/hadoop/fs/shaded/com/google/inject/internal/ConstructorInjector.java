package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

final class ConstructorInjector<T>
{
  private final .ImmutableSet<InjectionPoint> injectableMembers;
  private final SingleParameterInjector<?>[] parameterInjectors;
  private final ConstructionProxy<T> constructionProxy;
  private final MembersInjectorImpl<T> membersInjector;
  
  ConstructorInjector(Set<InjectionPoint> injectableMembers, ConstructionProxy<T> constructionProxy, SingleParameterInjector<?>[] parameterInjectors, MembersInjectorImpl<T> membersInjector)
  {
    this.injectableMembers = .ImmutableSet.copyOf(injectableMembers);
    this.constructionProxy = constructionProxy;
    this.parameterInjectors = parameterInjectors;
    this.membersInjector = membersInjector;
  }
  
  public .ImmutableSet<InjectionPoint> getInjectableMembers()
  {
    return injectableMembers;
  }
  
  ConstructionProxy<T> getConstructionProxy()
  {
    return constructionProxy;
  }
  
  Object construct(Errors errors, InternalContext context, Class<?> expectedType, boolean allowProxy)
    throws ErrorsException
  {
    ConstructionContext<T> constructionContext = context.getConstructionContext(this);
    if (constructionContext.isConstructing())
    {
      if (!allowProxy) {
        throw errors.circularProxiesDisabled(expectedType).toException();
      }
      return constructionContext.createProxy(errors, expectedType);
    }
    T t = constructionContext.getCurrentReference();
    if (t != null) {
      return t;
    }
    try
    {
      constructionContext.startConstruction();
      Object[] parameters;
      try
      {
        parameters = SingleParameterInjector.getAll(errors, context, parameterInjectors);
        t = constructionProxy.newInstance(parameters);
        constructionContext.setProxyDelegates(t);
      }
      finally {}
      constructionContext.setCurrentReference(t);
      
      membersInjector.injectMembers(t, errors, context, false);
      membersInjector.notifyListeners(t, errors);
      
      return t;
    }
    catch (InvocationTargetException userException)
    {
      Object cause = userException.getCause() != null ? userException.getCause() : userException;
      
      throw errors.withSource(constructionProxy.getInjectionPoint()).errorInjectingConstructor((Throwable)cause).toException();
    }
    finally
    {
      constructionContext.removeCurrentReference();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructorInjector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */