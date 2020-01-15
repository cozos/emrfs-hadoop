package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;

final class GJYearOfEraDateTimeField
  extends DecoratedDateTimeField
{
  private static final long serialVersionUID = -5961050944769862059L;
  private final BasicChronology iChronology;
  
  GJYearOfEraDateTimeField(DateTimeField paramDateTimeField, BasicChronology paramBasicChronology)
  {
    super(paramDateTimeField, DateTimeFieldType.yearOfEra());
    iChronology = paramBasicChronology;
  }
  
  public DurationField getRangeDurationField()
  {
    return iChronology.eras();
  }
  
  public int get(long paramLong)
  {
    int i = getWrappedField().get(paramLong);
    if (i <= 0) {
      i = 1 - i;
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
    FieldUtils.verifyValueBounds(this, paramInt, 1, getMaximumValue());
    if (iChronology.getYear(paramLong) <= 0) {
      paramInt = 1 - paramInt;
    }
    return super.set(paramLong, paramInt);
  }
  
  public int getMinimumValue()
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return getWrappedField().getMaximumValue();
  }
  
  public long roundFloor(long paramLong)
  {
    return getWrappedField().roundFloor(paramLong);
  }
  
  public long roundCeiling(long paramLong)
  {
    return getWrappedField().roundCeiling(paramLong);
  }
  
  public long remainder(long paramLong)
  {
    return getWrappedField().remainder(paramLong);
  }
  
  private Object readResolve()
  {
    return iChronology.yearOfEra();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJYearOfEraDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */