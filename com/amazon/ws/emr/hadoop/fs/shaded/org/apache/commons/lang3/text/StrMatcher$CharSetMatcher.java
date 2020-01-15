package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

import java.util.Arrays;

final class StrMatcher$CharSetMatcher
  extends StrMatcher
{
  private final char[] chars;
  
  StrMatcher$CharSetMatcher(char[] chars)
  {
    this.chars = ((char[])chars.clone());
    Arrays.sort(this.chars);
  }
  
  public int isMatch(char[] buffer, int pos, int bufferStart, int bufferEnd)
  {
    return Arrays.binarySearch(chars, buffer[pos]) >= 0 ? 1 : 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrMatcher.CharSetMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */