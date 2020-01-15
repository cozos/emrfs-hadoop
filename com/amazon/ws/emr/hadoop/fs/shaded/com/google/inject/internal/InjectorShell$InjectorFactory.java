package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class InjectorShell$InjectorFactory
  implements InternalFactory<Injector>, Provider<Injector>
{
  private final Injector injector;
  
  private InjectorShell$InjectorFactory(Injector injector)
  {
    this.injector = injector;
  }
  
  public Injector get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
    throws ErrorsException
  {
    return injector;
  }
  
  public Injector get()
  {
    return injector;
  }
  
  public String toString()
  {
    return "Provider<Injector>";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorShell.InjectorFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */