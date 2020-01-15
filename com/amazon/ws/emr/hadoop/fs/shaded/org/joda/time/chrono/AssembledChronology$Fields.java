package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

public final class AssembledChronology$Fields
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.AssembledChronology.Fields
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */