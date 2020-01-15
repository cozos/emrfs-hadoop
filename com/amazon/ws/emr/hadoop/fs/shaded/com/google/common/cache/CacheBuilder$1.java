package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

final class CacheBuilder$1
  implements AbstractCache.StatsCounter
{
  public void recordHits(int count) {}
  
  public void recordMisses(int count) {}
  
  public void recordLoadSuccess(long loadTime) {}
  
  public void recordLoadException(long loadTime) {}
  
  public void recordEviction() {}
  
  public CacheStats snapshot()
  {
    return CacheBuilder.EMPTY_STATS;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */