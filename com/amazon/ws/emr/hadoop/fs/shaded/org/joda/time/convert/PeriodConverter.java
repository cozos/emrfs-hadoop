package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;

public abstract interface PeriodConverter
  extends Converter
{
  public abstract void setInto(ReadWritablePeriod paramReadWritablePeriod, Object paramObject, Chronology paramChronology);
  
  public abstract PeriodType getPeriodType(Object paramObject);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.PeriodConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */