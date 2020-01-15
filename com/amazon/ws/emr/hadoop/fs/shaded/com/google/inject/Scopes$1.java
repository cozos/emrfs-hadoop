package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.CircularDependencyProxy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalInjectorCreator;

final class Scopes$1
  implements Scope
{
  public <T> Provider<T> scope(Key<T> key, final Provider<T> creator)
  {
    new Provider()
    {
      private volatile Object instance;
      
      public T get()
      {
        if (instance == null) {
          synchronized (InternalInjectorCreator.class)
          {
            if (instance == null)
            {
              T provided = creator.get();
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
        return String.format("%s[%s]", new Object[] { creator, Scopes.SINGLETON });
      }
    };
  }
  
  public String toString()
  {
    return "Scopes.SINGLETON";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */