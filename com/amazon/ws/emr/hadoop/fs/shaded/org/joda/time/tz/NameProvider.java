package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import java.util.Locale;

public abstract interface NameProvider
{
  public abstract String getShortName(Locale paramLocale, String paramString1, String paramString2);
  
  public abstract String getName(Locale paramLocale, String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.NameProvider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */