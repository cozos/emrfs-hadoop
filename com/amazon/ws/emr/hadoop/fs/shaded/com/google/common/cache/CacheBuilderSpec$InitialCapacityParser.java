package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class CacheBuilderSpec$InitialCapacityParser
  extends CacheBuilderSpec.IntegerParser
{
  protected void parseInteger(CacheBuilderSpec spec, int value)
  {
    Preconditions.checkArgument(initialCapacity == null, "initial capacity was already set to ", new Object[] { initialCapacity });
    
    initialCapacity = Integer.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.InitialCapacityParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */