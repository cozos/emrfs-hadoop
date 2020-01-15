package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Member;
import java.util.logging.Logger;

class InjectorShell$LoggerFactory
  implements InternalFactory<Logger>, Provider<Logger>
{
  public Logger get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
  {
    InjectionPoint injectionPoint = dependency.getInjectionPoint();
    return injectionPoint == null ? Logger.getAnonymousLogger() : Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
  }
  
  public Logger get()
  {
    return Logger.getAnonymousLogger();
  }
  
  public String toString()
  {
    return "Provider<Logger>";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorShell.LoggerFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */