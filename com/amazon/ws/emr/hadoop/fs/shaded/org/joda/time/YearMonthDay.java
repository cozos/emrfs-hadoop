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
public final class YearMonthDay
  extends BasePartial
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = 797544782896179L;
  private static final DateTimeFieldType[] FIELD_TYPES = { DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth() };
  public static final int YEAR = 0;
  public static final int MONTH_OF_YEAR = 1;
  public static final int DAY_OF_MONTH = 2;
  
  public static YearMonthDay fromCalendarFields(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The calendar must not be null");
    }
    return new YearMonthDay(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
  }
  
  public static YearMonthDay fromDateFields(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return new YearMonthDay(paramDate.getYear() + 1900, paramDate.getMonth() + 1, paramDate.getDate());
  }
  
  public YearMonthDay() {}
  
  public YearMonthDay(DateTimeZone paramDateTimeZone)
  {
    super(ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public YearMonthDay(Chronology paramChronology)
  {
    super(paramChronology);
  }
  
  public YearMonthDay(long paramLong)
  {
    super(paramLong);
  }
  
  public YearMonthDay(long paramLong, Chronology paramChronology)
  {
    super(paramLong, paramChronology);
  }
  
  public YearMonthDay(Object paramObject)
  {
    super(paramObject, null, ISODateTimeFormat.dateOptionalTimeParser());
  }
  
  public YearMonthDay(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, DateTimeUtils.getChronology(paramChronology), ISODateTimeFormat.dateOptionalTimeParser());
  }
  
  public YearMonthDay(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, null);
  }
  
  public YearMonthDay(int paramInt1, int paramInt2, int paramInt3, Chronology paramChronology)
  {
    super(new int[] { paramInt1, paramInt2, paramInt3 }, paramChronology);
  }
  
  YearMonthDay(YearMonthDay paramYearMonthDay, int[] paramArrayOfInt)
  {
    super(paramYearMonthDay, paramArrayOfInt);
  }
  
  YearMonthDay(YearMonthDay paramYearMonthDay, Chronology paramChronology)
  {
    super(paramYearMonthDay, paramChronology);
  }
  
  public int size()
  {
    return 3;
  }
  
  protected DateTimeField getField(int paramInt, Chronology paramChronology)
  {
    switch (paramInt)
    {
    case 0: 
      return paramChronology.year();
    case 1: 
      return paramChronology.monthOfYear();
    case 2: 
      return paramChronology.dayOfMonth();
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
  
  public YearMonthDay withChronologyRetainFields(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    paramChronology = paramChronology.withUTC();
    if (paramChronology == getChronology()) {
      return this;
    }
    YearMonthDay localYearMonthDay = new YearMonthDay(this, paramChronology);
    paramChronology.validate(localYearMonthDay, getValues());
    return localYearMonthDay;
  }
  
  public YearMonthDay withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDateTimeFieldType);
    if (paramInt == getValue(i)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).set(this, i, arrayOfInt, paramInt);
    return new YearMonthDay(this, arrayOfInt);
  }
  
  public YearMonthDay withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDurationFieldType);
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).add(this, i, arrayOfInt, paramInt);
    return new YearMonthDay(this, arrayOfInt);
  }
  
  public YearMonthDay withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
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
        arrayOfInt = getField(j).add(this, j, arrayOfInt, FieldUtils.safeMultiply(paramReadablePeriod.getValue(i), paramInt));
      }
    }
    return new YearMonthDay(this, arrayOfInt);
  }
  
  public YearMonthDay plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public YearMonthDay plusYears(int paramInt)
  {
    return withFieldAdded(DurationFieldType.years(), paramInt);
  }
  
  public YearMonthDay plusMonths(int paramInt)
  {
    return withFieldAdded(DurationFieldType.months(), paramInt);
  }
  
  public YearMonthDay plusDays(int paramInt)
  {
    return withFieldAdded(DurationFieldType.days(), paramInt);
  }
  
  public YearMonthDay minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public YearMonthDay minusYears(int paramInt)
  {
    return withFieldAdded(DurationFieldType.years(), FieldUtils.safeNegate(paramInt));
  }
  
  public YearMonthDay minusMonths(int paramInt)
  {
    return withFieldAdded(DurationFieldType.months(), FieldUtils.safeNegate(paramInt));
  }
  
  public YearMonthDay minusDays(int paramInt)
  {
    return withFieldAdded(DurationFieldType.days(), FieldUtils.safeNegate(paramInt));
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    return new Property(this, indexOfSupported(paramDateTimeFieldType));
  }
  
  public LocalDate toLocalDate()
  {
    return new LocalDate(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology());
  }
  
  public DateTime toDateTimeAtMidnight()
  {
    return toDateTimeAtMidnight(null);
  }
  
  public DateTime toDateTimeAtMidnight(DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, localChronology);
  }
  
  public DateTime toDateTimeAtCurrentTime()
  {
    return toDateTimeAtCurrentTime(null);
  }
  
  public DateTime toDateTimeAtCurrentTime(DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    long l1 = DateTimeUtils.currentTimeMillis();
    long l2 = localChronology.set(this, l1);
    return new DateTime(l2, localChronology);
  }
  
  public DateMidnight toDateMidnight()
  {
    return toDateMidnight(null);
  }
  
  public DateMidnight toDateMidnight(DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), localChronology);
  }
  
  public DateTime toDateTime(TimeOfDay paramTimeOfDay)
  {
    return toDateTime(paramTimeOfDay, null);
  }
  
  public DateTime toDateTime(TimeOfDay paramTimeOfDay, DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    long l = DateTimeUtils.currentTimeMillis();
    l = localChronology.set(this, l);
    if (paramTimeOfDay != null) {
      l = localChronology.set(paramTimeOfDay, l);
    }
    return new DateTime(l, localChronology);
  }
  
  public Interval toInterval()
  {
    return toInterval(null);
  }
  
  public Interval toInterval(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    return toDateMidnight(paramDateTimeZone).toInterval();
  }
  
  public int getYear()
  {
    return getValue(0);
  }
  
  public int getMonthOfYear()
  {
    return getValue(1);
  }
  
  public int getDayOfMonth()
  {
    return getValue(2);
  }
  
  public YearMonthDay withYear(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().year().set(this, 0, arrayOfInt, paramInt);
    return new YearMonthDay(this, arrayOfInt);
  }
  
  public YearMonthDay withMonthOfYear(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().monthOfYear().set(this, 1, arrayOfInt, paramInt);
    return new YearMonthDay(this, arrayOfInt);
  }
  
  public YearMonthDay withDayOfMonth(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().dayOfMonth().set(this, 2, arrayOfInt, paramInt);
    return new YearMonthDay(this, arrayOfInt);
  }
  
  public Property year()
  {
    return new Property(this, 0);
  }
  
  public Property monthOfYear()
  {
    return new Property(this, 1);
  }
  
  public Property dayOfMonth()
  {
    return new Property(this, 2);
  }
  
  public String toString()
  {
    return ISODateTimeFormat.yearMonthDay().print(this);
  }
  
  @Deprecated
  public static class Property
    extends AbstractPartialFieldProperty
    implements Serializable
  {
    private static final long serialVersionUID = 5727734012190224363L;
    private final YearMonthDay iYearMonthDay;
    private final int iFieldIndex;
    
    Property(YearMonthDay paramYearMonthDay, int paramInt)
    {
      iYearMonthDay = paramYearMonthDay;
      iFieldIndex = paramInt;
    }
    
    public DateTimeField getField()
    {
      return iYearMonthDay.getField(iFieldIndex);
    }
    
    protected ReadablePartial getReadablePartial()
    {
      return iYearMonthDay;
    }
    
    public YearMonthDay getYearMonthDay()
    {
      return iYearMonthDay;
    }
    
    public int get()
    {
      return iYearMonthDay.getValue(iFieldIndex);
    }
    
    public YearMonthDay addToCopy(int paramInt)
    {
      int[] arrayOfInt = iYearMonthDay.getValues();
      arrayOfInt = getField().add(iYearMonthDay, iFieldIndex, arrayOfInt, paramInt);
      return new YearMonthDay(iYearMonthDay, arrayOfInt);
    }
    
    public YearMonthDay addWrapFieldToCopy(int paramInt)
    {
      int[] arrayOfInt = iYearMonthDay.getValues();
      arrayOfInt = getField().addWrapField(iYearMonthDay, iFieldIndex, arrayOfInt, paramInt);
      return new YearMonthDay(iYearMonthDay, arrayOfInt);
    }
    
    public YearMonthDay setCopy(int paramInt)
    {
      int[] arrayOfInt = iYearMonthDay.getValues();
      arrayOfInt = getField().set(iYearMonthDay, iFieldIndex, arrayOfInt, paramInt);
      return new YearMonthDay(iYearMonthDay, arrayOfInt);
    }
    
    public YearMonthDay setCopy(String paramString, Locale paramLocale)
    {
      int[] arrayOfInt = iYearMonthDay.getValues();
      arrayOfInt = getField().set(iYearMonthDay, iFieldIndex, arrayOfInt, paramString, paramLocale);
      return new YearMonthDay(iYearMonthDay, arrayOfInt);
    }
    
    public YearMonthDay setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public YearMonthDay withMaximumValue()
    {
      return setCopy(getMaximumValue());
    }
    
    public YearMonthDay withMinimumValue()
    {
      return setCopy(getMinimumValue());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.YearMonthDay
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */