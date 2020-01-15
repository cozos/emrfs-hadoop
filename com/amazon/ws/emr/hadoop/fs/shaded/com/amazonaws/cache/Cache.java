package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract interface Cache<K, V>
{
  public abstract V get(K paramK);
  
  public abstract void put(K paramK, V paramV);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache.Cache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */