package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

class DateTimeFormatterBuilder$MatchingParser
  implements InternalParser
{
  private final InternalParser[] iParsers;
  private final int iParsedLengthEstimate;
  
  DateTimeFormatterBuilder$MatchingParser(InternalParser[] paramArrayOfInternalParser)
  {
    iParsers = paramArrayOfInternalParser;
    int i = 0;
    int j = paramArrayOfInternalParser.length;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      InternalParser localInternalParser = paramArrayOfInternalParser[j];
      if (localInternalParser != null)
      {
        int k = localInternalParser.estimateParsedLength();
        if (k > i) {
          i = k;
        }
      }
    }
    iParsedLengthEstimate = i;
  }
  
  public int estimateParsedLength()
  {
    return iParsedLengthEstimate;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    InternalParser[] arrayOfInternalParser = iParsers;
    int i = arrayOfInternalParser.length;
    
    Object localObject1 = paramDateTimeParserBucket.saveState();
    int j = 0;
    
    int k = paramInt;
    Object localObject2 = null;
    
    int m = paramInt;
    for (int n = 0; n < i; n++)
    {
      InternalParser localInternalParser = arrayOfInternalParser[n];
      if (localInternalParser == null)
      {
        if (k <= paramInt) {
          return paramInt;
        }
        j = 1;
        break;
      }
      int i1 = localInternalParser.parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
      if (i1 >= paramInt)
      {
        if (i1 > k)
        {
          if ((i1 >= paramCharSequence.length()) || (n + 1 >= i) || (arrayOfInternalParser[(n + 1)] == null)) {
            return i1;
          }
          k = i1;
          localObject2 = paramDateTimeParserBucket.saveState();
        }
      }
      else if (i1 < 0)
      {
        i1 ^= 0xFFFFFFFF;
        if (i1 > m) {
          m = i1;
        }
      }
      paramDateTimeParserBucket.restoreState(localObject1);
    }
    if ((k > paramInt) || ((k == paramInt) && (j != 0)))
    {
      if (localObject2 != null) {
        paramDateTimeParserBucket.restoreState(localObject2);
      }
      return k;
    }
    return m ^ 0xFFFFFFFF;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.MatchingParser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */