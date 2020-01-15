package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;

final class CacheBuilder$2
  implements Supplier<AbstractCache.StatsCounter>
{
  public AbstractCache.StatsCounter get()
  {
    return new AbstractCache.SimpleStatsCounter();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilder.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */