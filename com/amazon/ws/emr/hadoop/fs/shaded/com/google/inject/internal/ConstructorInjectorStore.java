package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;

final class ConstructorInjectorStore
{
  private final InjectorImpl injector;
  private final FailableCache<InjectionPoint, ConstructorInjector<?>> cache = new FailableCache()
  {
    protected ConstructorInjector<?> create(InjectionPoint constructorInjector, Errors errors)
      throws ErrorsException
    {
      return ConstructorInjectorStore.this.createConstructor(constructorInjector, errors);
    }
  };
  
  ConstructorInjectorStore(InjectorImpl injector)
  {
    this.injector = injector;
  }
  
  public ConstructorInjector<?> get(InjectionPoint constructorInjector, Errors errors)
    throws ErrorsException
  {
    return (ConstructorInjector)cache.get(constructorInjector, errors);
  }
  
  boolean remove(InjectionPoint ip)
  {
    return cache.remove(ip);
  }
  
  private <T> ConstructorInjector<T> createConstructor(InjectionPoint injectionPoint, Errors errors)
    throws ErrorsException
  {
    int numErrorsBefore = errors.size();
    
    SingleParameterInjector<?>[] constructorParameterInjectors = injector.getParametersInjectors(injectionPoint.getDependencies(), errors);
    
    MembersInjectorImpl<T> membersInjector = injector.membersInjectorStore.get(injectionPoint.getDeclaringType(), errors);
    
    .ImmutableList<MethodAspect> injectorAspects = injector.state.getMethodAspects();
    .ImmutableList<MethodAspect> methodAspects = membersInjector.getAddedAspects().isEmpty() ? injectorAspects : .ImmutableList.copyOf(.Iterables.concat(injectorAspects, membersInjector.getAddedAspects()));
    
    ConstructionProxyFactory<T> factory = new ProxyFactory(injectionPoint, methodAspects);
    
    errors.throwIfNewErrors(numErrorsBefore);
    
    return new ConstructorInjector(membersInjector.getInjectionPoints(), factory.create(), constructorParameterInjectors, membersInjector);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructorInjectorStore
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */