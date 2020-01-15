package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.util.Locale;

public abstract class BaseDateTimeField
  extends DateTimeField
{
  private final DateTimeFieldType iType;
  
  protected BaseDateTimeField(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The type must not be null");
    }
    iType = paramDateTimeFieldType;
  }
  
  public final DateTimeFieldType getType()
  {
    return iType;
  }
  
  public final String getName()
  {
    return iType.getName();
  }
  
  public final boolean isSupported()
  {
    return true;
  }
  
  public abstract int get(long paramLong);
  
  public String getAsText(long paramLong, Locale paramLocale)
  {
    return getAsText(get(paramLong), paramLocale);
  }
  
  public final String getAsText(long paramLong)
  {
    return getAsText(paramLong, null);
  }
  
  public String getAsText(ReadablePartial paramReadablePartial, int paramInt, Locale paramLocale)
  {
    return getAsText(paramInt, paramLocale);
  }
  
  public final String getAsText(ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    return getAsText(paramReadablePartial, paramReadablePartial.get(getType()), paramLocale);
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return Integer.toString(paramInt);
  }
  
  public String getAsShortText(long paramLong, Locale paramLocale)
  {
    return getAsShortText(get(paramLong), paramLocale);
  }
  
  public final String getAsShortText(long paramLong)
  {
    return getAsShortText(paramLong, null);
  }
  
  public String getAsShortText(ReadablePartial paramReadablePartial, int paramInt, Locale paramLocale)
  {
    return getAsShortText(paramInt, paramLocale);
  }
  
  public final String getAsShortText(ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    return getAsShortText(paramReadablePartial, paramReadablePartial.get(getType()), paramLocale);
  }
  
  public String getAsShortText(int paramInt, Locale paramLocale)
  {
    return getAsText(paramInt, paramLocale);
  }
  
  public long add(long paramLong, int paramInt)
  {
    return getDurationField().add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return getDurationField().add(paramLong1, paramLong2);
  }
  
  public int[] add(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramArrayOfInt;
    }
    DateTimeField localDateTimeField = null;
    int i;
    long l;
    while (paramInt2 > 0)
    {
      i = getMaximumValue(paramReadablePartial, paramArrayOfInt);
      l = paramArrayOfInt[paramInt1] + paramInt2;
      if (l <= i)
      {
        paramArrayOfInt[paramInt1] = ((int)l);
        break;
      }
      if (localDateTimeField == null)
      {
        if (paramInt1 == 0) {
          throw new IllegalArgumentException("Maximum value exceeded for add");
        }
        localDateTimeField = paramReadablePartial.getField(paramInt1 - 1);
        if (getRangeDurationField().getType() != localDateTimeField.getDurationField().getType()) {
          throw new IllegalArgumentException("Fields invalid for add");
        }
      }
      paramInt2 -= i + 1 - paramArrayOfInt[paramInt1];
      paramArrayOfInt = localDateTimeField.add(paramReadablePartial, paramInt1 - 1, paramArrayOfInt, 1);
      paramArrayOfInt[paramInt1] = getMinimumValue(paramReadablePartial, paramArrayOfInt);
    }
    while (paramInt2 < 0)
    {
      i = getMinimumValue(paramReadablePartial, paramArrayOfInt);
      l = paramArrayOfInt[paramInt1] + paramInt2;
      if (l >= i)
      {
        paramArrayOfInt[paramInt1] = ((int)l);
        break;
      }
      if (localDateTimeField == null)
      {
        if (paramInt1 == 0) {
          throw new IllegalArgumentException("Maximum value exceeded for add");
        }
        localDateTimeField = paramReadablePartial.getField(paramInt1 - 1);
        if (getRangeDurationField().getType() != localDateTimeField.getDurationField().getType()) {
          throw new IllegalArgumentException("Fields invalid for add");
        }
      }
      paramInt2 -= i - 1 - paramArrayOfInt[paramInt1];
      paramArrayOfInt = localDateTimeField.add(paramReadablePartial, paramInt1 - 1, paramArrayOfInt, -1);
      paramArrayOfInt[paramInt1] = getMaximumValue(paramReadablePartial, paramArrayOfInt);
    }
    return set(paramReadablePartial, paramInt1, paramArrayOfInt, paramArrayOfInt[paramInt1]);
  }
  
  public int[] addWrapPartial(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramArrayOfInt;
    }
    DateTimeField localDateTimeField = null;
    int i;
    long l;
    while (paramInt2 > 0)
    {
      i = getMaximumValue(paramReadablePartial, paramArrayOfInt);
      l = paramArrayOfInt[paramInt1] + paramInt2;
      if (l <= i)
      {
        paramArrayOfInt[paramInt1] = ((int)l);
        break;
      }
      if (localDateTimeField == null)
      {
        if (paramInt1 == 0)
        {
          paramInt2 -= i + 1 - paramArrayOfInt[paramInt1];
          paramArrayOfInt[paramInt1] = getMinimumValue(paramReadablePartial, paramArrayOfInt);
          continue;
        }
        localDateTimeField = paramReadablePartial.getField(paramInt1 - 1);
        if (getRangeDurationField().getType() != localDateTimeField.getDurationField().getType()) {
          throw new IllegalArgumentException("Fields invalid for add");
        }
      }
      paramInt2 -= i + 1 - paramArrayOfInt[paramInt1];
      paramArrayOfInt = localDateTimeField.addWrapPartial(paramReadablePartial, paramInt1 - 1, paramArrayOfInt, 1);
      paramArrayOfInt[paramInt1] = getMinimumValue(paramReadablePartial, paramArrayOfInt);
    }
    while (paramInt2 < 0)
    {
      i = getMinimumValue(paramReadablePartial, paramArrayOfInt);
      l = paramArrayOfInt[paramInt1] + paramInt2;
      if (l >= i)
      {
        paramArrayOfInt[paramInt1] = ((int)l);
        break;
      }
      if (localDateTimeField == null)
      {
        if (paramInt1 == 0)
        {
          paramInt2 -= i - 1 - paramArrayOfInt[paramInt1];
          paramArrayOfInt[paramInt1] = getMaximumValue(paramReadablePartial, paramArrayOfInt);
          continue;
        }
        localDateTimeField = paramReadablePartial.getField(paramInt1 - 1);
        if (getRangeDurationField().getType() != localDateTimeField.getDurationField().getType()) {
          throw new IllegalArgumentException("Fields invalid for add");
        }
      }
      paramInt2 -= i - 1 - paramArrayOfInt[paramInt1];
      paramArrayOfInt = localDateTimeField.addWrapPartial(paramReadablePartial, paramInt1 - 1, paramArrayOfInt, -1);
      paramArrayOfInt[paramInt1] = getMaximumValue(paramReadablePartial, paramArrayOfInt);
    }
    return set(paramReadablePartial, paramInt1, paramArrayOfInt, paramArrayOfInt[paramInt1]);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    int i = get(paramLong);
    int j = FieldUtils.getWrappedValue(i, paramInt, getMinimumValue(paramLong), getMaximumValue(paramLong));
    
    return set(paramLong, j);
  }
  
  public int[] addWrapField(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = paramArrayOfInt[paramInt1];
    int j = FieldUtils.getWrappedValue(i, paramInt2, getMinimumValue(paramReadablePartial), getMaximumValue(paramReadablePartial));
    
    return set(paramReadablePartial, paramInt1, paramArrayOfInt, j);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return getDurationField().getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return getDurationField().getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public abstract long set(long paramLong, int paramInt);
  
  public int[] set(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    FieldUtils.verifyValueBounds(this, paramInt2, getMinimumValue(paramReadablePartial, paramArrayOfInt), getMaximumValue(paramReadablePartial, paramArrayOfInt));
    paramArrayOfInt[paramInt1] = paramInt2;
    for (int i = paramInt1 + 1; i < paramReadablePartial.size(); i++)
    {
      DateTimeField localDateTimeField = paramReadablePartial.getField(i);
      if (paramArrayOfInt[i] > localDateTimeField.getMaximumValue(paramReadablePartial, paramArrayOfInt)) {
        paramArrayOfInt[i] = localDateTimeField.getMaximumValue(paramReadablePartial, paramArrayOfInt);
      }
      if (paramArrayOfInt[i] < localDateTimeField.getMinimumValue(paramReadablePartial, paramArrayOfInt)) {
        paramArrayOfInt[i] = localDateTimeField.getMinimumValue(paramReadablePartial, paramArrayOfInt);
      }
    }
    return paramArrayOfInt;
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    int i = convertText(paramString, paramLocale);
    return set(paramLong, i);
  }
  
  public final long set(long paramLong, String paramString)
  {
    return set(paramLong, paramString, null);
  }
  
  public int[] set(ReadablePartial paramReadablePartial, int paramInt, int[] paramArrayOfInt, String paramString, Locale paramLocale)
  {
    int i = convertText(paramString, paramLocale);
    return set(paramReadablePartial, paramInt, paramArrayOfInt, i);
  }
  
  protected int convertText(String paramString, Locale paramLocale)
  {
    try
    {
      return Integer.parseInt(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IllegalFieldValueException(getType(), paramString);
    }
  }
  
  public abstract DurationField getDurationField();
  
  public abstract DurationField getRangeDurationField();
  
  public boolean isLeap(long paramLong)
  {
    return false;
  }
  
  public int getLeapAmount(long paramLong)
  {
    return 0;
  }
  
  public DurationField getLeapDurationField()
  {
    return null;
  }
  
  public abstract int getMinimumValue();
  
  public int getMinimumValue(long paramLong)
  {
    return getMinimumValue();
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial)
  {
    return getMinimumValue();
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    return getMinimumValue(paramReadablePartial);
  }
  
  public abstract int getMaximumValue();
  
  public int getMaximumValue(long paramLong)
  {
    return getMaximumValue();
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    return getMaximumValue();
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    return getMaximumValue(paramReadablePartial);
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    int i = getMaximumValue();
    if (i >= 0)
    {
      if (i < 10) {
        return 1;
      }
      if (i < 100) {
        return 2;
      }
      if (i < 1000) {
        return 3;
      }
    }
    return Integer.toString(i).length();
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return getMaximumTextLength(paramLocale);
  }
  
  public abstract long roundFloor(long paramLong);
  
  public long roundCeiling(long paramLong)
  {
    long l = roundFloor(paramLong);
    if (l != paramLong) {
      paramLong = add(l, 1);
    }
    return paramLong;
  }
  
  public long roundHalfFloor(long paramLong)
  {
    long l1 = roundFloor(paramLong);
    long l2 = roundCeiling(paramLong);
    
    long l3 = paramLong - l1;
    long l4 = l2 - paramLong;
    if (l3 <= l4) {
      return l1;
    }
    return l2;
  }
  
  public long roundHalfCeiling(long paramLong)
  {
    long l1 = roundFloor(paramLong);
    long l2 = roundCeiling(paramLong);
    
    long l3 = paramLong - l1;
    long l4 = l2 - paramLong;
    if (l4 <= l3) {
      return l2;
    }
    return l1;
  }
  
  public long roundHalfEven(long paramLong)
  {
    long l1 = roundFloor(paramLong);
    long l2 = roundCeiling(paramLong);
    
    long l3 = paramLong - l1;
    long l4 = l2 - paramLong;
    if (l3 < l4) {
      return l1;
    }
    if (l4 < l3) {
      return l2;
    }
    if ((get(l2) & 0x1) == 0) {
      return l2;
    }
    return l1;
  }
  
  public long remainder(long paramLong)
  {
    return paramLong - roundFloor(paramLong);
  }
  
  public String toString()
  {
    return "DateTimeField[" + getName() + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */