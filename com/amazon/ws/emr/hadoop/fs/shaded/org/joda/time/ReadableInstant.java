package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

public abstract interface ReadableInstant
  extends Comparable<ReadableInstant>
{
  public abstract long getMillis();
  
  public abstract Chronology getChronology();
  
  public abstract DateTimeZone getZone();
  
  public abstract int get(DateTimeFieldType paramDateTimeFieldType);
  
  public abstract boolean isSupported(DateTimeFieldType paramDateTimeFieldType);
  
  public abstract Instant toInstant();
  
  public abstract boolean isEqual(ReadableInstant paramReadableInstant);
  
  public abstract boolean isAfter(ReadableInstant paramReadableInstant);
  
  public abstract boolean isBefore(ReadableInstant paramReadableInstant);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */