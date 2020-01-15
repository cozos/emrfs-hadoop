package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Instant;

class GJCacheKey
{
  private final DateTimeZone zone;
  private final Instant cutoverInstant;
  private final int minDaysInFirstWeek;
  
  GJCacheKey(DateTimeZone paramDateTimeZone, Instant paramInstant, int paramInt)
  {
    zone = paramDateTimeZone;
    cutoverInstant = paramInstant;
    minDaysInFirstWeek = paramInt;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (cutoverInstant == null ? 0 : cutoverInstant.hashCode());
    i = 31 * i + minDaysInFirstWeek;
    i = 31 * i + (zone == null ? 0 : zone.hashCode());
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof GJCacheKey)) {
      return false;
    }
    GJCacheKey localGJCacheKey = (GJCacheKey)paramObject;
    if (cutoverInstant == null)
    {
      if (cutoverInstant != null) {
        return false;
      }
    }
    else if (!cutoverInstant.equals(cutoverInstant)) {
      return false;
    }
    if (minDaysInFirstWeek != minDaysInFirstWeek) {
      return false;
    }
    if (zone == null)
    {
      if (zone != null) {
        return false;
      }
    }
    else if (!zone.equals(zone)) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJCacheKey
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */