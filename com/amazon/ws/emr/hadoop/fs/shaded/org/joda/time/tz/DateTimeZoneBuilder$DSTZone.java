package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

final class DateTimeZoneBuilder$DSTZone
  extends DateTimeZone
{
  private static final long serialVersionUID = 6941492635554961361L;
  final int iStandardOffset;
  final DateTimeZoneBuilder.Recurrence iStartRecurrence;
  final DateTimeZoneBuilder.Recurrence iEndRecurrence;
  
  static DSTZone readFrom(DataInput paramDataInput, String paramString)
    throws IOException
  {
    return new DSTZone(paramString, (int)DateTimeZoneBuilder.readMillis(paramDataInput), DateTimeZoneBuilder.Recurrence.readFrom(paramDataInput), DateTimeZoneBuilder.Recurrence.readFrom(paramDataInput));
  }
  
  DateTimeZoneBuilder$DSTZone(String paramString, int paramInt, DateTimeZoneBuilder.Recurrence paramRecurrence1, DateTimeZoneBuilder.Recurrence paramRecurrence2)
  {
    super(paramString);
    iStandardOffset = paramInt;
    iStartRecurrence = paramRecurrence1;
    iEndRecurrence = paramRecurrence2;
  }
  
  public String getNameKey(long paramLong)
  {
    return findMatchingRecurrence(paramLong).getNameKey();
  }
  
  public int getOffset(long paramLong)
  {
    return iStandardOffset + findMatchingRecurrence(paramLong).getSaveMillis();
  }
  
  public int getStandardOffset(long paramLong)
  {
    return iStandardOffset;
  }
  
  public boolean isFixed()
  {
    return false;
  }
  
  public long nextTransition(long paramLong)
  {
    int i = iStandardOffset;
    DateTimeZoneBuilder.Recurrence localRecurrence1 = iStartRecurrence;
    DateTimeZoneBuilder.Recurrence localRecurrence2 = iEndRecurrence;
    long l1;
    try
    {
      l1 = localRecurrence1.next(paramLong, i, localRecurrence2.getSaveMillis());
      if ((paramLong > 0L) && (l1 < 0L)) {
        l1 = paramLong;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      l1 = paramLong;
    }
    catch (ArithmeticException localArithmeticException1)
    {
      l1 = paramLong;
    }
    long l2;
    try
    {
      l2 = localRecurrence2.next(paramLong, i, localRecurrence1.getSaveMillis());
      if ((paramLong > 0L) && (l2 < 0L)) {
        l2 = paramLong;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      l2 = paramLong;
    }
    catch (ArithmeticException localArithmeticException2)
    {
      l2 = paramLong;
    }
    return l1 > l2 ? l2 : l1;
  }
  
  public long previousTransition(long paramLong)
  {
    paramLong += 1L;
    
    int i = iStandardOffset;
    DateTimeZoneBuilder.Recurrence localRecurrence1 = iStartRecurrence;
    DateTimeZoneBuilder.Recurrence localRecurrence2 = iEndRecurrence;
    long l1;
    try
    {
      l1 = localRecurrence1.previous(paramLong, i, localRecurrence2.getSaveMillis());
      if ((paramLong < 0L) && (l1 > 0L)) {
        l1 = paramLong;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      l1 = paramLong;
    }
    catch (ArithmeticException localArithmeticException1)
    {
      l1 = paramLong;
    }
    long l2;
    try
    {
      l2 = localRecurrence2.previous(paramLong, i, localRecurrence1.getSaveMillis());
      if ((paramLong < 0L) && (l2 > 0L)) {
        l2 = paramLong;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      l2 = paramLong;
    }
    catch (ArithmeticException localArithmeticException2)
    {
      l2 = paramLong;
    }
    return (l1 > l2 ? l1 : l2) - 1L;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof DSTZone))
    {
      DSTZone localDSTZone = (DSTZone)paramObject;
      return (getID().equals(localDSTZone.getID())) && (iStandardOffset == iStandardOffset) && (iStartRecurrence.equals(iStartRecurrence)) && (iEndRecurrence.equals(iEndRecurrence));
    }
    return false;
  }
  
  public void writeTo(DataOutput paramDataOutput)
    throws IOException
  {
    DateTimeZoneBuilder.writeMillis(paramDataOutput, iStandardOffset);
    iStartRecurrence.writeTo(paramDataOutput);
    iEndRecurrence.writeTo(paramDataOutput);
  }
  
  private DateTimeZoneBuilder.Recurrence findMatchingRecurrence(long paramLong)
  {
    int i = iStandardOffset;
    DateTimeZoneBuilder.Recurrence localRecurrence1 = iStartRecurrence;
    DateTimeZoneBuilder.Recurrence localRecurrence2 = iEndRecurrence;
    long l1;
    try
    {
      l1 = localRecurrence1.next(paramLong, i, localRecurrence2.getSaveMillis());
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      l1 = paramLong;
    }
    catch (ArithmeticException localArithmeticException1)
    {
      l1 = paramLong;
    }
    long l2;
    try
    {
      l2 = localRecurrence2.next(paramLong, i, localRecurrence1.getSaveMillis());
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      l2 = paramLong;
    }
    catch (ArithmeticException localArithmeticException2)
    {
      l2 = paramLong;
    }
    return l1 > l2 ? localRecurrence1 : localRecurrence2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder.DSTZone
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */