package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

abstract class FastDateParser$Strategy
{
  boolean isNumber()
  {
    return false;
  }
  
  void setCalendar(FastDateParser parser, Calendar cal, String value) {}
  
  abstract boolean addRegex(FastDateParser paramFastDateParser, StringBuilder paramStringBuilder);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.Strategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */