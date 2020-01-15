package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

public abstract interface Scope
{
  public abstract <T> Provider<T> scope(Key<T> paramKey, Provider<T> paramProvider);
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */