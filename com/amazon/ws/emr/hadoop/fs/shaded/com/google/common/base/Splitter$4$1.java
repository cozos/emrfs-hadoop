package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

class Splitter$4$1
  extends Splitter.SplittingIterator
{
  Splitter$4$1(Splitter.4 param4, Splitter x0, CharSequence x1)
  {
    super(x0, x1);
  }
  
  public int separatorStart(int start)
  {
    int nextChunkStart = start + this$0.val$length;
    return nextChunkStart < toSplit.length() ? nextChunkStart : -1;
  }
  
  public int separatorEnd(int separatorPosition)
  {
    return separatorPosition;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.4.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */