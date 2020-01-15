package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

abstract class Splitter$SplittingIterator
  extends AbstractIterator<String>
{
  final CharSequence toSplit;
  final CharMatcher trimmer;
  final boolean omitEmptyStrings;
  int offset = 0;
  int limit;
  
  abstract int separatorStart(int paramInt);
  
  abstract int separatorEnd(int paramInt);
  
  protected Splitter$SplittingIterator(Splitter splitter, CharSequence toSplit)
  {
    trimmer = Splitter.access$200(splitter);
    omitEmptyStrings = Splitter.access$300(splitter);
    limit = Splitter.access$400(splitter);
    this.toSplit = toSplit;
  }
  
  protected String computeNext()
  {
    int nextStart = offset;
    while (offset != -1)
    {
      int start = nextStart;
      
      int separatorPosition = separatorStart(offset);
      int end;
      if (separatorPosition == -1)
      {
        int end = toSplit.length();
        offset = -1;
      }
      else
      {
        end = separatorPosition;
        offset = separatorEnd(separatorPosition);
      }
      if (offset == nextStart)
      {
        offset += 1;
        if (offset >= toSplit.length()) {
          offset = -1;
        }
      }
      else
      {
        while ((start < end) && (trimmer.matches(toSplit.charAt(start)))) {
          start++;
        }
        while ((end > start) && (trimmer.matches(toSplit.charAt(end - 1)))) {
          end--;
        }
        if ((omitEmptyStrings) && (start == end))
        {
          nextStart = offset;
        }
        else
        {
          if (limit == 1)
          {
            end = toSplit.length();
            offset = -1;
            while ((end > start) && (trimmer.matches(toSplit.charAt(end - 1)))) {
              end--;
            }
          }
          limit -= 1;
          
          return toSplit.subSequence(start, end).toString();
        }
      }
    }
    return (String)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.SplittingIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */