package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalInstantException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDateTimeField;
import java.util.Locale;

final class ZonedChronology$ZonedDateTimeField
  extends BaseDateTimeField
{
  private static final long serialVersionUID = -3968986277775529794L;
  final DateTimeField iField;
  final DateTimeZone iZone;
  final DurationField iDurationField;
  final boolean iTimeField;
  final DurationField iRangeDurationField;
  final DurationField iLeapDurationField;
  
  ZonedChronology$ZonedDateTimeField(DateTimeField paramDateTimeField, DateTimeZone paramDateTimeZone, DurationField paramDurationField1, DurationField paramDurationField2, DurationField paramDurationField3)
  {
    super(paramDateTimeField.getType());
    if (!paramDateTimeField.isSupported()) {
      throw new IllegalArgumentException();
    }
    iField = paramDateTimeField;
    iZone = paramDateTimeZone;
    iDurationField = paramDurationField1;
    iTimeField = ZonedChronology.useTimeArithmetic(paramDurationField1);
    iRangeDurationField = paramDurationField2;
    iLeapDurationField = paramDurationField3;
  }
  
  public boolean isLenient()
  {
    return iField.isLenient();
  }
  
  public int get(long paramLong)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.get(l);
  }
  
  public String getAsText(long paramLong, Locale paramLocale)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.getAsText(l, paramLocale);
  }
  
  public String getAsShortText(long paramLong, Locale paramLocale)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.getAsShortText(l, paramLocale);
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return iField.getAsText(paramInt, paramLocale);
  }
  
  public String getAsShortText(int paramInt, Locale paramLocale)
  {
    return iField.getAsShortText(paramInt, paramLocale);
  }
  
  public long add(long paramLong, int paramInt)
  {
    if (iTimeField)
    {
      int i = getOffsetToAdd(paramLong);
      long l1 = iField.add(paramLong + i, paramInt);
      return l1 - i;
    }
    long l2 = iZone.convertUTCToLocal(paramLong);
    l2 = iField.add(l2, paramInt);
    return iZone.convertLocalToUTC(l2, false, paramLong);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    if (iTimeField)
    {
      int i = getOffsetToAdd(paramLong1);
      long l1 = iField.add(paramLong1 + i, paramLong2);
      return l1 - i;
    }
    long l2 = iZone.convertUTCToLocal(paramLong1);
    l2 = iField.add(l2, paramLong2);
    return iZone.convertLocalToUTC(l2, false, paramLong1);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    if (iTimeField)
    {
      int i = getOffsetToAdd(paramLong);
      long l1 = iField.addWrapField(paramLong + i, paramInt);
      return l1 - i;
    }
    long l2 = iZone.convertUTCToLocal(paramLong);
    l2 = iField.addWrapField(l2, paramInt);
    return iZone.convertLocalToUTC(l2, false, paramLong);
  }
  
  public long set(long paramLong, int paramInt)
  {
    long l1 = iZone.convertUTCToLocal(paramLong);
    l1 = iField.set(l1, paramInt);
    long l2 = iZone.convertLocalToUTC(l1, false, paramLong);
    if (get(l2) != paramInt)
    {
      IllegalInstantException localIllegalInstantException = new IllegalInstantException(l1, iZone.getID());
      IllegalFieldValueException localIllegalFieldValueException = new IllegalFieldValueException(iField.getType(), Integer.valueOf(paramInt), localIllegalInstantException.getMessage());
      localIllegalFieldValueException.initCause(localIllegalInstantException);
      throw localIllegalFieldValueException;
    }
    return l2;
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    l = iField.set(l, paramString, paramLocale);
    return iZone.convertLocalToUTC(l, false, paramLong);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    int i = getOffsetToAdd(paramLong2);
    return iField.getDifference(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    int i = getOffsetToAdd(paramLong2);
    return iField.getDifferenceAsLong(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
  }
  
  public final DurationField getDurationField()
  {
    return iDurationField;
  }
  
  public final DurationField getRangeDurationField()
  {
    return iRangeDurationField;
  }
  
  public boolean isLeap(long paramLong)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.isLeap(l);
  }
  
  public int getLeapAmount(long paramLong)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.getLeapAmount(l);
  }
  
  public final DurationField getLeapDurationField()
  {
    return iLeapDurationField;
  }
  
  public long roundFloor(long paramLong)
  {
    if (iTimeField)
    {
      int i = getOffsetToAdd(paramLong);
      paramLong = iField.roundFloor(paramLong + i);
      return paramLong - i;
    }
    long l = iZone.convertUTCToLocal(paramLong);
    l = iField.roundFloor(l);
    return iZone.convertLocalToUTC(l, false, paramLong);
  }
  
  public long roundCeiling(long paramLong)
  {
    if (iTimeField)
    {
      int i = getOffsetToAdd(paramLong);
      paramLong = iField.roundCeiling(paramLong + i);
      return paramLong - i;
    }
    long l = iZone.convertUTCToLocal(paramLong);
    l = iField.roundCeiling(l);
    return iZone.convertLocalToUTC(l, false, paramLong);
  }
  
  public long remainder(long paramLong)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.remainder(l);
  }
  
  public int getMinimumValue()
  {
    return iField.getMinimumValue();
  }
  
  public int getMinimumValue(long paramLong)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.getMinimumValue(l);
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial)
  {
    return iField.getMinimumValue(paramReadablePartial);
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    return iField.getMinimumValue(paramReadablePartial, paramArrayOfInt);
  }
  
  public int getMaximumValue()
  {
    return iField.getMaximumValue();
  }
  
  public int getMaximumValue(long paramLong)
  {
    long l = iZone.convertUTCToLocal(paramLong);
    return iField.getMaximumValue(l);
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    return iField.getMaximumValue(paramReadablePartial);
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    return iField.getMaximumValue(paramReadablePartial, paramArrayOfInt);
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return iField.getMaximumTextLength(paramLocale);
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return iField.getMaximumShortTextLength(paramLocale);
  }
  
  private int getOffsetToAdd(long paramLong)
  {
    int i = iZone.getOffset(paramLong);
    long l = paramLong + i;
    if (((paramLong ^ l) < 0L) && ((paramLong ^ i) >= 0L)) {
      throw new ArithmeticException("Adding time zone offset caused overflow");
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof ZonedDateTimeField))
    {
      ZonedDateTimeField localZonedDateTimeField = (ZonedDateTimeField)paramObject;
      return (iField.equals(iField)) && (iZone.equals(iZone)) && (iDurationField.equals(iDurationField)) && (iRangeDurationField.equals(iRangeDurationField));
    }
    return false;
  }
  
  public int hashCode()
  {
    return iField.hashCode() ^ iZone.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ZonedChronology.ZonedDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */