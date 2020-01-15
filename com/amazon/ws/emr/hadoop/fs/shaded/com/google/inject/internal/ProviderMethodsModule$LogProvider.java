package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import java.lang.reflect.Method;
import java.util.logging.Logger;

final class ProviderMethodsModule$LogProvider
  implements Provider<Logger>
{
  private final String name;
  
  public ProviderMethodsModule$LogProvider(Method method)
  {
    name = (method.getDeclaringClass().getName() + "." + method.getName());
  }
  
  public Logger get()
  {
    return Logger.getLogger(name);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProviderMethodsModule.LogProvider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */