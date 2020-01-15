package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

public class DividedDateTimeField
  extends DecoratedDateTimeField
{
  private static final long serialVersionUID = 8318475124230605365L;
  final int iDivisor;
  final DurationField iDurationField;
  final DurationField iRangeDurationField;
  private final int iMin;
  private final int iMax;
  
  public DividedDateTimeField(DateTimeField paramDateTimeField, DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    this(paramDateTimeField, paramDateTimeField.getRangeDurationField(), paramDateTimeFieldType, paramInt);
  }
  
  public DividedDateTimeField(DateTimeField paramDateTimeField, DurationField paramDurationField, DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    super(paramDateTimeField, paramDateTimeFieldType);
    if (paramInt < 2) {
      throw new IllegalArgumentException("The divisor must be at least 2");
    }
    DurationField localDurationField = paramDateTimeField.getDurationField();
    if (localDurationField == null) {
      iDurationField = null;
    } else {
      iDurationField = new ScaledDurationField(localDurationField, paramDateTimeFieldType.getDurationType(), paramInt);
    }
    iRangeDurationField = paramDurationField;
    iDivisor = paramInt;
    int i = paramDateTimeField.getMinimumValue();
    int j = i >= 0 ? i / paramInt : (i + 1) / paramInt - 1;
    int k = paramDateTimeField.getMaximumValue();
    int m = k >= 0 ? k / paramInt : (k + 1) / paramInt - 1;
    iMin = j;
    iMax = m;
  }
  
  public DividedDateTimeField(RemainderDateTimeField paramRemainderDateTimeField, DateTimeFieldType paramDateTimeFieldType)
  {
    this(paramRemainderDateTimeField, null, paramDateTimeFieldType);
  }
  
  public DividedDateTimeField(RemainderDateTimeField paramRemainderDateTimeField, DurationField paramDurationField, DateTimeFieldType paramDateTimeFieldType)
  {
    super(paramRemainderDateTimeField.getWrappedField(), paramDateTimeFieldType);
    int i = iDivisor = iDivisor;
    iDurationField = iRangeField;
    iRangeDurationField = paramDurationField;
    DateTimeField localDateTimeField = getWrappedField();
    int j = localDateTimeField.getMinimumValue();
    int k = j >= 0 ? j / i : (j + 1) / i - 1;
    int m = localDateTimeField.getMaximumValue();
    int n = m >= 0 ? m / i : (m + 1) / i - 1;
    iMin = k;
    iMax = n;
  }
  
  public DurationField getRangeDurationField()
  {
    if (iRangeDurationField != null) {
      return iRangeDurationField;
    }
    return super.getRangeDurationField();
  }
  
  public int get(long paramLong)
  {
    int i = getWrappedField().get(paramLong);
    if (i >= 0) {
      return i / iDivisor;
    }
    return (i + 1) / iDivisor - 1;
  }
  
  public long add(long paramLong, int paramInt)
  {
    return getWrappedField().add(paramLong, paramInt * iDivisor);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return getWrappedField().add(paramLong1, paramLong2 * iDivisor);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return set(paramLong, FieldUtils.getWrappedValue(get(paramLong), paramInt, iMin, iMax));
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifference(paramLong1, paramLong2) / iDivisor;
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2) / iDivisor;
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, iMin, iMax);
    int i = getRemainder(getWrappedField().get(paramLong));
    return getWrappedField().set(paramLong, paramInt * iDivisor + i);
  }
  
  public DurationField getDurationField()
  {
    return iDurationField;
  }
  
  public int getMinimumValue()
  {
    return iMin;
  }
  
  public int getMaximumValue()
  {
    return iMax;
  }
  
  public long roundFloor(long paramLong)
  {
    DateTimeField localDateTimeField = getWrappedField();
    return localDateTimeField.roundFloor(localDateTimeField.set(paramLong, get(paramLong) * iDivisor));
  }
  
  public long remainder(long paramLong)
  {
    return set(paramLong, get(getWrappedField().remainder(paramLong)));
  }
  
  public int getDivisor()
  {
    return iDivisor;
  }
  
  private int getRemainder(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt % iDivisor;
    }
    return iDivisor - 1 + (paramInt + 1) % iDivisor;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DividedDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */