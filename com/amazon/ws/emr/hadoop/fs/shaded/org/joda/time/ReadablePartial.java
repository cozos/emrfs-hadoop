package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

public abstract interface ReadablePartial
  extends Comparable<ReadablePartial>
{
  public abstract int size();
  
  public abstract DateTimeFieldType getFieldType(int paramInt);
  
  public abstract DateTimeField getField(int paramInt);
  
  public abstract int getValue(int paramInt);
  
  public abstract Chronology getChronology();
  
  public abstract int get(DateTimeFieldType paramDateTimeFieldType);
  
  public abstract boolean isSupported(DateTimeFieldType paramDateTimeFieldType);
  
  public abstract DateTime toDateTime(ReadableInstant paramReadableInstant);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */