package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import org.joda.convert.FromString;

public final class DateTime
  extends BaseDateTime
  implements ReadableDateTime, Serializable
{
  private static final long serialVersionUID = -5171125899451703815L;
  
  public static DateTime now()
  {
    return new DateTime();
  }
  
  public static DateTime now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new DateTime(paramDateTimeZone);
  }
  
  public static DateTime now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new DateTime(paramChronology);
  }
  
  @FromString
  public static DateTime parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.dateTimeParser().withOffsetParsed());
  }
  
  public static DateTime parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    return paramDateTimeFormatter.parseDateTime(paramString);
  }
  
  public DateTime() {}
  
  public DateTime(DateTimeZone paramDateTimeZone)
  {
    super(paramDateTimeZone);
  }
  
  public DateTime(Chronology paramChronology)
  {
    super(paramChronology);
  }
  
  public DateTime(long paramLong)
  {
    super(paramLong);
  }
  
  public DateTime(long paramLong, DateTimeZone paramDateTimeZone)
  {
    super(paramLong, paramDateTimeZone);
  }
  
  public DateTime(long paramLong, Chronology paramChronology)
  {
    super(paramLong, paramChronology);
  }
  
  public DateTime(Object paramObject)
  {
    super(paramObject, (Chronology)null);
  }
  
  public DateTime(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    super(paramObject, paramDateTimeZone);
  }
  
  public DateTime(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, DateTimeUtils.getChronology(paramChronology));
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 0);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, DateTimeZone paramDateTimeZone)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 0, paramDateTimeZone);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Chronology paramChronology)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 0, paramChronology);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, DateTimeZone paramDateTimeZone)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0, paramDateTimeZone);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Chronology paramChronology)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0, paramChronology);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, DateTimeZone paramDateTimeZone)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramDateTimeZone);
  }
  
  public DateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Chronology paramChronology)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramChronology);
  }
  
  public DateTime toDateTime()
  {
    return this;
  }
  
  public DateTime toDateTimeISO()
  {
    if (getChronology() == ISOChronology.getInstance()) {
      return this;
    }
    return super.toDateTimeISO();
  }
  
  public DateTime toDateTime(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    if (getZone() == paramDateTimeZone) {
      return this;
    }
    return super.toDateTime(paramDateTimeZone);
  }
  
  public DateTime toDateTime(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    if (getChronology() == paramChronology) {
      return this;
    }
    return super.toDateTime(paramChronology);
  }
  
  public DateTime withMillis(long paramLong)
  {
    return paramLong == getMillis() ? this : new DateTime(paramLong, getChronology());
  }
  
  public DateTime withChronology(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    return paramChronology == getChronology() ? this : new DateTime(getMillis(), paramChronology);
  }
  
  public DateTime withZone(DateTimeZone paramDateTimeZone)
  {
    return withChronology(getChronology().withZone(paramDateTimeZone));
  }
  
  public DateTime withZoneRetainFields(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    DateTimeZone localDateTimeZone = DateTimeUtils.getZone(getZone());
    if (paramDateTimeZone == localDateTimeZone) {
      return this;
    }
    long l = localDateTimeZone.getMillisKeepLocal(paramDateTimeZone, getMillis());
    return new DateTime(l, getChronology().withZone(paramDateTimeZone));
  }
  
  public DateTime withEarlierOffsetAtOverlap()
  {
    long l = getZone().adjustOffset(getMillis(), false);
    return withMillis(l);
  }
  
  public DateTime withLaterOffsetAtOverlap()
  {
    long l = getZone().adjustOffset(getMillis(), true);
    return withMillis(l);
  }
  
  public DateTime withDate(int paramInt1, int paramInt2, int paramInt3)
  {
    Chronology localChronology = getChronology();
    long l = localChronology.withUTC().getDateTimeMillis(paramInt1, paramInt2, paramInt3, getMillisOfDay());
    return withMillis(localChronology.getZone().convertLocalToUTC(l, false, getMillis()));
  }
  
  public DateTime withDate(LocalDate paramLocalDate)
  {
    return withDate(paramLocalDate.getYear(), paramLocalDate.getMonthOfYear(), paramLocalDate.getDayOfMonth());
  }
  
  public DateTime withTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Chronology localChronology = getChronology();
    long l = localChronology.withUTC().getDateTimeMillis(getYear(), getMonthOfYear(), getDayOfMonth(), paramInt1, paramInt2, paramInt3, paramInt4);
    
    return withMillis(localChronology.getZone().convertLocalToUTC(l, false, getMillis()));
  }
  
  public DateTime withTime(LocalTime paramLocalTime)
  {
    return withTime(paramLocalTime.getHourOfDay(), paramLocalTime.getMinuteOfHour(), paramLocalTime.getSecondOfMinute(), paramLocalTime.getMillisOfSecond());
  }
  
  public DateTime withTimeAtStartOfDay()
  {
    return toLocalDate().toDateTimeAtStartOfDay(getZone());
  }
  
  public DateTime withFields(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      return this;
    }
    return withMillis(getChronology().set(paramReadablePartial, getMillis()));
  }
  
  public DateTime withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    long l = paramDateTimeFieldType.getField(getChronology()).set(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
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
  
  public DateTime withDurationAdded(long paramLong, int paramInt)
  {
    if ((paramLong == 0L) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(getMillis(), paramLong, paramInt);
    return withMillis(l);
  }
  
  public DateTime withDurationAdded(ReadableDuration paramReadableDuration, int paramInt)
  {
    if ((paramReadableDuration == null) || (paramInt == 0)) {
      return this;
    }
    return withDurationAdded(paramReadableDuration.getMillis(), paramInt);
  }
  
  public DateTime withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if ((paramReadablePeriod == null) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(paramReadablePeriod, getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plus(long paramLong)
  {
    return withDurationAdded(paramLong, 1);
  }
  
  public DateTime plus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, 1);
  }
  
  public DateTime plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public DateTime plusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plusHours(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().hours().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plusMinutes(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().minutes().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plusSeconds(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().seconds().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime plusMillis(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().millis().add(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minus(long paramLong)
  {
    return withDurationAdded(paramLong, -1);
  }
  
  public DateTime minus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, -1);
  }
  
  public DateTime minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public DateTime minusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minusHours(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().hours().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minusMinutes(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().minutes().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minusSeconds(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().seconds().subtract(getMillis(), paramInt);
    return withMillis(l);
  }
  
  public DateTime minusMillis(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().millis().subtract(getMillis(), paramInt);
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
  public DateMidnight toDateMidnight()
  {
    return new DateMidnight(getMillis(), getChronology());
  }
  
  @Deprecated
  public YearMonthDay toYearMonthDay()
  {
    return new YearMonthDay(getMillis(), getChronology());
  }
  
  @Deprecated
  public TimeOfDay toTimeOfDay()
  {
    return new TimeOfDay(getMillis(), getChronology());
  }
  
  public LocalDateTime toLocalDateTime()
  {
    return new LocalDateTime(getMillis(), getChronology());
  }
  
  public LocalDate toLocalDate()
  {
    return new LocalDate(getMillis(), getChronology());
  }
  
  public LocalTime toLocalTime()
  {
    return new LocalTime(getMillis(), getChronology());
  }
  
  public DateTime withEra(int paramInt)
  {
    return withMillis(getChronology().era().set(getMillis(), paramInt));
  }
  
  public DateTime withCenturyOfEra(int paramInt)
  {
    return withMillis(getChronology().centuryOfEra().set(getMillis(), paramInt));
  }
  
  public DateTime withYearOfEra(int paramInt)
  {
    return withMillis(getChronology().yearOfEra().set(getMillis(), paramInt));
  }
  
  public DateTime withYearOfCentury(int paramInt)
  {
    return withMillis(getChronology().yearOfCentury().set(getMillis(), paramInt));
  }
  
  public DateTime withYear(int paramInt)
  {
    return withMillis(getChronology().year().set(getMillis(), paramInt));
  }
  
  public DateTime withWeekyear(int paramInt)
  {
    return withMillis(getChronology().weekyear().set(getMillis(), paramInt));
  }
  
  public DateTime withMonthOfYear(int paramInt)
  {
    return withMillis(getChronology().monthOfYear().set(getMillis(), paramInt));
  }
  
  public DateTime withWeekOfWeekyear(int paramInt)
  {
    return withMillis(getChronology().weekOfWeekyear().set(getMillis(), paramInt));
  }
  
  public DateTime withDayOfYear(int paramInt)
  {
    return withMillis(getChronology().dayOfYear().set(getMillis(), paramInt));
  }
  
  public DateTime withDayOfMonth(int paramInt)
  {
    return withMillis(getChronology().dayOfMonth().set(getMillis(), paramInt));
  }
  
  public DateTime withDayOfWeek(int paramInt)
  {
    return withMillis(getChronology().dayOfWeek().set(getMillis(), paramInt));
  }
  
  public DateTime withHourOfDay(int paramInt)
  {
    return withMillis(getChronology().hourOfDay().set(getMillis(), paramInt));
  }
  
  public DateTime withMinuteOfHour(int paramInt)
  {
    return withMillis(getChronology().minuteOfHour().set(getMillis(), paramInt));
  }
  
  public DateTime withSecondOfMinute(int paramInt)
  {
    return withMillis(getChronology().secondOfMinute().set(getMillis(), paramInt));
  }
  
  public DateTime withMillisOfSecond(int paramInt)
  {
    return withMillis(getChronology().millisOfSecond().set(getMillis(), paramInt));
  }
  
  public DateTime withMillisOfDay(int paramInt)
  {
    return withMillis(getChronology().millisOfDay().set(getMillis(), paramInt));
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
  
  public Property hourOfDay()
  {
    return new Property(this, getChronology().hourOfDay());
  }
  
  public Property minuteOfDay()
  {
    return new Property(this, getChronology().minuteOfDay());
  }
  
  public Property minuteOfHour()
  {
    return new Property(this, getChronology().minuteOfHour());
  }
  
  public Property secondOfDay()
  {
    return new Property(this, getChronology().secondOfDay());
  }
  
  public Property secondOfMinute()
  {
    return new Property(this, getChronology().secondOfMinute());
  }
  
  public Property millisOfDay()
  {
    return new Property(this, getChronology().millisOfDay());
  }
  
  public Property millisOfSecond()
  {
    return new Property(this, getChronology().millisOfSecond());
  }
  
  public static final class Property
    extends AbstractReadableInstantFieldProperty
  {
    private static final long serialVersionUID = -6983323811635733510L;
    private DateTime iInstant;
    private DateTimeField iField;
    
    Property(DateTime paramDateTime, DateTimeField paramDateTimeField)
    {
      iInstant = paramDateTime;
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
      iInstant = ((DateTime)paramObjectInputStream.readObject());
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
    
    public DateTime getDateTime()
    {
      return iInstant;
    }
    
    public DateTime addToCopy(int paramInt)
    {
      return iInstant.withMillis(iField.add(iInstant.getMillis(), paramInt));
    }
    
    public DateTime addToCopy(long paramLong)
    {
      return iInstant.withMillis(iField.add(iInstant.getMillis(), paramLong));
    }
    
    public DateTime addWrapFieldToCopy(int paramInt)
    {
      return iInstant.withMillis(iField.addWrapField(iInstant.getMillis(), paramInt));
    }
    
    public DateTime setCopy(int paramInt)
    {
      return iInstant.withMillis(iField.set(iInstant.getMillis(), paramInt));
    }
    
    public DateTime setCopy(String paramString, Locale paramLocale)
    {
      return iInstant.withMillis(iField.set(iInstant.getMillis(), paramString, paramLocale));
    }
    
    public DateTime setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public DateTime withMaximumValue()
    {
      try
      {
        return setCopy(getMaximumValue());
      }
      catch (RuntimeException localRuntimeException)
      {
        if (IllegalInstantException.isIllegalInstant(localRuntimeException))
        {
          long l = getChronology().getZone().previousTransition(getMillis() + 86400000L);
          return new DateTime(l, getChronology());
        }
        throw localRuntimeException;
      }
    }
    
    public DateTime withMinimumValue()
    {
      try
      {
        return setCopy(getMinimumValue());
      }
      catch (RuntimeException localRuntimeException)
      {
        if (IllegalInstantException.isIllegalInstant(localRuntimeException))
        {
          long l = getChronology().getZone().nextTransition(getMillis() - 86400000L);
          return new DateTime(l, getChronology());
        }
        throw localRuntimeException;
      }
    }
    
    public DateTime roundFloorCopy()
    {
      return iInstant.withMillis(iField.roundFloor(iInstant.getMillis()));
    }
    
    public DateTime roundCeilingCopy()
    {
      return iInstant.withMillis(iField.roundCeiling(iInstant.getMillis()));
    }
    
    public DateTime roundHalfFloorCopy()
    {
      return iInstant.withMillis(iField.roundHalfFloor(iInstant.getMillis()));
    }
    
    public DateTime roundHalfCeilingCopy()
    {
      return iInstant.withMillis(iField.roundHalfCeiling(iInstant.getMillis()));
    }
    
    public DateTime roundHalfEvenCopy()
    {
      return iInstant.withMillis(iField.roundHalfEven(iInstant.getMillis()));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */