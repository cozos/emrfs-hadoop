package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDuration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.IntervalConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import java.io.Serializable;

public abstract class BaseInterval
  extends AbstractInterval
  implements ReadableInterval, Serializable
{
  private static final long serialVersionUID = 576586928732749278L;
  private volatile Chronology iChronology;
  private volatile long iStartMillis;
  private volatile long iEndMillis;
  
  protected BaseInterval(long paramLong1, long paramLong2, Chronology paramChronology)
  {
    iChronology = DateTimeUtils.getChronology(paramChronology);
    checkInterval(paramLong1, paramLong2);
    iStartMillis = paramLong1;
    iEndMillis = paramLong2;
  }
  
  protected BaseInterval(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    if ((paramReadableInstant1 == null) && (paramReadableInstant2 == null))
    {
      iStartMillis = (iEndMillis = DateTimeUtils.currentTimeMillis());
      iChronology = ISOChronology.getInstance();
    }
    else
    {
      iChronology = DateTimeUtils.getInstantChronology(paramReadableInstant1);
      iStartMillis = DateTimeUtils.getInstantMillis(paramReadableInstant1);
      iEndMillis = DateTimeUtils.getInstantMillis(paramReadableInstant2);
      checkInterval(iStartMillis, iEndMillis);
    }
  }
  
  protected BaseInterval(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration)
  {
    iChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    iStartMillis = DateTimeUtils.getInstantMillis(paramReadableInstant);
    long l = DateTimeUtils.getDurationMillis(paramReadableDuration);
    iEndMillis = FieldUtils.safeAdd(iStartMillis, l);
    checkInterval(iStartMillis, iEndMillis);
  }
  
  protected BaseInterval(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant)
  {
    iChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    iEndMillis = DateTimeUtils.getInstantMillis(paramReadableInstant);
    long l = DateTimeUtils.getDurationMillis(paramReadableDuration);
    iStartMillis = FieldUtils.safeAdd(iEndMillis, -l);
    checkInterval(iStartMillis, iEndMillis);
  }
  
  protected BaseInterval(ReadableInstant paramReadableInstant, ReadablePeriod paramReadablePeriod)
  {
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    iChronology = localChronology;
    iStartMillis = DateTimeUtils.getInstantMillis(paramReadableInstant);
    if (paramReadablePeriod == null) {
      iEndMillis = iStartMillis;
    } else {
      iEndMillis = localChronology.add(paramReadablePeriod, iStartMillis, 1);
    }
    checkInterval(iStartMillis, iEndMillis);
  }
  
  protected BaseInterval(ReadablePeriod paramReadablePeriod, ReadableInstant paramReadableInstant)
  {
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    iChronology = localChronology;
    iEndMillis = DateTimeUtils.getInstantMillis(paramReadableInstant);
    if (paramReadablePeriod == null) {
      iStartMillis = iEndMillis;
    } else {
      iStartMillis = localChronology.add(paramReadablePeriod, iEndMillis, -1);
    }
    checkInterval(iStartMillis, iEndMillis);
  }
  
  protected BaseInterval(Object paramObject, Chronology paramChronology)
  {
    IntervalConverter localIntervalConverter = ConverterManager.getInstance().getIntervalConverter(paramObject);
    Object localObject;
    if (localIntervalConverter.isReadableInterval(paramObject, paramChronology))
    {
      localObject = (ReadableInterval)paramObject;
      iChronology = (paramChronology != null ? paramChronology : ((ReadableInterval)localObject).getChronology());
      iStartMillis = ((ReadableInterval)localObject).getStartMillis();
      iEndMillis = ((ReadableInterval)localObject).getEndMillis();
    }
    else if ((this instanceof ReadWritableInterval))
    {
      localIntervalConverter.setInto((ReadWritableInterval)this, paramObject, paramChronology);
    }
    else
    {
      localObject = new MutableInterval();
      localIntervalConverter.setInto((ReadWritableInterval)localObject, paramObject, paramChronology);
      iChronology = ((MutableInterval)localObject).getChronology();
      iStartMillis = ((MutableInterval)localObject).getStartMillis();
      iEndMillis = ((MutableInterval)localObject).getEndMillis();
    }
    checkInterval(iStartMillis, iEndMillis);
  }
  
  public Chronology getChronology()
  {
    return iChronology;
  }
  
  public long getStartMillis()
  {
    return iStartMillis;
  }
  
  public long getEndMillis()
  {
    return iEndMillis;
  }
  
  protected void setInterval(long paramLong1, long paramLong2, Chronology paramChronology)
  {
    checkInterval(paramLong1, paramLong2);
    iStartMillis = paramLong1;
    iEndMillis = paramLong2;
    iChronology = DateTimeUtils.getChronology(paramChronology);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseInterval
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */