package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;

public abstract class AbstractConverter
  implements Converter
{
  public long getInstantMillis(Object paramObject, Chronology paramChronology)
  {
    return DateTimeUtils.currentTimeMillis();
  }
  
  public Chronology getChronology(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    return ISOChronology.getInstance(paramDateTimeZone);
  }
  
  public Chronology getChronology(Object paramObject, Chronology paramChronology)
  {
    return DateTimeUtils.getChronology(paramChronology);
  }
  
  public int[] getPartialValues(ReadablePartial paramReadablePartial, Object paramObject, Chronology paramChronology)
  {
    long l = getInstantMillis(paramObject, paramChronology);
    return paramChronology.get(paramReadablePartial, l);
  }
  
  public int[] getPartialValues(ReadablePartial paramReadablePartial, Object paramObject, Chronology paramChronology, DateTimeFormatter paramDateTimeFormatter)
  {
    return getPartialValues(paramReadablePartial, paramObject, paramChronology);
  }
  
  public PeriodType getPeriodType(Object paramObject)
  {
    return PeriodType.standard();
  }
  
  public boolean isReadableInterval(Object paramObject, Chronology paramChronology)
  {
    return false;
  }
  
  public String toString()
  {
    return "Converter[" + (getSupportedType() == null ? "null" : getSupportedType().getName()) + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.AbstractConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */