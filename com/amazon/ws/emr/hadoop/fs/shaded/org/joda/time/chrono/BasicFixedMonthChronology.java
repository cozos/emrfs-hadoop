package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;

abstract class BasicFixedMonthChronology
  extends BasicChronology
{
  private static final long serialVersionUID = 261387371998L;
  static final int MONTH_LENGTH = 30;
  static final long MILLIS_PER_YEAR = 31557600000L;
  static final long MILLIS_PER_MONTH = 2592000000L;
  
  BasicFixedMonthChronology(Chronology paramChronology, Object paramObject, int paramInt)
  {
    super(paramChronology, paramObject, paramInt);
  }
  
  long setYear(long paramLong, int paramInt)
  {
    int i = getYear(paramLong);
    int j = getDayOfYear(paramLong, i);
    int k = getMillisOfDay(paramLong);
    if (j > 365) {
      if (!isLeapYear(paramInt)) {
        j--;
      }
    }
    paramLong = getYearMonthDayMillis(paramInt, 1, j);
    paramLong += k;
    return paramLong;
  }
  
  long getYearDifference(long paramLong1, long paramLong2)
  {
    int i = getYear(paramLong1);
    int j = getYear(paramLong2);
    
    long l1 = paramLong1 - getYearMillis(i);
    long l2 = paramLong2 - getYearMillis(j);
    
    int k = i - j;
    if (l1 < l2) {
      k--;
    }
    return k;
  }
  
  long getTotalMillisByYearMonth(int paramInt1, int paramInt2)
  {
    return (paramInt2 - 1) * 2592000000L;
  }
  
  int getDayOfMonth(long paramLong)
  {
    return (getDayOfYear(paramLong) - 1) % 30 + 1;
  }
  
  boolean isLeapYear(int paramInt)
  {
    return (paramInt & 0x3) == 3;
  }
  
  int getDaysInYearMonth(int paramInt1, int paramInt2)
  {
    return isLeapYear(paramInt1) ? 6 : paramInt2 != 13 ? 30 : 5;
  }
  
  int getDaysInMonthMax()
  {
    return 30;
  }
  
  int getDaysInMonthMax(int paramInt)
  {
    return paramInt != 13 ? 30 : 6;
  }
  
  int getMonthOfYear(long paramLong)
  {
    return (getDayOfYear(paramLong) - 1) / 30 + 1;
  }
  
  int getMonthOfYear(long paramLong, int paramInt)
  {
    long l = (paramLong - getYearMillis(paramInt)) / 2592000000L;
    return (int)l + 1;
  }
  
  int getMaxMonth()
  {
    return 13;
  }
  
  long getAverageMillisPerYear()
  {
    return 31557600000L;
  }
  
  long getAverageMillisPerYearDividedByTwo()
  {
    return 15778800000L;
  }
  
  long getAverageMillisPerMonth()
  {
    return 2592000000L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicFixedMonthChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */