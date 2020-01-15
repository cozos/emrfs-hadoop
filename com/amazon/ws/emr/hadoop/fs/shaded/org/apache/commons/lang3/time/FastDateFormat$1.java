package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Locale;
import java.util.TimeZone;

final class FastDateFormat$1
  extends FormatCache<FastDateFormat>
{
  protected FastDateFormat createInstance(String pattern, TimeZone timeZone, Locale locale)
  {
    return new FastDateFormat(pattern, timeZone, locale);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateFormat.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */