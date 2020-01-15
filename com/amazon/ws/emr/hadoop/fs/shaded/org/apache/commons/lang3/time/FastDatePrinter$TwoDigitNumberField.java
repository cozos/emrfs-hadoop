package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$TwoDigitNumberField
  implements FastDatePrinter.NumberRule
{
  private final int mField;
  
  FastDatePrinter$TwoDigitNumberField(int field)
  {
    mField = field;
  }
  
  public int estimateLength()
  {
    return 2;
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    appendTo(buffer, calendar.get(mField));
  }
  
  public final void appendTo(StringBuffer buffer, int value)
  {
    if (value < 100)
    {
      buffer.append((char)(value / 10 + 48));
      buffer.append((char)(value % 10 + 48));
    }
    else
    {
      buffer.append(Integer.toString(value));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TwoDigitNumberField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */