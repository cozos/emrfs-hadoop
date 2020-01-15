package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;

abstract interface Lookups
{
  public abstract <T> Provider<T> getProvider(Key<T> paramKey);
  
  public abstract <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> paramTypeLiteral);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Lookups
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */