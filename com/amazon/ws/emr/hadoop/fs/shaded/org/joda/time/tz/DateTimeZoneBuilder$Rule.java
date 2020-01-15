package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;

final class DateTimeZoneBuilder$Rule
{
  final DateTimeZoneBuilder.Recurrence iRecurrence;
  final int iFromYear;
  final int iToYear;
  
  DateTimeZoneBuilder$Rule(DateTimeZoneBuilder.Recurrence paramRecurrence, int paramInt1, int paramInt2)
  {
    iRecurrence = paramRecurrence;
    iFromYear = paramInt1;
    iToYear = paramInt2;
  }
  
  public int getFromYear()
  {
    return iFromYear;
  }
  
  public int getToYear()
  {
    return iToYear;
  }
  
  public DateTimeZoneBuilder.OfYear getOfYear()
  {
    return iRecurrence.getOfYear();
  }
  
  public String getNameKey()
  {
    return iRecurrence.getNameKey();
  }
  
  public int getSaveMillis()
  {
    return iRecurrence.getSaveMillis();
  }
  
  public long next(long paramLong, int paramInt1, int paramInt2)
  {
    ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
    
    int i = paramInt1 + paramInt2;
    long l1 = paramLong;
    int j;
    if (paramLong == Long.MIN_VALUE) {
      j = Integer.MIN_VALUE;
    } else {
      j = localISOChronology.year().get(paramLong + i);
    }
    if (j < iFromYear)
    {
      l1 = localISOChronology.year().set(0L, iFromYear) - i;
      
      l1 -= 1L;
    }
    long l2 = iRecurrence.next(l1, paramInt1, paramInt2);
    if (l2 > paramLong)
    {
      j = localISOChronology.year().get(l2 + i);
      if (j > iToYear) {
        l2 = paramLong;
      }
    }
    return l2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder.Rule
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */