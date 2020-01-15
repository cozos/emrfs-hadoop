package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.Validate;
import java.util.Calendar;

class FastDatePrinter$PaddedNumberField
  implements FastDatePrinter.NumberRule
{
  private final int mField;
  private final int mSize;
  
  FastDatePrinter$PaddedNumberField(int field, int size)
  {
    if (size < 3) {
      throw new IllegalArgumentException();
    }
    mField = field;
    mSize = size;
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
    if (value < 100)
    {
      int i = mSize;
      for (;;)
      {
        i--;
        if (i < 2) {
          break;
        }
        buffer.append('0');
      }
      buffer.append((char)(value / 10 + 48));
      buffer.append((char)(value % 10 + 48));
    }
    else
    {
      int digits;
      int digits;
      if (value < 1000)
      {
        digits = 3;
      }
      else
      {
        Validate.isTrue(value > -1, "Negative values should not be possible", value);
        digits = Integer.toString(value).length();
      }
      int i = mSize;
      for (;;)
      {
        i--;
        if (i < digits) {
          break;
        }
        buffer.append('0');
      }
      buffer.append(Integer.toString(value));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.PaddedNumberField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */