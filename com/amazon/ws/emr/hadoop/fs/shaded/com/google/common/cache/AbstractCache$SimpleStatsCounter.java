package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;

@Beta
public final class AbstractCache$SimpleStatsCounter
  implements AbstractCache.StatsCounter
{
  private final LongAddable hitCount = LongAddables.create();
  private final LongAddable missCount = LongAddables.create();
  private final LongAddable loadSuccessCount = LongAddables.create();
  private final LongAddable loadExceptionCount = LongAddables.create();
  private final LongAddable totalLoadTime = LongAddables.create();
  private final LongAddable evictionCount = LongAddables.create();
  
  public void recordHits(int count)
  {
    hitCount.add(count);
  }
  
  public void recordMisses(int count)
  {
    missCount.add(count);
  }
  
  public void recordLoadSuccess(long loadTime)
  {
    loadSuccessCount.increment();
    totalLoadTime.add(loadTime);
  }
  
  public void recordLoadException(long loadTime)
  {
    loadExceptionCount.increment();
    totalLoadTime.add(loadTime);
  }
  
  public void recordEviction()
  {
    evictionCount.increment();
  }
  
  public CacheStats snapshot()
  {
    return new CacheStats(hitCount.sum(), missCount.sum(), loadSuccessCount.sum(), loadExceptionCount.sum(), totalLoadTime.sum(), evictionCount.sum());
  }
  
  public void incrementBy(AbstractCache.StatsCounter other)
  {
    CacheStats otherStats = other.snapshot();
    hitCount.add(otherStats.hitCount());
    missCount.add(otherStats.missCount());
    loadSuccessCount.add(otherStats.loadSuccessCount());
    loadExceptionCount.add(otherStats.loadExceptionCount());
    totalLoadTime.add(otherStats.totalLoadTime());
    evictionCount.add(otherStats.evictionCount());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.AbstractCache.SimpleStatsCounter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */