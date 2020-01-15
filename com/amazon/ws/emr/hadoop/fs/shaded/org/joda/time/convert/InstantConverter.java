package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;

public abstract interface InstantConverter
  extends Converter
{
  public abstract Chronology getChronology(Object paramObject, DateTimeZone paramDateTimeZone);
  
  public abstract Chronology getChronology(Object paramObject, Chronology paramChronology);
  
  public abstract long getInstantMillis(Object paramObject, Chronology paramChronology);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.InstantConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */