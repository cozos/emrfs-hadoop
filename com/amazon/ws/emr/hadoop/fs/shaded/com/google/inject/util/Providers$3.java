package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderWithDependencies;
import java.util.Set;
import javax.inject.Provider;

final class Providers$3
  implements ProviderWithDependencies<T>
{
  Providers$3(Provider paramProvider, Set paramSet) {}
  
  @Inject
  void initialize(Injector injector)
  {
    injector.injectMembers(val$delegate);
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return val$dependencies;
  }
  
  public T get()
  {
    return (T)val$delegate.get();
  }
  
  public String toString()
  {
    return "guicified(" + val$delegate + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Providers.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */