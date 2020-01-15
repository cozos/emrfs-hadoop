package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

public abstract interface ReadableDuration
  extends Comparable<ReadableDuration>
{
  public abstract long getMillis();
  
  public abstract Duration toDuration();
  
  public abstract Period toPeriod();
  
  public abstract boolean isEqual(ReadableDuration paramReadableDuration);
  
  public abstract boolean isLongerThan(ReadableDuration paramReadableDuration);
  
  public abstract boolean isShorterThan(ReadableDuration paramReadableDuration);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDuration
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */