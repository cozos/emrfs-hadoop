package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class GregorianChronology
  extends BasicGJChronology
{
  private static final ConcurrentHashMap<DateTimeZone, GregorianChronology[]> cCache = new ConcurrentHashMap();
  private static final GregorianChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
  private static final int MAX_YEAR = 292278993;
  private static final int MIN_YEAR = -292275054;
  private static final int DAYS_0000_TO_1970 = 719527;
  private static final long MILLIS_PER_MONTH = 2629746000L;
  private static final long MILLIS_PER_YEAR = 31556952000L;
  private static final long serialVersionUID = -861407383323710522L;
  
  public static GregorianChronology getInstanceUTC()
  {
    return INSTANCE_UTC;
  }
  
  public static GregorianChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault(), 4);
  }
  
  public static GregorianChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    return getInstance(paramDateTimeZone, 4);
  }
  
  public static GregorianChronology getInstance(DateTimeZone paramDateTimeZone, int paramInt)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    Object localObject1 = (GregorianChronology[])cCache.get(paramDateTimeZone);
    if (localObject1 == null)
    {
      localObject1 = new GregorianChronology[7];
      GregorianChronology[] arrayOfGregorianChronology = (GregorianChronology[])cCache.putIfAbsent(paramDateTimeZone, localObject1);
      if (arrayOfGregorianChronology != null) {
        localObject1 = arrayOfGregorianChronology;
      }
    }
    GregorianChronology localGregorianChronology;
    try
    {
      localGregorianChronology = localObject1[(paramInt - 1)];
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("Invalid min days in first week: " + paramInt);
    }
    if (localGregorianChronology == null) {
      synchronized (localObject1)
      {
        localGregorianChronology = localObject1[(paramInt - 1)];
        if (localGregorianChronology == null)
        {
          if (paramDateTimeZone == DateTimeZone.UTC)
          {
            localGregorianChronology = new GregorianChronology(null, null, paramInt);
          }
          else
          {
            localGregorianChronology = getInstance(DateTimeZone.UTC, paramInt);
            localGregorianChronology = new GregorianChronology(ZonedChronology.getInstance(localGregorianChronology, paramDateTimeZone), null, paramInt);
          }
          localObject1[(paramInt - 1)] = localGregorianChronology;
        }
      }
    }
    return localGregorianChronology;
  }
  
  private GregorianChronology(Chronology paramChronology, Object paramObject, int paramInt)
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
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    if (getBase() == null) {
      super.assemble(paramFields);
    }
  }
  
  boolean isLeapYear(int paramInt)
  {
    return ((paramInt & 0x3) == 0) && ((paramInt % 100 != 0) || (paramInt % 400 == 0));
  }
  
  long calculateFirstDayOfYearMillis(int paramInt)
  {
    int i = paramInt / 100;
    if (paramInt < 0)
    {
      i = (paramInt + 3 >> 2) - i + (i + 3 >> 2) - 1;
    }
    else
    {
      i = (paramInt >> 2) - i + (i >> 2);
      if (isLeapYear(paramInt)) {
        i--;
      }
    }
    return (paramInt * 365L + (i - 719527)) * 86400000L;
  }
  
  int getMinYear()
  {
    return -292275054;
  }
  
  int getMaxYear()
  {
    return 292278993;
  }
  
  long getAverageMillisPerYear()
  {
    return 31556952000L;
  }
  
  long getAverageMillisPerYearDividedByTwo()
  {
    return 15778476000L;
  }
  
  long getAverageMillisPerMonth()
  {
    return 2629746000L;
  }
  
  long getApproxMillisAtEpochDividedByTwo()
  {
    return 31083597720000L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GregorianChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */