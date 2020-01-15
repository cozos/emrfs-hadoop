package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

public abstract interface ReadWritableInstant
  extends ReadableInstant
{
  public abstract void setMillis(long paramLong);
  
  public abstract void setMillis(ReadableInstant paramReadableInstant);
  
  public abstract void setChronology(Chronology paramChronology);
  
  public abstract void setZone(DateTimeZone paramDateTimeZone);
  
  public abstract void setZoneRetainFields(DateTimeZone paramDateTimeZone);
  
  public abstract void add(long paramLong);
  
  public abstract void add(ReadableDuration paramReadableDuration);
  
  public abstract void add(ReadableDuration paramReadableDuration, int paramInt);
  
  public abstract void add(ReadablePeriod paramReadablePeriod);
  
  public abstract void add(ReadablePeriod paramReadablePeriod, int paramInt);
  
  public abstract void set(DateTimeFieldType paramDateTimeFieldType, int paramInt);
  
  public abstract void add(DurationFieldType paramDurationFieldType, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritableInstant
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */