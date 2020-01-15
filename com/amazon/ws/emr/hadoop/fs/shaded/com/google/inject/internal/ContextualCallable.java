package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

abstract interface ContextualCallable<T>
{
  public abstract T call(InternalContext paramInternalContext)
    throws ErrorsException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ContextualCallable
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */