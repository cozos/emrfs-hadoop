package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;

public final class ZeroIsMaxDateTimeField
  extends DecoratedDateTimeField
{
  private static final long serialVersionUID = 961749798233026866L;
  
  public ZeroIsMaxDateTimeField(DateTimeField paramDateTimeField, DateTimeFieldType paramDateTimeFieldType)
  {
    super(paramDateTimeField, paramDateTimeFieldType);
    if (paramDateTimeField.getMinimumValue() != 0) {
      throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
    }
  }
  
  public int get(long paramLong)
  {
    int i = getWrappedField().get(paramLong);
    if (i == 0) {
      i = getMaximumValue();
    }
    return i;
  }
  
  public long add(long paramLong, int paramInt)
  {
    return getWrappedField().add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return getWrappedField().add(paramLong1, paramLong2);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return getWrappedField().addWrapField(paramLong, paramInt);
  }
  
  public int[] addWrapField(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return getWrappedField().addWrapField(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public long set(long paramLong, int paramInt)
  {
    int i = getMaximumValue();
    FieldUtils.verifyValueBounds(this, paramInt, 1, i);
    if (paramInt == i) {
      paramInt = 0;
    }
    return getWrappedField().set(paramLong, paramInt);
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
    return 1;
  }
  
  public int getMinimumValue(long paramLong)
  {
    return 1;
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial)
  {
    return 1;
  }
  
  public int getMinimumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return getWrappedField().getMaximumValue() + 1;
  }
  
  public int getMaximumValue(long paramLong)
  {
    return getWrappedField().getMaximumValue(paramLong) + 1;
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    return getWrappedField().getMaximumValue(paramReadablePartial) + 1;
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    return getWrappedField().getMaximumValue(paramReadablePartial, paramArrayOfInt) + 1;
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ZeroIsMaxDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */