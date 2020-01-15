package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

class FastDatePrinter$TimeZoneNameRule
  implements FastDatePrinter.Rule
{
  private final Locale mLocale;
  private final int mStyle;
  private final String mStandard;
  private final String mDaylight;
  
  FastDatePrinter$TimeZoneNameRule(TimeZone timeZone, Locale locale, int style)
  {
    mLocale = locale;
    mStyle = style;
    
    mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, style, locale);
    mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, style, locale);
  }
  
  public int estimateLength()
  {
    return Math.max(mStandard.length(), mDaylight.length());
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    TimeZone zone = calendar.getTimeZone();
    if ((zone.useDaylightTime()) && (calendar.get(16) != 0)) {
      buffer.append(FastDatePrinter.getTimeZoneDisplay(zone, true, mStyle, mLocale));
    } else {
      buffer.append(FastDatePrinter.getTimeZoneDisplay(zone, false, mStyle, mLocale));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TimeZoneNameRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */