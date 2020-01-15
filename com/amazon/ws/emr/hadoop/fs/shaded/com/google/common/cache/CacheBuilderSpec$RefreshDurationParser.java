package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

class CacheBuilderSpec$RefreshDurationParser
  extends CacheBuilderSpec.DurationParser
{
  protected void parseDuration(CacheBuilderSpec spec, long duration, TimeUnit unit)
  {
    Preconditions.checkArgument(refreshTimeUnit == null, "refreshAfterWrite already set");
    refreshDuration = duration;
    refreshTimeUnit = unit;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.RefreshDurationParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */