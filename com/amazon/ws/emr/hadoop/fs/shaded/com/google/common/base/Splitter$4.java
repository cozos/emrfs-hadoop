package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

final class Splitter$4
  implements Splitter.Strategy
{
  Splitter$4(int paramInt) {}
  
  public Splitter.SplittingIterator iterator(Splitter splitter, CharSequence toSplit)
  {
    new Splitter.SplittingIterator(splitter, toSplit)
    {
      public int separatorStart(int start)
      {
        int nextChunkStart = start + val$length;
        return nextChunkStart < toSplit.length() ? nextChunkStart : -1;
      }
      
      public int separatorEnd(int separatorPosition)
      {
        return separatorPosition;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */