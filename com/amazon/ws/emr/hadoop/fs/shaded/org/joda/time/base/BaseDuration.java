package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Interval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDuration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.DurationConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import java.io.Serializable;

public abstract class BaseDuration
  extends AbstractDuration
  implements ReadableDuration, Serializable
{
  private static final long serialVersionUID = 2581698638990L;
  private volatile long iMillis;
  
  protected BaseDuration(long paramLong)
  {
    iMillis = paramLong;
  }
  
  protected BaseDuration(long paramLong1, long paramLong2)
  {
    iMillis = FieldUtils.safeSubtract(paramLong2, paramLong1);
  }
  
  protected BaseDuration(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    if (paramReadableInstant1 == paramReadableInstant2)
    {
      iMillis = 0L;
    }
    else
    {
      long l1 = DateTimeUtils.getInstantMillis(paramReadableInstant1);
      long l2 = DateTimeUtils.getInstantMillis(paramReadableInstant2);
      iMillis = FieldUtils.safeSubtract(l2, l1);
    }
  }
  
  protected BaseDuration(Object paramObject)
  {
    DurationConverter localDurationConverter = ConverterManager.getInstance().getDurationConverter(paramObject);
    iMillis = localDurationConverter.getDurationMillis(paramObject);
  }
  
  public long getMillis()
  {
    return iMillis;
  }
  
  protected void setMillis(long paramLong)
  {
    iMillis = paramLong;
  }
  
  public Period toPeriod(PeriodType paramPeriodType)
  {
    return new Period(getMillis(), paramPeriodType);
  }
  
  public Period toPeriod(Chronology paramChronology)
  {
    return new Period(getMillis(), paramChronology);
  }
  
  public Period toPeriod(PeriodType paramPeriodType, Chronology paramChronology)
  {
    return new Period(getMillis(), paramPeriodType, paramChronology);
  }
  
  public Period toPeriodFrom(ReadableInstant paramReadableInstant)
  {
    return new Period(paramReadableInstant, this);
  }
  
  public Period toPeriodFrom(ReadableInstant paramReadableInstant, PeriodType paramPeriodType)
  {
    return new Period(paramReadableInstant, this, paramPeriodType);
  }
  
  public Period toPeriodTo(ReadableInstant paramReadableInstant)
  {
    return new Period(this, paramReadableInstant);
  }
  
  public Period toPeriodTo(ReadableInstant paramReadableInstant, PeriodType paramPeriodType)
  {
    return new Period(this, paramReadableInstant, paramPeriodType);
  }
  
  public Interval toIntervalFrom(ReadableInstant paramReadableInstant)
  {
    return new Interval(paramReadableInstant, this);
  }
  
  public Interval toIntervalTo(ReadableInstant paramReadableInstant)
  {
    return new Interval(this, paramReadableInstant);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseDuration
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */