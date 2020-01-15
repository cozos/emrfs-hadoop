package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class AssembledChronology
  extends BaseChronology
{
  private static final long serialVersionUID = -6728465968995518215L;
  private final Chronology iBase;
  private final Object iParam;
  private transient DurationField iMillis;
  private transient DurationField iSeconds;
  private transient DurationField iMinutes;
  private transient DurationField iHours;
  private transient DurationField iHalfdays;
  private transient DurationField iDays;
  private transient DurationField iWeeks;
  private transient DurationField iWeekyears;
  private transient DurationField iMonths;
  private transient DurationField iYears;
  private transient DurationField iCenturies;
  private transient DurationField iEras;
  private transient DateTimeField iMillisOfSecond;
  private transient DateTimeField iMillisOfDay;
  private transient DateTimeField iSecondOfMinute;
  private transient DateTimeField iSecondOfDay;
  private transient DateTimeField iMinuteOfHour;
  private transient DateTimeField iMinuteOfDay;
  private transient DateTimeField iHourOfDay;
  private transient DateTimeField iClockhourOfDay;
  private transient DateTimeField iHourOfHalfday;
  private transient DateTimeField iClockhourOfHalfday;
  private transient DateTimeField iHalfdayOfDay;
  private transient DateTimeField iDayOfWeek;
  private transient DateTimeField iDayOfMonth;
  private transient DateTimeField iDayOfYear;
  private transient DateTimeField iWeekOfWeekyear;
  private transient DateTimeField iWeekyear;
  private transient DateTimeField iWeekyearOfCentury;
  private transient DateTimeField iMonthOfYear;
  private transient DateTimeField iYear;
  private transient DateTimeField iYearOfEra;
  private transient DateTimeField iYearOfCentury;
  private transient DateTimeField iCenturyOfEra;
  private transient DateTimeField iEra;
  private transient int iBaseFlags;
  
  protected AssembledChronology(Chronology paramChronology, Object paramObject)
  {
    iBase = paramChronology;
    iParam = paramObject;
    setFields();
  }
  
  public DateTimeZone getZone()
  {
    Chronology localChronology;
    if ((localChronology = iBase) != null) {
      return localChronology.getZone();
    }
    return null;
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    Chronology localChronology;
    if (((localChronology = iBase) != null) && ((iBaseFlags & 0x6) == 6)) {
      return localChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return super.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws IllegalArgumentException
  {
    Chronology localChronology;
    if (((localChronology = iBase) != null) && ((iBaseFlags & 0x5) == 5)) {
      return localChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    return super.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public long getDateTimeMillis(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    Chronology localChronology;
    if (((localChronology = iBase) != null) && ((iBaseFlags & 0x1) == 1)) {
      return localChronology.getDateTimeMillis(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return super.getDateTimeMillis(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final DurationField millis()
  {
    return iMillis;
  }
  
  public final DateTimeField millisOfSecond()
  {
    return iMillisOfSecond;
  }
  
  public final DateTimeField millisOfDay()
  {
    return iMillisOfDay;
  }
  
  public final DurationField seconds()
  {
    return iSeconds;
  }
  
  public final DateTimeField secondOfMinute()
  {
    return iSecondOfMinute;
  }
  
  public final DateTimeField secondOfDay()
  {
    return iSecondOfDay;
  }
  
  public final DurationField minutes()
  {
    return iMinutes;
  }
  
  public final DateTimeField minuteOfHour()
  {
    return iMinuteOfHour;
  }
  
  public final DateTimeField minuteOfDay()
  {
    return iMinuteOfDay;
  }
  
  public final DurationField hours()
  {
    return iHours;
  }
  
  public final DateTimeField hourOfDay()
  {
    return iHourOfDay;
  }
  
  public final DateTimeField clockhourOfDay()
  {
    return iClockhourOfDay;
  }
  
  public final DurationField halfdays()
  {
    return iHalfdays;
  }
  
  public final DateTimeField hourOfHalfday()
  {
    return iHourOfHalfday;
  }
  
  public final DateTimeField clockhourOfHalfday()
  {
    return iClockhourOfHalfday;
  }
  
  public final DateTimeField halfdayOfDay()
  {
    return iHalfdayOfDay;
  }
  
  public final DurationField days()
  {
    return iDays;
  }
  
  public final DateTimeField dayOfWeek()
  {
    return iDayOfWeek;
  }
  
  public final DateTimeField dayOfMonth()
  {
    return iDayOfMonth;
  }
  
  public final DateTimeField dayOfYear()
  {
    return iDayOfYear;
  }
  
  public final DurationField weeks()
  {
    return iWeeks;
  }
  
  public final DateTimeField weekOfWeekyear()
  {
    return iWeekOfWeekyear;
  }
  
  public final DurationField weekyears()
  {
    return iWeekyears;
  }
  
  public final DateTimeField weekyear()
  {
    return iWeekyear;
  }
  
  public final DateTimeField weekyearOfCentury()
  {
    return iWeekyearOfCentury;
  }
  
  public final DurationField months()
  {
    return iMonths;
  }
  
  public final DateTimeField monthOfYear()
  {
    return iMonthOfYear;
  }
  
  public final DurationField years()
  {
    return iYears;
  }
  
  public final DateTimeField year()
  {
    return iYear;
  }
  
  public final DateTimeField yearOfEra()
  {
    return iYearOfEra;
  }
  
  public final DateTimeField yearOfCentury()
  {
    return iYearOfCentury;
  }
  
  public final DurationField centuries()
  {
    return iCenturies;
  }
  
  public final DateTimeField centuryOfEra()
  {
    return iCenturyOfEra;
  }
  
  public final DurationField eras()
  {
    return iEras;
  }
  
  public final DateTimeField era()
  {
    return iEra;
  }
  
  protected abstract void assemble(Fields paramFields);
  
  protected final Chronology getBase()
  {
    return iBase;
  }
  
  protected final Object getParam()
  {
    return iParam;
  }
  
  private void setFields()
  {
    Fields localFields = new Fields();
    if (iBase != null) {
      localFields.copyFieldsFrom(iBase);
    }
    assemble(localFields);
    Object localObject;
    iMillis = ((localObject = millis) != null ? localObject : super.millis());
    iSeconds = ((localObject = seconds) != null ? localObject : super.seconds());
    iMinutes = ((localObject = minutes) != null ? localObject : super.minutes());
    iHours = ((localObject = hours) != null ? localObject : super.hours());
    iHalfdays = ((localObject = halfdays) != null ? localObject : super.halfdays());
    iDays = ((localObject = days) != null ? localObject : super.days());
    iWeeks = ((localObject = weeks) != null ? localObject : super.weeks());
    iWeekyears = ((localObject = weekyears) != null ? localObject : super.weekyears());
    iMonths = ((localObject = months) != null ? localObject : super.months());
    iYears = ((localObject = years) != null ? localObject : super.years());
    iCenturies = ((localObject = centuries) != null ? localObject : super.centuries());
    iEras = ((localObject = eras) != null ? localObject : super.eras());
    
    iMillisOfSecond = ((localObject = millisOfSecond) != null ? localObject : super.millisOfSecond());
    iMillisOfDay = ((localObject = millisOfDay) != null ? localObject : super.millisOfDay());
    iSecondOfMinute = ((localObject = secondOfMinute) != null ? localObject : super.secondOfMinute());
    iSecondOfDay = ((localObject = secondOfDay) != null ? localObject : super.secondOfDay());
    iMinuteOfHour = ((localObject = minuteOfHour) != null ? localObject : super.minuteOfHour());
    iMinuteOfDay = ((localObject = minuteOfDay) != null ? localObject : super.minuteOfDay());
    iHourOfDay = ((localObject = hourOfDay) != null ? localObject : super.hourOfDay());
    iClockhourOfDay = ((localObject = clockhourOfDay) != null ? localObject : super.clockhourOfDay());
    iHourOfHalfday = ((localObject = hourOfHalfday) != null ? localObject : super.hourOfHalfday());
    iClockhourOfHalfday = ((localObject = clockhourOfHalfday) != null ? localObject : super.clockhourOfHalfday());
    iHalfdayOfDay = ((localObject = halfdayOfDay) != null ? localObject : super.halfdayOfDay());
    iDayOfWeek = ((localObject = dayOfWeek) != null ? localObject : super.dayOfWeek());
    iDayOfMonth = ((localObject = dayOfMonth) != null ? localObject : super.dayOfMonth());
    iDayOfYear = ((localObject = dayOfYear) != null ? localObject : super.dayOfYear());
    iWeekOfWeekyear = ((localObject = weekOfWeekyear) != null ? localObject : super.weekOfWeekyear());
    iWeekyear = ((localObject = weekyear) != null ? localObject : super.weekyear());
    iWeekyearOfCentury = ((localObject = weekyearOfCentury) != null ? localObject : super.weekyearOfCentury());
    iMonthOfYear = ((localObject = monthOfYear) != null ? localObject : super.monthOfYear());
    iYear = ((localObject = year) != null ? localObject : super.year());
    iYearOfEra = ((localObject = yearOfEra) != null ? localObject : super.yearOfEra());
    iYearOfCentury = ((localObject = yearOfCentury) != null ? localObject : super.yearOfCentury());
    iCenturyOfEra = ((localObject = centuryOfEra) != null ? localObject : super.centuryOfEra());
    iEra = ((localObject = era) != null ? localObject : super.era());
    int i;
    if (iBase == null) {
      i = 0;
    } else {
      i = ((iHourOfDay == iBase.hourOfDay()) && (iMinuteOfHour == iBase.minuteOfHour()) && (iSecondOfMinute == iBase.secondOfMinute()) && (iMillisOfSecond == iBase.millisOfSecond()) ? 1 : 0) | (iMillisOfDay == iBase.millisOfDay() ? 2 : 0) | ((iYear == iBase.year()) && (iMonthOfYear == iBase.monthOfYear()) && (iDayOfMonth == iBase.dayOfMonth()) ? 4 : 0);
    }
    iBaseFlags = i;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    setFields();
  }
  
  public static final class Fields
  {
    public DurationField millis;
    public DurationField seconds;
    public DurationField minutes;
    public DurationField hours;
    public DurationField halfdays;
    public DurationField days;
    public DurationField weeks;
    public DurationField weekyears;
    public DurationField months;
    public DurationField years;
    public DurationField centuries;
    public DurationField eras;
    public DateTimeField millisOfSecond;
    public DateTimeField millisOfDay;
    public DateTimeField secondOfMinute;
    public DateTimeField secondOfDay;
    public DateTimeField minuteOfHour;
    public DateTimeField minuteOfDay;
    public DateTimeField hourOfDay;
    public DateTimeField clockhourOfDay;
    public DateTimeField hourOfHalfday;
    public DateTimeField clockhourOfHalfday;
    public DateTimeField halfdayOfDay;
    public DateTimeField dayOfWeek;
    public DateTimeField dayOfMonth;
    public DateTimeField dayOfYear;
    public DateTimeField weekOfWeekyear;
    public DateTimeField weekyear;
    public DateTimeField weekyearOfCentury;
    public DateTimeField monthOfYear;
    public DateTimeField year;
    public DateTimeField yearOfEra;
    public DateTimeField yearOfCentury;
    public DateTimeField centuryOfEra;
    public DateTimeField era;
    
    public void copyFieldsFrom(Chronology paramChronology)
    {
      Object localObject;
      if (isSupported(localObject = paramChronology.millis())) {
        millis = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.seconds())) {
        seconds = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.minutes())) {
        minutes = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.hours())) {
        hours = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.halfdays())) {
        halfdays = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.days())) {
        days = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.weeks())) {
        weeks = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.weekyears())) {
        weekyears = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.months())) {
        months = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.years())) {
        years = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.centuries())) {
        centuries = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.eras())) {
        eras = ((DurationField)localObject);
      }
      if (isSupported(localObject = paramChronology.millisOfSecond())) {
        millisOfSecond = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.millisOfDay())) {
        millisOfDay = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.secondOfMinute())) {
        secondOfMinute = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.secondOfDay())) {
        secondOfDay = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.minuteOfHour())) {
        minuteOfHour = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.minuteOfDay())) {
        minuteOfDay = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.hourOfDay())) {
        hourOfDay = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.clockhourOfDay())) {
        clockhourOfDay = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.hourOfHalfday())) {
        hourOfHalfday = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.clockhourOfHalfday())) {
        clockhourOfHalfday = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.halfdayOfDay())) {
        halfdayOfDay = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.dayOfWeek())) {
        dayOfWeek = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.dayOfMonth())) {
        dayOfMonth = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.dayOfYear())) {
        dayOfYear = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.weekOfWeekyear())) {
        weekOfWeekyear = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.weekyear())) {
        weekyear = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.weekyearOfCentury())) {
        weekyearOfCentury = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.monthOfYear())) {
        monthOfYear = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.year())) {
        year = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.yearOfEra())) {
        yearOfEra = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.yearOfCentury())) {
        yearOfCentury = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.centuryOfEra())) {
        centuryOfEra = ((DateTimeField)localObject);
      }
      if (isSupported(localObject = paramChronology.era())) {
        era = ((DateTimeField)localObject);
      }
    }
    
    private static boolean isSupported(DurationField paramDurationField)
    {
      return paramDurationField == null ? false : paramDurationField.isSupported();
    }
    
    private static boolean isSupported(DateTimeField paramDateTimeField)
    {
      return paramDateTimeField == null ? false : paramDateTimeField.isSupported();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.AssembledChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */