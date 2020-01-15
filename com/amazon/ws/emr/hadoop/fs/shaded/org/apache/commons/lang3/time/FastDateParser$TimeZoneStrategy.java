package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

class FastDateParser$TimeZoneStrategy
  extends FastDateParser.Strategy
{
  private final String validTimeZoneChars;
  private final SortedMap<String, TimeZone> tzNames = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  private static final int ID = 0;
  private static final int LONG_STD = 1;
  private static final int SHORT_STD = 2;
  private static final int LONG_DST = 3;
  private static final int SHORT_DST = 4;
  
  FastDateParser$TimeZoneStrategy(Locale locale)
  {
    super(null);
    String[][] zones = DateFormatSymbols.getInstance(locale).getZoneStrings();
    for (String[] zone : zones) {
      if (!zone[0].startsWith("GMT"))
      {
        TimeZone tz = TimeZone.getTimeZone(zone[0]);
        if (!tzNames.containsKey(zone[1])) {
          tzNames.put(zone[1], tz);
        }
        if (!tzNames.containsKey(zone[2])) {
          tzNames.put(zone[2], tz);
        }
        if (tz.useDaylightTime())
        {
          if (!tzNames.containsKey(zone[3])) {
            tzNames.put(zone[3], tz);
          }
          if (!tzNames.containsKey(zone[4])) {
            tzNames.put(zone[4], tz);
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append("(GMT[+\\-]\\d{0,1}\\d{2}|[+\\-]\\d{2}:?\\d{2}|");
    for (String id : tzNames.keySet()) {
      FastDateParser.access$100(sb, id, false).append('|');
    }
    sb.setCharAt(sb.length() - 1, ')');
    validTimeZoneChars = sb.toString();
  }
  
  boolean addRegex(FastDateParser parser, StringBuilder regex)
  {
    regex.append(validTimeZoneChars);
    return true;
  }
  
  void setCalendar(FastDateParser parser, Calendar cal, String value)
  {
    TimeZone tz;
    TimeZone tz;
    if ((value.charAt(0) == '+') || (value.charAt(0) == '-'))
    {
      tz = TimeZone.getTimeZone("GMT" + value);
    }
    else
    {
      TimeZone tz;
      if (value.startsWith("GMT"))
      {
        tz = TimeZone.getTimeZone(value);
      }
      else
      {
        tz = (TimeZone)tzNames.get(value);
        if (tz == null) {
          throw new IllegalArgumentException(value + " is not a supported timezone name");
        }
      }
    }
    cal.setTimeZone(tz);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.TimeZoneStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */