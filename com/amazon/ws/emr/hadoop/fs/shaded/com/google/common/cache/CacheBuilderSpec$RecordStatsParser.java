package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import javax.annotation.Nullable;

class CacheBuilderSpec$RecordStatsParser
  implements CacheBuilderSpec.ValueParser
{
  public void parse(CacheBuilderSpec spec, String key, @Nullable String value)
  {
    Preconditions.checkArgument(value == null, "recordStats does not take values");
    Preconditions.checkArgument(recordStats == null, "recordStats already set");
    recordStats = Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.RecordStatsParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */