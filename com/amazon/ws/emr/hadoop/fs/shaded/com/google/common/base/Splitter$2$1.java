package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

class Splitter$2$1
  extends Splitter.SplittingIterator
{
  Splitter$2$1(Splitter.2 param2, Splitter x0, CharSequence x1)
  {
    super(x0, x1);
  }
  
  public int separatorStart(int start)
  {
    int separatorLength = this$0.val$separator.length();
    
    int p = start;int last = toSplit.length() - separatorLength;
    label80:
    for (; p <= last; p++)
    {
      for (int i = 0; i < separatorLength; i++) {
        if (toSplit.charAt(i + p) != this$0.val$separator.charAt(i)) {
          break label80;
        }
      }
      return p;
    }
    return -1;
  }
  
  public int separatorEnd(int separatorPosition)
  {
    return separatorPosition + this$0.val$separator.length();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */