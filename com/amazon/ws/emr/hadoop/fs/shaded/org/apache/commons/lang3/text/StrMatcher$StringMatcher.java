package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

final class StrMatcher$StringMatcher
  extends StrMatcher
{
  private final char[] chars;
  
  StrMatcher$StringMatcher(String str)
  {
    chars = str.toCharArray();
  }
  
  public int isMatch(char[] buffer, int pos, int bufferStart, int bufferEnd)
  {
    int len = chars.length;
    if (pos + len > bufferEnd) {
      return 0;
    }
    for (int i = 0; i < chars.length; pos++)
    {
      if (chars[i] != buffer[pos]) {
        return 0;
      }
      i++;
    }
    return len;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrMatcher.StringMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */