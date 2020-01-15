package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

abstract class CacheBuilderSpec$LongParser
  implements CacheBuilderSpec.ValueParser
{
  protected abstract void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong);
  
  public void parse(CacheBuilderSpec spec, String key, String value)
  {
    Preconditions.checkArgument((value != null) && (!value.isEmpty()), "value of key %s omitted", new Object[] { key });
    try
    {
      parseLong(spec, Long.parseLong(value));
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[] { key, value }), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.LongParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */