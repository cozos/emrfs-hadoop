package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.LenientDateTimeField;

public final class LenientChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = -3148237568046877177L;
  private transient Chronology iWithUTC;
  
  public static LenientChronology getInstance(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new IllegalArgumentException("Must supply a chronology");
    }
    return new LenientChronology(paramChronology);
  }
  
  private LenientChronology(Chronology paramChronology)
  {
    super(paramChronology, null);
  }
  
  public Chronology withUTC()
  {
    if (iWithUTC == null) {
      if (getZone() == DateTimeZone.UTC) {
        iWithUTC = this;
      } else {
        iWithUTC = getInstance(getBase().withUTC());
      }
    }
    return iWithUTC;
  }
  
  public Chronology withZone(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    if (paramDateTimeZone == DateTimeZone.UTC) {
      return withUTC();
    }
    if (paramDateTimeZone == getZone()) {
      return this;
    }
    return getInstance(getBase().withZone(paramDateTimeZone));
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    year = convertField(year);
    yearOfEra = convertField(yearOfEra);
    yearOfCentury = convertField(yearOfCentury);
    centuryOfEra = convertField(centuryOfEra);
    era = convertField(era);
    dayOfWeek = convertField(dayOfWeek);
    dayOfMonth = convertField(dayOfMonth);
    dayOfYear = convertField(dayOfYear);
    monthOfYear = convertField(monthOfYear);
    weekOfWeekyear = convertField(weekOfWeekyear);
    weekyear = convertField(weekyear);
    weekyearOfCentury = convertField(weekyearOfCentury);
    
    millisOfSecond = convertField(millisOfSecond);
    millisOfDay = convertField(millisOfDay);
    secondOfMinute = convertField(secondOfMinute);
    secondOfDay = convertField(secondOfDay);
    minuteOfHour = convertField(minuteOfHour);
    minuteOfDay = convertField(minuteOfDay);
    hourOfDay = convertField(hourOfDay);
    hourOfHalfday = convertField(hourOfHalfday);
    clockhourOfDay = convertField(clockhourOfDay);
    clockhourOfHalfday = convertField(clockhourOfHalfday);
    halfdayOfDay = convertField(halfdayOfDay);
  }
  
  private final DateTimeField convertField(DateTimeField paramDateTimeField)
  {
    return LenientDateTimeField.getInstance(paramDateTimeField, getBase());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LenientChronology)) {
      return false;
    }
    LenientChronology localLenientChronology = (LenientChronology)paramObject;
    return getBase().equals(localLenientChronology.getBase());
  }
  
  public int hashCode()
  {
    return 236548278 + getBase().hashCode() * 7;
  }
  
  public String toString()
  {
    return "LenientChronology[" + getBase().toString() + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.LenientChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */