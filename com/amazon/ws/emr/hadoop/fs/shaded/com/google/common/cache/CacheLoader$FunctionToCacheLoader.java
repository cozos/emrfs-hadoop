package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;

final class CacheLoader$FunctionToCacheLoader<K, V>
  extends CacheLoader<K, V>
  implements Serializable
{
  private final Function<K, V> computingFunction;
  private static final long serialVersionUID = 0L;
  
  public CacheLoader$FunctionToCacheLoader(Function<K, V> computingFunction)
  {
    this.computingFunction = ((Function)Preconditions.checkNotNull(computingFunction));
  }
  
  public V load(K key)
  {
    return (V)computingFunction.apply(Preconditions.checkNotNull(key));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader.FunctionToCacheLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */