package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.InstantConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.Serializable;
import org.joda.convert.FromString;

public final class Instant
  extends AbstractInstant
  implements ReadableInstant, Serializable
{
  private static final long serialVersionUID = 3299096530934209741L;
  private final long iMillis;
  
  public static Instant now()
  {
    return new Instant();
  }
  
  @FromString
  public static Instant parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.dateTimeParser());
  }
  
  public static Instant parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    return paramDateTimeFormatter.parseDateTime(paramString).toInstant();
  }
  
  public Instant()
  {
    iMillis = DateTimeUtils.currentTimeMillis();
  }
  
  public Instant(long paramLong)
  {
    iMillis = paramLong;
  }
  
  public Instant(Object paramObject)
  {
    InstantConverter localInstantConverter = ConverterManager.getInstance().getInstantConverter(paramObject);
    iMillis = localInstantConverter.getInstantMillis(paramObject, ISOChronology.getInstanceUTC());
  }
  
  public Instant toInstant()
  {
    return this;
  }
  
  public Instant withMillis(long paramLong)
  {
    return paramLong == iMillis ? this : new Instant(paramLong);
  }
  
  public Instant withDurationAdded(long paramLong, int paramInt)
  {
    if ((paramLong == 0L) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(getMillis(), paramLong, paramInt);
    return withMillis(l);
  }
  
  public Instant withDurationAdded(ReadableDuration paramReadableDuration, int paramInt)
  {
    if ((paramReadableDuration == null) || (paramInt == 0)) {
      return this;
    }
    return withDurationAdded(paramReadableDuration.getMillis(), paramInt);
  }
  
  public Instant plus(long paramLong)
  {
    return withDurationAdded(paramLong, 1);
  }
  
  public Instant plus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, 1);
  }
  
  public Instant minus(long paramLong)
  {
    return withDurationAdded(paramLong, -1);
  }
  
  public Instant minus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, -1);
  }
  
  public long getMillis()
  {
    return iMillis;
  }
  
  public Chronology getChronology()
  {
    return ISOChronology.getInstanceUTC();
  }
  
  public DateTime toDateTime()
  {
    return new DateTime(getMillis(), ISOChronology.getInstance());
  }
  
  @Deprecated
  public DateTime toDateTimeISO()
  {
    return toDateTime();
  }
  
  public MutableDateTime toMutableDateTime()
  {
    return new MutableDateTime(getMillis(), ISOChronology.getInstance());
  }
  
  @Deprecated
  public MutableDateTime toMutableDateTimeISO()
  {
    return toMutableDateTime();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Instant
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */