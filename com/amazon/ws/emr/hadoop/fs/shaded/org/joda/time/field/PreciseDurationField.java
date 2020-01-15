package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;

public class PreciseDurationField
  extends BaseDurationField
{
  private static final long serialVersionUID = -8346152187724495365L;
  private final long iUnitMillis;
  
  public PreciseDurationField(DurationFieldType paramDurationFieldType, long paramLong)
  {
    super(paramDurationFieldType);
    iUnitMillis = paramLong;
  }
  
  public final boolean isPrecise()
  {
    return true;
  }
  
  public final long getUnitMillis()
  {
    return iUnitMillis;
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    return paramLong1 / iUnitMillis;
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    return paramInt * iUnitMillis;
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeMultiply(paramLong1, iUnitMillis);
  }
  
  public long add(long paramLong, int paramInt)
  {
    long l = paramInt * iUnitMillis;
    return FieldUtils.safeAdd(paramLong, l);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    long l = FieldUtils.safeMultiply(paramLong2, iUnitMillis);
    return FieldUtils.safeAdd(paramLong1, l);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    long l = FieldUtils.safeSubtract(paramLong1, paramLong2);
    return l / iUnitMillis;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof PreciseDurationField))
    {
      PreciseDurationField localPreciseDurationField = (PreciseDurationField)paramObject;
      return (getType() == localPreciseDurationField.getType()) && (iUnitMillis == iUnitMillis);
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = iUnitMillis;
    int i = (int)(l ^ l >>> 32);
    i += getType().hashCode();
    return i;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */