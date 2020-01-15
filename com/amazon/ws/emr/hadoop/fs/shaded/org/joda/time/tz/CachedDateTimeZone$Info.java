package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;

final class CachedDateTimeZone$Info
{
  public final long iPeriodStart;
  public final DateTimeZone iZoneRef;
  Info iNextInfo;
  private String iNameKey;
  private int iOffset = Integer.MIN_VALUE;
  private int iStandardOffset = Integer.MIN_VALUE;
  
  CachedDateTimeZone$Info(DateTimeZone paramDateTimeZone, long paramLong)
  {
    iPeriodStart = paramLong;
    iZoneRef = paramDateTimeZone;
  }
  
  public String getNameKey(long paramLong)
  {
    if ((iNextInfo == null) || (paramLong < iNextInfo.iPeriodStart))
    {
      if (iNameKey == null) {
        iNameKey = iZoneRef.getNameKey(iPeriodStart);
      }
      return iNameKey;
    }
    return iNextInfo.getNameKey(paramLong);
  }
  
  public int getOffset(long paramLong)
  {
    if ((iNextInfo == null) || (paramLong < iNextInfo.iPeriodStart))
    {
      if (iOffset == Integer.MIN_VALUE) {
        iOffset = iZoneRef.getOffset(iPeriodStart);
      }
      return iOffset;
    }
    return iNextInfo.getOffset(paramLong);
  }
  
  public int getStandardOffset(long paramLong)
  {
    if ((iNextInfo == null) || (paramLong < iNextInfo.iPeriodStart))
    {
      if (iStandardOffset == Integer.MIN_VALUE) {
        iStandardOffset = iZoneRef.getStandardOffset(iPeriodStart);
      }
      return iStandardOffset;
    }
    return iNextInfo.getStandardOffset(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.CachedDateTimeZone.Info
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */