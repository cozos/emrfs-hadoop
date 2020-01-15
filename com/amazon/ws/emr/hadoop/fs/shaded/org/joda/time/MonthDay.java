package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BasePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class MonthDay
  extends BasePartial
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = 2954560699050434609L;
  private static final DateTimeFieldType[] FIELD_TYPES = { DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth() };
  private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendOptional(ISODateTimeFormat.localDateParser().getParser()).appendOptional(DateTimeFormat.forPattern("--MM-dd").getParser()).toFormatter();
  public static final int MONTH_OF_YEAR = 0;
  public static final int DAY_OF_MONTH = 1;
  
  public static MonthDay now()
  {
    return new MonthDay();
  }
  
  public static MonthDay now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new MonthDay(paramDateTimeZone);
  }
  
  public static MonthDay now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new MonthDay(paramChronology);
  }
  
  @FromString
  public static MonthDay parse(String paramString)
  {
    return parse(paramString, PARSER);
  }
  
  public static MonthDay parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    LocalDate localLocalDate = paramDateTimeFormatter.parseLocalDate(paramString);
    return new MonthDay(localLocalDate.getMonthOfYear(), localLocalDate.getDayOfMonth());
  }
  
  public static MonthDay fromCalendarFields(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The calendar must not be null");
    }
    return new MonthDay(paramCalendar.get(2) + 1, paramCalendar.get(5));
  }
  
  public static MonthDay fromDateFields(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return new MonthDay(paramDate.getMonth() + 1, paramDate.getDate());
  }
  
  public MonthDay() {}
  
  public MonthDay(DateTimeZone paramDateTimeZone)
  {
    super(ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public MonthDay(Chronology paramChronology)
  {
    super(paramChronology);
  }
  
  public MonthDay(long paramLong)
  {
    super(paramLong);
  }
  
  public MonthDay(long paramLong, Chronology paramChronology)
  {
    super(paramLong, paramChronology);
  }
  
  public MonthDay(Object paramObject)
  {
    super(paramObject, null, ISODateTimeFormat.localDateParser());
  }
  
  public MonthDay(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, DateTimeUtils.getChronology(paramChronology), ISODateTimeFormat.localDateParser());
  }
  
  public MonthDay(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }
  
  public MonthDay(int paramInt1, int paramInt2, Chronology paramChronology)
  {
    super(new int[] { paramInt1, paramInt2 }, paramChronology);
  }
  
  MonthDay(MonthDay paramMonthDay, int[] paramArrayOfInt)
  {
    super(paramMonthDay, paramArrayOfInt);
  }
  
  MonthDay(MonthDay paramMonthDay, Chronology paramChronology)
  {
    super(paramMonthDay, paramChronology);
  }
  
  private Object readResolve()
  {
    if (!DateTimeZone.UTC.equals(getChronology().getZone())) {
      return new MonthDay(this, getChronology().withUTC());
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
      return paramChronology.monthOfYear();
    case 1: 
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
  
  public MonthDay withChronologyRetainFields(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    paramChronology = paramChronology.withUTC();
    if (paramChronology == getChronology()) {
      return this;
    }
    MonthDay localMonthDay = new MonthDay(this, paramChronology);
    paramChronology.validate(localMonthDay, getValues());
    return localMonthDay;
  }
  
  public MonthDay withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDateTimeFieldType);
    if (paramInt == getValue(i)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).set(this, i, arrayOfInt, paramInt);
    return new MonthDay(this, arrayOfInt);
  }
  
  public MonthDay withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDurationFieldType);
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).add(this, i, arrayOfInt, paramInt);
    return new MonthDay(this, arrayOfInt);
  }
  
  public MonthDay withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
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
    return new MonthDay(this, arrayOfInt);
  }
  
  public MonthDay plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public MonthDay plusMonths(int paramInt)
  {
    return withFieldAdded(DurationFieldType.months(), paramInt);
  }
  
  public MonthDay plusDays(int paramInt)
  {
    return withFieldAdded(DurationFieldType.days(), paramInt);
  }
  
  public MonthDay minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public MonthDay minusMonths(int paramInt)
  {
    return withFieldAdded(DurationFieldType.months(), FieldUtils.safeNegate(paramInt));
  }
  
  public MonthDay minusDays(int paramInt)
  {
    return withFieldAdded(DurationFieldType.days(), FieldUtils.safeNegate(paramInt));
  }
  
  public LocalDate toLocalDate(int paramInt)
  {
    return new LocalDate(paramInt, getMonthOfYear(), getDayOfMonth(), getChronology());
  }
  
  public int getMonthOfYear()
  {
    return getValue(0);
  }
  
  public int getDayOfMonth()
  {
    return getValue(1);
  }
  
  public MonthDay withMonthOfYear(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().monthOfYear().set(this, 0, arrayOfInt, paramInt);
    return new MonthDay(this, arrayOfInt);
  }
  
  public MonthDay withDayOfMonth(int paramInt)
  {
    int[] arrayOfInt = getValues();
    arrayOfInt = getChronology().dayOfMonth().set(this, 1, arrayOfInt, paramInt);
    return new MonthDay(this, arrayOfInt);
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    return new Property(this, indexOfSupported(paramDateTimeFieldType));
  }
  
  public Property monthOfYear()
  {
    return new Property(this, 0);
  }
  
  public Property dayOfMonth()
  {
    return new Property(this, 1);
  }
  
  @ToString
  public String toString()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DateTimeFieldType.monthOfYear());
    localArrayList.add(DateTimeFieldType.dayOfMonth());
    return ISODateTimeFormat.forFields(localArrayList, true, true).print(this);
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
    private final MonthDay iBase;
    private final int iFieldIndex;
    
    Property(MonthDay paramMonthDay, int paramInt)
    {
      iBase = paramMonthDay;
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
    
    public MonthDay getMonthDay()
    {
      return iBase;
    }
    
    public int get()
    {
      return iBase.getValue(iFieldIndex);
    }
    
    public MonthDay addToCopy(int paramInt)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().add(iBase, iFieldIndex, arrayOfInt, paramInt);
      return new MonthDay(iBase, arrayOfInt);
    }
    
    public MonthDay addWrapFieldToCopy(int paramInt)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().addWrapField(iBase, iFieldIndex, arrayOfInt, paramInt);
      return new MonthDay(iBase, arrayOfInt);
    }
    
    public MonthDay setCopy(int paramInt)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramInt);
      return new MonthDay(iBase, arrayOfInt);
    }
    
    public MonthDay setCopy(String paramString, Locale paramLocale)
    {
      int[] arrayOfInt = iBase.getValues();
      arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramString, paramLocale);
      return new MonthDay(iBase, arrayOfInt);
    }
    
    public MonthDay setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MonthDay
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */