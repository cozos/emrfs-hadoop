package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.concurrent.Callable;

class LocalCache$LocalManualCache$1
  extends CacheLoader<Object, V>
{
  LocalCache$LocalManualCache$1(LocalCache.LocalManualCache paramLocalManualCache, Callable paramCallable) {}
  
  public V load(Object key)
    throws Exception
  {
    return (V)val$valueLoader.call();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.LocalManualCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */