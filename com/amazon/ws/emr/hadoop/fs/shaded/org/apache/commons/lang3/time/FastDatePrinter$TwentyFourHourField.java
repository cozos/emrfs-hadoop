package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$TwentyFourHourField
  implements FastDatePrinter.NumberRule
{
  private final FastDatePrinter.NumberRule mRule;
  
  FastDatePrinter$TwentyFourHourField(FastDatePrinter.NumberRule rule)
  {
    mRule = rule;
  }
  
  public int estimateLength()
  {
    return mRule.estimateLength();
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    int value = calendar.get(11);
    if (value == 0) {
      value = calendar.getMaximum(11) + 1;
    }
    mRule.appendTo(buffer, value);
  }
  
  public void appendTo(StringBuffer buffer, int value)
  {
    mRule.appendTo(buffer, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TwentyFourHourField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */