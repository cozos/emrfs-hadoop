package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

class FastDateParser$TextStrategy
  extends FastDateParser.Strategy
{
  private final int field;
  private final Map<String, Integer> keyValues;
  
  FastDateParser$TextStrategy(int field, Calendar definingCalendar, Locale locale)
  {
    super(null);
    this.field = field;
    keyValues = FastDateParser.access$200(field, definingCalendar, locale);
  }
  
  boolean addRegex(FastDateParser parser, StringBuilder regex)
  {
    regex.append('(');
    for (String textKeyValue : keyValues.keySet()) {
      FastDateParser.access$100(regex, textKeyValue, false).append('|');
    }
    regex.setCharAt(regex.length() - 1, ')');
    return true;
  }
  
  void setCalendar(FastDateParser parser, Calendar cal, String value)
  {
    Integer iVal = (Integer)keyValues.get(value);
    if (iVal == null)
    {
      StringBuilder sb = new StringBuilder(value);
      sb.append(" not in (");
      for (String textKeyValue : keyValues.keySet()) {
        sb.append(textKeyValue).append(' ');
      }
      sb.setCharAt(sb.length() - 1, ')');
      throw new IllegalArgumentException(sb.toString());
    }
    cal.set(field, iVal.intValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.TextStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */