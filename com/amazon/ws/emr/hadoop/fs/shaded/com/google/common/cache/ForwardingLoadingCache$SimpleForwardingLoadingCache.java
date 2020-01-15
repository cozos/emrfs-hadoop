package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

@Beta
public abstract class ForwardingLoadingCache$SimpleForwardingLoadingCache<K, V>
  extends ForwardingLoadingCache<K, V>
{
  private final LoadingCache<K, V> delegate;
  
  protected ForwardingLoadingCache$SimpleForwardingLoadingCache(LoadingCache<K, V> delegate)
  {
    this.delegate = ((LoadingCache)Preconditions.checkNotNull(delegate));
  }
  
  protected final LoadingCache<K, V> delegate()
  {
    return delegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.ForwardingLoadingCache.SimpleForwardingLoadingCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */