package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

final class ConstructionContext<T>
{
  T currentReference;
  boolean constructing;
  List<DelegatingInvocationHandler<T>> invocationHandlers;
  
  public T getCurrentReference()
  {
    return (T)currentReference;
  }
  
  public void removeCurrentReference()
  {
    currentReference = null;
  }
  
  public void setCurrentReference(T currentReference)
  {
    this.currentReference = currentReference;
  }
  
  public boolean isConstructing()
  {
    return constructing;
  }
  
  public void startConstruction()
  {
    constructing = true;
  }
  
  public void finishConstruction()
  {
    constructing = false;
    invocationHandlers = null;
  }
  
  public Object createProxy(Errors errors, Class<?> expectedType)
    throws ErrorsException
  {
    if (!expectedType.isInterface()) {
      throw errors.cannotSatisfyCircularDependency(expectedType).toException();
    }
    if (invocationHandlers == null) {
      invocationHandlers = new ArrayList();
    }
    DelegatingInvocationHandler<T> invocationHandler = new DelegatingInvocationHandler();
    invocationHandlers.add(invocationHandler);
    
    ClassLoader classLoader = BytecodeGen.getClassLoader(expectedType);
    return expectedType.cast(Proxy.newProxyInstance(classLoader, new Class[] { expectedType, CircularDependencyProxy.class }, invocationHandler));
  }
  
  public void setProxyDelegates(T delegate)
  {
    if (invocationHandlers != null) {
      for (DelegatingInvocationHandler<T> handler : invocationHandlers) {
        handler.setDelegate(delegate);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructionContext
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */