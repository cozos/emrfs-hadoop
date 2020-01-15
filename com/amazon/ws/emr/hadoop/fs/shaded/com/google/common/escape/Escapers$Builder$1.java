package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import java.util.Map;

class Escapers$Builder$1
  extends ArrayBasedCharEscaper
{
  Escapers$Builder$1(Escapers.Builder paramBuilder, Map x0, char x1, char x2)
  {
    super(x0, x1, x2);
  }
  
  private final char[] replacementChars = Escapers.Builder.access$100(this$0) != null ? Escapers.Builder.access$100(this$0).toCharArray() : null;
  
  protected char[] escapeUnsafe(char c)
  {
    return replacementChars;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escapers.Builder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */