package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDate;
import java.util.StringTokenizer;

class ZoneInfoCompiler$DateTimeOfYear
{
  public final int iMonthOfYear;
  public final int iDayOfMonth;
  public final int iDayOfWeek;
  public final boolean iAdvanceDayOfWeek;
  public final int iMillisOfDay;
  public final char iZoneChar;
  
  ZoneInfoCompiler$DateTimeOfYear()
  {
    iMonthOfYear = 1;
    iDayOfMonth = 1;
    iDayOfWeek = 0;
    iAdvanceDayOfWeek = false;
    iMillisOfDay = 0;
    iZoneChar = 'w';
  }
  
  ZoneInfoCompiler$DateTimeOfYear(StringTokenizer paramStringTokenizer)
  {
    int i = 1;
    int j = 1;
    int k = 0;
    int m = 0;
    boolean bool = false;
    char c = 'w';
    if (paramStringTokenizer.hasMoreTokens())
    {
      i = ZoneInfoCompiler.parseMonth(paramStringTokenizer.nextToken());
      if (paramStringTokenizer.hasMoreTokens())
      {
        String str = paramStringTokenizer.nextToken();
        if (str.startsWith("last"))
        {
          j = -1;
          k = ZoneInfoCompiler.parseDayOfWeek(str.substring(4));
          bool = false;
        }
        else
        {
          try
          {
            j = Integer.parseInt(str);
            k = 0;
            bool = false;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            int n = str.indexOf(">=");
            if (n > 0)
            {
              j = Integer.parseInt(str.substring(n + 2));
              k = ZoneInfoCompiler.parseDayOfWeek(str.substring(0, n));
              bool = true;
            }
            else
            {
              n = str.indexOf("<=");
              if (n > 0)
              {
                j = Integer.parseInt(str.substring(n + 2));
                k = ZoneInfoCompiler.parseDayOfWeek(str.substring(0, n));
                bool = false;
              }
              else
              {
                throw new IllegalArgumentException(str);
              }
            }
          }
        }
        if (paramStringTokenizer.hasMoreTokens())
        {
          str = paramStringTokenizer.nextToken();
          c = ZoneInfoCompiler.parseZoneChar(str.charAt(str.length() - 1));
          if (str.equals("24:00"))
          {
            if ((i == 12) && (j == 31))
            {
              m = ZoneInfoCompiler.parseTime("23:59:59.999");
            }
            else
            {
              LocalDate localLocalDate = j == -1 ? new LocalDate(2001, i, 1).plusMonths(1) : new LocalDate(2001, i, j).plusDays(1);
              
              bool = (j != -1) && (k != 0);
              i = localLocalDate.getMonthOfYear();
              j = localLocalDate.getDayOfMonth();
              if (k != 0) {
                k = (k - 1 + 1) % 7 + 1;
              }
            }
          }
          else {
            m = ZoneInfoCompiler.parseTime(str);
          }
        }
      }
    }
    iMonthOfYear = i;
    iDayOfMonth = j;
    iDayOfWeek = k;
    iAdvanceDayOfWeek = bool;
    iMillisOfDay = m;
    iZoneChar = c;
  }
  
  public void addRecurring(DateTimeZoneBuilder paramDateTimeZoneBuilder, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramDateTimeZoneBuilder.addRecurringSavings(paramString, paramInt1, paramInt2, paramInt3, iZoneChar, iMonthOfYear, iDayOfMonth, iDayOfWeek, iAdvanceDayOfWeek, iMillisOfDay);
  }
  
  public void addCutover(DateTimeZoneBuilder paramDateTimeZoneBuilder, int paramInt)
  {
    paramDateTimeZoneBuilder.addCutover(paramInt, iZoneChar, iMonthOfYear, iDayOfMonth, iDayOfWeek, iAdvanceDayOfWeek, iMillisOfDay);
  }
  
  public String toString()
  {
    return "MonthOfYear: " + iMonthOfYear + "\n" + "DayOfMonth: " + iDayOfMonth + "\n" + "DayOfWeek: " + iDayOfWeek + "\n" + "AdvanceDayOfWeek: " + iAdvanceDayOfWeek + "\n" + "MillisOfDay: " + iMillisOfDay + "\n" + "ZoneChar: " + iZoneChar + "\n";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoCompiler.DateTimeOfYear
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */