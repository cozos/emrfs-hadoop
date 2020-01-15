package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DividedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.MillisDurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.OffsetDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.RemainderDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ZeroIsMaxDateTimeField;
import java.util.Locale;

abstract class BasicChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = 8283225332206808863L;
  private static final DurationField cMillisField = MillisDurationField.INSTANCE;
  private static final DurationField cSecondsField = new PreciseDurationField(DurationFieldType.seconds(), 1000L);
  private static final DurationField cMinutesField = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
  private static final DurationField cHoursField = new PreciseDurationField(DurationFieldType.hours(), 3600000L);
  private static final DurationField cHalfdaysField = new PreciseDurationField(DurationFieldType.halfdays(), 43200000L);
  private static final DurationField cDaysField = new PreciseDurationField(DurationFieldType.days(), 86400000L);
  private static final DurationField cWeeksField = new PreciseDurationField(DurationFieldType.weeks(), 604800000L);
  private static final DateTimeField cMillisOfSecondField = new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), cMillisField, cSecondsField);
  private static final DateTimeField cMillisOfDayField = new PreciseDateTimeField(DateTimeFieldType.millisOfDay(), cMillisField, cDaysField);
  private static final DateTimeField cSecondOfMinuteField = new PreciseDateTimeField(DateTimeFieldType.secondOfMinute(), cSecondsField, cMinutesField);
  private static final DateTimeField cSecondOfDayField = new PreciseDateTimeField(DateTimeFieldType.secondOfDay(), cSecondsField, cDaysField);
  private static final DateTimeField cMinuteOfHourField = new PreciseDateTimeField(DateTimeFieldType.minuteOfHour(), cMinutesField, cHoursField);
  private static final DateTimeField cMinuteOfDayField = new PreciseDateTimeField(DateTimeFieldType.minuteOfDay(), cMinutesField, cDaysField);
  private static final DateTimeField cHourOfDayField = new PreciseDateTimeField(DateTimeFieldType.hourOfDay(), cHoursField, cDaysField);
  private static final DateTimeField cHourOfHalfdayField = new PreciseDateTimeField(DateTimeFieldType.hourOfHalfday(), cHoursField, cHalfdaysField);
  private static final DateTimeField cClockhourOfDayField = new ZeroIsMaxDateTimeField(cHourOfDayField, DateTimeFieldType.clockhourOfDay());
  private static final DateTimeField cClockhourOfHalfdayField = new ZeroIsMaxDateTimeField(cHourOfHalfdayField, DateTimeFieldType.clockhourOfHalfday());
  private static final DateTimeField cHalfdayOfDayField = new HalfdayField();
  private static final int CACHE_SIZE = 1024;
  private static final int CACHE_MASK = 1023;
  private final transient YearInfo[] iYearInfoCache = new YearInfo['Ѐ'];
  private final int iMinDaysInFirstWeek;
  
  BasicChronology(Chronology paramChronology, Object paramObject, int paramInt)
  {
    super(paramChronology, paramObject);
    if ((paramInt < 1) || (paramInt > 7)) {
      throw new IllegalArgumentException("Invalid min days in first week: " + paramInt);
    }
    iMinDaysInFirstWeek = paramInt;
  }
  
  public DateTimeZone getZone()
  {
    Chronology localChronology;
    if ((localChronology = getBase()) != null) {
      return localChronology.getZone();
    }
    return DateTimeZone.UTC;
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    Chronology localChronology;
    if ((localChronology = getBase()) != null) {
      return localChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    FieldUtils.verifyValueBounds(DateTimeFieldType.millisOfDay(), paramInt4, 0, 86399999);
    
    return getDateTimeMillis0(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws IllegalArgumentException
  {
    Chronology localChronology;
    if ((localChronology = getBase()) != null) {
      return localChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    FieldUtils.verifyValueBounds(DateTimeFieldType.hourOfDay(), paramInt4, 0, 23);
    FieldUtils.verifyValueBounds(DateTimeFieldType.minuteOfHour(), paramInt5, 0, 59);
    FieldUtils.verifyValueBounds(DateTimeFieldType.secondOfMinute(), paramInt6, 0, 59);
    FieldUtils.verifyValueBounds(DateTimeFieldType.millisOfSecond(), paramInt7, 0, 999);
    long l = paramInt4 * 3600000 + paramInt5 * 60000 + paramInt6 * 1000 + paramInt7;
    
    return getDateTimeMillis0(paramInt1, paramInt2, paramInt3, (int)l);
  }
  
  private long getDateTimeMillis0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = getDateMidnightMillis(paramInt1, paramInt2, paramInt3);
    if (l1 == Long.MIN_VALUE)
    {
      l1 = getDateMidnightMillis(paramInt1, paramInt2, paramInt3 + 1);
      paramInt4 -= 86400000;
    }
    long l2 = l1 + paramInt4;
    if ((l2 < 0L) && (l1 > 0L)) {
      return Long.MAX_VALUE;
    }
    if ((l2 > 0L) && (l1 < 0L)) {
      return Long.MIN_VALUE;
    }
    return l2;
  }
  
  public int getMinimumDaysInFirstWeek()
  {
    return iMinDaysInFirstWeek;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      BasicChronology localBasicChronology = (BasicChronology)paramObject;
      return (getMinimumDaysInFirstWeek() == localBasicChronology.getMinimumDaysInFirstWeek()) && (getZone().equals(localBasicChronology.getZone()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode() * 11 + getZone().hashCode() + getMinimumDaysInFirstWeek();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(60);
    String str = getClass().getName();
    int i = str.lastIndexOf('.');
    if (i >= 0) {
      str = str.substring(i + 1);
    }
    localStringBuilder.append(str);
    localStringBuilder.append('[');
    DateTimeZone localDateTimeZone = getZone();
    if (localDateTimeZone != null) {
      localStringBuilder.append(localDateTimeZone.getID());
    }
    if (getMinimumDaysInFirstWeek() != 4)
    {
      localStringBuilder.append(",mdfw=");
      localStringBuilder.append(getMinimumDaysInFirstWeek());
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    millis = cMillisField;
    seconds = cSecondsField;
    minutes = cMinutesField;
    hours = cHoursField;
    halfdays = cHalfdaysField;
    days = cDaysField;
    weeks = cWeeksField;
    
    millisOfSecond = cMillisOfSecondField;
    millisOfDay = cMillisOfDayField;
    secondOfMinute = cSecondOfMinuteField;
    secondOfDay = cSecondOfDayField;
    minuteOfHour = cMinuteOfHourField;
    minuteOfDay = cMinuteOfDayField;
    hourOfDay = cHourOfDayField;
    hourOfHalfday = cHourOfHalfdayField;
    clockhourOfDay = cClockhourOfDayField;
    clockhourOfHalfday = cClockhourOfHalfdayField;
    halfdayOfDay = cHalfdayOfDayField;
    
    year = new BasicYearDateTimeField(this);
    yearOfEra = new GJYearOfEraDateTimeField(year, this);
    
    Object localObject = new OffsetDateTimeField(yearOfEra, 99);
    
    centuryOfEra = new DividedDateTimeField((DateTimeField)localObject, DateTimeFieldType.centuryOfEra(), 100);
    
    centuries = centuryOfEra.getDurationField();
    
    localObject = new RemainderDateTimeField((DividedDateTimeField)centuryOfEra);
    
    yearOfCentury = new OffsetDateTimeField((DateTimeField)localObject, DateTimeFieldType.yearOfCentury(), 1);
    
    era = new GJEraDateTimeField(this);
    dayOfWeek = new GJDayOfWeekDateTimeField(this, days);
    dayOfMonth = new BasicDayOfMonthDateTimeField(this, days);
    dayOfYear = new BasicDayOfYearDateTimeField(this, days);
    monthOfYear = new GJMonthOfYearDateTimeField(this);
    weekyear = new BasicWeekyearDateTimeField(this);
    weekOfWeekyear = new BasicWeekOfWeekyearDateTimeField(this, weeks);
    
    localObject = new RemainderDateTimeField(weekyear, centuries, DateTimeFieldType.weekyearOfCentury(), 100);
    
    weekyearOfCentury = new OffsetDateTimeField((DateTimeField)localObject, DateTimeFieldType.weekyearOfCentury(), 1);
    
    years = year.getDurationField();
    months = monthOfYear.getDurationField();
    weekyears = weekyear.getDurationField();
  }
  
  int getDaysInYearMax()
  {
    return 366;
  }
  
  int getDaysInYear(int paramInt)
  {
    return isLeapYear(paramInt) ? 366 : 365;
  }
  
  int getWeeksInYear(int paramInt)
  {
    long l1 = getFirstWeekOfYearMillis(paramInt);
    long l2 = getFirstWeekOfYearMillis(paramInt + 1);
    return (int)((l2 - l1) / 604800000L);
  }
  
  long getFirstWeekOfYearMillis(int paramInt)
  {
    long l = getYearMillis(paramInt);
    int i = getDayOfWeek(l);
    if (i > 8 - iMinDaysInFirstWeek) {
      return l + (8 - i) * 86400000L;
    }
    return l - (i - 1) * 86400000L;
  }
  
  long getYearMillis(int paramInt)
  {
    return getYearInfoiFirstDayMillis;
  }
  
  long getYearMonthMillis(int paramInt1, int paramInt2)
  {
    long l = getYearMillis(paramInt1);
    l += getTotalMillisByYearMonth(paramInt1, paramInt2);
    return l;
  }
  
  long getYearMonthDayMillis(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = getYearMillis(paramInt1);
    l += getTotalMillisByYearMonth(paramInt1, paramInt2);
    return l + (paramInt3 - 1) * 86400000L;
  }
  
  int getYear(long paramLong)
  {
    long l1 = getAverageMillisPerYearDividedByTwo();
    long l2 = (paramLong >> 1) + getApproxMillisAtEpochDividedByTwo();
    if (l2 < 0L) {
      l2 = l2 - l1 + 1L;
    }
    int i = (int)(l2 / l1);
    
    long l3 = getYearMillis(i);
    long l4 = paramLong - l3;
    if (l4 < 0L)
    {
      i--;
    }
    else if (l4 >= 31536000000L)
    {
      long l5;
      if (isLeapYear(i)) {
        l5 = 31622400000L;
      } else {
        l5 = 31536000000L;
      }
      l3 += l5;
      if (l3 <= paramLong) {
        i++;
      }
    }
    return i;
  }
  
  int getMonthOfYear(long paramLong)
  {
    return getMonthOfYear(paramLong, getYear(paramLong));
  }
  
  abstract int getMonthOfYear(long paramLong, int paramInt);
  
  int getDayOfMonth(long paramLong)
  {
    int i = getYear(paramLong);
    int j = getMonthOfYear(paramLong, i);
    return getDayOfMonth(paramLong, i, j);
  }
  
  int getDayOfMonth(long paramLong, int paramInt)
  {
    int i = getMonthOfYear(paramLong, paramInt);
    return getDayOfMonth(paramLong, paramInt, i);
  }
  
  int getDayOfMonth(long paramLong, int paramInt1, int paramInt2)
  {
    long l = getYearMillis(paramInt1);
    l += getTotalMillisByYearMonth(paramInt1, paramInt2);
    return (int)((paramLong - l) / 86400000L) + 1;
  }
  
  int getDayOfYear(long paramLong)
  {
    return getDayOfYear(paramLong, getYear(paramLong));
  }
  
  int getDayOfYear(long paramLong, int paramInt)
  {
    long l = getYearMillis(paramInt);
    return (int)((paramLong - l) / 86400000L) + 1;
  }
  
  int getWeekyear(long paramLong)
  {
    int i = getYear(paramLong);
    int j = getWeekOfWeekyear(paramLong, i);
    if (j == 1) {
      return getYear(paramLong + 604800000L);
    }
    if (j > 51) {
      return getYear(paramLong - 1209600000L);
    }
    return i;
  }
  
  int getWeekOfWeekyear(long paramLong)
  {
    return getWeekOfWeekyear(paramLong, getYear(paramLong));
  }
  
  int getWeekOfWeekyear(long paramLong, int paramInt)
  {
    long l1 = getFirstWeekOfYearMillis(paramInt);
    if (paramLong < l1) {
      return getWeeksInYear(paramInt - 1);
    }
    long l2 = getFirstWeekOfYearMillis(paramInt + 1);
    if (paramLong >= l2) {
      return 1;
    }
    return (int)((paramLong - l1) / 604800000L) + 1;
  }
  
  int getDayOfWeek(long paramLong)
  {
    long l;
    if (paramLong >= 0L)
    {
      l = paramLong / 86400000L;
    }
    else
    {
      l = (paramLong - 86399999L) / 86400000L;
      if (l < -3L) {
        return 7 + (int)((l + 4L) % 7L);
      }
    }
    return 1 + (int)((l + 3L) % 7L);
  }
  
  int getMillisOfDay(long paramLong)
  {
    if (paramLong >= 0L) {
      return (int)(paramLong % 86400000L);
    }
    return 86399999 + (int)((paramLong + 1L) % 86400000L);
  }
  
  int getDaysInMonthMax()
  {
    return 31;
  }
  
  int getDaysInMonthMax(long paramLong)
  {
    int i = getYear(paramLong);
    int j = getMonthOfYear(paramLong, i);
    return getDaysInYearMonth(i, j);
  }
  
  int getDaysInMonthMaxForSet(long paramLong, int paramInt)
  {
    return getDaysInMonthMax(paramLong);
  }
  
  long getDateMidnightMillis(int paramInt1, int paramInt2, int paramInt3)
  {
    FieldUtils.verifyValueBounds(DateTimeFieldType.year(), paramInt1, getMinYear() - 1, getMaxYear() + 1);
    FieldUtils.verifyValueBounds(DateTimeFieldType.monthOfYear(), paramInt2, 1, getMaxMonth(paramInt1));
    FieldUtils.verifyValueBounds(DateTimeFieldType.dayOfMonth(), paramInt3, 1, getDaysInYearMonth(paramInt1, paramInt2));
    long l = getYearMonthDayMillis(paramInt1, paramInt2, paramInt3);
    if ((l < 0L) && (paramInt1 == getMaxYear() + 1)) {
      return Long.MAX_VALUE;
    }
    if ((l > 0L) && (paramInt1 == getMinYear() - 1)) {
      return Long.MIN_VALUE;
    }
    return l;
  }
  
  abstract long getYearDifference(long paramLong1, long paramLong2);
  
  abstract boolean isLeapYear(int paramInt);
  
  boolean isLeapDay(long paramLong)
  {
    return false;
  }
  
  abstract int getDaysInYearMonth(int paramInt1, int paramInt2);
  
  abstract int getDaysInMonthMax(int paramInt);
  
  abstract long getTotalMillisByYearMonth(int paramInt1, int paramInt2);
  
  abstract long calculateFirstDayOfYearMillis(int paramInt);
  
  abstract int getMinYear();
  
  abstract int getMaxYear();
  
  int getMaxMonth(int paramInt)
  {
    return getMaxMonth();
  }
  
  int getMaxMonth()
  {
    return 12;
  }
  
  abstract long getAverageMillisPerYear();
  
  abstract long getAverageMillisPerYearDividedByTwo();
  
  abstract long getAverageMillisPerMonth();
  
  abstract long getApproxMillisAtEpochDividedByTwo();
  
  abstract long setYear(long paramLong, int paramInt);
  
  private YearInfo getYearInfo(int paramInt)
  {
    YearInfo localYearInfo = iYearInfoCache[(paramInt & 0x3FF)];
    if ((localYearInfo == null) || (iYear != paramInt))
    {
      localYearInfo = new YearInfo(paramInt, calculateFirstDayOfYearMillis(paramInt));
      iYearInfoCache[(paramInt & 0x3FF)] = localYearInfo;
    }
    return localYearInfo;
  }
  
  private static class HalfdayField
    extends PreciseDateTimeField
  {
    private static final long serialVersionUID = 581601443656929254L;
    
    HalfdayField()
    {
      super(BasicChronology.cHalfdaysField, BasicChronology.cDaysField);
    }
    
    public String getAsText(int paramInt, Locale paramLocale)
    {
      return GJLocaleSymbols.forLocale(paramLocale).halfdayValueToText(paramInt);
    }
    
    public long set(long paramLong, String paramString, Locale paramLocale)
    {
      return set(paramLong, GJLocaleSymbols.forLocale(paramLocale).halfdayTextToValue(paramString));
    }
    
    public int getMaximumTextLength(Locale paramLocale)
    {
      return GJLocaleSymbols.forLocale(paramLocale).getHalfdayMaxTextLength();
    }
  }
  
  private static class YearInfo
  {
    public final int iYear;
    public final long iFirstDayMillis;
    
    YearInfo(int paramInt, long paramLong)
    {
      iYear = paramInt;
      iFirstDayMillis = paramLong;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */