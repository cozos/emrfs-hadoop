package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

class Splitter$1$1
  extends Splitter.SplittingIterator
{
  Splitter$1$1(Splitter.1 param1, Splitter x0, CharSequence x1)
  {
    super(x0, x1);
  }
  
  int separatorStart(int start)
  {
    return this$0.val$separatorMatcher.indexIn(toSplit, start);
  }
  
  int separatorEnd(int separatorPosition)
  {
    return separatorPosition + 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */