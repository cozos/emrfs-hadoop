package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public final class FixedDateTimeZone
  extends DateTimeZone
{
  private static final long serialVersionUID = -3513011772763289092L;
  private final String iNameKey;
  private final int iWallOffset;
  private final int iStandardOffset;
  
  public FixedDateTimeZone(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramString1);
    iNameKey = paramString2;
    iWallOffset = paramInt1;
    iStandardOffset = paramInt2;
  }
  
  public String getNameKey(long paramLong)
  {
    return iNameKey;
  }
  
  public int getOffset(long paramLong)
  {
    return iWallOffset;
  }
  
  public int getStandardOffset(long paramLong)
  {
    return iStandardOffset;
  }
  
  public int getOffsetFromLocal(long paramLong)
  {
    return iWallOffset;
  }
  
  public boolean isFixed()
  {
    return true;
  }
  
  public long nextTransition(long paramLong)
  {
    return paramLong;
  }
  
  public long previousTransition(long paramLong)
  {
    return paramLong;
  }
  
  public TimeZone toTimeZone()
  {
    String str = getID();
    if ((str.length() == 6) && ((str.startsWith("+")) || (str.startsWith("-")))) {
      return TimeZone.getTimeZone("GMT" + getID());
    }
    return new SimpleTimeZone(iWallOffset, getID());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof FixedDateTimeZone))
    {
      FixedDateTimeZone localFixedDateTimeZone = (FixedDateTimeZone)paramObject;
      return (getID().equals(localFixedDateTimeZone.getID())) && (iStandardOffset == iStandardOffset) && (iWallOffset == iWallOffset);
    }
    return false;
  }
  
  public int hashCode()
  {
    return getID().hashCode() + 37 * iStandardOffset + 31 * iWallOffset;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.FixedDateTimeZone
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */