package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

public final class UnsupportedDateTimeField
  extends DateTimeField
  implements Serializable
{
  private static final long serialVersionUID = -1934618396111902255L;
  private static HashMap<DateTimeFieldType, UnsupportedDateTimeField> cCache;
  private final DateTimeFieldType iType;
  private final DurationField iDurationField;
  
  public static synchronized UnsupportedDateTimeField getInstance(DateTimeFieldType paramDateTimeFieldType, DurationField paramDurationField)
  {
    UnsupportedDateTimeField localUnsupportedDateTimeField;
    if (cCache == null)
    {
      cCache = new HashMap(7);
      localUnsupportedDateTimeField = null;
    }
    else
    {
      localUnsupportedDateTimeField = (UnsupportedDateTimeField)cCache.get(paramDateTimeFieldType);
      if ((localUnsupportedDateTimeField != null) && (localUnsupportedDateTimeField.getDurationField() != paramDurationField)) {
        localUnsupportedDateTimeField = null;
      }
    }
    if (localUnsupportedDateTimeField == null)
    {
      localUnsupportedDateTimeField = new UnsupportedDateTimeField(paramDateTimeFieldType, paramDurationField);
      cCache.put(paramDateTimeFieldType, localUnsupportedDateTimeField);
    }
    return localUnsupportedDateTimeField;
  }
  
  private UnsupportedDateTimeField(DateTimeFieldType paramDateTimeFieldType, DurationField paramDurationField)
  {
    if ((paramDateTimeFieldType == null) || (paramDurationField == null)) {
      throw new IllegalArgumentException();
    }
    iType = paramDateTimeFieldType;
    iDurationField = paramDurationField;
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
    return false;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public int get(long paramLong)
  {
    throw unsupported();
  }
  
  public String getAsText(long paramLong, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public String getAsText(long paramLong)
  {
    throw unsupported();
  }
  
  public String getAsText(ReadablePartial paramReadablePartial, int paramInt, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public String getAsText(ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public String getAsShortText(long paramLong, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public String getAsShortText(long paramLong)
  {
    throw unsupported();
  }
  
  public String getAsShortText(ReadablePartial paramReadablePartial, int paramInt, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public String getAsShortText(ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public String getAsShortText(int paramInt, Locale paramLocale)
  {
    throw unsupported();
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
    throw unsupported();
  }
  
  public int[] addWrapPartial(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw unsupported();
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    throw unsupported();
  }
  
  public int[] addWrapField(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw unsupported();
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return getDurationField().getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return getDurationField().getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public long set(long paramLong, int paramInt)
  {
    throw unsupported();
  }
  
  public int[] set(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw unsupported();
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public long set(long paramLong, String paramString)
  {
    throw unsupported();
  }
  
  public int[] set(ReadablePartial paramReadablePartial, int paramInt, int[] paramArrayOfInt, String paramString, Locale paramLocale)
  {
    throw unsupported();
  }
  
  public DurationField getDurationField()
  {
    return iDurationField;
  }
  
  public DurationField getRangeDurationField()
  {
    return null;
  }
  
  public boolean isLeap(long paramLong)
  {
    throw unsupported();
  }
  
  public int getLeapAmount(long paramLong)
  {
    throw unsupported();
  }
  
  public DurationField getLeapDurationField()
  {
    return null;
  }
  
  public int getMinimumValue()
  {
    throw unsupported();
  }
  
  public int getMinimumValue(long paramLong)
  {
    throw unsupported();
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial)
  {
    throw unsupported();
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    throw unsupported();
  }
  
  public int getMaximumValue()
  {
    throw unsupported();
  }
  
  public int getMaximumValue(long paramLong)
  {
    throw unsupported();
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    throw unsupported();
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    throw unsupported();
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    throw unsupported();
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    throw unsupported();
  }
  
  public long roundFloor(long paramLong)
  {
    throw unsupported();
  }
  
  public long roundCeiling(long paramLong)
  {
    throw unsupported();
  }
  
  public long roundHalfFloor(long paramLong)
  {
    throw unsupported();
  }
  
  public long roundHalfCeiling(long paramLong)
  {
    throw unsupported();
  }
  
  public long roundHalfEven(long paramLong)
  {
    throw unsupported();
  }
  
  public long remainder(long paramLong)
  {
    throw unsupported();
  }
  
  public String toString()
  {
    return "UnsupportedDateTimeField";
  }
  
  private Object readResolve()
  {
    return getInstance(iType, iDurationField);
  }
  
  private UnsupportedOperationException unsupported()
  {
    return new UnsupportedOperationException(iType + " field is unsupported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.UnsupportedDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */