package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

abstract class CacheBuilderSpec$IntegerParser
  implements CacheBuilderSpec.ValueParser
{
  protected abstract void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt);
  
  public void parse(CacheBuilderSpec spec, String key, String value)
  {
    Preconditions.checkArgument((value != null) && (!value.isEmpty()), "value of key %s omitted", new Object[] { key });
    try
    {
      parseInteger(spec, Integer.parseInt(value));
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[] { key, value }), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.IntegerParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */