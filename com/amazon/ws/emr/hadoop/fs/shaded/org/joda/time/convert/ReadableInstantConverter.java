package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;

class ReadableInstantConverter
  extends AbstractConverter
  implements InstantConverter, PartialConverter
{
  static final ReadableInstantConverter INSTANCE = new ReadableInstantConverter();
  
  public Chronology getChronology(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = ((ReadableInstant)paramObject).getChronology();
    if (localChronology == null) {
      return ISOChronology.getInstance(paramDateTimeZone);
    }
    DateTimeZone localDateTimeZone = localChronology.getZone();
    if (localDateTimeZone != paramDateTimeZone)
    {
      localChronology = localChronology.withZone(paramDateTimeZone);
      if (localChronology == null) {
        return ISOChronology.getInstance(paramDateTimeZone);
      }
    }
    return localChronology;
  }
  
  public Chronology getChronology(Object paramObject, Chronology paramChronology)
  {
    if (paramChronology == null)
    {
      paramChronology = ((ReadableInstant)paramObject).getChronology();
      paramChronology = DateTimeUtils.getChronology(paramChronology);
    }
    return paramChronology;
  }
  
  public long getInstantMillis(Object paramObject, Chronology paramChronology)
  {
    return ((ReadableInstant)paramObject).getMillis();
  }
  
  public Class<?> getSupportedType()
  {
    return ReadableInstant.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ReadableInstantConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */