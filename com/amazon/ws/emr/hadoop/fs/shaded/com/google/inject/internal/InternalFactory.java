package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

abstract interface InternalFactory<T>
{
  public abstract T get(Errors paramErrors, InternalContext paramInternalContext, Dependency<?> paramDependency, boolean paramBoolean)
    throws ErrorsException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */