package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

final class StrMatcher$TrimMatcher
  extends StrMatcher
{
  public int isMatch(char[] buffer, int pos, int bufferStart, int bufferEnd)
  {
    return buffer[pos] <= ' ' ? 1 : 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrMatcher.TrimMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */