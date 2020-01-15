package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ImpreciseDateTimeField;

class BasicYearDateTimeField
  extends ImpreciseDateTimeField
{
  private static final long serialVersionUID = -98628754872287L;
  protected final BasicChronology iChronology;
  
  BasicYearDateTimeField(BasicChronology paramBasicChronology)
  {
    super(DateTimeFieldType.year(), paramBasicChronology.getAverageMillisPerYear());
    iChronology = paramBasicChronology;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public int get(long paramLong)
  {
    return iChronology.getYear(paramLong);
  }
  
  public long add(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return paramLong;
    }
    int i = get(paramLong);
    int j = FieldUtils.safeAdd(i, paramInt);
    return set(paramLong, j);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return add(paramLong1, FieldUtils.safeToInt(paramLong2));
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return paramLong;
    }
    int i = iChronology.getYear(paramLong);
    int j = FieldUtils.getWrappedValue(i, paramInt, iChronology.getMinYear(), iChronology.getMaxYear());
    
    return set(paramLong, j);
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, iChronology.getMinYear(), iChronology.getMaxYear());
    
    return iChronology.setYear(paramLong, paramInt);
  }
  
  public long setExtended(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, iChronology.getMinYear() - 1, iChronology.getMaxYear() + 1);
    
    return iChronology.setYear(paramLong, paramInt);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -iChronology.getYearDifference(paramLong2, paramLong1);
    }
    return iChronology.getYearDifference(paramLong1, paramLong2);
  }
  
  public DurationField getRangeDurationField()
  {
    return null;
  }
  
  public boolean isLeap(long paramLong)
  {
    return iChronology.isLeapYear(get(paramLong));
  }
  
  public int getLeapAmount(long paramLong)
  {
    if (iChronology.isLeapYear(get(paramLong))) {
      return 1;
    }
    return 0;
  }
  
  public DurationField getLeapDurationField()
  {
    return iChronology.days();
  }
  
  public int getMinimumValue()
  {
    return iChronology.getMinYear();
  }
  
  public int getMaximumValue()
  {
    return iChronology.getMaxYear();
  }
  
  public long roundFloor(long paramLong)
  {
    return iChronology.getYearMillis(get(paramLong));
  }
  
  public long roundCeiling(long paramLong)
  {
    int i = get(paramLong);
    long l = iChronology.getYearMillis(i);
    if (paramLong != l) {
      paramLong = iChronology.getYearMillis(i + 1);
    }
    return paramLong;
  }
  
  public long remainder(long paramLong)
  {
    return paramLong - roundFloor(paramLong);
  }
  
  private Object readResolve()
  {
    return iChronology.year();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicYearDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */