package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.UnsupportedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.UnsupportedDurationField;
import java.io.Serializable;

public abstract class BaseChronology
  extends Chronology
  implements Serializable
{
  private static final long serialVersionUID = -7310865996721419676L;
  
  public abstract DateTimeZone getZone();
  
  public abstract Chronology withUTC();
  
  public abstract Chronology withZone(DateTimeZone paramDateTimeZone);
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    long l = year().set(0L, paramInt1);
    l = monthOfYear().set(l, paramInt2);
    l = dayOfMonth().set(l, paramInt3);
    return millisOfDay().set(l, paramInt4);
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws IllegalArgumentException
  {
    long l = year().set(0L, paramInt1);
    l = monthOfYear().set(l, paramInt2);
    l = dayOfMonth().set(l, paramInt3);
    l = hourOfDay().set(l, paramInt4);
    l = minuteOfHour().set(l, paramInt5);
    l = secondOfMinute().set(l, paramInt6);
    return millisOfSecond().set(l, paramInt7);
  }
  
  public long getDateTimeMillis(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    paramLong = hourOfDay().set(paramLong, paramInt1);
    paramLong = minuteOfHour().set(paramLong, paramInt2);
    paramLong = secondOfMinute().set(paramLong, paramInt3);
    return millisOfSecond().set(paramLong, paramInt4);
  }
  
  public void validate(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    int i = paramReadablePartial.size();
    int k;
    DateTimeField localDateTimeField;
    for (int j = 0; j < i; j++)
    {
      k = paramArrayOfInt[j];
      localDateTimeField = paramReadablePartial.getField(j);
      if (k < localDateTimeField.getMinimumValue()) {
        throw new IllegalFieldValueException(localDateTimeField.getType(), Integer.valueOf(k), Integer.valueOf(localDateTimeField.getMinimumValue()), null);
      }
      if (k > localDateTimeField.getMaximumValue()) {
        throw new IllegalFieldValueException(localDateTimeField.getType(), Integer.valueOf(k), null, Integer.valueOf(localDateTimeField.getMaximumValue()));
      }
    }
    for (j = 0; j < i; j++)
    {
      k = paramArrayOfInt[j];
      localDateTimeField = paramReadablePartial.getField(j);
      if (k < localDateTimeField.getMinimumValue(paramReadablePartial, paramArrayOfInt)) {
        throw new IllegalFieldValueException(localDateTimeField.getType(), Integer.valueOf(k), Integer.valueOf(localDateTimeField.getMinimumValue(paramReadablePartial, paramArrayOfInt)), null);
      }
      if (k > localDateTimeField.getMaximumValue(paramReadablePartial, paramArrayOfInt)) {
        throw new IllegalFieldValueException(localDateTimeField.getType(), Integer.valueOf(k), null, Integer.valueOf(localDateTimeField.getMaximumValue(paramReadablePartial, paramArrayOfInt)));
      }
    }
  }
  
  public int[] get(ReadablePartial paramReadablePartial, long paramLong)
  {
    int i = paramReadablePartial.size();
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = paramReadablePartial.getFieldType(j).getField(this).get(paramLong);
    }
    return arrayOfInt;
  }
  
  public long set(ReadablePartial paramReadablePartial, long paramLong)
  {
    int i = 0;
    for (int j = paramReadablePartial.size(); i < j; i++) {
      paramLong = paramReadablePartial.getFieldType(i).getField(this).set(paramLong, paramReadablePartial.getValue(i));
    }
    return paramLong;
  }
  
  public int[] get(ReadablePeriod paramReadablePeriod, long paramLong1, long paramLong2)
  {
    int i = paramReadablePeriod.size();
    int[] arrayOfInt = new int[i];
    if (paramLong1 != paramLong2) {
      for (int j = 0; j < i; j++)
      {
        DurationField localDurationField = paramReadablePeriod.getFieldType(j).getField(this);
        int k = localDurationField.getDifference(paramLong2, paramLong1);
        if (k != 0) {
          paramLong1 = localDurationField.add(paramLong1, k);
        }
        arrayOfInt[j] = k;
      }
    }
    return arrayOfInt;
  }
  
  public int[] get(ReadablePeriod paramReadablePeriod, long paramLong)
  {
    int i = paramReadablePeriod.size();
    int[] arrayOfInt = new int[i];
    if (paramLong != 0L)
    {
      long l = 0L;
      for (int j = 0; j < i; j++)
      {
        DurationField localDurationField = paramReadablePeriod.getFieldType(j).getField(this);
        if (localDurationField.isPrecise())
        {
          int k = localDurationField.getDifference(paramLong, l);
          l = localDurationField.add(l, k);
          arrayOfInt[j] = k;
        }
      }
    }
    return arrayOfInt;
  }
  
  public long add(ReadablePeriod paramReadablePeriod, long paramLong, int paramInt)
  {
    if ((paramInt != 0) && (paramReadablePeriod != null))
    {
      int i = 0;
      for (int j = paramReadablePeriod.size(); i < j; i++)
      {
        long l = paramReadablePeriod.getValue(i);
        if (l != 0L) {
          paramLong = paramReadablePeriod.getFieldType(i).getField(this).add(paramLong, l * paramInt);
        }
      }
    }
    return paramLong;
  }
  
  public long add(long paramLong1, long paramLong2, int paramInt)
  {
    if ((paramLong2 == 0L) || (paramInt == 0)) {
      return paramLong1;
    }
    long l = FieldUtils.safeMultiply(paramLong2, paramInt);
    return FieldUtils.safeAdd(paramLong1, l);
  }
  
  public DurationField millis()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.millis());
  }
  
  public DateTimeField millisOfSecond()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfSecond(), millis());
  }
  
  public DateTimeField millisOfDay()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfDay(), millis());
  }
  
  public DurationField seconds()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.seconds());
  }
  
  public DateTimeField secondOfMinute()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfMinute(), seconds());
  }
  
  public DateTimeField secondOfDay()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfDay(), seconds());
  }
  
  public DurationField minutes()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.minutes());
  }
  
  public DateTimeField minuteOfHour()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfHour(), minutes());
  }
  
  public DateTimeField minuteOfDay()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfDay(), minutes());
  }
  
  public DurationField hours()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.hours());
  }
  
  public DateTimeField hourOfDay()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfDay(), hours());
  }
  
  public DateTimeField clockhourOfDay()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfDay(), hours());
  }
  
  public DurationField halfdays()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.halfdays());
  }
  
  public DateTimeField hourOfHalfday()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfHalfday(), hours());
  }
  
  public DateTimeField clockhourOfHalfday()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfHalfday(), hours());
  }
  
  public DateTimeField halfdayOfDay()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.halfdayOfDay(), halfdays());
  }
  
  public DurationField days()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.days());
  }
  
  public DateTimeField dayOfWeek()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfWeek(), days());
  }
  
  public DateTimeField dayOfMonth()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfMonth(), days());
  }
  
  public DateTimeField dayOfYear()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfYear(), days());
  }
  
  public DurationField weeks()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.weeks());
  }
  
  public DateTimeField weekOfWeekyear()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekOfWeekyear(), weeks());
  }
  
  public DurationField weekyears()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.weekyears());
  }
  
  public DateTimeField weekyear()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyear(), weekyears());
  }
  
  public DateTimeField weekyearOfCentury()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyearOfCentury(), weekyears());
  }
  
  public DurationField months()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.months());
  }
  
  public DateTimeField monthOfYear()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.monthOfYear(), months());
  }
  
  public DurationField years()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.years());
  }
  
  public DateTimeField year()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.year(), years());
  }
  
  public DateTimeField yearOfEra()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfEra(), years());
  }
  
  public DateTimeField yearOfCentury()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfCentury(), years());
  }
  
  public DurationField centuries()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.centuries());
  }
  
  public DateTimeField centuryOfEra()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.centuryOfEra(), centuries());
  }
  
  public DurationField eras()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.eras());
  }
  
  public DateTimeField era()
  {
    return UnsupportedDateTimeField.getInstance(DateTimeFieldType.era(), eras());
  }
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BaseChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */