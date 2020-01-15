package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDurationDateTimeField;

final class BasicDayOfYearDateTimeField
  extends PreciseDurationDateTimeField
{
  private static final long serialVersionUID = -6821236822336841037L;
  private final BasicChronology iChronology;
  
  BasicDayOfYearDateTimeField(BasicChronology paramBasicChronology, DurationField paramDurationField)
  {
    super(DateTimeFieldType.dayOfYear(), paramDurationField);
    iChronology = paramBasicChronology;
  }
  
  public int get(long paramLong)
  {
    return iChronology.getDayOfYear(paramLong);
  }
  
  public DurationField getRangeDurationField()
  {
    return iChronology.years();
  }
  
  public int getMinimumValue()
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return iChronology.getDaysInYearMax();
  }
  
  public int getMaximumValue(long paramLong)
  {
    int i = iChronology.getYear(paramLong);
    return iChronology.getDaysInYear(i);
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial.isSupported(DateTimeFieldType.year()))
    {
      int i = paramReadablePartial.get(DateTimeFieldType.year());
      return iChronology.getDaysInYear(i);
    }
    return iChronology.getDaysInYearMax();
  }
  
  public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
  {
    int i = paramReadablePartial.size();
    for (int j = 0; j < i; j++) {
      if (paramReadablePartial.getFieldType(j) == DateTimeFieldType.year())
      {
        int k = paramArrayOfInt[j];
        return iChronology.getDaysInYear(k);
      }
    }
    return iChronology.getDaysInYearMax();
  }
  
  protected int getMaximumValueForSet(long paramLong, int paramInt)
  {
    int i = iChronology.getDaysInYearMax() - 1;
    return (paramInt > i) || (paramInt < 1) ? getMaximumValue(paramLong) : i;
  }
  
  public boolean isLeap(long paramLong)
  {
    return iChronology.isLeapDay(paramLong);
  }
  
  private Object readResolve()
  {
    return iChronology.dayOfYear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicDayOfYearDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */