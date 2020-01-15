package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Sets;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderWithDependencies;
import java.util.Set;

public final class Providers
{
  public static <T> com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider<T> of(T instance)
  {
    new com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider()
    {
      public T get()
      {
        return (T)val$instance;
      }
      
      public String toString()
      {
        return "of(" + val$instance + ")";
      }
    };
  }
  
  public static <T> com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider<T> guicify(javax.inject.Provider<T> provider)
  {
    if ((provider instanceof com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider)) {
      return (com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider)provider;
    }
    javax.inject.Provider<T> delegate = (javax.inject.Provider).Preconditions.checkNotNull(provider, "provider");
    
    Set<InjectionPoint> injectionPoints = InjectionPoint.forInstanceMethodsAndFields(provider.getClass());
    if (injectionPoints.isEmpty()) {
      new com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider()
      {
        public T get()
        {
          return (T)val$delegate.get();
        }
        
        public String toString()
        {
          return "guicified(" + val$delegate + ")";
        }
      };
    }
    Set<Dependency<?>> mutableDeps = .Sets.newHashSet();
    for (InjectionPoint ip : injectionPoints) {
      mutableDeps.addAll(ip.getDependencies());
    }
    final Set<Dependency<?>> dependencies = .ImmutableSet.copyOf(mutableDeps);
    new ProviderWithDependencies()
    {
      @Inject
      void initialize(Injector injector)
      {
        injector.injectMembers(val$delegate);
      }
      
      public Set<Dependency<?>> getDependencies()
      {
        return dependencies;
      }
      
      public T get()
      {
        return (T)val$delegate.get();
      }
      
      public String toString()
      {
        return "guicified(" + val$delegate + ")";
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Providers
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */