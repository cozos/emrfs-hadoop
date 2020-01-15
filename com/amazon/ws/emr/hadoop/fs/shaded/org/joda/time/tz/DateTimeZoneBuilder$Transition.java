package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

final class DateTimeZoneBuilder$Transition
{
  private final long iMillis;
  private final String iNameKey;
  private final int iWallOffset;
  private final int iStandardOffset;
  
  DateTimeZoneBuilder$Transition(long paramLong, Transition paramTransition)
  {
    iMillis = paramLong;
    iNameKey = iNameKey;
    iWallOffset = iWallOffset;
    iStandardOffset = iStandardOffset;
  }
  
  DateTimeZoneBuilder$Transition(long paramLong, DateTimeZoneBuilder.Rule paramRule, int paramInt)
  {
    iMillis = paramLong;
    iNameKey = paramRule.getNameKey();
    iWallOffset = (paramInt + paramRule.getSaveMillis());
    iStandardOffset = paramInt;
  }
  
  DateTimeZoneBuilder$Transition(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    iMillis = paramLong;
    iNameKey = paramString;
    iWallOffset = paramInt1;
    iStandardOffset = paramInt2;
  }
  
  public long getMillis()
  {
    return iMillis;
  }
  
  public String getNameKey()
  {
    return iNameKey;
  }
  
  public int getWallOffset()
  {
    return iWallOffset;
  }
  
  public int getStandardOffset()
  {
    return iStandardOffset;
  }
  
  public int getSaveMillis()
  {
    return iWallOffset - iStandardOffset;
  }
  
  public boolean isTransitionFrom(Transition paramTransition)
  {
    if (paramTransition == null) {
      return true;
    }
    return (iMillis > iMillis) && ((iWallOffset != iWallOffset) || (!iNameKey.equals(iNameKey)));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder.Transition
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */