package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDurationField;

class ZonedChronology$ZonedDurationField
  extends BaseDurationField
{
  private static final long serialVersionUID = -485345310999208286L;
  final DurationField iField;
  final boolean iTimeField;
  final DateTimeZone iZone;
  
  ZonedChronology$ZonedDurationField(DurationField paramDurationField, DateTimeZone paramDateTimeZone)
  {
    super(paramDurationField.getType());
    if (!paramDurationField.isSupported()) {
      throw new IllegalArgumentException();
    }
    iField = paramDurationField;
    iTimeField = ZonedChronology.useTimeArithmetic(paramDurationField);
    iZone = paramDateTimeZone;
  }
  
  public boolean isPrecise()
  {
    return (iField.isPrecise()) && (iZone.isFixed()) ? true : iTimeField ? iField.isPrecise() : false;
  }
  
  public long getUnitMillis()
  {
    return iField.getUnitMillis();
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    return iField.getValue(paramLong1, addOffset(paramLong2));
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    return iField.getValueAsLong(paramLong1, addOffset(paramLong2));
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    return iField.getMillis(paramInt, addOffset(paramLong));
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    return iField.getMillis(paramLong1, addOffset(paramLong2));
  }
  
  public long add(long paramLong, int paramInt)
  {
    int i = getOffsetToAdd(paramLong);
    paramLong = iField.add(paramLong + i, paramInt);
    return paramLong - (iTimeField ? i : getOffsetFromLocalToSubtract(paramLong));
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    int i = getOffsetToAdd(paramLong1);
    paramLong1 = iField.add(paramLong1 + i, paramLong2);
    return paramLong1 - (iTimeField ? i : getOffsetFromLocalToSubtract(paramLong1));
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    int i = getOffsetToAdd(paramLong2);
    return iField.getDifference(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    int i = getOffsetToAdd(paramLong2);
    return iField.getDifferenceAsLong(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
  }
  
  private int getOffsetToAdd(long paramLong)
  {
    int i = iZone.getOffset(paramLong);
    long l = paramLong + i;
    if (((paramLong ^ l) < 0L) && ((paramLong ^ i) >= 0L)) {
      throw new ArithmeticException("Adding time zone offset caused overflow");
    }
    return i;
  }
  
  private int getOffsetFromLocalToSubtract(long paramLong)
  {
    int i = iZone.getOffsetFromLocal(paramLong);
    long l = paramLong - i;
    if (((paramLong ^ l) < 0L) && ((paramLong ^ i) < 0L)) {
      throw new ArithmeticException("Subtracting time zone offset caused overflow");
    }
    return i;
  }
  
  private long addOffset(long paramLong)
  {
    return iZone.convertUTCToLocal(paramLong);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof ZonedDurationField))
    {
      ZonedDurationField localZonedDurationField = (ZonedDurationField)paramObject;
      return (iField.equals(iField)) && (iZone.equals(iZone));
    }
    return false;
  }
  
  public int hashCode()
  {
    return iField.hashCode() ^ iZone.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ZonedChronology.ZonedDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */