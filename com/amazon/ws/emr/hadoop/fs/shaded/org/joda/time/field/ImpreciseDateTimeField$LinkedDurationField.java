package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;

final class ImpreciseDateTimeField$LinkedDurationField
  extends BaseDurationField
{
  private static final long serialVersionUID = -203813474600094134L;
  
  ImpreciseDateTimeField$LinkedDurationField(ImpreciseDateTimeField paramImpreciseDateTimeField, DurationFieldType paramDurationFieldType)
  {
    super(paramDurationFieldType);
  }
  
  public boolean isPrecise()
  {
    return false;
  }
  
  public long getUnitMillis()
  {
    return this$0.iUnitMillis;
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    return this$0.getDifference(paramLong2 + paramLong1, paramLong2);
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    return this$0.getDifferenceAsLong(paramLong2 + paramLong1, paramLong2);
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    return this$0.add(paramLong, paramInt) - paramLong;
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    return this$0.add(paramLong2, paramLong1) - paramLong2;
  }
  
  public long add(long paramLong, int paramInt)
  {
    return this$0.add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return this$0.add(paramLong1, paramLong2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return this$0.getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return this$0.getDifferenceAsLong(paramLong1, paramLong2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ImpreciseDateTimeField.LinkedDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */