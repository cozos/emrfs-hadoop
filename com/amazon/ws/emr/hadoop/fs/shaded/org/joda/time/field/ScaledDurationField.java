package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;

public class ScaledDurationField
  extends DecoratedDurationField
{
  private static final long serialVersionUID = -3205227092378684157L;
  private final int iScalar;
  
  public ScaledDurationField(DurationField paramDurationField, DurationFieldType paramDurationFieldType, int paramInt)
  {
    super(paramDurationField, paramDurationFieldType);
    if ((paramInt == 0) || (paramInt == 1)) {
      throw new IllegalArgumentException("The scalar must not be 0 or 1");
    }
    iScalar = paramInt;
  }
  
  public int getValue(long paramLong)
  {
    return getWrappedField().getValue(paramLong) / iScalar;
  }
  
  public long getValueAsLong(long paramLong)
  {
    return getWrappedField().getValueAsLong(paramLong) / iScalar;
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    return getWrappedField().getValue(paramLong1, paramLong2) / iScalar;
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    return getWrappedField().getValueAsLong(paramLong1, paramLong2) / iScalar;
  }
  
  public long getMillis(int paramInt)
  {
    long l = paramInt * iScalar;
    return getWrappedField().getMillis(l);
  }
  
  public long getMillis(long paramLong)
  {
    long l = FieldUtils.safeMultiply(paramLong, iScalar);
    return getWrappedField().getMillis(l);
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    long l = paramInt * iScalar;
    return getWrappedField().getMillis(l, paramLong);
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    long l = FieldUtils.safeMultiply(paramLong1, iScalar);
    return getWrappedField().getMillis(l, paramLong2);
  }
  
  public long add(long paramLong, int paramInt)
  {
    long l = paramInt * iScalar;
    return getWrappedField().add(paramLong, l);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    long l = FieldUtils.safeMultiply(paramLong2, iScalar);
    return getWrappedField().add(paramLong1, l);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifference(paramLong1, paramLong2) / iScalar;
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2) / iScalar;
  }
  
  public long getUnitMillis()
  {
    return getWrappedField().getUnitMillis() * iScalar;
  }
  
  public int getScalar()
  {
    return iScalar;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof ScaledDurationField))
    {
      ScaledDurationField localScaledDurationField = (ScaledDurationField)paramObject;
      return (getWrappedField().equals(localScaledDurationField.getWrappedField())) && (getType() == localScaledDurationField.getType()) && (iScalar == iScalar);
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = iScalar;
    int i = (int)(l ^ l >>> 32);
    i += getType().hashCode();
    i += getWrappedField().hashCode();
    return i;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ScaledDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */