package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDurationField;

class GJChronology$LinkedDurationField
  extends DecoratedDurationField
{
  private static final long serialVersionUID = 4097975388007713084L;
  private final GJChronology.ImpreciseCutoverField iField;
  
  GJChronology$LinkedDurationField(DurationField paramDurationField, GJChronology.ImpreciseCutoverField paramImpreciseCutoverField)
  {
    super(paramDurationField, paramDurationField.getType());
    iField = paramImpreciseCutoverField;
  }
  
  public long add(long paramLong, int paramInt)
  {
    return iField.add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return iField.add(paramLong1, paramLong2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return iField.getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return iField.getDifferenceAsLong(paramLong1, paramLong2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJChronology.LinkedDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */