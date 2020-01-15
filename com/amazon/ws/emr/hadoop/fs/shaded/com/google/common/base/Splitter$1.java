package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

final class Splitter$1
  implements Splitter.Strategy
{
  Splitter$1(CharMatcher paramCharMatcher) {}
  
  public Splitter.SplittingIterator iterator(Splitter splitter, CharSequence toSplit)
  {
    new Splitter.SplittingIterator(splitter, toSplit)
    {
      int separatorStart(int start)
      {
        return val$separatorMatcher.indexIn(toSplit, start);
      }
      
      int separatorEnd(int separatorPosition)
      {
        return separatorPosition + 1;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */