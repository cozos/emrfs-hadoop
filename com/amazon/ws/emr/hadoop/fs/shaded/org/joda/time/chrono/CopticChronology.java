package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.SkipDateTimeField;
import java.util.concurrent.ConcurrentHashMap;

public final class CopticChronology
  extends BasicFixedMonthChronology
{
  private static final long serialVersionUID = -5972804258688333942L;
  public static final int AM = 1;
  private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("AM");
  private static final int MIN_YEAR = -292269337;
  private static final int MAX_YEAR = 292272708;
  private static final ConcurrentHashMap<DateTimeZone, CopticChronology[]> cCache = new ConcurrentHashMap();
  private static final CopticChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
  
  public static CopticChronology getInstanceUTC()
  {
    return INSTANCE_UTC;
  }
  
  public static CopticChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault(), 4);
  }
  
  public static CopticChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    return getInstance(paramDateTimeZone, 4);
  }
  
  public static CopticChronology getInstance(DateTimeZone paramDateTimeZone, int paramInt)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    Object localObject1 = (CopticChronology[])cCache.get(paramDateTimeZone);
    if (localObject1 == null)
    {
      localObject1 = new CopticChronology[7];
      CopticChronology[] arrayOfCopticChronology = (CopticChronology[])cCache.putIfAbsent(paramDateTimeZone, localObject1);
      if (arrayOfCopticChronology != null) {
        localObject1 = arrayOfCopticChronology;
      }
    }
    CopticChronology localCopticChronology;
    try
    {
      localCopticChronology = localObject1[(paramInt - 1)];
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("Invalid min days in first week: " + paramInt);
    }
    if (localCopticChronology == null) {
      synchronized (localObject1)
      {
        localCopticChronology = localObject1[(paramInt - 1)];
        if (localCopticChronology == null)
        {
          if (paramDateTimeZone == DateTimeZone.UTC)
          {
            localCopticChronology = new CopticChronology(null, null, paramInt);
            
            DateTime localDateTime = new DateTime(1, 1, 1, 0, 0, 0, 0, localCopticChronology);
            localCopticChronology = new CopticChronology(LimitChronology.getInstance(localCopticChronology, localDateTime, null), null, paramInt);
          }
          else
          {
            localCopticChronology = getInstance(DateTimeZone.UTC, paramInt);
            localCopticChronology = new CopticChronology(ZonedChronology.getInstance(localCopticChronology, paramDateTimeZone), null, paramInt);
          }
          localObject1[(paramInt - 1)] = localCopticChronology;
        }
      }
    }
    return localCopticChronology;
  }
  
  CopticChronology(Chronology paramChronology, Object paramObject, int paramInt)
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
  
  boolean isLeapDay(long paramLong)
  {
    return (dayOfMonth().get(paramLong) == 6) && (monthOfYear().isLeap(paramLong));
  }
  
  long calculateFirstDayOfYearMillis(int paramInt)
  {
    int i = paramInt - 1687;
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
    return 292272708;
  }
  
  long getApproxMillisAtEpochDividedByTwo()
  {
    return 26607895200000L;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.CopticChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */