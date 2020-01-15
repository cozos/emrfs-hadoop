package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.StrictDateTimeField;

public final class StrictChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = 6633006628097111960L;
  private transient Chronology iWithUTC;
  
  public static StrictChronology getInstance(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new IllegalArgumentException("Must supply a chronology");
    }
    return new StrictChronology(paramChronology);
  }
  
  private StrictChronology(Chronology paramChronology)
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
  
  private static final DateTimeField convertField(DateTimeField paramDateTimeField)
  {
    return StrictDateTimeField.getInstance(paramDateTimeField);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof StrictChronology)) {
      return false;
    }
    StrictChronology localStrictChronology = (StrictChronology)paramObject;
    return getBase().equals(localStrictChronology.getBase());
  }
  
  public int hashCode()
  {
    return 352831696 + getBase().hashCode() * 7;
  }
  
  public String toString()
  {
    return "StrictChronology[" + getBase().toString() + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.StrictChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */