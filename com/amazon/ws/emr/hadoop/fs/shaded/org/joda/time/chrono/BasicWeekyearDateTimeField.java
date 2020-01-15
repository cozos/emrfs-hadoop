package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ImpreciseDateTimeField;

final class BasicWeekyearDateTimeField
  extends ImpreciseDateTimeField
{
  private static final long serialVersionUID = 6215066916806820644L;
  private static final long WEEK_53 = 31449600000L;
  private final BasicChronology iChronology;
  
  BasicWeekyearDateTimeField(BasicChronology paramBasicChronology)
  {
    super(DateTimeFieldType.weekyear(), paramBasicChronology.getAverageMillisPerYear());
    iChronology = paramBasicChronology;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public int get(long paramLong)
  {
    return iChronology.getWeekyear(paramLong);
  }
  
  public long add(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return paramLong;
    }
    return set(paramLong, get(paramLong) + paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return add(paramLong1, FieldUtils.safeToInt(paramLong2));
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return add(paramLong, paramInt);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -getDifference(paramLong2, paramLong1);
    }
    int i = get(paramLong1);
    int j = get(paramLong2);
    
    long l1 = remainder(paramLong1);
    long l2 = remainder(paramLong2);
    if ((l2 >= 31449600000L) && (iChronology.getWeeksInYear(i) <= 52)) {
      l2 -= 604800000L;
    }
    int k = i - j;
    if (l1 < l2) {
      k--;
    }
    return k;
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, Math.abs(paramInt), iChronology.getMinYear(), iChronology.getMaxYear());
    
    int i = get(paramLong);
    if (i == paramInt) {
      return paramLong;
    }
    int j = iChronology.getDayOfWeek(paramLong);
    
    int k = iChronology.getWeeksInYear(i);
    int m = iChronology.getWeeksInYear(paramInt);
    int n = m < k ? m : k;
    
    int i1 = iChronology.getWeekOfWeekyear(paramLong);
    if (i1 > n) {
      i1 = n;
    }
    long l = paramLong;
    
    l = iChronology.setYear(l, paramInt);
    
    int i2 = get(l);
    if (i2 < paramInt) {
      l += 604800000L;
    } else if (i2 > paramInt) {
      l -= 604800000L;
    }
    int i3 = iChronology.getWeekOfWeekyear(l);
    
    l += (i1 - i3) * 604800000L;
    
    l = iChronology.dayOfWeek().set(l, j);
    
    return l;
  }
  
  public DurationField getRangeDurationField()
  {
    return null;
  }
  
  public boolean isLeap(long paramLong)
  {
    return iChronology.getWeeksInYear(iChronology.getWeekyear(paramLong)) > 52;
  }
  
  public int getLeapAmount(long paramLong)
  {
    return iChronology.getWeeksInYear(iChronology.getWeekyear(paramLong)) - 52;
  }
  
  public DurationField getLeapDurationField()
  {
    return iChronology.weeks();
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
    paramLong = iChronology.weekOfWeekyear().roundFloor(paramLong);
    int i = iChronology.getWeekOfWeekyear(paramLong);
    if (i > 1) {
      paramLong -= 604800000L * (i - 1);
    }
    return paramLong;
  }
  
  public long remainder(long paramLong)
  {
    return paramLong - roundFloor(paramLong);
  }
  
  private Object readResolve()
  {
    return iChronology.weekyear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicWeekyearDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */