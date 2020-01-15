package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDurationField;

class LimitChronology$LimitDurationField
  extends DecoratedDurationField
{
  private static final long serialVersionUID = 8049297699408782284L;
  
  LimitChronology$LimitDurationField(LimitChronology paramLimitChronology, DurationField paramDurationField)
  {
    super(paramDurationField, paramDurationField.getType());
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong2, null);
    return getWrappedField().getValue(paramLong1, paramLong2);
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong2, null);
    return getWrappedField().getValueAsLong(paramLong1, paramLong2);
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    this$0.checkLimits(paramLong, null);
    return getWrappedField().getMillis(paramInt, paramLong);
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong2, null);
    return getWrappedField().getMillis(paramLong1, paramLong2);
  }
  
  public long add(long paramLong, int paramInt)
  {
    this$0.checkLimits(paramLong, null);
    long l = getWrappedField().add(paramLong, paramInt);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong1, null);
    long l = getWrappedField().add(paramLong1, paramLong2);
    this$0.checkLimits(l, "resulting");
    return l;
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong1, "minuend");
    this$0.checkLimits(paramLong2, "subtrahend");
    return getWrappedField().getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    this$0.checkLimits(paramLong1, "minuend");
    this$0.checkLimits(paramLong2, "subtrahend");
    return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.LimitChronology.LimitDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */