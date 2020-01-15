package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

public abstract interface $CustomConcurrentHashMap$Strategy<K, V, E>
{
  public abstract E newEntry(K paramK, int paramInt, E paramE);
  
  public abstract E copyEntry(K paramK, E paramE1, E paramE2);
  
  public abstract void setValue(E paramE, V paramV);
  
  public abstract V getValue(E paramE);
  
  public abstract boolean equalKeys(K paramK, Object paramObject);
  
  public abstract boolean equalValues(V paramV, Object paramObject);
  
  public abstract int hashKey(Object paramObject);
  
  public abstract K getKey(E paramE);
  
  public abstract E getNext(E paramE);
  
  public abstract int getHash(E paramE);
  
  public abstract void setInternals(.CustomConcurrentHashMap.Internals<K, V, E> paramInternals);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Strategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */