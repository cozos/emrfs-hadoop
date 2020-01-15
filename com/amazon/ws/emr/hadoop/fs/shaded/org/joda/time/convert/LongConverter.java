package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;

class LongConverter
  extends AbstractConverter
  implements InstantConverter, PartialConverter, DurationConverter
{
  static final LongConverter INSTANCE = new LongConverter();
  
  public long getInstantMillis(Object paramObject, Chronology paramChronology)
  {
    return ((Long)paramObject).longValue();
  }
  
  public long getDurationMillis(Object paramObject)
  {
    return ((Long)paramObject).longValue();
  }
  
  public Class<?> getSupportedType()
  {
    return Long.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.LongConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */