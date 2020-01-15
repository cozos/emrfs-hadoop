package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$StringLiteral
  implements FastDatePrinter.Rule
{
  private final String mValue;
  
  FastDatePrinter$StringLiteral(String value)
  {
    mValue = value;
  }
  
  public int estimateLength()
  {
    return mValue.length();
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    buffer.append(mValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.StringLiteral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */