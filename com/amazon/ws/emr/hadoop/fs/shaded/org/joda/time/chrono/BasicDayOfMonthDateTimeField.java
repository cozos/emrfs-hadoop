package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDurationDateTimeField;

final class BasicDayOfMonthDateTimeField
  extends PreciseDurationDateTimeField
{
  private static final long serialVersionUID = -4677223814028011723L;
  private final BasicChronology iChronology;
  
  BasicDayOfMonthDateTimeField(BasicChronology paramBasicChronology, DurationField paramDurationField)
  {
    super(DateTimeFieldType.dayOfMonth(), paramDurationField);
    iChronology = paramBasicChronology;
  }
  
  public int get(long paramLong)
  {
    return iChronology.getDayOfMonth(paramLong);
  }
  
  public DurationField getRangeDurationField()
  {
    return iChronology.months();
  }
  
  public int getMinimumValue()
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return iChronology.getDaysInMonthMax();
  }
  
  public int getMaximumValue(long paramLong)
  {
    return iChronology.getDaysInMonthMax(paramLong);
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial.isSupported(DateTimeFieldType.monthOfYear()))
    {
      int i = paramReadablePartial.get(DateTimeFieldType.monthOfYear());
      if (paramReadablePartial.isSupported(DateTimeFieldType.year()))
      {
        int j = paramReadablePartial.get(DateTimeFieldType.year());
        return iChronology.getDaysInYearMonth(j, i);
      }
      return iChronology.getDaysInMonthMax(i);
    }
    return getMaximumValue();
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    int i = paramReadablePartial.size();
    for (int j = 0; j < i; j++) {
      if (paramReadablePartial.getFieldType(j) == DateTimeFieldType.monthOfYear())
      {
        int k = paramArrayOfInt[j];
        for (int m = 0; m < i; m++) {
          if (paramReadablePartial.getFieldType(m) == DateTimeFieldType.year())
          {
            int n = paramArrayOfInt[m];
            return iChronology.getDaysInYearMonth(n, k);
          }
        }
        return iChronology.getDaysInMonthMax(k);
      }
    }
    return getMaximumValue();
  }
  
  protected int getMaximumValueForSet(long paramLong, int paramInt)
  {
    return iChronology.getDaysInMonthMaxForSet(paramLong, paramInt);
  }
  
  public boolean isLeap(long paramLong)
  {
    return iChronology.isLeapDay(paramLong);
  }
  
  private Object readResolve()
  {
    return iChronology.dayOfMonth();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicDayOfMonthDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */