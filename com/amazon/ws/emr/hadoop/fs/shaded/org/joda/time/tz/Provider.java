package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.util.Set;

public abstract interface Provider
{
  public abstract DateTimeZone getZone(String paramString);
  
  public abstract Set<String> getAvailableIDs();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.Provider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */