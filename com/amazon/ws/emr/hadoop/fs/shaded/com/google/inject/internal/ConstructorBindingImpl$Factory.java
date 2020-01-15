package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

class ConstructorBindingImpl$Factory<T>
  implements InternalFactory<T>
{
  private final boolean failIfNotLinked;
  private final Key<?> key;
  private boolean allowCircularProxy;
  private ConstructorInjector<T> constructorInjector;
  
  ConstructorBindingImpl$Factory(boolean failIfNotLinked, Key<?> key)
  {
    this.failIfNotLinked = failIfNotLinked;
    this.key = key;
  }
  
  public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
    throws ErrorsException
  {
    .Preconditions.checkState(constructorInjector != null, "Constructor not ready");
    if ((failIfNotLinked) && (!linked)) {
      throw errors.jitDisabled(key).toException();
    }
    return (T)constructorInjector.construct(errors, context, dependency.getKey().getTypeLiteral().getRawType(), allowCircularProxy);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructorBindingImpl.Factory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */