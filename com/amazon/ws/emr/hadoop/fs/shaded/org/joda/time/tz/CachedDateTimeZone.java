package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;

public class CachedDateTimeZone
  extends DateTimeZone
{
  private static final long serialVersionUID = 5472298452022250685L;
  private static final int cInfoCacheMask;
  private final DateTimeZone iZone;
  
  static
  {
    Integer localInteger;
    try
    {
      localInteger = Integer.getInteger("com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.CachedDateTimeZone.size");
    }
    catch (SecurityException localSecurityException)
    {
      localInteger = null;
    }
    int i;
    if (localInteger == null)
    {
      i = 512;
    }
    else
    {
      i = localInteger.intValue();
      
      i--;
      int j = 0;
      while (i > 0)
      {
        j++;
        i >>= 1;
      }
      i = 1 << j;
    }
    cInfoCacheMask = i - 1;
  }
  
  public static CachedDateTimeZone forZone(DateTimeZone paramDateTimeZone)
  {
    if ((paramDateTimeZone instanceof CachedDateTimeZone)) {
      return (CachedDateTimeZone)paramDateTimeZone;
    }
    return new CachedDateTimeZone(paramDateTimeZone);
  }
  
  private final transient Info[] iInfoCache = new Info[cInfoCacheMask + 1];
  
  private CachedDateTimeZone(DateTimeZone paramDateTimeZone)
  {
    super(paramDateTimeZone.getID());
    iZone = paramDateTimeZone;
  }
  
  public DateTimeZone getUncachedZone()
  {
    return iZone;
  }
  
  public String getNameKey(long paramLong)
  {
    return getInfo(paramLong).getNameKey(paramLong);
  }
  
  public int getOffset(long paramLong)
  {
    return getInfo(paramLong).getOffset(paramLong);
  }
  
  public int getStandardOffset(long paramLong)
  {
    return getInfo(paramLong).getStandardOffset(paramLong);
  }
  
  public boolean isFixed()
  {
    return iZone.isFixed();
  }
  
  public long nextTransition(long paramLong)
  {
    return iZone.nextTransition(paramLong);
  }
  
  public long previousTransition(long paramLong)
  {
    return iZone.previousTransition(paramLong);
  }
  
  public int hashCode()
  {
    return iZone.hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof CachedDateTimeZone)) {
      return iZone.equals(iZone);
    }
    return false;
  }
  
  private Info getInfo(long paramLong)
  {
    int i = (int)(paramLong >> 32);
    Info[] arrayOfInfo = iInfoCache;
    int j = i & cInfoCacheMask;
    Info localInfo = arrayOfInfo[j];
    if ((localInfo == null) || ((int)(iPeriodStart >> 32) != i))
    {
      localInfo = createInfo(paramLong);
      arrayOfInfo[j] = localInfo;
    }
    return localInfo;
  }
  
  private Info createInfo(long paramLong)
  {
    long l1 = paramLong & 0xFFFFFFFF00000000;
    Info localInfo1 = new Info(iZone, l1);
    
    long l2 = l1 | 0xFFFFFFFF;
    Info localInfo2 = localInfo1;
    for (;;)
    {
      long l3 = iZone.nextTransition(l1);
      if ((l3 == l1) || (l3 > l2)) {
        break;
      }
      l1 = l3;
      localInfo2 = iNextInfo = new Info(iZone, l1);
    }
    return localInfo1;
  }
  
  private static final class Info
  {
    public final long iPeriodStart;
    public final DateTimeZone iZoneRef;
    Info iNextInfo;
    private String iNameKey;
    private int iOffset = Integer.MIN_VALUE;
    private int iStandardOffset = Integer.MIN_VALUE;
    
    Info(DateTimeZone paramDateTimeZone, long paramLong)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.CachedDateTimeZone
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */