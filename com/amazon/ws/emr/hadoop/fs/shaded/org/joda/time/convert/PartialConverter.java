package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;

public abstract interface PartialConverter
  extends Converter
{
  public abstract Chronology getChronology(Object paramObject, DateTimeZone paramDateTimeZone);
  
  public abstract Chronology getChronology(Object paramObject, Chronology paramChronology);
  
  public abstract int[] getPartialValues(ReadablePartial paramReadablePartial, Object paramObject, Chronology paramChronology);
  
  public abstract int[] getPartialValues(ReadablePartial paramReadablePartial, Object paramObject, Chronology paramChronology, DateTimeFormatter paramDateTimeFormatter);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.PartialConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */