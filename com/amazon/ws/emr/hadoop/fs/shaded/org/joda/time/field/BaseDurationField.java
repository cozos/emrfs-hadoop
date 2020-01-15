package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import java.io.Serializable;

public abstract class BaseDurationField
  extends DurationField
  implements Serializable
{
  private static final long serialVersionUID = -2554245107589433218L;
  private final DurationFieldType iType;
  
  protected BaseDurationField(DurationFieldType paramDurationFieldType)
  {
    if (paramDurationFieldType == null) {
      throw new IllegalArgumentException("The type must not be null");
    }
    iType = paramDurationFieldType;
  }
  
  public final DurationFieldType getType()
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
  
  public int getValue(long paramLong)
  {
    return FieldUtils.safeToInt(getValueAsLong(paramLong));
  }
  
  public long getValueAsLong(long paramLong)
  {
    return paramLong / getUnitMillis();
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeToInt(getValueAsLong(paramLong1, paramLong2));
  }
  
  public long getMillis(int paramInt)
  {
    return paramInt * getUnitMillis();
  }
  
  public long getMillis(long paramLong)
  {
    return FieldUtils.safeMultiply(paramLong, getUnitMillis());
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeToInt(getDifferenceAsLong(paramLong1, paramLong2));
  }
  
  public int compareTo(DurationField paramDurationField)
  {
    long l1 = paramDurationField.getUnitMillis();
    long l2 = getUnitMillis();
    if (l2 == l1) {
      return 0;
    }
    if (l2 < l1) {
      return -1;
    }
    return 1;
  }
  
  public String toString()
  {
    return "DurationField[" + getName() + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */