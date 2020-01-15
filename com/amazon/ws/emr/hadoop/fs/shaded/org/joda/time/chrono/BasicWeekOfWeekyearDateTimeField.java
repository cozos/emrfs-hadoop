package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDurationDateTimeField;

final class BasicWeekOfWeekyearDateTimeField
  extends PreciseDurationDateTimeField
{
  private static final long serialVersionUID = -1587436826395135328L;
  private final BasicChronology iChronology;
  
  BasicWeekOfWeekyearDateTimeField(BasicChronology paramBasicChronology, DurationField paramDurationField)
  {
    super(DateTimeFieldType.weekOfWeekyear(), paramDurationField);
    iChronology = paramBasicChronology;
  }
  
  public int get(long paramLong)
  {
    return iChronology.getWeekOfWeekyear(paramLong);
  }
  
  public DurationField getRangeDurationField()
  {
    return iChronology.weekyears();
  }
  
  public long roundFloor(long paramLong)
  {
    return super.roundFloor(paramLong + 259200000L) - 259200000L;
  }
  
  public long roundCeiling(long paramLong)
  {
    return super.roundCeiling(paramLong + 259200000L) - 259200000L;
  }
  
  public long remainder(long paramLong)
  {
    return super.remainder(paramLong + 259200000L);
  }
  
  public int getMinimumValue()
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return 53;
  }
  
  public int getMaximumValue(long paramLong)
  {
    int i = iChronology.getWeekyear(paramLong);
    return iChronology.getWeeksInYear(i);
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial.isSupported(DateTimeFieldType.weekyear()))
    {
      int i = paramReadablePartial.get(DateTimeFieldType.weekyear());
      return iChronology.getWeeksInYear(i);
    }
    return 53;
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    int i = paramReadablePartial.size();
    for (int j = 0; j < i; j++) {
      if (paramReadablePartial.getFieldType(j) == DateTimeFieldType.weekyear())
      {
        int k = paramArrayOfInt[j];
        return iChronology.getWeeksInYear(k);
      }
    }
    return 53;
  }
  
  protected int getMaximumValueForSet(long paramLong, int paramInt)
  {
    return paramInt > 52 ? getMaximumValue(paramLong) : 52;
  }
  
  private Object readResolve()
  {
    return iChronology.weekOfWeekyear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicWeekOfWeekyearDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */