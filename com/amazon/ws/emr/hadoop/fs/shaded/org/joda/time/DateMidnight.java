package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import org.joda.convert.FromString;

@Deprecated
public final class DateMidnight
  extends BaseDateTime
  implements ReadableDateTime, Serializable
{
  private static final long serialVersionUID = 156371964018738L;
  
  public static DateMidnight now()
  {
    return new DateMidnight();
  }
  
  public static DateMidnight now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new DateMidnight(paramDateTimeZone);
  }
  
  public static DateMidnight now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new DateMidnight(paramChronology);
  }
  
  @FromString
  public static DateMidnight parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.dateTimeParser().withOffsetParsed());
  }
  
  public static DateMidnight parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    return paramDateTimeFormatter.parseDateTime(paramString).toDateMidnight();
  }
  
  public DateMidnight() {}
  
  public DateMidnight(DateTimeZone paramDateTimeZone)
  {
    super(paramDateTimeZone);
  }
  
  public DateMidnight(Chronology paramChronology)
  {
    super(paramChronology);
  }
  
  public DateMidnight(long paramLong)
  {
    super(paramLong);
  }
  
  public DateMidnight(long paramLong, DateTimeZone paramDateTimeZone)
  {
    super(paramLong, paramDateTimeZone);
  }
  
  public DateMidnight(long paramLong, Chronology paramChronology)
  {
    super(paramLong, paramChronology);
  }
  
  public DateMidnight(Object paramObject)
  {
    super(paramObject, (Chronology)null);
  }
  
  public DateMidnight(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    super(paramObject, paramDateTimeZone);
  }
  
  public DateMidnight(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, DateTimeUtils.getChronology(paramChronology));
  }
  
  public DateMidnight(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3, 0, 0, 0, 0);
  }
  
  public DateMidnight(int paramInt1, int paramInt2, int paramInt3, DateTimeZone paramDateTimeZone)
  {
    super(paramInt1, paramInt2, paramInt3, 0, 0, 0, 0, paramDateTimeZone);
  }
  
  public DateMidnight(int paramInt1, int paramInt2, int paramInt3, Chronology paramChronology)
  {
    super(paramInt1, paramInt2, paramInt3, 0, 0, 0, 0, paramChronology);
  }
  
  protected long checkInstant(long paramLong, Chronology paramChronology)
  {
    return paramChronology.dayOfMonth().roundFloor(paramLong);
  }
  
  public DateMidnight withMillis(long paramLong)
  {
    Chronology localChronology = getChronology();
    paramLong = checkInstant(paramLong, localChronology);
    return paramLong == getMillis() ? this : new DateMidnight(paramLong, localChronology);
  }
  
  public DateMidnight withChronology(Chronology paramChronology)
  {
    return paramChronology == getChronology() ? this : new DateMidnight(getMillis(), paramChronology);
  }
  
  public DateMidnight withZoneRetainFields(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    DateTimeZone localDateTimeZone = DateTimeUtils.getZone(getZone());
    if (paramDateTimeZone == localDateTimeZone) {
      return this;
    }
    long l = localDateTimeZone.getMillisKeepLocal(paramDateTimeZone, getMillis());
    return new DateMidnight(l, getChronology().withZone(paramDateTimeZone));
  }
  
  public DateMidnight withFields(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      return this;
    }
    return withMillis(getChronology().set(paramReadablePartial, getMillis()));
  }
  
  public DateMidnight withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    long l = paramDateTimeFieldType.getField(getChronology()).set(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    if (paramDurationFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    if (paramInt == 0) {
      return this;
    }
    long l = paramDurationFieldType.getField(getChronology()).add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight withDurationAdded(long paramLong, int paramInt)
  {
    if ((paramLong == 0L) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(getMillis(), paramLong, paramInt);
    return withMillis(l);
  }
  
  public DateMidnight withDurationAdded(ReadableDuration paramReadableDuration, int paramInt)
  {
    if ((paramReadableDuration == null) || (paramInt == 0)) {
      return this;
    }
    return withDurationAdded(paramReadableDuration.getMillis(), paramInt);
  }
  
  public DateMidnight withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if ((paramReadablePeriod == null) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(paramReadablePeriod, getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight plus(long paramLong)
  {
    return withDurationAdded(paramLong, 1);
  }
  
  public DateMidnight plus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, 1);
  }
  
  public DateMidnight plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public DateMidnight plusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight plusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight plusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight plusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight minus(long paramLong)
  {
    return withDurationAdded(paramLong, -1);
  }
  
  public DateMidnight minus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, -1);
  }
  
  public DateMidnight minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public DateMidnight minusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight minusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight minusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateMidnight minusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    DateTimeField localDateTimeField = paramDateTimeFieldType.getField(getChronology());
    if (!localDateTimeField.isSupported()) {
      throw new IllegalArgumentException("Field '" + paramDateTimeFieldType + "' is not supported");
    }
    return new Property(this, localDateTimeField);
  }
  
  @Deprecated
  public YearMonthDay toYearMonthDay()
  {
    return new YearMonthDay(getMillis(), getChronology());
  }
  
  public LocalDate toLocalDate()
  {
    return new LocalDate(getMillis(), getChronology());
  }
  
  public Interval toInterval()
  {
    Chronology localChronology = getChronology();
    long l1 = getMillis();
    long l2 = DurationFieldType.days().getField(localChronology).add(l1, 1);
    return new Interval(l1, l2, localChronology);
  }
  
  public DateMidnight withEra(int paramInt)
  {
    return withMillis(getChronology().era().set(getMillis(), paramInt));
  }
  
  public DateMidnight withCenturyOfEra(int paramInt)
  {
    return withMillis(getChronology().centuryOfEra().set(getMillis(), paramInt));
  }
  
  public DateMidnight withYearOfEra(int paramInt)
  {
    return withMillis(getChronology().yearOfEra().set(getMillis(), paramInt));
  }
  
  public DateMidnight withYearOfCentury(int paramInt)
  {
    return withMillis(getChronology().yearOfCentury().set(getMillis(), paramInt));
  }
  
  public DateMidnight withYear(int paramInt)
  {
    return withMillis(getChronology().year().set(getMillis(), paramInt));
  }
  
  public DateMidnight withWeekyear(int paramInt)
  {
    return withMillis(getChronology().weekyear().set(getMillis(), paramInt));
  }
  
  public DateMidnight withMonthOfYear(int paramInt)
  {
    return withMillis(getChronology().monthOfYear().set(getMillis(), paramInt));
  }
  
  public DateMidnight withWeekOfWeekyear(int paramInt)
  {
    return withMillis(getChronology().weekOfWeekyear().set(getMillis(), paramInt));
  }
  
  public DateMidnight withDayOfYear(int paramInt)
  {
    return withMillis(getChronology().dayOfYear().set(getMillis(), paramInt));
  }
  
  public DateMidnight withDayOfMonth(int paramInt)
  {
    return withMillis(getChronology().dayOfMonth().set(getMillis(), paramInt));
  }
  
  public DateMidnight withDayOfWeek(int paramInt)
  {
    return withMillis(getChronology().dayOfWeek().set(getMillis(), paramInt));
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
  
  public static final class Property
    extends AbstractReadableInstantFieldProperty
  {
    private static final long serialVersionUID = 257629620L;
    private DateMidnight iInstant;
    private DateTimeField iField;
    
    Property(DateMidnight paramDateMidnight, DateTimeField paramDateTimeField)
    {
      iInstant = paramDateMidnight;
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
      iInstant = ((DateMidnight)paramObjectInputStream.readObject());
      DateTimeFieldType localDateTimeFieldType = (DateTimeFieldType)paramObjectInputStream.readObject();
      iField = localDateTimeFieldType.getField(iInstant.getChronology());
    }
    
    public DateTimeField getField()
    {
      return iField;
    }
    
    protected long getMillis()
    {
      return iInstant.getMillis();
    }
    
    protected Chronology getChronology()
    {
      return iInstant.getChronology();
    }
    
    public DateMidnight getDateMidnight()
    {
      return iInstant;
    }
    
    public DateMidnight addToCopy(int paramInt)
    {
      return iInstant.withMillis(iField.add(iInstant.getMillis(), paramInt));
    }
    
    public DateMidnight addToCopy(long paramLong)
    {
      return iInstant.withMillis(iField.add(iInstant.getMillis(), paramLong));
    }
    
    public DateMidnight addWrapFieldToCopy(int paramInt)
    {
      return iInstant.withMillis(iField.addWrapField(iInstant.getMillis(), paramInt));
    }
    
    public DateMidnight setCopy(int paramInt)
    {
      return iInstant.withMillis(iField.set(iInstant.getMillis(), paramInt));
    }
    
    public DateMidnight setCopy(String paramString, Locale paramLocale)
    {
      return iInstant.withMillis(iField.set(iInstant.getMillis(), paramString, paramLocale));
    }
    
    public DateMidnight setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public DateMidnight withMaximumValue()
    {
      return setCopy(getMaximumValue());
    }
    
    public DateMidnight withMinimumValue()
    {
      return setCopy(getMinimumValue());
    }
    
    public DateMidnight roundFloorCopy()
    {
      return iInstant.withMillis(iField.roundFloor(iInstant.getMillis()));
    }
    
    public DateMidnight roundCeilingCopy()
    {
      return iInstant.withMillis(iField.roundCeiling(iInstant.getMillis()));
    }
    
    public DateMidnight roundHalfFloorCopy()
    {
      return iInstant.withMillis(iField.roundHalfFloor(iInstant.getMillis()));
    }
    
    public DateMidnight roundHalfCeilingCopy()
    {
      return iInstant.withMillis(iField.roundHalfCeiling(iInstant.getMillis()));
    }
    
    public DateMidnight roundHalfEvenCopy()
    {
      return iInstant.withMillis(iField.roundHalfEven(iInstant.getMillis()));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateMidnight
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */