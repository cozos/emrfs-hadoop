package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

final class LocalCache$LoadingSerializationProxy<K, V>
  extends LocalCache.ManualSerializationProxy<K, V>
  implements LoadingCache<K, V>, Serializable
{
  private static final long serialVersionUID = 1L;
  transient LoadingCache<K, V> autoDelegate;
  
  LocalCache$LoadingSerializationProxy(LocalCache<K, V> cache)
  {
    super(cache);
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    in.defaultReadObject();
    CacheBuilder<K, V> builder = recreateCacheBuilder();
    autoDelegate = builder.build(loader);
  }
  
  public V get(K key)
    throws ExecutionException
  {
    return (V)autoDelegate.get(key);
  }
  
  public V getUnchecked(K key)
  {
    return (V)autoDelegate.getUnchecked(key);
  }
  
  public ImmutableMap<K, V> getAll(Iterable<? extends K> keys)
    throws ExecutionException
  {
    return autoDelegate.getAll(keys);
  }
  
  public final V apply(K key)
  {
    return (V)autoDelegate.apply(key);
  }
  
  public void refresh(K key)
  {
    autoDelegate.refresh(key);
  }
  
  private Object readResolve()
  {
    return autoDelegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.LoadingSerializationProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */