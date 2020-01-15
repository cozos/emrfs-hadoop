package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$TwoDigitYearField
  implements FastDatePrinter.NumberRule
{
  static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
  
  public int estimateLength()
  {
    return 2;
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    appendTo(buffer, calendar.get(1) % 100);
  }
  
  public final void appendTo(StringBuffer buffer, int value)
  {
    buffer.append((char)(value / 10 + 48));
    buffer.append((char)(value % 10 + 48));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TwoDigitYearField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */