package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.util.regex.Matcher;

class Splitter$3$1
  extends Splitter.SplittingIterator
{
  Splitter$3$1(Splitter.3 param3, Splitter x0, CharSequence x1, Matcher paramMatcher)
  {
    super(x0, x1);
  }
  
  public int separatorStart(int start)
  {
    return val$matcher.find(start) ? val$matcher.start() : -1;
  }
  
  public int separatorEnd(int separatorPosition)
  {
    return val$matcher.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */