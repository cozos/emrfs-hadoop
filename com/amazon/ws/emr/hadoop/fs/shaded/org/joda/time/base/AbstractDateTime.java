package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.joda.convert.ToString;

public abstract class AbstractDateTime
  extends AbstractInstant
  implements ReadableDateTime
{
  public int get(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    return paramDateTimeFieldType.getField(getChronology()).get(getMillis());
  }
  
  public int getEra()
  {
    return getChronology().era().get(getMillis());
  }
  
  public int getCenturyOfEra()
  {
    return getChronology().centuryOfEra().get(getMillis());
  }
  
  public int getYearOfEra()
  {
    return getChronology().yearOfEra().get(getMillis());
  }
  
  public int getYearOfCentury()
  {
    return getChronology().yearOfCentury().get(getMillis());
  }
  
  public int getYear()
  {
    return getChronology().year().get(getMillis());
  }
  
  public int getWeekyear()
  {
    return getChronology().weekyear().get(getMillis());
  }
  
  public int getMonthOfYear()
  {
    return getChronology().monthOfYear().get(getMillis());
  }
  
  public int getWeekOfWeekyear()
  {
    return getChronology().weekOfWeekyear().get(getMillis());
  }
  
  public int getDayOfYear()
  {
    return getChronology().dayOfYear().get(getMillis());
  }
  
  public int getDayOfMonth()
  {
    return getChronology().dayOfMonth().get(getMillis());
  }
  
  public int getDayOfWeek()
  {
    return getChronology().dayOfWeek().get(getMillis());
  }
  
  public int getHourOfDay()
  {
    return getChronology().hourOfDay().get(getMillis());
  }
  
  public int getMinuteOfDay()
  {
    return getChronology().minuteOfDay().get(getMillis());
  }
  
  public int getMinuteOfHour()
  {
    return getChronology().minuteOfHour().get(getMillis());
  }
  
  public int getSecondOfDay()
  {
    return getChronology().secondOfDay().get(getMillis());
  }
  
  public int getSecondOfMinute()
  {
    return getChronology().secondOfMinute().get(getMillis());
  }
  
  public int getMillisOfDay()
  {
    return getChronology().millisOfDay().get(getMillis());
  }
  
  public int getMillisOfSecond()
  {
    return getChronology().millisOfSecond().get(getMillis());
  }
  
  public Calendar toCalendar(Locale paramLocale)
  {
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    DateTimeZone localDateTimeZone = getZone();
    Calendar localCalendar = Calendar.getInstance(localDateTimeZone.toTimeZone(), paramLocale);
    localCalendar.setTime(toDate());
    return localCalendar;
  }
  
  public GregorianCalendar toGregorianCalendar()
  {
    DateTimeZone localDateTimeZone = getZone();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(localDateTimeZone.toTimeZone());
    localGregorianCalendar.setTime(toDate());
    return localGregorianCalendar;
  }
  
  @ToString
  public String toString()
  {
    return super.toString();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractDateTime
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */