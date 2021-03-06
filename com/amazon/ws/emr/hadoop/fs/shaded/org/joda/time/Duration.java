package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseDuration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import java.io.Serializable;
import org.joda.convert.FromString;

public final class Duration
  extends BaseDuration
  implements ReadableDuration, Serializable
{
  public static final Duration ZERO = new Duration(0L);
  private static final long serialVersionUID = 2471658376918L;
  
  @FromString
  public static Duration parse(String paramString)
  {
    return new Duration(paramString);
  }
  
  public static Duration standardDays(long paramLong)
  {
    if (paramLong == 0L) {
      return ZERO;
    }
    return new Duration(FieldUtils.safeMultiply(paramLong, 86400000));
  }
  
  public static Duration standardHours(long paramLong)
  {
    if (paramLong == 0L) {
      return ZERO;
    }
    return new Duration(FieldUtils.safeMultiply(paramLong, 3600000));
  }
  
  public static Duration standardMinutes(long paramLong)
  {
    if (paramLong == 0L) {
      return ZERO;
    }
    return new Duration(FieldUtils.safeMultiply(paramLong, 60000));
  }
  
  public static Duration standardSeconds(long paramLong)
  {
    if (paramLong == 0L) {
      return ZERO;
    }
    return new Duration(FieldUtils.safeMultiply(paramLong, 1000));
  }
  
  public static Duration millis(long paramLong)
  {
    if (paramLong == 0L) {
      return ZERO;
    }
    return new Duration(paramLong);
  }
  
  public Duration(long paramLong)
  {
    super(paramLong);
  }
  
  public Duration(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public Duration(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    super(paramReadableInstant1, paramReadableInstant2);
  }
  
  public Duration(Object paramObject)
  {
    super(paramObject);
  }
  
  public long getStandardDays()
  {
    return getMillis() / 86400000L;
  }
  
  public long getStandardHours()
  {
    return getMillis() / 3600000L;
  }
  
  public long getStandardMinutes()
  {
    return getMillis() / 60000L;
  }
  
  public long getStandardSeconds()
  {
    return getMillis() / 1000L;
  }
  
  public Duration toDuration()
  {
    return this;
  }
  
  public Days toStandardDays()
  {
    long l = getStandardDays();
    return Days.days(FieldUtils.safeToInt(l));
  }
  
  public Hours toStandardHours()
  {
    long l = getStandardHours();
    return Hours.hours(FieldUtils.safeToInt(l));
  }
  
  public Minutes toStandardMinutes()
  {
    long l = getStandardMinutes();
    return Minutes.minutes(FieldUtils.safeToInt(l));
  }
  
  public Seconds toStandardSeconds()
  {
    long l = getStandardSeconds();
    return Seconds.seconds(FieldUtils.safeToInt(l));
  }
  
  public Duration withMillis(long paramLong)
  {
    if (paramLong == getMillis()) {
      return this;
    }
    return new Duration(paramLong);
  }
  
  public Duration withDurationAdded(long paramLong, int paramInt)
  {
    if ((paramLong == 0L) || (paramInt == 0)) {
      return this;
    }
    long l1 = FieldUtils.safeMultiply(paramLong, paramInt);
    long l2 = FieldUtils.safeAdd(getMillis(), l1);
    return new Duration(l2);
  }
  
  public Duration withDurationAdded(ReadableDuration paramReadableDuration, int paramInt)
  {
    if ((paramReadableDuration == null) || (paramInt == 0)) {
      return this;
    }
    return withDurationAdded(paramReadableDuration.getMillis(), paramInt);
  }
  
  public Duration plus(long paramLong)
  {
    return withDurationAdded(paramLong, 1);
  }
  
  public Duration plus(ReadableDuration paramReadableDuration)
  {
    if (paramReadableDuration == null) {
      return this;
    }
    return withDurationAdded(paramReadableDuration.getMillis(), 1);
  }
  
  public Duration minus(long paramLong)
  {
    return withDurationAdded(paramLong, -1);
  }
  
  public Duration minus(ReadableDuration paramReadableDuration)
  {
    if (paramReadableDuration == null) {
      return this;
    }
    return withDurationAdded(paramReadableDuration.getMillis(), -1);
  }
  
  public Duration multipliedBy(long paramLong)
  {
    if (paramLong == 1L) {
      return this;
    }
    return new Duration(FieldUtils.safeMultiply(getMillis(), paramLong));
  }
  
  public Duration dividedBy(long paramLong)
  {
    if (paramLong == 1L) {
      return this;
    }
    return new Duration(FieldUtils.safeDivide(getMillis(), paramLong));
  }
  
  public Duration negated()
  {
    if (getMillis() == Long.MIN_VALUE) {
      throw new ArithmeticException("Negation of this duration would overflow");
    }
    return new Duration(-getMillis());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Duration
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */