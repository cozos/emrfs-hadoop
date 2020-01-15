package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.Serializable;
import java.util.Locale;

public class DelegatedDateTimeField
  extends DateTimeField
  implements Serializable
{
  private static final long serialVersionUID = -4730164440214502503L;
  private final DateTimeField iField;
  private final DurationField iRangeDurationField;
  private final DateTimeFieldType iType;
  
  public DelegatedDateTimeField(DateTimeField paramDateTimeField)
  {
    this(paramDateTimeField, null);
  }
  
  public DelegatedDateTimeField(DateTimeField paramDateTimeField, DateTimeFieldType paramDateTimeFieldType)
  {
    this(paramDateTimeField, null, paramDateTimeFieldType);
  }
  
  public DelegatedDateTimeField(DateTimeField paramDateTimeField, DurationField paramDurationField, DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeField == null) {
      throw new IllegalArgumentException("The field must not be null");
    }
    iField = paramDateTimeField;
    iRangeDurationField = paramDurationField;
    iType = (paramDateTimeFieldType == null ? paramDateTimeField.getType() : paramDateTimeFieldType);
  }
  
  public final DateTimeField getWrappedField()
  {
    return iField;
  }
  
  public DateTimeFieldType getType()
  {
    return iType;
  }
  
  public String getName()
  {
    return iType.getName();
  }
  
  public boolean isSupported()
  {
    return iField.isSupported();
  }
  
  public boolean isLenient()
  {
    return iField.isLenient();
  }
  
  public int get(long paramLong)
  {
    return iField.get(paramLong);
  }
  
  public String getAsText(long paramLong, Locale paramLocale)
  {
    return iField.getAsText(paramLong, paramLocale);
  }
  
  public String getAsText(long paramLong)
  {
    return iField.getAsText(paramLong);
  }
  
  public String getAsText(ReadablePartial paramReadablePartial, int paramInt, Locale paramLocale)
  {
    return iField.getAsText(paramReadablePartial, paramInt, paramLocale);
  }
  
  public String getAsText(ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    return iField.getAsText(paramReadablePartial, paramLocale);
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return iField.getAsText(paramInt, paramLocale);
  }
  
  public String getAsShortText(long paramLong, Locale paramLocale)
  {
    return iField.getAsShortText(paramLong, paramLocale);
  }
  
  public String getAsShortText(long paramLong)
  {
    return iField.getAsShortText(paramLong);
  }
  
  public String getAsShortText(ReadablePartial paramReadablePartial, int paramInt, Locale paramLocale)
  {
    return iField.getAsShortText(paramReadablePartial, paramInt, paramLocale);
  }
  
  public String getAsShortText(ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    return iField.getAsShortText(paramReadablePartial, paramLocale);
  }
  
  public String getAsShortText(int paramInt, Locale paramLocale)
  {
    return iField.getAsShortText(paramInt, paramLocale);
  }
  
  public long add(long paramLong, int paramInt)
  {
    return iField.add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return iField.add(paramLong1, paramLong2);
  }
  
  public int[] add(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return iField.add(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public int[] addWrapPartial(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return iField.addWrapPartial(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return iField.addWrapField(paramLong, paramInt);
  }
  
  public int[] addWrapField(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return iField.addWrapField(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return iField.getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return iField.getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public long set(long paramLong, int paramInt)
  {
    return iField.set(paramLong, paramInt);
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    return iField.set(paramLong, paramString, paramLocale);
  }
  
  public long set(long paramLong, String paramString)
  {
    return iField.set(paramLong, paramString);
  }
  
  public int[] set(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return iField.set(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public int[] set(ReadablePartial paramReadablePartial, int paramInt, int[] paramArrayOfInt, String paramString, Locale paramLocale)
  {
    return iField.set(paramReadablePartial, paramInt, paramArrayOfInt, paramString, paramLocale);
  }
  
  public DurationField getDurationField()
  {
    return iField.getDurationField();
  }
  
  public DurationField getRangeDurationField()
  {
    if (iRangeDurationField != null) {
      return iRangeDurationField;
    }
    return iField.getRangeDurationField();
  }
  
  public boolean isLeap(long paramLong)
  {
    return iField.isLeap(paramLong);
  }
  
  public int getLeapAmount(long paramLong)
  {
    return iField.getLeapAmount(paramLong);
  }
  
  public DurationField getLeapDurationField()
  {
    return iField.getLeapDurationField();
  }
  
  public int getMinimumValue()
  {
    return iField.getMinimumValue();
  }
  
  public int getMinimumValue(long paramLong)
  {
    return iField.getMinimumValue(paramLong);
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
    return iField.getMaximumValue(paramLong);
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
  
  public long roundFloor(long paramLong)
  {
    return iField.roundFloor(paramLong);
  }
  
  public long roundCeiling(long paramLong)
  {
    return iField.roundCeiling(paramLong);
  }
  
  public long roundHalfFloor(long paramLong)
  {
    return iField.roundHalfFloor(paramLong);
  }
  
  public long roundHalfCeiling(long paramLong)
  {
    return iField.roundHalfCeiling(paramLong);
  }
  
  public long roundHalfEven(long paramLong)
  {
    return iField.roundHalfEven(paramLong);
  }
  
  public long remainder(long paramLong)
  {
    return iField.remainder(paramLong);
  }
  
  public String toString()
  {
    return "DateTimeField[" + getName() + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DelegatedDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */