package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

final class ConstantFactory<T>
  implements InternalFactory<T>
{
  private final Initializable<T> initializable;
  
  public ConstantFactory(Initializable<T> initializable)
  {
    this.initializable = initializable;
  }
  
  public T get(Errors errors, InternalContext context, Dependency dependency, boolean linked)
    throws ErrorsException
  {
    return (T)initializable.get(errors);
  }
  
  public String toString()
  {
    return new .ToStringBuilder(ConstantFactory.class).add("value", initializable).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstantFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */