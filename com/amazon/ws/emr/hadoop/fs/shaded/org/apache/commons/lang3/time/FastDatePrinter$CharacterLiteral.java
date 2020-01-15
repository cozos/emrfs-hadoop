package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;

class FastDatePrinter$CharacterLiteral
  implements FastDatePrinter.Rule
{
  private final char mValue;
  
  FastDatePrinter$CharacterLiteral(char value)
  {
    mValue = value;
  }
  
  public int estimateLength()
  {
    return 1;
  }
  
  public void appendTo(StringBuffer buffer, Calendar calendar)
  {
    buffer.append(mValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDatePrinter.CharacterLiteral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */