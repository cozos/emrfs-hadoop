package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

@Beta
@GwtCompatible
public abstract class UnicodeEscaper
  extends Escaper
{
  private static final int DEST_PAD = 32;
  
  protected abstract char[] escape(int paramInt);
  
  protected int nextEscapeIndex(CharSequence csq, int start, int end)
  {
    int index = start;
    while (index < end)
    {
      int cp = codePointAt(csq, index, end);
      if ((cp < 0) || (escape(cp) != null)) {
        break;
      }
      index += (Character.isSupplementaryCodePoint(cp) ? 2 : 1);
    }
    return index;
  }
  
  public String escape(String string)
  {
    Preconditions.checkNotNull(string);
    int end = string.length();
    int index = nextEscapeIndex(string, 0, end);
    return index == end ? string : escapeSlow(string, index);
  }
  
  protected final String escapeSlow(String s, int index)
  {
    int end = s.length();
    
    char[] dest = Platform.charBufferFromThreadLocal();
    int destIndex = 0;
    int unescapedChunkStart = 0;
    while (index < end)
    {
      int cp = codePointAt(s, index, end);
      if (cp < 0) {
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
      }
      char[] escaped = escape(cp);
      int nextIndex = index + (Character.isSupplementaryCodePoint(cp) ? 2 : 1);
      if (escaped != null)
      {
        int charsSkipped = index - unescapedChunkStart;
        
        int sizeNeeded = destIndex + charsSkipped + escaped.length;
        if (dest.length < sizeNeeded)
        {
          int destLength = sizeNeeded + (end - index) + 32;
          dest = growBuffer(dest, destIndex, destLength);
        }
        if (charsSkipped > 0)
        {
          s.getChars(unescapedChunkStart, index, dest, destIndex);
          destIndex += charsSkipped;
        }
        if (escaped.length > 0)
        {
          System.arraycopy(escaped, 0, dest, destIndex, escaped.length);
          destIndex += escaped.length;
        }
        unescapedChunkStart = nextIndex;
      }
      index = nextEscapeIndex(s, nextIndex, end);
    }
    int charsSkipped = end - unescapedChunkStart;
    if (charsSkipped > 0)
    {
      int endIndex = destIndex + charsSkipped;
      if (dest.length < endIndex) {
        dest = growBuffer(dest, destIndex, endIndex);
      }
      s.getChars(unescapedChunkStart, end, dest, destIndex);
      destIndex = endIndex;
    }
    return new String(dest, 0, destIndex);
  }
  
  protected static int codePointAt(CharSequence seq, int index, int end)
  {
    Preconditions.checkNotNull(seq);
    if (index < end)
    {
      char c1 = seq.charAt(index++);
      if ((c1 < 55296) || (c1 > 57343)) {
        return c1;
      }
      if (c1 <= 56319)
      {
        if (index == end) {
          return -c1;
        }
        c2 = seq.charAt(index);
        if (Character.isLowSurrogate(c2)) {
          return Character.toCodePoint(c1, c2);
        }
        c1 = c2;i = c2;int j = index;String str2 = String.valueOf(String.valueOf(seq));throw new IllegalArgumentException(89 + str2.length() + "Expected low surrogate but got char '" + c1 + "' with value " + i + " at index " + j + " in '" + str2 + "'");
      }
      char c2 = c1;char c1 = c1;int i = index - 1;String str1 = String.valueOf(String.valueOf(seq));throw new IllegalArgumentException(88 + str1.length() + "Unexpected low surrogate character '" + c2 + "' with value " + c1 + " at index " + i + " in '" + str1 + "'");
    }
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }
  
  private static char[] growBuffer(char[] dest, int index, int size)
  {
    char[] copy = new char[size];
    if (index > 0) {
      System.arraycopy(dest, 0, copy, 0, index);
    }
    return copy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.UnicodeEscaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */