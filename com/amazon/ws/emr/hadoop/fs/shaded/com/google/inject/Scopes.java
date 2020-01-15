package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.CircularDependencyProxy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalInjectorCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.LinkedBindingImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ExposedBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import java.lang.annotation.Annotation;

public class Scopes
{
  private static final Object NULL = new Object();
  public static final Scope SINGLETON = new Scope()
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
                Object providedOrSentinel = provided == null ? Scopes.NULL : provided;
                if ((instance != null) && (instance != providedOrSentinel)) {
                  throw new ProvisionException("Provider was reentrant while creating a singleton");
                }
                instance = providedOrSentinel;
              }
            }
          }
          Object localInstance = instance;
          
          T returnedInstance = localInstance != Scopes.NULL ? localInstance : null;
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
  };
  public static final Scope NO_SCOPE = new Scope()
  {
    public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped)
    {
      return unscoped;
    }
    
    public String toString()
    {
      return "Scopes.NO_SCOPE";
    }
  };
  
  public static boolean isSingleton(Binding<?> binding)
  {
    for (;;)
    {
      boolean singleton = ((Boolean)binding.acceptScopingVisitor(new BindingScopingVisitor()
      {
        public Boolean visitNoScoping()
        {
          return Boolean.valueOf(false);
        }
        
        public Boolean visitScopeAnnotation(Class<? extends Annotation> scopeAnnotation)
        {
          return Boolean.valueOf((scopeAnnotation == Singleton.class) || (scopeAnnotation == javax.inject.Singleton.class));
        }
        
        public Boolean visitScope(Scope scope)
        {
          return Boolean.valueOf(scope == Scopes.SINGLETON);
        }
        
        public Boolean visitEagerSingleton()
        {
          return Boolean.valueOf(true);
        }
      })).booleanValue();
      if (singleton) {
        return true;
      }
      if ((binding instanceof LinkedBindingImpl))
      {
        LinkedBindingImpl<?> linkedBinding = (LinkedBindingImpl)binding;
        Injector injector = linkedBinding.getInjector();
        if (injector != null) {
          binding = injector.getBinding(linkedBinding.getLinkedKey());
        } else {
          break;
        }
      }
      else
      {
        if (!(binding instanceof ExposedBinding)) {
          break;
        }
        ExposedBinding<?> exposedBinding = (ExposedBinding)binding;
        Injector injector = exposedBinding.getPrivateElements().getInjector();
        if (injector == null) {
          break;
        }
        binding = injector.getBinding(exposedBinding.getKey());
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */