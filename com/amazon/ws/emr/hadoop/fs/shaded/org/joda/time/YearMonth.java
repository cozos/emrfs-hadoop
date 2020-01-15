package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BasePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class YearMonth
  extends BasePartial
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = 797544782896179L;
  private static final DateTimeFieldType[] FIELD_TYPES = { DateTimeFieldType.year(), DateTimeFieldType.monthOfYear() };
  public static final int YEAR = 0;
  public static final int MONTH_OF_YEAR = 1;
  
  public static YearMonth now()
  {
    return new YearMonth();
  }
  
  public static YearMonth now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new YearMonth(paramDateTimeZone);
  }
  
  public static YearMonth now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new YearMonth(paramChronology);
  }
  
  @FromString
  public static YearMonth parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.localDateParser());
  }
  
  public static YearMonth parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    LocalDate localLocalDate = paramDateTimeFormatter.parseLocalDate(paramString);
    return new YearMonth(localLocalDate.getYear(), localLocalDate.getMonthOfYear());
  }
  
  public static YearMonth fromCalendarFields(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The calendar must not be null");
    }
    return new YearMonth(paramCalendar.get(1), paramCalendar.get(2) + 1);
  }
  
  public static YearMonth fromDateFields(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return new YearMonth(paramDate.getYear() + 1900, paramDate.getMonth() + 1);
  }
  
  public YearMonth() {}
  
  public YearMonth(DateTimeZone paramDateTimeZone)
  {
    super(ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public YearMonth(Chronology paramChronology)
  {
    super(paramChronology);
  }
  
  public YearMonth(long paramLong)
  {
    super(paramLong);
  }
  
  public YearMonth(long paramLong, Chronology paramChronology)
  {
    super(paramLong, paramChronology);
  }
  
  public YearMonth(Object paramObject)
  {
    super(paramObject, null, ISODateTimeFormat.localDateParser());
  }
  
  public YearMonth(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, DateTimeUtils.getChronology(paramChronology), ISODateTimeFormat.localDateParser());
  }
  
  public YearMonth(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }
  
  public YearMonth(int paramInt1, int paramInt2, Chronology paramChronology)
  {
    super(new int[] { paramInt1, paramInt2 }, paramChronology);
  }
  
  YearMonth(YearMonth paramYearMonth, int[] paramArrayOfInt)
  {
    super(paramYearMonth, paramArrayOfInt);
  }
  
  YearMonth(YearMonth paramYearMonth, Chronology paramChronology)
  {
    super(paramYearMonth, paramChronology);
  }
  
  private Object readResolve()
  {
    if (!DateTimeZone.UTC.equals(getChronology().getZone())) {
      return new YearMonth(this, getChronology().withUTC());
    }
    return this;
  }
  
  public int size()
  {
    return 2;
  }
  
  protected DateTimeField getField(int paramInt, Chronology paramChronology)
  {
    switch (paramInt)
    {
    case 0: 
      return paramChronology.year();
    case 1: 
      return paramChronology.monthOfYear();
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
  
  public YearMonth withChronologyRetainFields(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    paramChronology = paramChronology.withUTC();
    if (paramChronology == getChronology()) {
      return this;
    }
    YearMonth localYearMonth = new YearMonth(this, paramChronology);
    paramChronology.validate(localYearMonth, getValues());
    return localYearMonth;
  }
  
  public YearMonth withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDateTimeFieldType);
    if (paramInt == getValue(i)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).set(this, i, arrayOfInt, paramInt);
    return new YearMonth(this, arrayOfInt);
  }
  
  public YearMonth withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDurationFieldType);
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).add(this, i, arrayOfInt, paramInt);
    return new YearMonth(this, arrayOfInt);
  }
  
  public YearMonth withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
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
    return new YearMonth(this, arrayOfInt);
  }
  
  public YearMonth plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public YearMonth plusYears(int paramInt)
  {
    return withFieldAdded(DurationFieldType.years(), paramInt);
  }
  
  public YearMonth plusMonths(int paramInt)
  {
    return withFieldAdded(DurationFieldType.months(), paramInt);
  }
  
  public YearMonth minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public YearMonth minusYears(int paramInt)
  {
    return withFieldAdded(DurationFieldType.years(), FieldUtils.safeNegate(paramInt));
  }
  
  public YearMonth minusMonths(int paramInt)
  {
    return withFieldAdded(DurationFieldType.months(), FieldUtils.safeNegate(paramInt));
  }
  
  public LocalDate toLocalDate(int paramInt)
  {
    return new LocalDate(getYear(), getMonthOfYear(), paramInt, getChronology());
  }
  
  public Interval toInterval()
  {
    return toInterval(null);
  }
  
  public Interval toInterval(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    DateTime localDateTime1 = toLocalDate(1).toDateTimeAtStartOfDay(paramDateTimeZone);
    DateTime localDateTime2 = plusMonths(1).toLocalDate(1).toDateTimeAtStartOfDay(paramDateTimeZone);
    return new Interval(localDateTime1, localDateTime2);
  }
  
  public int getYear()
  {
    return getValue(0);
  }
  
  public int getMonthOfYear()
  {
    return getValue(1);
  }
  
  public YearMonth withYear(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().year().set(this, 0, arrayOfInt, paramInt);
    return new YearMonth(this, arrayOfInt);
  }
  
  public YearMonth withMonthOfYear(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().monthOfYear().set(this, 1, arrayOfInt, paramInt);
    return new YearMonth(this, arrayOfInt);
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    return new Property(this, indexOfSupported(paramDateTimeFieldType));
  }
  
  public Property year()
  {
    return new Property(this, 0);
  }
  
  public Property monthOfYear()
  {
    return new Property(this, 1);
  }
  
  @ToString
  public String toString()
  {
    return ISODateTimeFormat.yearMonth().print(this);
  }
  
  public String toString(String paramString)
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).print(this);
  }
  
  public String toString(String paramString, Locale paramLocale)
    throws IllegalArgumentException
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).withLocale(paramLocale).print(this);
  }
  
  public static class Property
    extends AbstractPartialFieldProperty
    implements Serializable
  {
    private static final long serialVersionUID = 5727734012190224363L;
    private final YearMonth iBase;
    private final int iFieldIndex;
    
    Property(YearMonth paramYearMonth, int paramInt)
    {
      iBase = paramYearMonth;
      iFieldIndex = paramInt;
    }
    
    public DateTimeField getField()
    {
      return iBase.getField(iFieldIndex);
    }
    
    protected ReadablePartial getReadablePartial()
    {
      return iBase;
    }
    
    public YearMonth getYearMonth()
    {
      return iBase;
    }
    
    public int get()
    {
      return iBase.getValue(iFieldIndex);
    }
    
    public YearMonth addToCopy(int paramInt)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().add(iBase, iFieldIndex, arrayOfInt, paramInt);
      return new YearMonth(iBase, arrayOfInt);
    }
    
    public YearMonth addWrapFieldToCopy(int paramInt)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().addWrapField(iBase, iFieldIndex, arrayOfInt, paramInt);
      return new YearMonth(iBase, arrayOfInt);
    }
    
    public YearMonth setCopy(int paramInt)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramInt);
      return new YearMonth(iBase, arrayOfInt);
    }
    
    public YearMonth setCopy(String paramString, Locale paramLocale)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramString, paramLocale);
      return new YearMonth(iBase, arrayOfInt);
    }
    
    public YearMonth setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.YearMonth
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */