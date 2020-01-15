package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

class CacheBuilderSpec$WriteDurationParser
  extends CacheBuilderSpec.DurationParser
{
  protected void parseDuration(CacheBuilderSpec spec, long duration, TimeUnit unit)
  {
    Preconditions.checkArgument(writeExpirationTimeUnit == null, "expireAfterWrite already set");
    writeExpirationDuration = duration;
    writeExpirationTimeUnit = unit;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.WriteDurationParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */