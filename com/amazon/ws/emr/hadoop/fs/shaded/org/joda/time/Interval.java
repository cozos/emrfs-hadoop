package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import java.io.Serializable;

public final class Interval
  extends BaseInterval
  implements ReadableInterval, Serializable
{
  private static final long serialVersionUID = 4922451897541386752L;
  
  public static Interval parse(String paramString)
  {
    return new Interval(paramString);
  }
  
  public static Interval parseWithOffset(String paramString)
  {
    int i = paramString.indexOf('/');
    if (i < 0) {
      throw new IllegalArgumentException("Format requires a '/' separator: " + paramString);
    }
    String str1 = paramString.substring(0, i);
    if (str1.length() <= 0) {
      throw new IllegalArgumentException("Format invalid: " + paramString);
    }
    String str2 = paramString.substring(i + 1);
    if (str2.length() <= 0) {
      throw new IllegalArgumentException("Format invalid: " + paramString);
    }
    DateTimeFormatter localDateTimeFormatter = ISODateTimeFormat.dateTimeParser().withOffsetParsed();
    PeriodFormatter localPeriodFormatter = ISOPeriodFormat.standard();
    DateTime localDateTime1 = null;
    Period localPeriod = null;
    
    int j = str1.charAt(0);
    if ((j == 80) || (j == 112)) {
      localPeriod = localPeriodFormatter.withParseType(PeriodType.standard()).parsePeriod(str1);
    } else {
      localDateTime1 = localDateTimeFormatter.parseDateTime(str1);
    }
    j = str2.charAt(0);
    if ((j == 80) || (j == 112))
    {
      if (localPeriod != null) {
        throw new IllegalArgumentException("Interval composed of two durations: " + paramString);
      }
      localPeriod = localPeriodFormatter.withParseType(PeriodType.standard()).parsePeriod(str2);
      return new Interval(localDateTime1, localPeriod);
    }
    DateTime localDateTime2 = localDateTimeFormatter.parseDateTime(str2);
    if (localPeriod != null) {
      return new Interval(localPeriod, localDateTime2);
    }
    return new Interval(localDateTime1, localDateTime2);
  }
  
  public Interval(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, null);
  }
  
  public Interval(long paramLong1, long paramLong2, DateTimeZone paramDateTimeZone)
  {
    super(paramLong1, paramLong2, ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public Interval(long paramLong1, long paramLong2, Chronology paramChronology)
  {
    super(paramLong1, paramLong2, paramChronology);
  }
  
  public Interval(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    super(paramReadableInstant1, paramReadableInstant2);
  }
  
  public Interval(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration)
  {
    super(paramReadableInstant, paramReadableDuration);
  }
  
  public Interval(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant)
  {
    super(paramReadableDuration, paramReadableInstant);
  }
  
  public Interval(ReadableInstant paramReadableInstant, ReadablePeriod paramReadablePeriod)
  {
    super(paramReadableInstant, paramReadablePeriod);
  }
  
  public Interval(ReadablePeriod paramReadablePeriod, ReadableInstant paramReadableInstant)
  {
    super(paramReadablePeriod, paramReadableInstant);
  }
  
  public Interval(Object paramObject)
  {
    super(paramObject, null);
  }
  
  public Interval(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, paramChronology);
  }
  
  public Interval toInterval()
  {
    return this;
  }
  
  public Interval overlap(ReadableInterval paramReadableInterval)
  {
    paramReadableInterval = DateTimeUtils.getReadableInterval(paramReadableInterval);
    if (!overlaps(paramReadableInterval)) {
      return null;
    }
    long l1 = Math.max(getStartMillis(), paramReadableInterval.getStartMillis());
    long l2 = Math.min(getEndMillis(), paramReadableInterval.getEndMillis());
    return new Interval(l1, l2, getChronology());
  }
  
  public Interval gap(ReadableInterval paramReadableInterval)
  {
    paramReadableInterval = DateTimeUtils.getReadableInterval(paramReadableInterval);
    long l1 = paramReadableInterval.getStartMillis();
    long l2 = paramReadableInterval.getEndMillis();
    long l3 = getStartMillis();
    long l4 = getEndMillis();
    if (l3 > l2) {
      return new Interval(l2, l3, getChronology());
    }
    if (l1 > l4) {
      return new Interval(l4, l1, getChronology());
    }
    return null;
  }
  
  public boolean abuts(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null)
    {
      long l = DateTimeUtils.currentTimeMillis();
      return (getStartMillis() == l) || (getEndMillis() == l);
    }
    return (paramReadableInterval.getEndMillis() == getStartMillis()) || (getEndMillis() == paramReadableInterval.getStartMillis());
  }
  
  public Interval withChronology(Chronology paramChronology)
  {
    if (getChronology() == paramChronology) {
      return this;
    }
    return new Interval(getStartMillis(), getEndMillis(), paramChronology);
  }
  
  public Interval withStartMillis(long paramLong)
  {
    if (paramLong == getStartMillis()) {
      return this;
    }
    return new Interval(paramLong, getEndMillis(), getChronology());
  }
  
  public Interval withStart(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    return withStartMillis(l);
  }
  
  public Interval withEndMillis(long paramLong)
  {
    if (paramLong == getEndMillis()) {
      return this;
    }
    return new Interval(getStartMillis(), paramLong, getChronology());
  }
  
  public Interval withEnd(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    return withEndMillis(l);
  }
  
  public Interval withDurationAfterStart(ReadableDuration paramReadableDuration)
  {
    long l1 = DateTimeUtils.getDurationMillis(paramReadableDuration);
    if (l1 == toDurationMillis()) {
      return this;
    }
    Chronology localChronology = getChronology();
    long l2 = getStartMillis();
    long l3 = localChronology.add(l2, l1, 1);
    return new Interval(l2, l3, localChronology);
  }
  
  public Interval withDurationBeforeEnd(ReadableDuration paramReadableDuration)
  {
    long l1 = DateTimeUtils.getDurationMillis(paramReadableDuration);
    if (l1 == toDurationMillis()) {
      return this;
    }
    Chronology localChronology = getChronology();
    long l2 = getEndMillis();
    long l3 = localChronology.add(l2, l1, -1);
    return new Interval(l3, l2, localChronology);
  }
  
  public Interval withPeriodAfterStart(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      return withDurationAfterStart(null);
    }
    Chronology localChronology = getChronology();
    long l1 = getStartMillis();
    long l2 = localChronology.add(paramReadablePeriod, l1, 1);
    return new Interval(l1, l2, localChronology);
  }
  
  public Interval withPeriodBeforeEnd(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      return withDurationBeforeEnd(null);
    }
    Chronology localChronology = getChronology();
    long l1 = getEndMillis();
    long l2 = localChronology.add(paramReadablePeriod, l1, -1);
    return new Interval(l2, l1, localChronology);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Interval
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */