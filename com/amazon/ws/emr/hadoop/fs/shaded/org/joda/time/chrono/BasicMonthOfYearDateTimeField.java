package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.ImpreciseDateTimeField;

class BasicMonthOfYearDateTimeField
  extends ImpreciseDateTimeField
{
  private static final long serialVersionUID = -8258715387168736L;
  private static final int MIN = 1;
  private final BasicChronology iChronology;
  private final int iMax;
  private final int iLeapMonth;
  
  BasicMonthOfYearDateTimeField(BasicChronology paramBasicChronology, int paramInt)
  {
    super(DateTimeFieldType.monthOfYear(), paramBasicChronology.getAverageMillisPerMonth());
    iChronology = paramBasicChronology;
    iMax = iChronology.getMaxMonth();
    iLeapMonth = paramInt;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public int get(long paramLong)
  {
    return iChronology.getMonthOfYear(paramLong);
  }
  
  public long add(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return paramLong;
    }
    long l1 = iChronology.getMillisOfDay(paramLong);
    
    int i = iChronology.getYear(paramLong);
    int j = iChronology.getMonthOfYear(paramLong, i);
    
    int k = i;
    
    int m = j - 1 + paramInt;
    if ((j > 0) && (m < 0))
    {
      k++;
      paramInt -= iMax;
      m = j - 1 + paramInt;
    }
    if (m >= 0)
    {
      k += m / iMax;
      m = m % iMax + 1;
    }
    else
    {
      k = k + m / iMax - 1;
      m = Math.abs(m);
      n = m % iMax;
      if (n == 0) {
        n = iMax;
      }
      m = iMax - n + 1;
      if (m == 1) {
        k++;
      }
    }
    int n = iChronology.getDayOfMonth(paramLong, i, j);
    int i1 = iChronology.getDaysInYearMonth(k, m);
    if (n > i1) {
      n = i1;
    }
    long l2 = iChronology.getYearMonthDayMillis(k, m, n);
    
    return l2 + l1;
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    int i = (int)paramLong2;
    if (i == paramLong2) {
      return add(paramLong1, i);
    }
    long l1 = iChronology.getMillisOfDay(paramLong1);
    
    int j = iChronology.getYear(paramLong1);
    int k = iChronology.getMonthOfYear(paramLong1, j);
    
    long l2 = k - 1 + paramLong2;
    long l3;
    if (l2 >= 0L)
    {
      l3 = j + l2 / iMax;
      l2 = l2 % iMax + 1L;
    }
    else
    {
      l3 = j + l2 / iMax - 1L;
      l2 = Math.abs(l2);
      m = (int)(l2 % iMax);
      if (m == 0) {
        m = iMax;
      }
      l2 = iMax - m + 1;
      if (l2 == 1L) {
        l3 += 1L;
      }
    }
    if ((l3 < iChronology.getMinYear()) || (l3 > iChronology.getMaxYear())) {
      throw new IllegalArgumentException("Magnitude of add amount is too large: " + paramLong2);
    }
    int m = (int)l3;
    int n = (int)l2;
    
    int i1 = iChronology.getDayOfMonth(paramLong1, j, k);
    int i2 = iChronology.getDaysInYearMonth(m, n);
    if (i1 > i2) {
      i1 = i2;
    }
    long l4 = iChronology.getYearMonthDayMillis(m, n, i1);
    
    return l4 + l1;
  }
  
  public int[] add(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramArrayOfInt;
    }
    if ((paramReadablePartial.size() > 0) && (paramReadablePartial.getFieldType(0).equals(DateTimeFieldType.monthOfYear())) && (paramInt1 == 0))
    {
      int i = paramArrayOfInt[0] - 1;
      int j = (i + paramInt2 % 12 + 12) % 12 + 1;
      return set(paramReadablePartial, 0, paramArrayOfInt, j);
    }
    if (DateTimeUtils.isContiguous(paramReadablePartial))
    {
      long l = 0L;
      int k = 0;
      for (int m = paramReadablePartial.size(); k < m; k++) {
        l = paramReadablePartial.getFieldType(k).getField(iChronology).set(l, paramArrayOfInt[k]);
      }
      l = add(l, paramInt2);
      return iChronology.get(paramReadablePartial, l);
    }
    return super.add(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return set(paramLong, FieldUtils.getWrappedValue(get(paramLong), paramInt, 1, iMax));
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -getDifference(paramLong2, paramLong1);
    }
    int i = iChronology.getYear(paramLong1);
    int j = iChronology.getMonthOfYear(paramLong1, i);
    int k = iChronology.getYear(paramLong2);
    int m = iChronology.getMonthOfYear(paramLong2, k);
    
    long l1 = (i - k) * iMax + j - m;
    
    int n = iChronology.getDayOfMonth(paramLong1, i, j);
    if (n == iChronology.getDaysInYearMonth(i, j))
    {
      int i1 = iChronology.getDayOfMonth(paramLong2, k, m);
      if (i1 > n) {
        paramLong2 = iChronology.dayOfMonth().set(paramLong2, n);
      }
    }
    long l2 = paramLong1 - iChronology.getYearMonthMillis(i, j);
    
    long l3 = paramLong2 - iChronology.getYearMonthMillis(k, m);
    if (l2 < l3) {
      l1 -= 1L;
    }
    return l1;
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, 1, iMax);
    
    int i = iChronology.getYear(paramLong);
    
    int j = iChronology.getDayOfMonth(paramLong, i);
    int k = iChronology.getDaysInYearMonth(i, paramInt);
    if (j > k) {
      j = k;
    }
    return iChronology.getYearMonthDayMillis(i, paramInt, j) + iChronology.getMillisOfDay(paramLong);
  }
  
  public DurationField getRangeDurationField()
  {
    return iChronology.years();
  }
  
  public boolean isLeap(long paramLong)
  {
    int i = iChronology.getYear(paramLong);
    if (iChronology.isLeapYear(i)) {
      return iChronology.getMonthOfYear(paramLong, i) == iLeapMonth;
    }
    return false;
  }
  
  public int getLeapAmount(long paramLong)
  {
    return isLeap(paramLong) ? 1 : 0;
  }
  
  public DurationField getLeapDurationField()
  {
    return iChronology.days();
  }
  
  public int getMinimumValue()
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return iMax;
  }
  
  public long roundFloor(long paramLong)
  {
    int i = iChronology.getYear(paramLong);
    int j = iChronology.getMonthOfYear(paramLong, i);
    return iChronology.getYearMonthMillis(i, j);
  }
  
  public long remainder(long paramLong)
  {
    return paramLong - roundFloor(paramLong);
  }
  
  private Object readResolve()
  {
    return iChronology.monthOfYear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicMonthOfYearDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */