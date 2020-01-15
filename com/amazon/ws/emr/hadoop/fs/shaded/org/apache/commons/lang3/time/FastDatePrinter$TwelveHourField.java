package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$TwelveHourField
  implements FastDatePrinter.NumberRule
{
  private final FastDatePrinter.NumberRule mRule;
  
  FastDatePrinter$TwelveHourField(FastDatePrinter.NumberRule rule)
  {
    mRule = rule;
  }
  
  public int estimateLength()
  {
    return mRule.estimateLength();
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    int value = calendar.get(10);
    if (value == 0) {
      value = calendar.getLeastMaximum(10) + 1;
    }
    mRule.appendTo(buffer, value);
  }
  
  public void appendTo(StringBuffer buffer, int value)
  {
    mRule.appendTo(buffer, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TwelveHourField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */