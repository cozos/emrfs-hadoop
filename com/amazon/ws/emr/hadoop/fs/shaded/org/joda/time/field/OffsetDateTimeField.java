package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;

public class OffsetDateTimeField
  extends DecoratedDateTimeField
{
  private static final long serialVersionUID = 3145790132623583142L;
  private final int iOffset;
  private final int iMin;
  private final int iMax;
  
  public OffsetDateTimeField(DateTimeField paramDateTimeField, int paramInt)
  {
    this(paramDateTimeField, paramDateTimeField == null ? null : paramDateTimeField.getType(), paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public OffsetDateTimeField(DateTimeField paramDateTimeField, DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    this(paramDateTimeField, paramDateTimeFieldType, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public OffsetDateTimeField(DateTimeField paramDateTimeField, DateTimeFieldType paramDateTimeFieldType, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramDateTimeField, paramDateTimeFieldType);
    if (paramInt1 == 0) {
      throw new IllegalArgumentException("The offset cannot be zero");
    }
    iOffset = paramInt1;
    if (paramInt2 < paramDateTimeField.getMinimumValue() + paramInt1) {
      iMin = (paramDateTimeField.getMinimumValue() + paramInt1);
    } else {
      iMin = paramInt2;
    }
    if (paramInt3 > paramDateTimeField.getMaximumValue() + paramInt1) {
      iMax = (paramDateTimeField.getMaximumValue() + paramInt1);
    } else {
      iMax = paramInt3;
    }
  }
  
  public int get(long paramLong)
  {
    return super.get(paramLong) + iOffset;
  }
  
  public long add(long paramLong, int paramInt)
  {
    paramLong = super.add(paramLong, paramInt);
    FieldUtils.verifyValueBounds(this, get(paramLong), iMin, iMax);
    return paramLong;
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    paramLong1 = super.add(paramLong1, paramLong2);
    FieldUtils.verifyValueBounds(this, get(paramLong1), iMin, iMax);
    return paramLong1;
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return set(paramLong, FieldUtils.getWrappedValue(get(paramLong), paramInt, iMin, iMax));
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, iMin, iMax);
    return super.set(paramLong, paramInt - iOffset);
  }
  
  public boolean isLeap(long paramLong)
  {
    return getWrappedField().isLeap(paramLong);
  }
  
  public int getLeapAmount(long paramLong)
  {
    return getWrappedField().getLeapAmount(paramLong);
  }
  
  public DurationField getLeapDurationField()
  {
    return getWrappedField().getLeapDurationField();
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
  
  public int getOffset()
  {
    return iOffset;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.OffsetDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */