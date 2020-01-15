package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDateParser$NumberStrategy
  extends FastDateParser.Strategy
{
  private final int field;
  
  FastDateParser$NumberStrategy(int field)
  {
    super(null);
    this.field = field;
  }
  
  boolean isNumber()
  {
    return true;
  }
  
  boolean addRegex(FastDateParser parser, StringBuilder regex)
  {
    if (parser.isNextNumber()) {
      regex.append("(\\p{Nd}{").append(parser.getFieldWidth()).append("}+)");
    } else {
      regex.append("(\\p{Nd}++)");
    }
    return true;
  }
  
  void setCalendar(FastDateParser parser, Calendar cal, String value)
  {
    cal.set(field, modify(Integer.parseInt(value)));
  }
  
  int modify(int iValue)
  {
    return iValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.NumberStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */