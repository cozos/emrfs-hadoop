package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

final class MapMaker$ComputingMapAdapter<K, V>
  extends ComputingConcurrentHashMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  
  MapMaker$ComputingMapAdapter(MapMaker mapMaker, Function<? super K, ? extends V> computingFunction)
  {
    super(mapMaker, computingFunction);
  }
  
  public V get(Object key)
  {
    V value;
    Throwable cause;
    try
    {
      value = getOrCompute(key);
    }
    catch (ExecutionException e)
    {
      cause = e.getCause();
      Throwables.propagateIfInstanceOf(cause, ComputationException.class);
      throw new ComputationException(cause);
    }
    if (value == null)
    {
      e = String.valueOf(String.valueOf(computingFunction));cause = String.valueOf(String.valueOf(key));throw new NullPointerException(24 + e.length() + cause.length() + e + " returned null for key " + cause + ".");
    }
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker.ComputingMapAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */