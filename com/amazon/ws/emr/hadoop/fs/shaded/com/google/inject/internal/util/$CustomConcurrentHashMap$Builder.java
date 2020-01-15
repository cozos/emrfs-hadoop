package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.concurrent.ConcurrentMap;

final class $CustomConcurrentHashMap$Builder
{
  float loadFactor = 0.75F;
  int initialCapacity = 16;
  int concurrencyLevel = 16;
  
  public Builder loadFactor(float loadFactor)
  {
    if (loadFactor <= 0.0F) {
      throw new IllegalArgumentException();
    }
    this.loadFactor = loadFactor;
    return this;
  }
  
  public Builder initialCapacity(int initialCapacity)
  {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException();
    }
    this.initialCapacity = initialCapacity;
    return this;
  }
  
  public Builder concurrencyLevel(int concurrencyLevel)
  {
    if (concurrencyLevel <= 0) {
      throw new IllegalArgumentException();
    }
    this.concurrencyLevel = concurrencyLevel;
    return this;
  }
  
  public <K, V, E> ConcurrentMap<K, V> buildMap(.CustomConcurrentHashMap.Strategy<K, V, E> strategy)
  {
    if (strategy == null) {
      throw new NullPointerException("strategy");
    }
    return new .CustomConcurrentHashMap.Impl(strategy, this);
  }
  
  public <K, V, E> ConcurrentMap<K, V> buildComputingMap(.CustomConcurrentHashMap.ComputingStrategy<K, V, E> strategy, .Function<? super K, ? extends V> computer)
  {
    if (strategy == null) {
      throw new NullPointerException("strategy");
    }
    if (computer == null) {
      throw new NullPointerException("computer");
    }
    return new .CustomConcurrentHashMap.ComputingImpl(strategy, this, computer);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */