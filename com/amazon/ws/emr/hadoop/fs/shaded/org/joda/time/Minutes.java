package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class Minutes
  extends BaseSingleFieldPeriod
{
  public static final Minutes ZERO = new Minutes(0);
  public static final Minutes ONE = new Minutes(1);
  public static final Minutes TWO = new Minutes(2);
  public static final Minutes THREE = new Minutes(3);
  public static final Minutes MAX_VALUE = new Minutes(Integer.MAX_VALUE);
  public static final Minutes MIN_VALUE = new Minutes(Integer.MIN_VALUE);
  private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.minutes());
  private static final long serialVersionUID = 87525275727380863L;
  
  public static Minutes minutes(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      return ZERO;
    case 1: 
      return ONE;
    case 2: 
      return TWO;
    case 3: 
      return THREE;
    case 2147483647: 
      return MAX_VALUE;
    case -2147483648: 
      return MIN_VALUE;
    }
    return new Minutes(paramInt);
  }
  
  public static Minutes minutesBetween(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    int i = BaseSingleFieldPeriod.between(paramReadableInstant1, paramReadableInstant2, DurationFieldType.minutes());
    return minutes(i);
  }
  
  public static Minutes minutesBetween(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if (((paramReadablePartial1 instanceof LocalTime)) && ((paramReadablePartial2 instanceof LocalTime)))
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology());
      int j = localChronology.minutes().getDifference(((LocalTime)paramReadablePartial2).getLocalMillis(), ((LocalTime)paramReadablePartial1).getLocalMillis());
      
      return minutes(j);
    }
    int i = BaseSingleFieldPeriod.between(paramReadablePartial1, paramReadablePartial2, ZERO);
    return minutes(i);
  }
  
  public static Minutes minutesIn(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ZERO;
    }
    int i = BaseSingleFieldPeriod.between(paramReadableInterval.getStart(), paramReadableInterval.getEnd(), DurationFieldType.minutes());
    return minutes(i);
  }
  
  public static Minutes standardMinutesIn(ReadablePeriod paramReadablePeriod)
  {
    int i = BaseSingleFieldPeriod.standardPeriodIn(paramReadablePeriod, 60000L);
    return minutes(i);
  }
  
  @FromString
  public static Minutes parseMinutes(String paramString)
  {
    if (paramString == null) {
      return ZERO;
    }
    Period localPeriod = PARSER.parsePeriod(paramString);
    return minutes(localPeriod.getMinutes());
  }
  
  private Minutes(int paramInt)
  {
    super(paramInt);
  }
  
  private Object readResolve()
  {
    return minutes(getValue());
  }
  
  public DurationFieldType getFieldType()
  {
    return DurationFieldType.minutes();
  }
  
  public PeriodType getPeriodType()
  {
    return PeriodType.minutes();
  }
  
  public Weeks toStandardWeeks()
  {
    return Weeks.weeks(getValue() / 10080);
  }
  
  public Days toStandardDays()
  {
    return Days.days(getValue() / 1440);
  }
  
  public Hours toStandardHours()
  {
    return Hours.hours(getValue() / 60);
  }
  
  public Seconds toStandardSeconds()
  {
    return Seconds.seconds(FieldUtils.safeMultiply(getValue(), 60));
  }
  
  public Duration toStandardDuration()
  {
    long l = getValue();
    return new Duration(l * 60000L);
  }
  
  public int getMinutes()
  {
    return getValue();
  }
  
  public Minutes plus(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return minutes(FieldUtils.safeAdd(getValue(), paramInt));
  }
  
  public Minutes plus(Minutes paramMinutes)
  {
    if (paramMinutes == null) {
      return this;
    }
    return plus(paramMinutes.getValue());
  }
  
  public Minutes minus(int paramInt)
  {
    return plus(FieldUtils.safeNegate(paramInt));
  }
  
  public Minutes minus(Minutes paramMinutes)
  {
    if (paramMinutes == null) {
      return this;
    }
    return minus(paramMinutes.getValue());
  }
  
  public Minutes multipliedBy(int paramInt)
  {
    return minutes(FieldUtils.safeMultiply(getValue(), paramInt));
  }
  
  public Minutes dividedBy(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    return minutes(getValue() / paramInt);
  }
  
  public Minutes negated()
  {
    return minutes(FieldUtils.safeNegate(getValue()));
  }
  
  public boolean isGreaterThan(Minutes paramMinutes)
  {
    if (paramMinutes == null) {
      return getValue() > 0;
    }
    return getValue() > paramMinutes.getValue();
  }
  
  public boolean isLessThan(Minutes paramMinutes)
  {
    if (paramMinutes == null) {
      return getValue() < 0;
    }
    return getValue() < paramMinutes.getValue();
  }
  
  @ToString
  public String toString()
  {
    return "PT" + String.valueOf(getValue()) + "M";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Minutes
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */