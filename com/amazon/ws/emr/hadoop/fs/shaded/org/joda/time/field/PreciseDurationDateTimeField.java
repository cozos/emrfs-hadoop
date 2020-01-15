package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

public abstract class PreciseDurationDateTimeField
  extends BaseDateTimeField
{
  private static final long serialVersionUID = 5004523158306266035L;
  final long iUnitMillis;
  private final DurationField iUnitField;
  
  public PreciseDurationDateTimeField(DateTimeFieldType paramDateTimeFieldType, DurationField paramDurationField)
  {
    super(paramDateTimeFieldType);
    if (!paramDurationField.isPrecise()) {
      throw new IllegalArgumentException("Unit duration field must be precise");
    }
    iUnitMillis = paramDurationField.getUnitMillis();
    if (iUnitMillis < 1L) {
      throw new IllegalArgumentException("The unit milliseconds must be at least 1");
    }
    iUnitField = paramDurationField;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, getMinimumValue(), getMaximumValueForSet(paramLong, paramInt));
    
    return paramLong + (paramInt - get(paramLong)) * iUnitMillis;
  }
  
  public long roundFloor(long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong - paramLong % iUnitMillis;
    }
    paramLong += 1L;
    return paramLong - paramLong % iUnitMillis - iUnitMillis;
  }
  
  public long roundCeiling(long paramLong)
  {
    if (paramLong > 0L)
    {
      paramLong -= 1L;
      return paramLong - paramLong % iUnitMillis + iUnitMillis;
    }
    return paramLong - paramLong % iUnitMillis;
  }
  
  public long remainder(long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong % iUnitMillis;
    }
    return (paramLong + 1L) % iUnitMillis + iUnitMillis - 1L;
  }
  
  public DurationField getDurationField()
  {
    return iUnitField;
  }
  
  public int getMinimumValue()
  {
    return 0;
  }
  
  public final long getUnitMillis()
  {
    return iUnitMillis;
  }
  
  protected int getMaximumValueForSet(long paramLong, int paramInt)
  {
    return getMaximumValue(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDurationDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */