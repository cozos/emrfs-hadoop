package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

abstract interface ConstructionProxyFactory<T>
{
  public abstract ConstructionProxy<T> create()
    throws ErrorsException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructionProxyFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */