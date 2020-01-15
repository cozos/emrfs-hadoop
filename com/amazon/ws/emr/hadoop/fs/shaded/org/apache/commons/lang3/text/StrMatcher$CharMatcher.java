package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

final class StrMatcher$CharMatcher
  extends StrMatcher
{
  private final char ch;
  
  StrMatcher$CharMatcher(char ch)
  {
    this.ch = ch;
  }
  
  public int isMatch(char[] buffer, int pos, int bufferStart, int bufferEnd)
  {
    return ch == buffer[pos] ? 1 : 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrMatcher.CharMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */