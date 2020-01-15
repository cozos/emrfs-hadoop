package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

final class DateTimeZoneBuilder$Recurrence
{
  final DateTimeZoneBuilder.OfYear iOfYear;
  final String iNameKey;
  final int iSaveMillis;
  
  static Recurrence readFrom(DataInput paramDataInput)
    throws IOException
  {
    return new Recurrence(DateTimeZoneBuilder.OfYear.readFrom(paramDataInput), paramDataInput.readUTF(), (int)DateTimeZoneBuilder.readMillis(paramDataInput));
  }
  
  DateTimeZoneBuilder$Recurrence(DateTimeZoneBuilder.OfYear paramOfYear, String paramString, int paramInt)
  {
    iOfYear = paramOfYear;
    iNameKey = paramString;
    iSaveMillis = paramInt;
  }
  
  public DateTimeZoneBuilder.OfYear getOfYear()
  {
    return iOfYear;
  }
  
  public long next(long paramLong, int paramInt1, int paramInt2)
  {
    return iOfYear.next(paramLong, paramInt1, paramInt2);
  }
  
  public long previous(long paramLong, int paramInt1, int paramInt2)
  {
    return iOfYear.previous(paramLong, paramInt1, paramInt2);
  }
  
  public String getNameKey()
  {
    return iNameKey;
  }
  
  public int getSaveMillis()
  {
    return iSaveMillis;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof Recurrence))
    {
      Recurrence localRecurrence = (Recurrence)paramObject;
      return (iSaveMillis == iSaveMillis) && (iNameKey.equals(iNameKey)) && (iOfYear.equals(iOfYear));
    }
    return false;
  }
  
  public void writeTo(DataOutput paramDataOutput)
    throws IOException
  {
    iOfYear.writeTo(paramDataOutput);
    paramDataOutput.writeUTF(iNameKey);
    DateTimeZoneBuilder.writeMillis(paramDataOutput, iSaveMillis);
  }
  
  Recurrence rename(String paramString)
  {
    return new Recurrence(iOfYear, paramString, iSaveMillis);
  }
  
  Recurrence renameAppend(String paramString)
  {
    return rename((iNameKey + paramString).intern());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder.Recurrence
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */