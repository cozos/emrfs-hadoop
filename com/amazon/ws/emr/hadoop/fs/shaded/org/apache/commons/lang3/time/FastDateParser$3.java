package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

final class FastDateParser$3
  extends FastDateParser.NumberStrategy
{
  FastDateParser$3(int x0)
  {
    super(x0);
  }
  
  int modify(int iValue)
  {
    return iValue % 24;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */