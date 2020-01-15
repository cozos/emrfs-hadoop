package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Locale;
import java.util.TimeZone;

class FastDatePrinter$TimeZoneDisplayKey
{
  private final TimeZone mTimeZone;
  private final int mStyle;
  private final Locale mLocale;
  
  FastDatePrinter$TimeZoneDisplayKey(TimeZone timeZone, boolean daylight, int style, Locale locale)
  {
    mTimeZone = timeZone;
    if (daylight) {
      mStyle = (style | 0x80000000);
    } else {
      mStyle = style;
    }
    mLocale = locale;
  }
  
  public int hashCode()
  {
    return (mStyle * 31 + mLocale.hashCode()) * 31 + mTimeZone.hashCode();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj instanceof TimeZoneDisplayKey))
    {
      TimeZoneDisplayKey other = (TimeZoneDisplayKey)obj;
      return (mTimeZone.equals(mTimeZone)) && (mStyle == mStyle) && (mLocale.equals(mLocale));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TimeZoneDisplayKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */