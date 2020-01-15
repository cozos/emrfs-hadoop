package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

final class FastDateParser$4
  extends FastDateParser.NumberStrategy
{
  FastDateParser$4(int x0)
  {
    super(x0);
  }
  
  int modify(int iValue)
  {
    return iValue % 12;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */