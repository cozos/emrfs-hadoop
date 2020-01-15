package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

public abstract interface ReadablePeriod
{
  public abstract PeriodType getPeriodType();
  
  public abstract int size();
  
  public abstract DurationFieldType getFieldType(int paramInt);
  
  public abstract int getValue(int paramInt);
  
  public abstract int get(DurationFieldType paramDurationFieldType);
  
  public abstract boolean isSupported(DurationFieldType paramDurationFieldType);
  
  public abstract Period toPeriod();
  
  public abstract MutablePeriod toMutablePeriod();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */