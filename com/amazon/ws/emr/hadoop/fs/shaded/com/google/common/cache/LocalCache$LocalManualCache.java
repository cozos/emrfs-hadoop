package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

class LocalCache$LocalManualCache<K, V>
  implements Cache<K, V>, Serializable
{
  final LocalCache<K, V> localCache;
  private static final long serialVersionUID = 1L;
  
  LocalCache$LocalManualCache(CacheBuilder<? super K, ? super V> builder)
  {
    this(new LocalCache(builder, null));
  }
  
  private LocalCache$LocalManualCache(LocalCache<K, V> localCache)
  {
    this.localCache = localCache;
  }
  
  @Nullable
  public V getIfPresent(Object key)
  {
    return (V)localCache.getIfPresent(key);
  }
  
  public V get(K key, final Callable<? extends V> valueLoader)
    throws ExecutionException
  {
    Preconditions.checkNotNull(valueLoader);
    (V)localCache.get(key, new CacheLoader()
    {
      public V load(Object key)
        throws Exception
      {
        return (V)valueLoader.call();
      }
    });
  }
  
  public ImmutableMap<K, V> getAllPresent(Iterable<?> keys)
  {
    return localCache.getAllPresent(keys);
  }
  
  public void put(K key, V value)
  {
    localCache.put(key, value);
  }
  
  public void putAll(Map<? extends K, ? extends V> m)
  {
    localCache.putAll(m);
  }
  
  public void invalidate(Object key)
  {
    Preconditions.checkNotNull(key);
    localCache.remove(key);
  }
  
  public void invalidateAll(Iterable<?> keys)
  {
    localCache.invalidateAll(keys);
  }
  
  public void invalidateAll()
  {
    localCache.clear();
  }
  
  public long size()
  {
    return localCache.longSize();
  }
  
  public ConcurrentMap<K, V> asMap()
  {
    return localCache;
  }
  
  public CacheStats stats()
  {
    AbstractCache.SimpleStatsCounter aggregator = new AbstractCache.SimpleStatsCounter();
    aggregator.incrementBy(localCache.globalStatsCounter);
    for (LocalCache.Segment<K, V> segment : localCache.segments) {
      aggregator.incrementBy(statsCounter);
    }
    return aggregator.snapshot();
  }
  
  public void cleanUp()
  {
    localCache.cleanUp();
  }
  
  Object writeReplace()
  {
    return new LocalCache.ManualSerializationProxy(localCache);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.LocalManualCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */