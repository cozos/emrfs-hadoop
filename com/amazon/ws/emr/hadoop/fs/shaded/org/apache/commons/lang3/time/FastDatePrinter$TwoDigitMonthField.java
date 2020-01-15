package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$TwoDigitMonthField
  implements FastDatePrinter.NumberRule
{
  static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
  
  public int estimateLength()
  {
    return 2;
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    appendTo(buffer, calendar.get(2) + 1);
  }
  
  public final void appendTo(StringBuffer buffer, int value)
  {
    buffer.append((char)(value / 10 + 48));
    buffer.append((char)(value % 10 + 48));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TwoDigitMonthField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */