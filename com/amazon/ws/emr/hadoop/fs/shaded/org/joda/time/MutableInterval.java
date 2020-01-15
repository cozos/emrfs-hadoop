package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import java.io.Serializable;

public class MutableInterval
  extends BaseInterval
  implements ReadWritableInterval, Cloneable, Serializable
{
  private static final long serialVersionUID = -5982824024992428470L;
  
  public static MutableInterval parse(String paramString)
  {
    return new MutableInterval(paramString);
  }
  
  public MutableInterval()
  {
    super(0L, 0L, null);
  }
  
  public MutableInterval(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, null);
  }
  
  public MutableInterval(long paramLong1, long paramLong2, Chronology paramChronology)
  {
    super(paramLong1, paramLong2, paramChronology);
  }
  
  public MutableInterval(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    super(paramReadableInstant1, paramReadableInstant2);
  }
  
  public MutableInterval(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration)
  {
    super(paramReadableInstant, paramReadableDuration);
  }
  
  public MutableInterval(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant)
  {
    super(paramReadableDuration, paramReadableInstant);
  }
  
  public MutableInterval(ReadableInstant paramReadableInstant, ReadablePeriod paramReadablePeriod)
  {
    super(paramReadableInstant, paramReadablePeriod);
  }
  
  public MutableInterval(ReadablePeriod paramReadablePeriod, ReadableInstant paramReadableInstant)
  {
    super(paramReadablePeriod, paramReadableInstant);
  }
  
  public MutableInterval(Object paramObject)
  {
    super(paramObject, null);
  }
  
  public MutableInterval(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, paramChronology);
  }
  
  public void setInterval(long paramLong1, long paramLong2)
  {
    super.setInterval(paramLong1, paramLong2, getChronology());
  }
  
  public void setInterval(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      throw new IllegalArgumentException("Interval must not be null");
    }
    long l1 = paramReadableInterval.getStartMillis();
    long l2 = paramReadableInterval.getEndMillis();
    Chronology localChronology = paramReadableInterval.getChronology();
    super.setInterval(l1, l2, localChronology);
  }
  
  public void setInterval(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    long l1;
    if ((paramReadableInstant1 == null) && (paramReadableInstant2 == null))
    {
      l1 = DateTimeUtils.currentTimeMillis();
      setInterval(l1, l1);
    }
    else
    {
      l1 = DateTimeUtils.getInstantMillis(paramReadableInstant1);
      long l2 = DateTimeUtils.getInstantMillis(paramReadableInstant2);
      Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant1);
      super.setInterval(l1, l2, localChronology);
    }
  }
  
  public void setChronology(Chronology paramChronology)
  {
    super.setInterval(getStartMillis(), getEndMillis(), paramChronology);
  }
  
  public void setStartMillis(long paramLong)
  {
    super.setInterval(paramLong, getEndMillis(), getChronology());
  }
  
  public void setStart(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    super.setInterval(l, getEndMillis(), getChronology());
  }
  
  public void setEndMillis(long paramLong)
  {
    super.setInterval(getStartMillis(), paramLong, getChronology());
  }
  
  public void setEnd(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    super.setInterval(getStartMillis(), l, getChronology());
  }
  
  public void setDurationAfterStart(long paramLong)
  {
    setEndMillis(FieldUtils.safeAdd(getStartMillis(), paramLong));
  }
  
  public void setDurationBeforeEnd(long paramLong)
  {
    setStartMillis(FieldUtils.safeAdd(getEndMillis(), -paramLong));
  }
  
  public void setDurationAfterStart(ReadableDuration paramReadableDuration)
  {
    long l = DateTimeUtils.getDurationMillis(paramReadableDuration);
    setEndMillis(FieldUtils.safeAdd(getStartMillis(), l));
  }
  
  public void setDurationBeforeEnd(ReadableDuration paramReadableDuration)
  {
    long l = DateTimeUtils.getDurationMillis(paramReadableDuration);
    setStartMillis(FieldUtils.safeAdd(getEndMillis(), -l));
  }
  
  public void setPeriodAfterStart(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      setEndMillis(getStartMillis());
    } else {
      setEndMillis(getChronology().add(paramReadablePeriod, getStartMillis(), 1));
    }
  }
  
  public void setPeriodBeforeEnd(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      setStartMillis(getEndMillis());
    } else {
      setStartMillis(getChronology().add(paramReadablePeriod, getEndMillis(), -1));
    }
  }
  
  public MutableInterval copy()
  {
    return (MutableInterval)clone();
  }
  
  public Object clone()
  {
    try
    {
      return super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError("Clone error");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableInterval
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */