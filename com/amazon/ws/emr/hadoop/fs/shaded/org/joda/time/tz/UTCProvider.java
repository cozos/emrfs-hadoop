package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.util.Collections;
import java.util.Set;

public final class UTCProvider
  implements Provider
{
  private static final Set<String> AVAILABLE_IDS = Collections.singleton("UTC");
  
  public DateTimeZone getZone(String paramString)
  {
    if ("UTC".equalsIgnoreCase(paramString)) {
      return DateTimeZone.UTC;
    }
    return null;
  }
  
  public Set<String> getAvailableIDs()
  {
    return AVAILABLE_IDS;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.UTCProvider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */