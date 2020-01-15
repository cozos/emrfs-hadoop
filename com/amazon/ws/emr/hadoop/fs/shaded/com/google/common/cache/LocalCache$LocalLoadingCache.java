package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.concurrent.ExecutionException;

class LocalCache$LocalLoadingCache<K, V>
  extends LocalCache.LocalManualCache<K, V>
  implements LoadingCache<K, V>
{
  private static final long serialVersionUID = 1L;
  
  LocalCache$LocalLoadingCache(CacheBuilder<? super K, ? super V> builder, CacheLoader<? super K, V> loader)
  {
    super(new LocalCache(builder, (CacheLoader)Preconditions.checkNotNull(loader)), null);
  }
  
  public V get(K key)
    throws ExecutionException
  {
    return (V)localCache.getOrLoad(key);
  }
  
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
    return localCache.getAll(keys);
  }
  
  public void refresh(K key)
  {
    localCache.refresh(key);
  }
  
  public final V apply(K key)
  {
    return (V)getUnchecked(key);
  }
  
  Object writeReplace()
  {
    return new LocalCache.LoadingSerializationProxy(localCache);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.LocalLoadingCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */