package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$UnpaddedMonthField
  implements FastDatePrinter.NumberRule
{
  static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
  
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
    if (value < 10)
    {
      buffer.append((char)(value + 48));
    }
    else
    {
      buffer.append((char)(value / 10 + 48));
      buffer.append((char)(value % 10 + 48));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.UnpaddedMonthField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */