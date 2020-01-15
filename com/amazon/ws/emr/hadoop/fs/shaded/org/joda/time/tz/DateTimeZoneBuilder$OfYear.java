package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

final class DateTimeZoneBuilder$OfYear
{
  final char iMode;
  final int iMonthOfYear;
  final int iDayOfMonth;
  final int iDayOfWeek;
  final boolean iAdvance;
  final int iMillisOfDay;
  
  static OfYear readFrom(DataInput paramDataInput)
    throws IOException
  {
    return new OfYear((char)paramDataInput.readUnsignedByte(), paramDataInput.readUnsignedByte(), paramDataInput.readByte(), paramDataInput.readUnsignedByte(), paramDataInput.readBoolean(), (int)DateTimeZoneBuilder.readMillis(paramDataInput));
  }
  
  DateTimeZoneBuilder$OfYear(char paramChar, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramChar != 'u') && (paramChar != 'w') && (paramChar != 's')) {
      throw new IllegalArgumentException("Unknown mode: " + paramChar);
    }
    iMode = paramChar;
    iMonthOfYear = paramInt1;
    iDayOfMonth = paramInt2;
    iDayOfWeek = paramInt3;
    iAdvance = paramBoolean;
    iMillisOfDay = paramInt4;
  }
  
  public long setInstant(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (iMode == 'w') {
      i = paramInt2 + paramInt3;
    } else if (iMode == 's') {
      i = paramInt2;
    } else {
      i = 0;
    }
    ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
    long l = localISOChronology.year().set(0L, paramInt1);
    l = localISOChronology.monthOfYear().set(l, iMonthOfYear);
    l = localISOChronology.millisOfDay().set(l, iMillisOfDay);
    l = setDayOfMonth(localISOChronology, l);
    if (iDayOfWeek != 0) {
      l = setDayOfWeek(localISOChronology, l);
    }
    return l - i;
  }
  
  public long next(long paramLong, int paramInt1, int paramInt2)
  {
    int i;
    if (iMode == 'w') {
      i = paramInt1 + paramInt2;
    } else if (iMode == 's') {
      i = paramInt1;
    } else {
      i = 0;
    }
    paramLong += i;
    
    ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
    long l = localISOChronology.monthOfYear().set(paramLong, iMonthOfYear);
    
    l = localISOChronology.millisOfDay().set(l, 0);
    l = localISOChronology.millisOfDay().add(l, iMillisOfDay);
    l = setDayOfMonthNext(localISOChronology, l);
    if (iDayOfWeek == 0)
    {
      if (l <= paramLong)
      {
        l = localISOChronology.year().add(l, 1);
        l = setDayOfMonthNext(localISOChronology, l);
      }
    }
    else
    {
      l = setDayOfWeek(localISOChronology, l);
      if (l <= paramLong)
      {
        l = localISOChronology.year().add(l, 1);
        l = localISOChronology.monthOfYear().set(l, iMonthOfYear);
        l = setDayOfMonthNext(localISOChronology, l);
        l = setDayOfWeek(localISOChronology, l);
      }
    }
    return l - i;
  }
  
  public long previous(long paramLong, int paramInt1, int paramInt2)
  {
    int i;
    if (iMode == 'w') {
      i = paramInt1 + paramInt2;
    } else if (iMode == 's') {
      i = paramInt1;
    } else {
      i = 0;
    }
    paramLong += i;
    
    ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
    long l = localISOChronology.monthOfYear().set(paramLong, iMonthOfYear);
    
    l = localISOChronology.millisOfDay().set(l, 0);
    l = localISOChronology.millisOfDay().add(l, iMillisOfDay);
    l = setDayOfMonthPrevious(localISOChronology, l);
    if (iDayOfWeek == 0)
    {
      if (l >= paramLong)
      {
        l = localISOChronology.year().add(l, -1);
        l = setDayOfMonthPrevious(localISOChronology, l);
      }
    }
    else
    {
      l = setDayOfWeek(localISOChronology, l);
      if (l >= paramLong)
      {
        l = localISOChronology.year().add(l, -1);
        l = localISOChronology.monthOfYear().set(l, iMonthOfYear);
        l = setDayOfMonthPrevious(localISOChronology, l);
        l = setDayOfWeek(localISOChronology, l);
      }
    }
    return l - i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof OfYear))
    {
      OfYear localOfYear = (OfYear)paramObject;
      return (iMode == iMode) && (iMonthOfYear == iMonthOfYear) && (iDayOfMonth == iDayOfMonth) && (iDayOfWeek == iDayOfWeek) && (iAdvance == iAdvance) && (iMillisOfDay == iMillisOfDay);
    }
    return false;
  }
  
  public void writeTo(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeByte(iMode);
    paramDataOutput.writeByte(iMonthOfYear);
    paramDataOutput.writeByte(iDayOfMonth);
    paramDataOutput.writeByte(iDayOfWeek);
    paramDataOutput.writeBoolean(iAdvance);
    DateTimeZoneBuilder.writeMillis(paramDataOutput, iMillisOfDay);
  }
  
  private long setDayOfMonthNext(Chronology paramChronology, long paramLong)
  {
    try
    {
      paramLong = setDayOfMonth(paramChronology, paramLong);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if ((iMonthOfYear == 2) && (iDayOfMonth == 29))
      {
        while (!paramChronology.year().isLeap(paramLong)) {
          paramLong = paramChronology.year().add(paramLong, 1);
        }
        paramLong = setDayOfMonth(paramChronology, paramLong);
      }
      else
      {
        throw localIllegalArgumentException;
      }
    }
    return paramLong;
  }
  
  private long setDayOfMonthPrevious(Chronology paramChronology, long paramLong)
  {
    try
    {
      paramLong = setDayOfMonth(paramChronology, paramLong);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if ((iMonthOfYear == 2) && (iDayOfMonth == 29))
      {
        while (!paramChronology.year().isLeap(paramLong)) {
          paramLong = paramChronology.year().add(paramLong, -1);
        }
        paramLong = setDayOfMonth(paramChronology, paramLong);
      }
      else
      {
        throw localIllegalArgumentException;
      }
    }
    return paramLong;
  }
  
  private long setDayOfMonth(Chronology paramChronology, long paramLong)
  {
    if (iDayOfMonth >= 0)
    {
      paramLong = paramChronology.dayOfMonth().set(paramLong, iDayOfMonth);
    }
    else
    {
      paramLong = paramChronology.dayOfMonth().set(paramLong, 1);
      paramLong = paramChronology.monthOfYear().add(paramLong, 1);
      paramLong = paramChronology.dayOfMonth().add(paramLong, iDayOfMonth);
    }
    return paramLong;
  }
  
  private long setDayOfWeek(Chronology paramChronology, long paramLong)
  {
    int i = paramChronology.dayOfWeek().get(paramLong);
    int j = iDayOfWeek - i;
    if (j != 0)
    {
      if (iAdvance)
      {
        if (j < 0) {
          j += 7;
        }
      }
      else if (j > 0) {
        j -= 7;
      }
      paramLong = paramChronology.dayOfWeek().add(paramLong, j);
    }
    return paramLong;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder.OfYear
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */