package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;

abstract interface SingleMemberInjector
{
  public abstract void inject(Errors paramErrors, InternalContext paramInternalContext, Object paramObject);
  
  public abstract InjectionPoint getInjectionPoint();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.SingleMemberInjector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */