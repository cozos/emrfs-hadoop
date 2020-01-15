package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFutureTask;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class CacheLoader$1
  extends CacheLoader<K, V>
{
  CacheLoader$1(CacheLoader paramCacheLoader, Executor paramExecutor) {}
  
  public V load(K key)
    throws Exception
  {
    return (V)val$loader.load(key);
  }
  
  public ListenableFuture<V> reload(final K key, final V oldValue)
    throws Exception
  {
    ListenableFutureTask<V> task = ListenableFutureTask.create(new Callable()
    {
      public V call()
        throws Exception
      {
        return (V)val$loader.reload(key, oldValue).get();
      }
    });
    val$executor.execute(task);
    return task;
  }
  
  public Map<K, V> loadAll(Iterable<? extends K> keys)
    throws Exception
  {
    return val$loader.loadAll(keys);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */