package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

final class Splitter$2
  implements Splitter.Strategy
{
  Splitter$2(String paramString) {}
  
  public Splitter.SplittingIterator iterator(Splitter splitter, CharSequence toSplit)
  {
    new Splitter.SplittingIterator(splitter, toSplit)
    {
      public int separatorStart(int start)
      {
        int separatorLength = val$separator.length();
        
        int p = start;int last = toSplit.length() - separatorLength;
        label80:
        for (; p <= last; p++)
        {
          for (int i = 0; i < separatorLength; i++) {
            if (toSplit.charAt(i + p) != val$separator.charAt(i)) {
              break label80;
            }
          }
          return p;
        }
        return -1;
      }
      
      public int separatorEnd(int separatorPosition)
      {
        return separatorPosition + val$separator.length();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */