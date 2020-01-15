package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

final class MapMaker$NullComputingConcurrentMap<K, V>
  extends MapMaker.NullConcurrentMap<K, V>
{
  private static final long serialVersionUID = 0L;
  final Function<? super K, ? extends V> computingFunction;
  
  MapMaker$NullComputingConcurrentMap(MapMaker mapMaker, Function<? super K, ? extends V> computingFunction)
  {
    super(mapMaker);
    this.computingFunction = ((Function)Preconditions.checkNotNull(computingFunction));
  }
  
  public V get(Object k)
  {
    K key = (K)k;
    V value = compute(key);
    Preconditions.checkNotNull(value, "%s returned null for key %s.", new Object[] { computingFunction, key });
    notifyRemoval(key, value);
    return value;
  }
  
  private V compute(K key)
  {
    Preconditions.checkNotNull(key);
    try
    {
      return (V)computingFunction.apply(key);
    }
    catch (ComputationException e)
    {
      throw e;
    }
    catch (Throwable t)
    {
      throw new ComputationException(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker.NullComputingConcurrentMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */