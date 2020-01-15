package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract interface CacheLoader<K, V>
{
  public abstract V load(K paramK);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache.CacheLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */