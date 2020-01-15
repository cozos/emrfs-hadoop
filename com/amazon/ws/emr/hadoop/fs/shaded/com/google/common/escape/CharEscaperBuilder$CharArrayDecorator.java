package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

class CharEscaperBuilder$CharArrayDecorator
  extends CharEscaper
{
  private final char[][] replacements;
  private final int replaceLength;
  
  CharEscaperBuilder$CharArrayDecorator(char[][] replacements)
  {
    this.replacements = replacements;
    replaceLength = replacements.length;
  }
  
  public String escape(String s)
  {
    int slen = s.length();
    for (int index = 0; index < slen; index++)
    {
      char c = s.charAt(index);
      if ((c < replacements.length) && (replacements[c] != null)) {
        return escapeSlow(s, index);
      }
    }
    return s;
  }
  
  protected char[] escape(char c)
  {
    return c < replaceLength ? replacements[c] : null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.CharEscaperBuilder.CharArrayDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */