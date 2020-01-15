package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$UnpaddedNumberField
  implements FastDatePrinter.NumberRule
{
  private final int mField;
  
  FastDatePrinter$UnpaddedNumberField(int field)
  {
    mField = field;
  }
  
  public int estimateLength()
  {
    return 4;
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    appendTo(buffer, calendar.get(mField));
  }
  
  public final void appendTo(StringBuffer buffer, int value)
  {
    if (value < 10)
    {
      buffer.append((char)(value + 48));
    }
    else if (value < 100)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.UnpaddedNumberField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */