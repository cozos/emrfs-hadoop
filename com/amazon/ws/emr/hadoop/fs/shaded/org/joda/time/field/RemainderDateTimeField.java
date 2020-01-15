package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

public class RemainderDateTimeField
  extends DecoratedDateTimeField
{
  private static final long serialVersionUID = 5708241235177666790L;
  final int iDivisor;
  final DurationField iDurationField;
  final DurationField iRangeField;
  
  public RemainderDateTimeField(DateTimeField paramDateTimeField, DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    super(paramDateTimeField, paramDateTimeFieldType);
    if (paramInt < 2) {
      throw new IllegalArgumentException("The divisor must be at least 2");
    }
    DurationField localDurationField = paramDateTimeField.getDurationField();
    if (localDurationField == null) {
      iRangeField = null;
    } else {
      iRangeField = new ScaledDurationField(localDurationField, paramDateTimeFieldType.getRangeDurationType(), paramInt);
    }
    iDurationField = paramDateTimeField.getDurationField();
    iDivisor = paramInt;
  }
  
  public RemainderDateTimeField(DateTimeField paramDateTimeField, DurationField paramDurationField, DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    super(paramDateTimeField, paramDateTimeFieldType);
    if (paramInt < 2) {
      throw new IllegalArgumentException("The divisor must be at least 2");
    }
    iRangeField = paramDurationField;
    iDurationField = paramDateTimeField.getDurationField();
    iDivisor = paramInt;
  }
  
  public RemainderDateTimeField(DividedDateTimeField paramDividedDateTimeField)
  {
    this(paramDividedDateTimeField, paramDividedDateTimeField.getType());
  }
  
  public RemainderDateTimeField(DividedDateTimeField paramDividedDateTimeField, DateTimeFieldType paramDateTimeFieldType)
  {
    this(paramDividedDateTimeField, paramDividedDateTimeField.getWrappedField().getDurationField(), paramDateTimeFieldType);
  }
  
  public RemainderDateTimeField(DividedDateTimeField paramDividedDateTimeField, DurationField paramDurationField, DateTimeFieldType paramDateTimeFieldType)
  {
    super(paramDividedDateTimeField.getWrappedField(), paramDateTimeFieldType);
    iDivisor = iDivisor;
    iDurationField = paramDurationField;
    iRangeField = iDurationField;
  }
  
  public int get(long paramLong)
  {
    int i = getWrappedField().get(paramLong);
    if (i >= 0) {
      return i % iDivisor;
    }
    return iDivisor - 1 + (i + 1) % iDivisor;
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return set(paramLong, FieldUtils.getWrappedValue(get(paramLong), paramInt, 0, iDivisor - 1));
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, 0, iDivisor - 1);
    int i = getDivided(getWrappedField().get(paramLong));
    return getWrappedField().set(paramLong, i * iDivisor + paramInt);
  }
  
  public DurationField getDurationField()
  {
    return iDurationField;
  }
  
  public DurationField getRangeDurationField()
  {
    return iRangeField;
  }
  
  public int getMinimumValue()
  {
    return 0;
  }
  
  public int getMaximumValue()
  {
    return iDivisor - 1;
  }
  
  public long roundFloor(long paramLong)
  {
    return getWrappedField().roundFloor(paramLong);
  }
  
  public long roundCeiling(long paramLong)
  {
    return getWrappedField().roundCeiling(paramLong);
  }
  
  public long roundHalfFloor(long paramLong)
  {
    return getWrappedField().roundHalfFloor(paramLong);
  }
  
  public long roundHalfCeiling(long paramLong)
  {
    return getWrappedField().roundHalfCeiling(paramLong);
  }
  
  public long roundHalfEven(long paramLong)
  {
    return getWrappedField().roundHalfEven(paramLong);
  }
  
  public long remainder(long paramLong)
  {
    return getWrappedField().remainder(paramLong);
  }
  
  public int getDivisor()
  {
    return iDivisor;
  }
  
  private int getDivided(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt / iDivisor;
    }
    return (paramInt + 1) / iDivisor - 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.RemainderDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */