package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseLocal;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.PartialConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class LocalDate
  extends BaseLocal
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = -8775358157899L;
  private static final int YEAR = 0;
  private static final int MONTH_OF_YEAR = 1;
  private static final int DAY_OF_MONTH = 2;
  private static final Set<DurationFieldType> DATE_DURATION_TYPES = new HashSet();
  private final long iLocalMillis;
  private final Chronology iChronology;
  private transient int iHash;
  
  static
  {
    DATE_DURATION_TYPES.add(DurationFieldType.days());
    DATE_DURATION_TYPES.add(DurationFieldType.weeks());
    DATE_DURATION_TYPES.add(DurationFieldType.months());
    DATE_DURATION_TYPES.add(DurationFieldType.weekyears());
    DATE_DURATION_TYPES.add(DurationFieldType.years());
    DATE_DURATION_TYPES.add(DurationFieldType.centuries());
    
    DATE_DURATION_TYPES.add(DurationFieldType.eras());
  }
  
  public static LocalDate now()
  {
    return new LocalDate();
  }
  
  public static LocalDate now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new LocalDate(paramDateTimeZone);
  }
  
  public static LocalDate now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new LocalDate(paramChronology);
  }
  
  @FromString
  public static LocalDate parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.localDateParser());
  }
  
  public static LocalDate parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    return paramDateTimeFormatter.parseLocalDate(paramString);
  }
  
  public static LocalDate fromCalendarFields(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The calendar must not be null");
    }
    int i = paramCalendar.get(0);
    int j = paramCalendar.get(1);
    return new LocalDate(i == 1 ? j : 1 - j, paramCalendar.get(2) + 1, paramCalendar.get(5));
  }
  
  public static LocalDate fromDateFields(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    if (paramDate.getTime() < 0L)
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTime(paramDate);
      return fromCalendarFields(localGregorianCalendar);
    }
    return new LocalDate(paramDate.getYear() + 1900, paramDate.getMonth() + 1, paramDate.getDate());
  }
  
  public LocalDate()
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance());
  }
  
  public LocalDate(DateTimeZone paramDateTimeZone)
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public LocalDate(Chronology paramChronology)
  {
    this(DateTimeUtils.currentTimeMillis(), paramChronology);
  }
  
  public LocalDate(long paramLong)
  {
    this(paramLong, ISOChronology.getInstance());
  }
  
  public LocalDate(long paramLong, DateTimeZone paramDateTimeZone)
  {
    this(paramLong, ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public LocalDate(long paramLong, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    
    long l = paramChronology.getZone().getMillisKeepLocal(DateTimeZone.UTC, paramLong);
    paramChronology = paramChronology.withUTC();
    iLocalMillis = paramChronology.dayOfMonth().roundFloor(l);
    iChronology = paramChronology;
  }
  
  public LocalDate(Object paramObject)
  {
    this(paramObject, (Chronology)null);
  }
  
  public LocalDate(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    Chronology localChronology = localPartialConverter.getChronology(paramObject, paramDateTimeZone);
    localChronology = DateTimeUtils.getChronology(localChronology);
    iChronology = localChronology.withUTC();
    int[] arrayOfInt = localPartialConverter.getPartialValues(this, paramObject, localChronology, ISODateTimeFormat.localDateParser());
    iLocalMillis = iChronology.getDateTimeMillis(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], 0);
  }
  
  public LocalDate(Object paramObject, Chronology paramChronology)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    paramChronology = localPartialConverter.getChronology(paramObject, paramChronology);
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iChronology = paramChronology.withUTC();
    int[] arrayOfInt = localPartialConverter.getPartialValues(this, paramObject, paramChronology, ISODateTimeFormat.localDateParser());
    iLocalMillis = iChronology.getDateTimeMillis(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], 0);
  }
  
  public LocalDate(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, ISOChronology.getInstanceUTC());
  }
  
  public LocalDate(int paramInt1, int paramInt2, int paramInt3, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology).withUTC();
    long l = paramChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, 0);
    iChronology = paramChronology;
    iLocalMillis = l;
  }
  
  private Object readResolve()
  {
    if (iChronology == null) {
      return new LocalDate(iLocalMillis, ISOChronology.getInstanceUTC());
    }
    if (!DateTimeZone.UTC.equals(iChronology.getZone())) {
      return new LocalDate(iLocalMillis, iChronology.withUTC());
    }
    return this;
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
  
  public int getValue(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      return getChronology().year().get(getLocalMillis());
    case 1: 
      return getChronology().monthOfYear().get(getLocalMillis());
    case 2: 
      return getChronology().dayOfMonth().get(getLocalMillis());
    }
    throw new IndexOutOfBoundsException("Invalid index: " + paramInt);
  }
  
  public int get(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    if (!isSupported(paramDateTimeFieldType)) {
      throw new IllegalArgumentException("Field '" + paramDateTimeFieldType + "' is not supported");
    }
    return paramDateTimeFieldType.getField(getChronology()).get(getLocalMillis());
  }
  
  public boolean isSupported(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      return false;
    }
    DurationFieldType localDurationFieldType = paramDateTimeFieldType.getDurationType();
    if ((DATE_DURATION_TYPES.contains(localDurationFieldType)) || (localDurationFieldType.getField(getChronology()).getUnitMillis() >= getChronology().days().getUnitMillis())) {
      return paramDateTimeFieldType.getField(getChronology()).isSupported();
    }
    return false;
  }
  
  public boolean isSupported(DurationFieldType paramDurationFieldType)
  {
    if (paramDurationFieldType == null) {
      return false;
    }
    DurationField localDurationField = paramDurationFieldType.getField(getChronology());
    if ((DATE_DURATION_TYPES.contains(paramDurationFieldType)) || (localDurationField.getUnitMillis() >= getChronology().days().getUnitMillis())) {
      return localDurationField.isSupported();
    }
    return false;
  }
  
  protected long getLocalMillis()
  {
    return iLocalMillis;
  }
  
  public Chronology getChronology()
  {
    return iChronology;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof LocalDate))
    {
      LocalDate localLocalDate = (LocalDate)paramObject;
      if (iChronology.equals(iChronology)) {
        return iLocalMillis == iLocalMillis;
      }
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    int i = iHash;
    if (i == 0) {
      i = iHash = super.hashCode();
    }
    return i;
  }
  
  public int compareTo(ReadablePartial paramReadablePartial)
  {
    if (this == paramReadablePartial) {
      return 0;
    }
    if ((paramReadablePartial instanceof LocalDate))
    {
      LocalDate localLocalDate = (LocalDate)paramReadablePartial;
      if (iChronology.equals(iChronology)) {
        return iLocalMillis == iLocalMillis ? 0 : iLocalMillis < iLocalMillis ? -1 : 1;
      }
    }
    return super.compareTo(paramReadablePartial);
  }
  
  public DateTime toDateTimeAtStartOfDay()
  {
    return toDateTimeAtStartOfDay(null);
  }
  
  public DateTime toDateTimeAtStartOfDay(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    long l1 = getLocalMillis() + 21600000L;
    long l2 = paramDateTimeZone.convertLocalToUTC(l1, false);
    l2 = localChronology.dayOfMonth().roundFloor(l2);
    return new DateTime(l2, localChronology);
  }
  
  @Deprecated
  public DateTime toDateTimeAtMidnight()
  {
    return toDateTimeAtMidnight(null);
  }
  
  @Deprecated
  public DateTime toDateTimeAtMidnight(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, localChronology);
  }
  
  public DateTime toDateTimeAtCurrentTime()
  {
    return toDateTimeAtCurrentTime(null);
  }
  
  public DateTime toDateTimeAtCurrentTime(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    long l1 = DateTimeUtils.currentTimeMillis();
    long l2 = localChronology.set(this, l1);
    return new DateTime(l2, localChronology);
  }
  
  @Deprecated
  public DateMidnight toDateMidnight()
  {
    return toDateMidnight(null);
  }
  
  @Deprecated
  public DateMidnight toDateMidnight(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), localChronology);
  }
  
  public LocalDateTime toLocalDateTime(LocalTime paramLocalTime)
  {
    if (paramLocalTime == null) {
      throw new IllegalArgumentException("The time must not be null");
    }
    if (getChronology() != paramLocalTime.getChronology()) {
      throw new IllegalArgumentException("The chronology of the time does not match");
    }
    long l = getLocalMillis() + paramLocalTime.getLocalMillis();
    return new LocalDateTime(l, getChronology());
  }
  
  public DateTime toDateTime(LocalTime paramLocalTime)
  {
    return toDateTime(paramLocalTime, null);
  }
  
  public DateTime toDateTime(LocalTime paramLocalTime, DateTimeZone paramDateTimeZone)
  {
    if (paramLocalTime == null) {
      return toDateTimeAtCurrentTime(paramDateTimeZone);
    }
    if (getChronology() != paramLocalTime.getChronology()) {
      throw new IllegalArgumentException("The chronology of the time does not match");
    }
    Chronology localChronology = getChronology().withZone(paramDateTimeZone);
    return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), paramLocalTime.getHourOfDay(), paramLocalTime.getMinuteOfHour(), paramLocalTime.getSecondOfMinute(), paramLocalTime.getMillisOfSecond(), localChronology);
  }
  
  public Interval toInterval()
  {
    return toInterval(null);
  }
  
  public Interval toInterval(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    DateTime localDateTime1 = toDateTimeAtStartOfDay(paramDateTimeZone);
    DateTime localDateTime2 = plusDays(1).toDateTimeAtStartOfDay(paramDateTimeZone);
    return new Interval(localDateTime1, localDateTime2);
  }
  
  public Date toDate()
  {
    int i = getDayOfMonth();
    Object localObject = new Date(getYear() - 1900, getMonthOfYear() - 1, i);
    LocalDate localLocalDate = fromDateFields((Date)localObject);
    if (localLocalDate.isBefore(this))
    {
      while (!localLocalDate.equals(this))
      {
        ((Date)localObject).setTime(((Date)localObject).getTime() + 3600000L);
        localLocalDate = fromDateFields((Date)localObject);
      }
      while (((Date)localObject).getDate() == i) {
        ((Date)localObject).setTime(((Date)localObject).getTime() - 1000L);
      }
      ((Date)localObject).setTime(((Date)localObject).getTime() + 1000L);
    }
    else if (localLocalDate.equals(this))
    {
      Date localDate = new Date(((Date)localObject).getTime() - TimeZone.getDefault().getDSTSavings());
      if (localDate.getDate() == i) {
        localObject = localDate;
      }
    }
    return (Date)localObject;
  }
  
  LocalDate withLocalMillis(long paramLong)
  {
    paramLong = iChronology.dayOfMonth().roundFloor(paramLong);
    return paramLong == getLocalMillis() ? this : new LocalDate(paramLong, getChronology());
  }
  
  public LocalDate withFields(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      return this;
    }
    return withLocalMillis(getChronology().set(paramReadablePartial, getLocalMillis()));
  }
  
  public LocalDate withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    if (!isSupported(paramDateTimeFieldType)) {
      throw new IllegalArgumentException("Field '" + paramDateTimeFieldType + "' is not supported");
    }
    long l = paramDateTimeFieldType.getField(getChronology()).set(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    if (paramDurationFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    if (!isSupported(paramDurationFieldType)) {
      throw new IllegalArgumentException("Field '" + paramDurationFieldType + "' is not supported");
    }
    if (paramInt == 0) {
      return this;
    }
    long l = paramDurationFieldType.getField(getChronology()).add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if ((paramReadablePeriod == null) || (paramInt == 0)) {
      return this;
    }
    long l1 = getLocalMillis();
    Chronology localChronology = getChronology();
    for (int i = 0; i < paramReadablePeriod.size(); i++)
    {
      long l2 = FieldUtils.safeMultiply(paramReadablePeriod.getValue(i), paramInt);
      DurationFieldType localDurationFieldType = paramReadablePeriod.getFieldType(i);
      if (isSupported(localDurationFieldType)) {
        l1 = localDurationFieldType.getField(localChronology).add(l1, l2);
      }
    }
    return withLocalMillis(l1);
  }
  
  public LocalDate plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public LocalDate plusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate plusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate plusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate plusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public LocalDate minusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate minusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate minusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDate minusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    if (!isSupported(paramDateTimeFieldType)) {
      throw new IllegalArgumentException("Field '" + paramDateTimeFieldType + "' is not supported");
    }
    return new Property(this, paramDateTimeFieldType.getField(getChronology()));
  }
  
  public int getEra()
  {
    return getChronology().era().get(getLocalMillis());
  }
  
  public int getCenturyOfEra()
  {
    return getChronology().centuryOfEra().get(getLocalMillis());
  }
  
  public int getYearOfEra()
  {
    return getChronology().yearOfEra().get(getLocalMillis());
  }
  
  public int getYearOfCentury()
  {
    return getChronology().yearOfCentury().get(getLocalMillis());
  }
  
  public int getYear()
  {
    return getChronology().year().get(getLocalMillis());
  }
  
  public int getWeekyear()
  {
    return getChronology().weekyear().get(getLocalMillis());
  }
  
  public int getMonthOfYear()
  {
    return getChronology().monthOfYear().get(getLocalMillis());
  }
  
  public int getWeekOfWeekyear()
  {
    return getChronology().weekOfWeekyear().get(getLocalMillis());
  }
  
  public int getDayOfYear()
  {
    return getChronology().dayOfYear().get(getLocalMillis());
  }
  
  public int getDayOfMonth()
  {
    return getChronology().dayOfMonth().get(getLocalMillis());
  }
  
  public int getDayOfWeek()
  {
    return getChronology().dayOfWeek().get(getLocalMillis());
  }
  
  public LocalDate withEra(int paramInt)
  {
    return withLocalMillis(getChronology().era().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withCenturyOfEra(int paramInt)
  {
    return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withYearOfEra(int paramInt)
  {
    return withLocalMillis(getChronology().yearOfEra().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withYearOfCentury(int paramInt)
  {
    return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withYear(int paramInt)
  {
    return withLocalMillis(getChronology().year().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withWeekyear(int paramInt)
  {
    return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withMonthOfYear(int paramInt)
  {
    return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withWeekOfWeekyear(int paramInt)
  {
    return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withDayOfYear(int paramInt)
  {
    return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withDayOfMonth(int paramInt)
  {
    return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), paramInt));
  }
  
  public LocalDate withDayOfWeek(int paramInt)
  {
    return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), paramInt));
  }
  
  public Property era()
  {
    return new Property(this, getChronology().era());
  }
  
  public Property centuryOfEra()
  {
    return new Property(this, getChronology().centuryOfEra());
  }
  
  public Property yearOfCentury()
  {
    return new Property(this, getChronology().yearOfCentury());
  }
  
  public Property yearOfEra()
  {
    return new Property(this, getChronology().yearOfEra());
  }
  
  public Property year()
  {
    return new Property(this, getChronology().year());
  }
  
  public Property weekyear()
  {
    return new Property(this, getChronology().weekyear());
  }
  
  public Property monthOfYear()
  {
    return new Property(this, getChronology().monthOfYear());
  }
  
  public Property weekOfWeekyear()
  {
    return new Property(this, getChronology().weekOfWeekyear());
  }
  
  public Property dayOfYear()
  {
    return new Property(this, getChronology().dayOfYear());
  }
  
  public Property dayOfMonth()
  {
    return new Property(this, getChronology().dayOfMonth());
  }
  
  public Property dayOfWeek()
  {
    return new Property(this, getChronology().dayOfWeek());
  }
  
  @ToString
  public String toString()
  {
    return ISODateTimeFormat.date().print(this);
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
  
  public static final class Property
    extends AbstractReadableInstantFieldProperty
  {
    private static final long serialVersionUID = -3193829732634L;
    private transient LocalDate iInstant;
    private transient DateTimeField iField;
    
    Property(LocalDate paramLocalDate, DateTimeField paramDateTimeField)
    {
      iInstant = paramLocalDate;
      iField = paramDateTimeField;
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.writeObject(iInstant);
      paramObjectOutputStream.writeObject(iField.getType());
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      iInstant = ((LocalDate)paramObjectInputStream.readObject());
      DateTimeFieldType localDateTimeFieldType = (DateTimeFieldType)paramObjectInputStream.readObject();
      iField = localDateTimeFieldType.getField(iInstant.getChronology());
    }
    
    public DateTimeField getField()
    {
      return iField;
    }
    
    protected long getMillis()
    {
      return iInstant.getLocalMillis();
    }
    
    protected Chronology getChronology()
    {
      return iInstant.getChronology();
    }
    
    public LocalDate getLocalDate()
    {
      return iInstant;
    }
    
    public LocalDate addToCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalDate addWrapFieldToCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalDate setCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalDate setCopy(String paramString, Locale paramLocale)
    {
      return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramString, paramLocale));
    }
    
    public LocalDate setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public LocalDate withMaximumValue()
    {
      return setCopy(getMaximumValue());
    }
    
    public LocalDate withMinimumValue()
    {
      return setCopy(getMinimumValue());
    }
    
    public LocalDate roundFloorCopy()
    {
      return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis()));
    }
    
    public LocalDate roundCeilingCopy()
    {
      return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis()));
    }
    
    public LocalDate roundHalfFloorCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis()));
    }
    
    public LocalDate roundHalfCeilingCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis()));
    }
    
    public LocalDate roundHalfEvenCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis()));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDate
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */