package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.CircularDependencyProxy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalInjectorCreator;

class Scopes$1$1
  implements Provider<T>
{
  private volatile Object instance;
  
  Scopes$1$1(Scopes.1 param1, Provider paramProvider) {}
  
  public T get()
  {
    if (instance == null) {
      synchronized (InternalInjectorCreator.class)
      {
        if (instance == null)
        {
          T provided = val$creator.get();
          if ((provided instanceof CircularDependencyProxy)) {
            return provided;
          }
          Object providedOrSentinel = provided == null ? Scopes.access$000() : provided;
          if ((instance != null) && (instance != providedOrSentinel)) {
            throw new ProvisionException("Provider was reentrant while creating a singleton");
          }
          instance = providedOrSentinel;
        }
      }
    }
    Object localInstance = instance;
    
    T returnedInstance = localInstance != Scopes.access$000() ? localInstance : null;
    return returnedInstance;
  }
  
  public String toString()
  {
    return String.format("%s[%s]", new Object[] { val$creator, Scopes.SINGLETON });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes.1.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */