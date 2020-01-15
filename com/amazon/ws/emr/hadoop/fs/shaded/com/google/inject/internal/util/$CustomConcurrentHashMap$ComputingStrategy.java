package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

public abstract interface $CustomConcurrentHashMap$ComputingStrategy<K, V, E>
  extends .CustomConcurrentHashMap.Strategy<K, V, E>
{
  public abstract V compute(K paramK, E paramE, .Function<? super K, ? extends V> paramFunction);
  
  public abstract V waitForValue(E paramE)
    throws InterruptedException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.ComputingStrategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */