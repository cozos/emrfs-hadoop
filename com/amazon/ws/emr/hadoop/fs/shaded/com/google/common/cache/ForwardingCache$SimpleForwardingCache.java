package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

@Beta
public abstract class ForwardingCache$SimpleForwardingCache<K, V>
  extends ForwardingCache<K, V>
{
  private final Cache<K, V> delegate;
  
  protected ForwardingCache$SimpleForwardingCache(Cache<K, V> delegate)
  {
    this.delegate = ((Cache)Preconditions.checkNotNull(delegate));
  }
  
  protected final Cache<K, V> delegate()
  {
    return delegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.ForwardingCache.SimpleForwardingCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */