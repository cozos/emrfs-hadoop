package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BasePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Deprecated
public final class TimeOfDay
  extends BasePartial
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = 3633353405803318660L;
  private static final DateTimeFieldType[] FIELD_TYPES = { DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(), DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond() };
  public static final TimeOfDay MIDNIGHT = new TimeOfDay(0, 0, 0, 0);
  public static final int HOUR_OF_DAY = 0;
  public static final int MINUTE_OF_HOUR = 1;
  public static final int SECOND_OF_MINUTE = 2;
  public static final int MILLIS_OF_SECOND = 3;
  
  public static TimeOfDay fromCalendarFields(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The calendar must not be null");
    }
    return new TimeOfDay(paramCalendar.get(11), paramCalendar.get(12), paramCalendar.get(13), paramCalendar.get(14));
  }
  
  public static TimeOfDay fromDateFields(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return new TimeOfDay(paramDate.getHours(), paramDate.getMinutes(), paramDate.getSeconds(), ((int)(paramDate.getTime() % 1000L) + 1000) % 1000);
  }
  
  public static TimeOfDay fromMillisOfDay(long paramLong)
  {
    return fromMillisOfDay(paramLong, null);
  }
  
  public static TimeOfDay fromMillisOfDay(long paramLong, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    paramChronology = paramChronology.withUTC();
    return new TimeOfDay(paramLong, paramChronology);
  }
  
  public TimeOfDay() {}
  
  public TimeOfDay(DateTimeZone paramDateTimeZone)
  {
    super(ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public TimeOfDay(Chronology paramChronology)
  {
    super(paramChronology);
  }
  
  public TimeOfDay(long paramLong)
  {
    super(paramLong);
  }
  
  public TimeOfDay(long paramLong, Chronology paramChronology)
  {
    super(paramLong, paramChronology);
  }
  
  public TimeOfDay(Object paramObject)
  {
    super(paramObject, null, ISODateTimeFormat.timeParser());
  }
  
  public TimeOfDay(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, DateTimeUtils.getChronology(paramChronology), ISODateTimeFormat.timeParser());
  }
  
  public TimeOfDay(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 0, null);
  }
  
  public TimeOfDay(int paramInt1, int paramInt2, Chronology paramChronology)
  {
    this(paramInt1, paramInt2, 0, 0, paramChronology);
  }
  
  public TimeOfDay(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 0, null);
  }
  
  public TimeOfDay(int paramInt1, int paramInt2, int paramInt3, Chronology paramChronology)
  {
    this(paramInt1, paramInt2, paramInt3, 0, paramChronology);
  }
  
  public TimeOfDay(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public TimeOfDay(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Chronology paramChronology)
  {
    super(new int[] { paramInt1, paramInt2, paramInt3, paramInt4 }, paramChronology);
  }
  
  TimeOfDay(TimeOfDay paramTimeOfDay, int[] paramArrayOfInt)
  {
    super(paramTimeOfDay, paramArrayOfInt);
  }
  
  TimeOfDay(TimeOfDay paramTimeOfDay, Chronology paramChronology)
  {
    super(paramTimeOfDay, paramChronology);
  }
  
  public int size()
  {
    return 4;
  }
  
  protected DateTimeField getField(int paramInt, Chronology paramChronology)
  {
    switch (paramInt)
    {
    case 0: 
      return paramChronology.hourOfDay();
    case 1: 
      return paramChronology.minuteOfHour();
    case 2: 
      return paramChronology.secondOfMinute();
    case 3: 
      return paramChronology.millisOfSecond();
    }
    throw new IndexOutOfBoundsException("Invalid index: " + paramInt);
  }
  
  public DateTimeFieldType getFieldType(int paramInt)
  {
    return FIELD_TYPES[paramInt];
  }
  
  public DateTimeFieldType[] getFieldTypes()
  {
    return (DateTimeFieldType[])FIELD_TYPES.clone();
  }
  
  public TimeOfDay withChronologyRetainFields(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    paramChronology = paramChronology.withUTC();
    if (paramChronology == getChronology()) {
      return this;
    }
    TimeOfDay localTimeOfDay = new TimeOfDay(this, paramChronology);
    paramChronology.validate(localTimeOfDay, getValues());
    return localTimeOfDay;
  }
  
  public TimeOfDay withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDateTimeFieldType);
    if (paramInt == getValue(i)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).set(this, i, arrayOfInt, paramInt);
    return new TimeOfDay(this, arrayOfInt);
  }
  
  public TimeOfDay withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDurationFieldType);
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).addWrapPartial(this, i, arrayOfInt, paramInt);
    return new TimeOfDay(this, arrayOfInt);
  }
  
  public TimeOfDay withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if ((paramReadablePeriod == null) || (paramInt == 0)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    for (int i = 0; i < paramReadablePeriod.size(); i++)
    {
      DurationFieldType localDurationFieldType = paramReadablePeriod.getFieldType(i);
      int j = indexOf(localDurationFieldType);
      if (j >= 0) {
        arrayOfInt = getField(j).addWrapPartial(this, j, arrayOfInt, FieldUtils.safeMultiply(paramReadablePeriod.getValue(i), paramInt));
      }
    }
    return new TimeOfDay(this, arrayOfInt);
  }
  
  public TimeOfDay plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public TimeOfDay plusHours(int paramInt)
  {
    return withFieldAdded(DurationFieldType.hours(), paramInt);
  }
  
  public TimeOfDay plusMinutes(int paramInt)
  {
    return withFieldAdded(DurationFieldType.minutes(), paramInt);
  }
  
  public TimeOfDay plusSeconds(int paramInt)
  {
    return withFieldAdded(DurationFieldType.seconds(), paramInt);
  }
  
  public TimeOfDay plusMillis(int paramInt)
  {
    return withFieldAdded(DurationFieldType.millis(), paramInt);
  }
  
  public TimeOfDay minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public TimeOfDay minusHours(int paramInt)
  {
    return withFieldAdded(DurationFieldType.hours(), FieldUtils.safeNegate(paramInt));
  }
  
  public TimeOfDay minusMinutes(int paramInt)
  {
    return withFieldAdded(DurationFieldType.minutes(), FieldUtils.safeNegate(paramInt));
  }
  
  public TimeOfDay minusSeconds(int paramInt)
  {
    return withFieldAdded(DurationFieldType.seconds(), FieldUtils.safeNegate(paramInt));
  }
  
  public TimeOfDay minusMillis(int paramInt)
  {
    return withFieldAdded(DurationFieldType.millis(), FieldUtils.safeNegate(paramInt));
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    return new Property(this, indexOfSupported(paramDateTimeFieldType));
  }
  
  public LocalTime toLocalTime()
  {
    return new LocalTime(getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), getChronology());
  }
  
  public DateTime toDateTimeToday()
  {
    return toDateTimeToday(null);
  }
  
  public DateTime toDateTimeToday(DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    long l1 = DateTimeUtils.currentTimeMillis();
    long l2 = localChronology.set(this, l1);
    return new DateTime(l2, localChronology);
  }
  
  public int getHourOfDay()
  {
    return getValue(0);
  }
  
  public int getMinuteOfHour()
  {
    return getValue(1);
  }
  
  public int getSecondOfMinute()
  {
    return getValue(2);
  }
  
  public int getMillisOfSecond()
  {
    return getValue(3);
  }
  
  public TimeOfDay withHourOfDay(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().hourOfDay().set(this, 0, arrayOfInt, paramInt);
    return new TimeOfDay(this, arrayOfInt);
  }
  
  public TimeOfDay withMinuteOfHour(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().minuteOfHour().set(this, 1, arrayOfInt, paramInt);
    return new TimeOfDay(this, arrayOfInt);
  }
  
  public TimeOfDay withSecondOfMinute(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().secondOfMinute().set(this, 2, arrayOfInt, paramInt);
    return new TimeOfDay(this, arrayOfInt);
  }
  
  public TimeOfDay withMillisOfSecond(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().millisOfSecond().set(this, 3, arrayOfInt, paramInt);
    return new TimeOfDay(this, arrayOfInt);
  }
  
  public Property hourOfDay()
  {
    return new Property(this, 0);
  }
  
  public Property minuteOfHour()
  {
    return new Property(this, 1);
  }
  
  public Property secondOfMinute()
  {
    return new Property(this, 2);
  }
  
  public Property millisOfSecond()
  {
    return new Property(this, 3);
  }
  
  public String toString()
  {
    return ISODateTimeFormat.tTime().print(this);
  }
  
  @Deprecated
  public static class Property
    extends AbstractPartialFieldProperty
    implements Serializable
  {
    private static final long serialVersionUID = 5598459141741063833L;
    private final TimeOfDay iTimeOfDay;
    private final int iFieldIndex;
    
    Property(TimeOfDay paramTimeOfDay, int paramInt)
    {
      iTimeOfDay = paramTimeOfDay;
      iFieldIndex = paramInt;
    }
    
    public DateTimeField getField()
    {
      return iTimeOfDay.getField(iFieldIndex);
    }
    
    protected ReadablePartial getReadablePartial()
    {
      return iTimeOfDay;
    }
    
    public TimeOfDay getTimeOfDay()
    {
      return iTimeOfDay;
    }
    
    public int get()
    {
      return iTimeOfDay.getValue(iFieldIndex);
    }
    
    public TimeOfDay addToCopy(int paramInt)
    {
      int[] arrayOfInt = iTimeOfDay.getValues();
      arrayOfInt = getField().addWrapPartial(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
      return new TimeOfDay(iTimeOfDay, arrayOfInt);
    }
    
    public TimeOfDay addNoWrapToCopy(int paramInt)
    {
      int[] arrayOfInt = iTimeOfDay.getValues();
      arrayOfInt = getField().add(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
      return new TimeOfDay(iTimeOfDay, arrayOfInt);
    }
    
    public TimeOfDay addWrapFieldToCopy(int paramInt)
    {
      int[] arrayOfInt = iTimeOfDay.getValues();
      arrayOfInt = getField().addWrapField(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
      return new TimeOfDay(iTimeOfDay, arrayOfInt);
    }
    
    public TimeOfDay setCopy(int paramInt)
    {
      int[] arrayOfInt = iTimeOfDay.getValues();
      arrayOfInt = getField().set(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
      return new TimeOfDay(iTimeOfDay, arrayOfInt);
    }
    
    public TimeOfDay setCopy(String paramString, Locale paramLocale)
    {
      int[] arrayOfInt = iTimeOfDay.getValues();
      arrayOfInt = getField().set(iTimeOfDay, iFieldIndex, arrayOfInt, paramString, paramLocale);
      return new TimeOfDay(iTimeOfDay, arrayOfInt);
    }
    
    public TimeOfDay setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public TimeOfDay withMaximumValue()
    {
      return setCopy(getMaximumValue());
    }
    
    public TimeOfDay withMinimumValue()
    {
      return setCopy(getMinimumValue());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.TimeOfDay
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */