package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$TextField
  implements FastDatePrinter.Rule
{
  private final int mField;
  private final String[] mValues;
  
  FastDatePrinter$TextField(int field, String[] values)
  {
    mField = field;
    mValues = values;
  }
  
  public int estimateLength()
  {
    int max = 0;
    int i = mValues.length;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      int len = mValues[i].length();
      if (len > max) {
        max = len;
      }
    }
    return max;
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    buffer.append(mValues[calendar.get(mField)]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.TextField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */