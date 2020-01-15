package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.SkipDateTimeField;
import java.util.concurrent.ConcurrentHashMap;

public final class EthiopicChronology
  extends BasicFixedMonthChronology
{
  private static final long serialVersionUID = -5972804258688333942L;
  public static final int EE = 1;
  private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("EE");
  private static final int MIN_YEAR = -292269337;
  private static final int MAX_YEAR = 292272984;
  private static final ConcurrentHashMap<DateTimeZone, EthiopicChronology[]> cCache = new ConcurrentHashMap();
  private static final EthiopicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
  
  public static EthiopicChronology getInstanceUTC()
  {
    return INSTANCE_UTC;
  }
  
  public static EthiopicChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault(), 4);
  }
  
  public static EthiopicChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    return getInstance(paramDateTimeZone, 4);
  }
  
  public static EthiopicChronology getInstance(DateTimeZone paramDateTimeZone, int paramInt)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    Object localObject1 = (EthiopicChronology[])cCache.get(paramDateTimeZone);
    if (localObject1 == null)
    {
      localObject1 = new EthiopicChronology[7];
      EthiopicChronology[] arrayOfEthiopicChronology = (EthiopicChronology[])cCache.putIfAbsent(paramDateTimeZone, localObject1);
      if (arrayOfEthiopicChronology != null) {
        localObject1 = arrayOfEthiopicChronology;
      }
    }
    EthiopicChronology localEthiopicChronology;
    try
    {
      localEthiopicChronology = localObject1[(paramInt - 1)];
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("Invalid min days in first week: " + paramInt);
    }
    if (localEthiopicChronology == null) {
      synchronized (localObject1)
      {
        localEthiopicChronology = localObject1[(paramInt - 1)];
        if (localEthiopicChronology == null)
        {
          if (paramDateTimeZone == DateTimeZone.UTC)
          {
            localEthiopicChronology = new EthiopicChronology(null, null, paramInt);
            
            DateTime localDateTime = new DateTime(1, 1, 1, 0, 0, 0, 0, localEthiopicChronology);
            localEthiopicChronology = new EthiopicChronology(LimitChronology.getInstance(localEthiopicChronology, localDateTime, null), null, paramInt);
          }
          else
          {
            localEthiopicChronology = getInstance(DateTimeZone.UTC, paramInt);
            localEthiopicChronology = new EthiopicChronology(ZonedChronology.getInstance(localEthiopicChronology, paramDateTimeZone), null, paramInt);
          }
          localObject1[(paramInt - 1)] = localEthiopicChronology;
        }
      }
    }
    return localEthiopicChronology;
  }
  
  EthiopicChronology(Chronology paramChronology, Object paramObject, int paramInt)
  {
    super(paramChronology, paramObject, paramInt);
  }
  
  private Object readResolve()
  {
    Chronology localChronology = getBase();
    return localChronology == null ? getInstance(DateTimeZone.UTC, getMinimumDaysInFirstWeek()) : getInstance(localChronology.getZone(), getMinimumDaysInFirstWeek());
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
  
  boolean isLeapDay(long paramLong)
  {
    return (dayOfMonth().get(paramLong) == 6) && (monthOfYear().isLeap(paramLong));
  }
  
  long calculateFirstDayOfYearMillis(int paramInt)
  {
    int i = paramInt - 1963;
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
    
    return l + 21859200000L;
  }
  
  int getMinYear()
  {
    return -292269337;
  }
  
  int getMaxYear()
  {
    return 292272984;
  }
  
  long getApproxMillisAtEpochDividedByTwo()
  {
    return 30962844000000L;
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    if (getBase() == null)
    {
      super.assemble(paramFields);
      
      year = new SkipDateTimeField(this, year);
      weekyear = new SkipDateTimeField(this, weekyear);
      
      era = ERA_FIELD;
      monthOfYear = new BasicMonthOfYearDateTimeField(this, 13);
      months = monthOfYear.getDurationField();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.EthiopicChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */