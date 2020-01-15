package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritableInterval;

public abstract interface IntervalConverter
  extends Converter
{
  public abstract boolean isReadableInterval(Object paramObject, Chronology paramChronology);
  
  public abstract void setInto(ReadWritableInterval paramReadWritableInterval, Object paramObject, Chronology paramChronology);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.IntervalConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */