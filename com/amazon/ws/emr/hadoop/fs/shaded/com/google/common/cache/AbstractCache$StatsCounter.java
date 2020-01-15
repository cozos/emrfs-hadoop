package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;

@Beta
public abstract interface AbstractCache$StatsCounter
{
  public abstract void recordHits(int paramInt);
  
  public abstract void recordMisses(int paramInt);
  
  public abstract void recordLoadSuccess(long paramLong);
  
  public abstract void recordLoadException(long paramLong);
  
  public abstract void recordEviction();
  
  public abstract CacheStats snapshot();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.AbstractCache.StatsCounter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */