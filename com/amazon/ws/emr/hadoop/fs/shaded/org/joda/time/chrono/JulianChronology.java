package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.SkipDateTimeField;
import java.util.concurrent.ConcurrentHashMap;

public final class JulianChronology
  extends BasicGJChronology
{
  private static final ConcurrentHashMap<DateTimeZone, JulianChronology[]> cCache = new ConcurrentHashMap();
  private static final JulianChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
  private static final int MAX_YEAR = 292272992;
  private static final int MIN_YEAR = -292269054;
  private static final long MILLIS_PER_MONTH = 2629800000L;
  private static final long MILLIS_PER_YEAR = 31557600000L;
  private static final long serialVersionUID = -8731039522547897247L;
  
  static int adjustYearForSet(int paramInt)
  {
    if (paramInt <= 0)
    {
      if (paramInt == 0) {
        throw new IllegalFieldValueException(DateTimeFieldType.year(), Integer.valueOf(paramInt), null, null);
      }
      paramInt++;
    }
    return paramInt;
  }
  
  public static JulianChronology getInstanceUTC()
  {
    return INSTANCE_UTC;
  }
  
  public static JulianChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault(), 4);
  }
  
  public static JulianChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    return getInstance(paramDateTimeZone, 4);
  }
  
  public static JulianChronology getInstance(DateTimeZone paramDateTimeZone, int paramInt)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    Object localObject1 = (JulianChronology[])cCache.get(paramDateTimeZone);
    if (localObject1 == null)
    {
      localObject1 = new JulianChronology[7];
      JulianChronology[] arrayOfJulianChronology = (JulianChronology[])cCache.putIfAbsent(paramDateTimeZone, localObject1);
      if (arrayOfJulianChronology != null) {
        localObject1 = arrayOfJulianChronology;
      }
    }
    JulianChronology localJulianChronology;
    try
    {
      localJulianChronology = localObject1[(paramInt - 1)];
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("Invalid min days in first week: " + paramInt);
    }
    if (localJulianChronology == null) {
      synchronized (localObject1)
      {
        localJulianChronology = localObject1[(paramInt - 1)];
        if (localJulianChronology == null)
        {
          if (paramDateTimeZone == DateTimeZone.UTC)
          {
            localJulianChronology = new JulianChronology(null, null, paramInt);
          }
          else
          {
            localJulianChronology = getInstance(DateTimeZone.UTC, paramInt);
            localJulianChronology = new JulianChronology(ZonedChronology.getInstance(localJulianChronology, paramDateTimeZone), null, paramInt);
          }
          localObject1[(paramInt - 1)] = localJulianChronology;
        }
      }
    }
    return localJulianChronology;
  }
  
  JulianChronology(Chronology paramChronology, Object paramObject, int paramInt)
  {
    super(paramChronology, paramObject, paramInt);
  }
  
  private Object readResolve()
  {
    Chronology localChronology = getBase();
    int i = getMinimumDaysInFirstWeek();
    i = i == 0 ? 4 : i;
    return localChronology == null ? getInstance(DateTimeZone.UTC, i) : getInstance(localChronology.getZone(), i);
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
  
  long getDateMidnightMillis(int paramInt1, int paramInt2, int paramInt3)
    throws IllegalArgumentException
  {
    return super.getDateMidnightMillis(adjustYearForSet(paramInt1), paramInt2, paramInt3);
  }
  
  boolean isLeapYear(int paramInt)
  {
    return (paramInt & 0x3) == 0;
  }
  
  long calculateFirstDayOfYearMillis(int paramInt)
  {
    int i = paramInt - 1968;
    int j;
    if (i <= 0)
    {
      j = i + 3 >> 2;
    }
    else
    {
      j = i >> 2;
      if (!isLeapYear(paramInt)) {
        j++;
      }
    }
    long l = (i * 365L + j) * 86400000L;
    
    return l - 62035200000L;
  }
  
  int getMinYear()
  {
    return -292269054;
  }
  
  int getMaxYear()
  {
    return 292272992;
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
    return 2629800000L;
  }
  
  long getApproxMillisAtEpochDividedByTwo()
  {
    return 31083663600000L;
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    if (getBase() == null)
    {
      super.assemble(paramFields);
      
      year = new SkipDateTimeField(this, year);
      weekyear = new SkipDateTimeField(this, weekyear);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.JulianChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */