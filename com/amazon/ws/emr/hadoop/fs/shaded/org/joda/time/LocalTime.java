package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseLocal;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.PartialConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class LocalTime
  extends BaseLocal
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = -12873158713873L;
  public static final LocalTime MIDNIGHT = new LocalTime(0, 0, 0, 0);
  private static final int HOUR_OF_DAY = 0;
  private static final int MINUTE_OF_HOUR = 1;
  private static final int SECOND_OF_MINUTE = 2;
  private static final int MILLIS_OF_SECOND = 3;
  private static final Set<DurationFieldType> TIME_DURATION_TYPES = new HashSet();
  private final long iLocalMillis;
  private final Chronology iChronology;
  
  static
  {
    TIME_DURATION_TYPES.add(DurationFieldType.millis());
    TIME_DURATION_TYPES.add(DurationFieldType.seconds());
    TIME_DURATION_TYPES.add(DurationFieldType.minutes());
    TIME_DURATION_TYPES.add(DurationFieldType.hours());
  }
  
  public static LocalTime now()
  {
    return new LocalTime();
  }
  
  public static LocalTime now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new LocalTime(paramDateTimeZone);
  }
  
  public static LocalTime now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new LocalTime(paramChronology);
  }
  
  @FromString
  public static LocalTime parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.localTimeParser());
  }
  
  public static LocalTime parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    return paramDateTimeFormatter.parseLocalTime(paramString);
  }
  
  public static LocalTime fromMillisOfDay(long paramLong)
  {
    return fromMillisOfDay(paramLong, null);
  }
  
  public static LocalTime fromMillisOfDay(long paramLong, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology).withUTC();
    return new LocalTime(paramLong, paramChronology);
  }
  
  public static LocalTime fromCalendarFields(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The calendar must not be null");
    }
    return new LocalTime(paramCalendar.get(11), paramCalendar.get(12), paramCalendar.get(13), paramCalendar.get(14));
  }
  
  public static LocalTime fromDateFields(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return new LocalTime(paramDate.getHours(), paramDate.getMinutes(), paramDate.getSeconds(), ((int)(paramDate.getTime() % 1000L) + 1000) % 1000);
  }
  
  public LocalTime()
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance());
  }
  
  public LocalTime(DateTimeZone paramDateTimeZone)
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public LocalTime(Chronology paramChronology)
  {
    this(DateTimeUtils.currentTimeMillis(), paramChronology);
  }
  
  public LocalTime(long paramLong)
  {
    this(paramLong, ISOChronology.getInstance());
  }
  
  public LocalTime(long paramLong, DateTimeZone paramDateTimeZone)
  {
    this(paramLong, ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public LocalTime(long paramLong, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    
    long l = paramChronology.getZone().getMillisKeepLocal(DateTimeZone.UTC, paramLong);
    paramChronology = paramChronology.withUTC();
    iLocalMillis = paramChronology.millisOfDay().get(l);
    iChronology = paramChronology;
  }
  
  public LocalTime(Object paramObject)
  {
    this(paramObject, (Chronology)null);
  }
  
  public LocalTime(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    Chronology localChronology = localPartialConverter.getChronology(paramObject, paramDateTimeZone);
    localChronology = DateTimeUtils.getChronology(localChronology);
    iChronology = localChronology.withUTC();
    int[] arrayOfInt = localPartialConverter.getPartialValues(this, paramObject, localChronology, ISODateTimeFormat.localTimeParser());
    iLocalMillis = iChronology.getDateTimeMillis(0L, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public LocalTime(Object paramObject, Chronology paramChronology)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    paramChronology = localPartialConverter.getChronology(paramObject, paramChronology);
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iChronology = paramChronology.withUTC();
    int[] arrayOfInt = localPartialConverter.getPartialValues(this, paramObject, paramChronology, ISODateTimeFormat.localTimeParser());
    iLocalMillis = iChronology.getDateTimeMillis(0L, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public LocalTime(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 0, ISOChronology.getInstanceUTC());
  }
  
  public LocalTime(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 0, ISOChronology.getInstanceUTC());
  }
  
  public LocalTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, ISOChronology.getInstanceUTC());
  }
  
  public LocalTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology).withUTC();
    long l = paramChronology.getDateTimeMillis(0L, paramInt1, paramInt2, paramInt3, paramInt4);
    
    iChronology = paramChronology;
    iLocalMillis = l;
  }
  
  private Object readResolve()
  {
    if (iChronology == null) {
      return new LocalTime(iLocalMillis, ISOChronology.getInstanceUTC());
    }
    if (!DateTimeZone.UTC.equals(iChronology.getZone())) {
      return new LocalTime(iLocalMillis, iChronology.withUTC());
    }
    return this;
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
  
  public int getValue(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      return getChronology().hourOfDay().get(getLocalMillis());
    case 1: 
      return getChronology().minuteOfHour().get(getLocalMillis());
    case 2: 
      return getChronology().secondOfMinute().get(getLocalMillis());
    case 3: 
      return getChronology().millisOfSecond().get(getLocalMillis());
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
    if (!isSupported(paramDateTimeFieldType.getDurationType())) {
      return false;
    }
    DurationFieldType localDurationFieldType = paramDateTimeFieldType.getRangeDurationType();
    return (isSupported(localDurationFieldType)) || (localDurationFieldType == DurationFieldType.days());
  }
  
  public boolean isSupported(DurationFieldType paramDurationFieldType)
  {
    if (paramDurationFieldType == null) {
      return false;
    }
    DurationField localDurationField = paramDurationFieldType.getField(getChronology());
    if ((TIME_DURATION_TYPES.contains(paramDurationFieldType)) || (localDurationField.getUnitMillis() < getChronology().days().getUnitMillis())) {
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
    if ((paramObject instanceof LocalTime))
    {
      LocalTime localLocalTime = (LocalTime)paramObject;
      if (iChronology.equals(iChronology)) {
        return iLocalMillis == iLocalMillis;
      }
    }
    return super.equals(paramObject);
  }
  
  public int compareTo(ReadablePartial paramReadablePartial)
  {
    if (this == paramReadablePartial) {
      return 0;
    }
    if ((paramReadablePartial instanceof LocalTime))
    {
      LocalTime localLocalTime = (LocalTime)paramReadablePartial;
      if (iChronology.equals(iChronology)) {
        return iLocalMillis == iLocalMillis ? 0 : iLocalMillis < iLocalMillis ? -1 : 1;
      }
    }
    return super.compareTo(paramReadablePartial);
  }
  
  LocalTime withLocalMillis(long paramLong)
  {
    return paramLong == getLocalMillis() ? this : new LocalTime(paramLong, getChronology());
  }
  
  public LocalTime withFields(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      return this;
    }
    return withLocalMillis(getChronology().set(paramReadablePartial, getLocalMillis()));
  }
  
  public LocalTime withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
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
  
  public LocalTime withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
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
  
  public LocalTime withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if ((paramReadablePeriod == null) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(paramReadablePeriod, getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public LocalTime plusHours(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().hours().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime plusMinutes(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().minutes().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime plusSeconds(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().seconds().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime plusMillis(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().millis().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public LocalTime minusHours(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().hours().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime minusMinutes(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().minutes().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime minusSeconds(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().seconds().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalTime minusMillis(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().millis().subtract(getLocalMillis(), paramInt);
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
  
  public int getHourOfDay()
  {
    return getChronology().hourOfDay().get(getLocalMillis());
  }
  
  public int getMinuteOfHour()
  {
    return getChronology().minuteOfHour().get(getLocalMillis());
  }
  
  public int getSecondOfMinute()
  {
    return getChronology().secondOfMinute().get(getLocalMillis());
  }
  
  public int getMillisOfSecond()
  {
    return getChronology().millisOfSecond().get(getLocalMillis());
  }
  
  public int getMillisOfDay()
  {
    return getChronology().millisOfDay().get(getLocalMillis());
  }
  
  public LocalTime withHourOfDay(int paramInt)
  {
    return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), paramInt));
  }
  
  public LocalTime withMinuteOfHour(int paramInt)
  {
    return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), paramInt));
  }
  
  public LocalTime withSecondOfMinute(int paramInt)
  {
    return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), paramInt));
  }
  
  public LocalTime withMillisOfSecond(int paramInt)
  {
    return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), paramInt));
  }
  
  public LocalTime withMillisOfDay(int paramInt)
  {
    return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), paramInt));
  }
  
  public Property hourOfDay()
  {
    return new Property(this, getChronology().hourOfDay());
  }
  
  public Property minuteOfHour()
  {
    return new Property(this, getChronology().minuteOfHour());
  }
  
  public Property secondOfMinute()
  {
    return new Property(this, getChronology().secondOfMinute());
  }
  
  public Property millisOfSecond()
  {
    return new Property(this, getChronology().millisOfSecond());
  }
  
  public Property millisOfDay()
  {
    return new Property(this, getChronology().millisOfDay());
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
  
  @ToString
  public String toString()
  {
    return ISODateTimeFormat.time().print(this);
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
    private static final long serialVersionUID = -325842547277223L;
    private transient LocalTime iInstant;
    private transient DateTimeField iField;
    
    Property(LocalTime paramLocalTime, DateTimeField paramDateTimeField)
    {
      iInstant = paramLocalTime;
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
      iInstant = ((LocalTime)paramObjectInputStream.readObject());
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
    
    public LocalTime getLocalTime()
    {
      return iInstant;
    }
    
    public LocalTime addCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalTime addCopy(long paramLong)
    {
      return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramLong));
    }
    
    public LocalTime addNoWrapToCopy(int paramInt)
    {
      long l1 = iField.add(iInstant.getLocalMillis(), paramInt);
      long l2 = iInstant.getChronology().millisOfDay().get(l1);
      if (l2 != l1) {
        throw new IllegalArgumentException("The addition exceeded the boundaries of LocalTime");
      }
      return iInstant.withLocalMillis(l1);
    }
    
    public LocalTime addWrapFieldToCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalTime setCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalTime setCopy(String paramString, Locale paramLocale)
    {
      return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramString, paramLocale));
    }
    
    public LocalTime setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public LocalTime withMaximumValue()
    {
      return setCopy(getMaximumValue());
    }
    
    public LocalTime withMinimumValue()
    {
      return setCopy(getMinimumValue());
    }
    
    public LocalTime roundFloorCopy()
    {
      return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis()));
    }
    
    public LocalTime roundCeilingCopy()
    {
      return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis()));
    }
    
    public LocalTime roundHalfFloorCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis()));
    }
    
    public LocalTime roundHalfCeilingCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis()));
    }
    
    public LocalTime roundHalfEvenCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis()));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalTime
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */