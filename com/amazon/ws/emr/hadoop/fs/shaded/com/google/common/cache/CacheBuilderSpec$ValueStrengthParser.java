package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import javax.annotation.Nullable;

class CacheBuilderSpec$ValueStrengthParser
  implements CacheBuilderSpec.ValueParser
{
  private final LocalCache.Strength strength;
  
  public CacheBuilderSpec$ValueStrengthParser(LocalCache.Strength strength)
  {
    this.strength = strength;
  }
  
  public void parse(CacheBuilderSpec spec, String key, @Nullable String value)
  {
    Preconditions.checkArgument(value == null, "key %s does not take values", new Object[] { key });
    Preconditions.checkArgument(valueStrength == null, "%s was already set to %s", new Object[] { key, valueStrength });
    
    valueStrength = strength;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.ValueStrengthParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */