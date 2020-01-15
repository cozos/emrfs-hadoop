package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Splitter$3
  implements Splitter.Strategy
{
  Splitter$3(Pattern paramPattern) {}
  
  public Splitter.SplittingIterator iterator(Splitter splitter, CharSequence toSplit)
  {
    final Matcher matcher = val$separatorPattern.matcher(toSplit);
    new Splitter.SplittingIterator(splitter, toSplit)
    {
      public int separatorStart(int start)
      {
        return matcher.find(start) ? matcher.start() : -1;
      }
      
      public int separatorEnd(int separatorPosition)
      {
        return matcher.end();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */