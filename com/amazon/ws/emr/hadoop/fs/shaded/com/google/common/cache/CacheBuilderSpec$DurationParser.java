package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

abstract class CacheBuilderSpec$DurationParser
  implements CacheBuilderSpec.ValueParser
{
  protected abstract void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit);
  
  public void parse(CacheBuilderSpec spec, String key, String value)
  {
    Preconditions.checkArgument((value != null) && (!value.isEmpty()), "value of key %s omitted", new Object[] { key });
    try
    {
      char lastChar = value.charAt(value.length() - 1);
      TimeUnit timeUnit;
      switch (lastChar)
      {
      case 'd': 
        timeUnit = TimeUnit.DAYS;
        break;
      case 'h': 
        timeUnit = TimeUnit.HOURS;
        break;
      case 'm': 
        timeUnit = TimeUnit.MINUTES;
        break;
      case 's': 
        timeUnit = TimeUnit.SECONDS;
        break;
      default: 
        throw new IllegalArgumentException(String.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[] { key, value }));
      }
      long duration = Long.parseLong(value.substring(0, value.length() - 1));
      parseDuration(spec, duration, timeUnit);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[] { key, value }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.DurationParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */