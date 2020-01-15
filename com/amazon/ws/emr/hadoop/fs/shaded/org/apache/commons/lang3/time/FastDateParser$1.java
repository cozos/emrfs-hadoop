package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

final class FastDateParser$1
  extends FastDateParser.NumberStrategy
{
  FastDateParser$1(int x0)
  {
    super(x0);
  }
  
  void setCalendar(FastDateParser parser, Calendar cal, String value)
  {
    int iValue = Integer.parseInt(value);
    if (iValue < 100) {
      iValue = FastDateParser.access$300(parser, iValue);
    }
    cal.set(1, iValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */