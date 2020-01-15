package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BuddhistChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GregorianChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.JulianChronology;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

final class CalendarConverter
  extends AbstractConverter
  implements InstantConverter, PartialConverter
{
  static final CalendarConverter INSTANCE = new CalendarConverter();
  
  public Chronology getChronology(Object paramObject, Chronology paramChronology)
  {
    if (paramChronology != null) {
      return paramChronology;
    }
    Calendar localCalendar = (Calendar)paramObject;
    DateTimeZone localDateTimeZone = null;
    try
    {
      localDateTimeZone = DateTimeZone.forTimeZone(localCalendar.getTimeZone());
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localDateTimeZone = DateTimeZone.getDefault();
    }
    return getChronology(localCalendar, localDateTimeZone);
  }
  
  public Chronology getChronology(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    if (paramObject.getClass().getName().endsWith(".BuddhistCalendar")) {
      return BuddhistChronology.getInstance(paramDateTimeZone);
    }
    if ((paramObject instanceof GregorianCalendar))
    {
      GregorianCalendar localGregorianCalendar = (GregorianCalendar)paramObject;
      long l = localGregorianCalendar.getGregorianChange().getTime();
      if (l == Long.MIN_VALUE) {
        return GregorianChronology.getInstance(paramDateTimeZone);
      }
      if (l == Long.MAX_VALUE) {
        return JulianChronology.getInstance(paramDateTimeZone);
      }
      return GJChronology.getInstance(paramDateTimeZone, l, 4);
    }
    return ISOChronology.getInstance(paramDateTimeZone);
  }
  
  public long getInstantMillis(Object paramObject, Chronology paramChronology)
  {
    Calendar localCalendar = (Calendar)paramObject;
    return localCalendar.getTime().getTime();
  }
  
  public Class<?> getSupportedType()
  {
    return Calendar.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.CalendarConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */