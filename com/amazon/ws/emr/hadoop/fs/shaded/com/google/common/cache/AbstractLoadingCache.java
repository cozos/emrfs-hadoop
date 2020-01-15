package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Beta
public abstract class AbstractLoadingCache<K, V>
  extends AbstractCache<K, V>
  implements LoadingCache<K, V>
{
  public V getUnchecked(K key)
  {
    try
    {
      return (V)get(key);
    }
    catch (ExecutionException e)
    {
      throw new UncheckedExecutionException(e.getCause());
    }
  }
  
  public ImmutableMap<K, V> getAll(Iterable<? extends K> keys)
    throws ExecutionException
  {
    Map<K, V> result = Maps.newLinkedHashMap();
    for (K key : keys) {
      if (!result.containsKey(key)) {
        result.put(key, get(key));
      }
    }
    return ImmutableMap.copyOf(result);
  }
  
  public final V apply(K key)
  {
    return (V)getUnchecked(key);
  }
  
  public void refresh(K key)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.AbstractLoadingCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */