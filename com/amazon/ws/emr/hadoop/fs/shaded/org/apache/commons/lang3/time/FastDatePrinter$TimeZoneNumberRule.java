package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$TimeZoneNumberRule
  implements FastDatePrinter.Rule
{
  static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
  static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
  final boolean mColon;
  
  FastDatePrinter$TimeZoneNumberRule(boolean colon)
  {
    mColon = colon;
  }
  
  public int estimateLength()
  {
    return 5;
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    int offset = calendar.get(15) + calendar.get(16);
    if (offset < 0)
    {
      buffer.append('-');
      offset = -offset;
    }
    else
    {
      buffer.append('+');
    }
    int hours = offset / 3600000;
    buffer.append((char)(hours / 10 + 48));
    buffer.append((char)(hours % 10 + 48));
    if (mColon) {
      buffer.append(':');
    }
    int minutes = offset / 60000 - 60 * hours;
    buffer.append((char)(minutes / 10 + 48));
    buffer.append((char)(minutes % 10 + 48));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TimeZoneNumberRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */