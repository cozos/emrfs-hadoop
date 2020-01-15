package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class IslamicChronology
  extends BasicChronology
{
  private static final long serialVersionUID = -3663823829888L;
  public static final int AH = 1;
  private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("AH");
  public static final LeapYearPatternType LEAP_YEAR_15_BASED = new LeapYearPatternType(0, 623158436);
  public static final LeapYearPatternType LEAP_YEAR_16_BASED = new LeapYearPatternType(1, 623191204);
  public static final LeapYearPatternType LEAP_YEAR_INDIAN = new LeapYearPatternType(2, 690562340);
  public static final LeapYearPatternType LEAP_YEAR_HABASH_AL_HASIB = new LeapYearPatternType(3, 153692453);
  private static final int MIN_YEAR = -292269337;
  private static final int MAX_YEAR = 292271022;
  private static final int MONTH_PAIR_LENGTH = 59;
  private static final int LONG_MONTH_LENGTH = 30;
  private static final int SHORT_MONTH_LENGTH = 29;
  private static final long MILLIS_PER_MONTH_PAIR = 5097600000L;
  private static final long MILLIS_PER_MONTH = 2551440384L;
  private static final long MILLIS_PER_LONG_MONTH = 2592000000L;
  private static final long MILLIS_PER_YEAR = 30617280288L;
  private static final long MILLIS_PER_SHORT_YEAR = 30585600000L;
  private static final long MILLIS_PER_LONG_YEAR = 30672000000L;
  private static final long MILLIS_YEAR_1 = -42521587200000L;
  private static final int CYCLE = 30;
  private static final long MILLIS_PER_CYCLE = 918518400000L;
  private static final ConcurrentHashMap<DateTimeZone, IslamicChronology[]> cCache = new ConcurrentHashMap();
  private static final IslamicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
  private final LeapYearPatternType iLeapYears;
  
  public static IslamicChronology getInstanceUTC()
  {
    return INSTANCE_UTC;
  }
  
  public static IslamicChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault(), LEAP_YEAR_16_BASED);
  }
  
  public static IslamicChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    return getInstance(paramDateTimeZone, LEAP_YEAR_16_BASED);
  }
  
  public static IslamicChronology getInstance(DateTimeZone paramDateTimeZone, LeapYearPatternType paramLeapYearPatternType)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    Object localObject1 = (IslamicChronology[])cCache.get(paramDateTimeZone);
    if (localObject1 == null)
    {
      localObject1 = new IslamicChronology[4];
      IslamicChronology[] arrayOfIslamicChronology = (IslamicChronology[])cCache.putIfAbsent(paramDateTimeZone, localObject1);
      if (arrayOfIslamicChronology != null) {
        localObject1 = arrayOfIslamicChronology;
      }
    }
    IslamicChronology localIslamicChronology = localObject1[index];
    if (localIslamicChronology == null) {
      synchronized (localObject1)
      {
        localIslamicChronology = localObject1[index];
        if (localIslamicChronology == null)
        {
          if (paramDateTimeZone == DateTimeZone.UTC)
          {
            localIslamicChronology = new IslamicChronology(null, null, paramLeapYearPatternType);
            
            DateTime localDateTime = new DateTime(1, 1, 1, 0, 0, 0, 0, localIslamicChronology);
            localIslamicChronology = new IslamicChronology(LimitChronology.getInstance(localIslamicChronology, localDateTime, null), null, paramLeapYearPatternType);
          }
          else
          {
            localIslamicChronology = getInstance(DateTimeZone.UTC, paramLeapYearPatternType);
            localIslamicChronology = new IslamicChronology(ZonedChronology.getInstance(localIslamicChronology, paramDateTimeZone), null, paramLeapYearPatternType);
          }
          localObject1[index] = localIslamicChronology;
        }
      }
    }
    return localIslamicChronology;
  }
  
  IslamicChronology(Chronology paramChronology, Object paramObject, LeapYearPatternType paramLeapYearPatternType)
  {
    super(paramChronology, paramObject, 4);
    iLeapYears = paramLeapYearPatternType;
  }
  
  private Object readResolve()
  {
    Chronology localChronology = getBase();
    return localChronology == null ? getInstanceUTC() : getInstance(localChronology.getZone());
  }
  
  public LeapYearPatternType getLeapYearPatternType()
  {
    return iLeapYears;
  }
  
  public Chronology withUTC()
  {
    return INSTANCE_UTC;
  }
  
  public Chronology withZone(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    if (paramDateTimeZone == getZone()) {
      return this;
    }
    return getInstance(paramDateTimeZone);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof IslamicChronology))
    {
      IslamicChronology localIslamicChronology = (IslamicChronology)paramObject;
      return (getLeapYearPatternTypeindex == getLeapYearPatternTypeindex) && (super.equals(paramObject));
    }
    return false;
  }
  
  public int hashCode()
  {
    return super.hashCode() * 13 + getLeapYearPatternType().hashCode();
  }
  
  int getYear(long paramLong)
  {
    long l1 = paramLong - -42521587200000L;
    long l2 = l1 / 918518400000L;
    long l3 = l1 % 918518400000L;
    
    int i = (int)(l2 * 30L + 1L);
    long l4 = isLeapYear(i) ? 30672000000L : 30585600000L;
    while (l3 >= l4)
    {
      l3 -= l4;
      l4 = isLeapYear(++i) ? 30672000000L : 30585600000L;
    }
    return i;
  }
  
  long setYear(long paramLong, int paramInt)
  {
    int i = getYear(paramLong);
    int j = getDayOfYear(paramLong, i);
    int k = getMillisOfDay(paramLong);
    if ((j > 354) && (!isLeapYear(paramInt))) {
      j--;
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
    
    if (paramInt2 % 2 == 1)
    {
      paramInt2 /= 2;
      return paramInt2 * 5097600000L + 2592000000L;
    }
    paramInt2 /= 2;
    return paramInt2 * 5097600000L;
  }
  
  int getDayOfMonth(long paramLong)
  {
    int i = getDayOfYear(paramLong) - 1;
    if (i == 354) {
      return 30;
    }
    return i % 59 % 30 + 1;
  }
  
  boolean isLeapYear(int paramInt)
  {
    return iLeapYears.isLeapYear(paramInt);
  }
  
  int getDaysInYearMax()
  {
    return 355;
  }
  
  int getDaysInYear(int paramInt)
  {
    return isLeapYear(paramInt) ? 355 : 354;
  }
  
  int getDaysInYearMonth(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 12) && (isLeapYear(paramInt1))) {
      return 30;
    }
    paramInt2--;return paramInt2 % 2 == 0 ? 30 : 29;
  }
  
  int getDaysInMonthMax()
  {
    return 30;
  }
  
  int getDaysInMonthMax(int paramInt)
  {
    if (paramInt == 12) {
      return 30;
    }
    paramInt--;return paramInt % 2 == 0 ? 30 : 29;
  }
  
  int getMonthOfYear(long paramLong, int paramInt)
  {
    int i = (int)((paramLong - getYearMillis(paramInt)) / 86400000L);
    if (i == 354) {
      return 12;
    }
    return i * 2 / 59 + 1;
  }
  
  long getAverageMillisPerYear()
  {
    return 30617280288L;
  }
  
  long getAverageMillisPerYearDividedByTwo()
  {
    return 15308640144L;
  }
  
  long getAverageMillisPerMonth()
  {
    return 2551440384L;
  }
  
  long calculateFirstDayOfYearMillis(int paramInt)
  {
    if (paramInt > 292271022) {
      throw new ArithmeticException("Year is too large: " + paramInt + " > " + 292271022);
    }
    if (paramInt < -292269337) {
      throw new ArithmeticException("Year is too small: " + paramInt + " < " + -292269337);
    }
    paramInt--;
    long l1 = paramInt / 30;
    long l2 = -42521587200000L + l1 * 918518400000L;
    int i = paramInt % 30 + 1;
    for (int j = 1; j < i; j++) {
      l2 += (isLeapYear(j) ? 30672000000L : 30585600000L);
    }
    return l2;
  }
  
  int getMinYear()
  {
    return 1;
  }
  
  int getMaxYear()
  {
    return 292271022;
  }
  
  long getApproxMillisAtEpochDividedByTwo()
  {
    return 21260793600000L;
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    if (getBase() == null)
    {
      super.assemble(paramFields);
      
      era = ERA_FIELD;
      monthOfYear = new BasicMonthOfYearDateTimeField(this, 12);
      months = monthOfYear.getDurationField();
    }
  }
  
  public static class LeapYearPatternType
    implements Serializable
  {
    private static final long serialVersionUID = 26581275372698L;
    final byte index;
    final int pattern;
    
    LeapYearPatternType(int paramInt1, int paramInt2)
    {
      index = ((byte)paramInt1);
      pattern = paramInt2;
    }
    
    boolean isLeapYear(int paramInt)
    {
      int i = 1 << paramInt % 30;
      return (pattern & i) > 0;
    }
    
    private Object readResolve()
    {
      switch (index)
      {
      case 0: 
        return IslamicChronology.LEAP_YEAR_15_BASED;
      case 1: 
        return IslamicChronology.LEAP_YEAR_16_BASED;
      case 2: 
        return IslamicChronology.LEAP_YEAR_INDIAN;
      case 3: 
        return IslamicChronology.LEAP_YEAR_HABASH_AL_HASIB;
      }
      return this;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof LeapYearPatternType)) {
        return index == index;
      }
      return false;
    }
    
    public int hashCode()
    {
      return index;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.IslamicChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */